package kz_Almas;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                Person.builder().name("Arman").age(30).city("Almaty").build(),
                Person.builder().name("Bolat").age(17).city("Aktau").build(),
                Person.builder().name("Sergey").age(25).city("Almaty").build(),
                Person.builder().name("Diana").age(15).city("Shimkent").build(),
                Person.builder().name("Erlan").age(40).city("Almaty").build()
        );
// 1. Фильтрация: тольĸо старше 18
        List<Person> adults = people.stream()
                .filter(person -> person.getAge() > 18)
                .collect(Collectors.toList());
        System.out.println(" Люди старше 18:");
        adults.forEach(System.out::println);
// 2. Средний возраст
        OptionalDouble averageAge = people.stream()
                .mapToInt(Person::getAge)
                .average();
        System.out.println("\n Средний возраст:");
        averageAge.ifPresent(System.out::println);
// 3. Люди из Алматы
        List<Person> fromAlmaty = people.stream()
                .filter(person -> "Almaty".equalsIgnoreCase(person.getCity()))
                .collect(Collectors.toList());
        System.out.println("\n Люди из Алматы:");
        fromAlmaty.forEach(System.out::println);
// 4. Преобразование в Map<String, Integer> (имя -> возраст)
        Map<String, Integer> nameToAge = people.stream()
                .collect(Collectors.toMap(Person::getName, Person::getAge));
        System.out.println("\n Map: имя -> возраст:");
        nameToAge.forEach((name, age) -> System.out.println(name + " -> " + age));
    }
}