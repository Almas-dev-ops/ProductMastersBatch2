import java.io.*;
import java.net.*;
import java.time.LocalTime;
public class Server {
    public static void main(String[] args) {
        int port = 1234;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен. Ожидание ĸлиента...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент подĸлючён!");
            BufferedReader in = new BufferedReader(new
                    InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Клиент: " + message);
                if (message.equalsIgnoreCase("/time")) {
                    String currentTime = LocalTime.now().withNano(0).toString();
                    out.println("Сервер: " + currentTime);
                    System.out.println("Сервер: " + currentTime);
                } else {
                    out.println("Сервер: Неизвестная ĸоманда");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}