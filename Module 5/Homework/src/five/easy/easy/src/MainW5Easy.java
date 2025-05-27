package five.easy.easy.src;

public class MainW5Easy {
    public static void main(String[] args) {
        DayW5Easy firstDay = new DayW5Easy(31, DayOfWeekW5Easy.SUNDAY);
        System.out.println(firstDay.toString());

        System.out.println("===================================");

        DayW5Easy secondDay = new DayW5Easy(24, DayOfWeekW5Easy.SATURDAY);
        System.out.println(secondDay);
    }
}