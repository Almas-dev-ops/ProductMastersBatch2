package five.easy.easy.src;

public class DayW5Easy
{
    private int date;
    private DayOfWeekW5Easy dayOfWeek;

    public DayW5Easy(int date, DayOfWeekW5Easy dayOfWeek) {
        this.date = date;
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String toString() {
        return "Дата: " + date +"\n"+
                 "День недели : "+ dayOfWeek;
    }
}
