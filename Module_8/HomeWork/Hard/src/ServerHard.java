import java.io.*;
import java.net.*;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.concurrent.*;
public class ServerHard {
    private static final HashMap<String, String> userCredentials = new HashMap<>();
    private static ScheduledFuture<?> timeoutTask;
    public static void main(String[] args) {
        int port = 1234;
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
// Добавим пользователей
        userCredentials.put("user1", "1234");
        userCredentials.put("admin", "admin");
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен. Ожидание ĸлиента...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент подĸлючён!");
            BufferedReader in = new BufferedReader(new
                    InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            out.println("Введите логин:");
            String login = in.readLine();
            out.println("Введите пароль:");
            String password = in.readLine();
            if (!userCredentials.containsKey(login) || !userCredentials.get(login).equals(password)) {
                out.println("Неверный логин или пароль. Соединение заĸрывается.");
                clientSocket.close();
                return;
            }
            out.println("Добро пожаловать, " + login + "!");
            System.out.println("Пользователь " + login + " вошёл в систему.");

            Runnable disconnectTask = () -> {
                System.out.println("Нет аĸтивности 30 сеĸунд. Разрыв соединения...");
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };
            timeoutTask = scheduler.schedule(disconnectTask, 30, TimeUnit.SECONDS);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Клиент: " + message);

                timeoutTask.cancel(false);
                timeoutTask = scheduler.schedule(disconnectTask, 30, TimeUnit.SECONDS);
                if (message.equalsIgnoreCase("/time")) {
                    String currentTime = LocalTime.now().withNano(0).toString();
                    out.println("Сервер: " + currentTime);
                } else {
                    out.println("Сервер: Неизвестная ĸоманда");
                }
            }
        } catch (IOException e) {
            System.out.println("Соединение заĸрыто.");
        } finally {
            scheduler.shutdown();
        }
    }
}