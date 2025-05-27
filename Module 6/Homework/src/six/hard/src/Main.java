package six.hard.src;

public class Main {
    public static void main(String[] args) {
        SafeList<String> list = new SafeList<>();
        list.add("apple");
        list.add("apple");
        list.add("banana");
        list.add("banana");
        list.add("banana");

        list.add(1, "cherry");

        System.out.println("Список без дубликатов: " + list);

        System.out.println("Содержимое индекса: " + list.get(0));

        System.out.println("Индекс не существует: " + list.get(7));


    }
}