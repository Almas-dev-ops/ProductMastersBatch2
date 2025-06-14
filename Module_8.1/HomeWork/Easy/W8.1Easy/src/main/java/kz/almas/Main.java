package kz.almas;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        Person person1 = Person.builder()
                .name("Marat")
                .age(30)
                .city("Astana")
                .build();
        Person person2 = Person.builder()
                .name("Vova")
                .age(25)
                .city("Aktau")
                .build();
        Person person3 = Person.builder()
                .name("Maxim")
                .age(35)
                .city("Almaty")
                .build();
        people.add(person1);
        people.add(person2);
        people.add(person3);
// Выводим списоĸ
        for (Person p : people) {
            System.out.println(p);
        }
    }
}
