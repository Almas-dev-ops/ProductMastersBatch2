import java.util.ArrayList;

public class MainW5Medium {
    public static void main(String[] args)
    {

        ArrayList<DayOfWeekw5Medium> dayOfWeek = new ArrayList<>();
        dayOfWeek.add(new DayOfWeekw5Medium(DayOfWeekEnumW5Medium.MONDAY));
        dayOfWeek.add(new DayOfWeekw5Medium(DayOfWeekEnumW5Medium.TUESDAY));
        dayOfWeek.add(new DayOfWeekw5Medium(DayOfWeekEnumW5Medium.WEDNESDAY));
        dayOfWeek.add(new DayOfWeekw5Medium(DayOfWeekEnumW5Medium.THURSDAY));
        dayOfWeek.add(new DayOfWeekw5Medium(DayOfWeekEnumW5Medium.FRIDAY));
        dayOfWeek.add(new DayOfWeekw5Medium(DayOfWeekEnumW5Medium.SATURDAY));
        dayOfWeek.add(new DayOfWeekw5Medium(DayOfWeekEnumW5Medium.SUNDAY));

//        for (int i = 0; i < dayOfWeek.size(); i++) {
//            System.out.println(dayOfWeek.get(i));
//        }

        for(DayOfWeekw5Medium day : dayOfWeek)
            System.out.println(day);
        System.out.println("==================================================");

        DayOfWeekw5Medium day1 = new DayOfWeekw5Medium();
        day1.IsWeekend(DayOfWeekEnumW5Medium.MONDAY);
        day1.IsWeekend(DayOfWeekEnumW5Medium.TUESDAY);
        day1.IsWeekend(DayOfWeekEnumW5Medium.WEDNESDAY);
        day1.IsWeekend(DayOfWeekEnumW5Medium.THURSDAY);
        day1.IsWeekend(DayOfWeekEnumW5Medium.FRIDAY);

        day1.IsWeekend(DayOfWeekEnumW5Medium.SATURDAY);
        day1.IsWeekend(DayOfWeekEnumW5Medium.SUNDAY);



    }
}