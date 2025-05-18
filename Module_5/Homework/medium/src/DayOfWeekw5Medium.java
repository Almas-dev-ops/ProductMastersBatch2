public class DayOfWeekw5Medium {

    private DayOfWeekEnumW5Medium day;

    public DayOfWeekw5Medium() {

    }

    public DayOfWeekw5Medium(DayOfWeekEnumW5Medium day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "День недели: " + day;
    }

    public void IsWeekend(DayOfWeekEnumW5Medium day) {
        if (day.equals(DayOfWeekEnumW5Medium.SUNDAY) || day.equals(DayOfWeekEnumW5Medium.SATURDAY)) {
            System.out.println(day + " - выходной день.");
        } else {
            System.out.println(day + " - будний день.");
        }
    }

}
