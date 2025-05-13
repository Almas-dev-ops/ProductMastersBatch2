
public class Main {
    public static void main(String[] args) {

        Printer<String> b = new Printer<>("Идет печать!");
        System.out.println(b.getValue());
    }
}