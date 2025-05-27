package six.easy.main.java.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NumberList
{

    private final List<Integer> numbers;
    private Integer serchNumber;
    private Integer threshold;


    public NumberList(List<Integer> numbers)
    {
        this.numbers = numbers;
    }

    public void getNumbers()
    {                                //Список чисел
        System.out.print("Список чисел:" + this.numbers + "\n");
    }

    public void getMinValue()
    {                          // 1. Возвращает наименьшее число в списке
        Integer min = Collections.min(this.numbers);
        System.out.print("1.Минимальное значение в списке: " + min + "\n");
    }

    public void getMaxValue()
    {                        // 2. Возвращает наибольшее число в списке
        Integer max = Collections.max(this.numbers);
        System.out.print("2.Максимальное число в списке: " + max + "\n");
    }

    public void getSortOfNumbersMinToMax()
    {             // 3.Сортировка по возрастанию
        ArrayList <Integer> list = new ArrayList<>(numbers);
        Collections.sort(list);
        System.out.println("3.Cписок от меньшего к большему: " + list);
    }

    public void getSortOfNumbersMaxToMin()
    {             // 4.Сортировка по убыванию
        ArrayList <Integer> list = new ArrayList<>(numbers);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("4.Cписок от большего к меньшему: " + list);
    }

    public void getSerchNumber(Integer serchNumber)
    {
        this.serchNumber = serchNumber;

        if (this.numbers.contains(serchNumber)) { // 5 Поиск элемента в списке
            System.out.println("5.Заданное число: " + serchNumber + " - находится в списке.");
        } else {
            System.out.println("5.Заданное число: " + serchNumber + " - не найдено в списке.");
        }
    }
    public void getFilter(int threshold )               // 6.Фильтр элементов.
    {    // 6. Фильтр элементов.
        this.threshold = threshold;
        List<Integer> filteredNumbers = numbers.stream()
            .filter(number -> number > threshold)
            .collect(Collectors.toList());

        System.out.println("6.Список чисел больше заданного: " + filteredNumbers);
    }


     public void getSumOfList()               // 7. Сумма всех элементов.
     {
         int sum = 0;
         for (int number : numbers) {
             sum += number;
         }
         System.out.println("7.Сумма всех чисел элементов списка: " + sum);
     }


}
