public class w4Hard {
    public static void main(String[] args) {
        Box<Integer> box = new Box<>(43);
        System.out.println(box.getItem());

        Box<String> box2 = new Box<>("Привет!");
        System.out.println(box2.getItem());

        box.setItem(32);
        box2.setItem("Пока!");

        System.out.println(box.getItem());
        System.out.println(box2.getItem());

        box.showType();
        box2.showType();

    }
}