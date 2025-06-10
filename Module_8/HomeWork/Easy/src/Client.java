import java.io.*;
import java.net.*;
public class Client {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 1234;
        try (Socket socket = new Socket(hostname, port);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(socket.getInputStream()))) {
            System.out.println("Введите ĸоманду (например: /time):");
            String input;
            while ((input = userInput.readLine()) != null) {
                out.println(input); // отправляем на сервер
                String response = in.readLine(); // получаем ответ
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}