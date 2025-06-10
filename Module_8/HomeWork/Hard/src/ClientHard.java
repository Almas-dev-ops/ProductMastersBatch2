import java.io.*;
import java.net.*;
import java.util.concurrent.*;
public class ClientHard {
    private static ScheduledFuture<?> timeoutTask;
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 1234;
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        try (Socket socket = new Socket(hostname, port);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(socket.getInputStream()))) {

            System.out.println(in.readLine());
            String login = userInput.readLine();
            out.println(login);
            System.out.println(in.readLine());
            String password = userInput.readLine();
            out.println(password);
            String authResponse = in.readLine();
            System.out.println(authResponse);
            if (authResponse.startsWith("Неверный")) {
                return;
            }

            Runnable disconnectTask = () -> {
                System.out.println("Нет аĸтивности 30 сеĸунд. Клиент заĸрывает соединение...");
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };
            timeoutTask = scheduler.schedule(disconnectTask, 30, TimeUnit.SECONDS);

            new Thread(() -> {
                try {
                    String response;
                    while ((response = in.readLine()) != null) {
                        timeoutTask.cancel(false);
                        timeoutTask = scheduler.schedule(disconnectTask, 30, TimeUnit.SECONDS);
                        System.out.println(response);
                    }
                } catch (IOException e) {
                    System.out.println("Сервер отĸлючился.");
                }
            }).start();

            String input;
            while ((input = userInput.readLine()) != null && !socket.isClosed()) {
                out.println(input);
                timeoutTask.cancel(false);
                timeoutTask = scheduler.schedule(disconnectTask, 30, TimeUnit.SECONDS);
            }
        } catch (IOException e) {
            System.out.println("Ошибĸа соединения.");
        } finally {
            scheduler.shutdown();
        }
    }
}