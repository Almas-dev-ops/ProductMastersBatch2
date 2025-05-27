package five.hard.hard.src;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class MainW5Hard
{
    public static void main(String[] args)
    {
       ArrayList<Integer> list = new ArrayList<>();
        System.out.print("Введите цифры: ");
        Scanner input = new Scanner(System.in);
        int num;
        while ((num = input.nextInt()) > 0){

            list.add(num);
            System.out.println("Изначальный список: "+ list);

            LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(list);
            ArrayList<Integer> listRemoveDublicates;
            listRemoveDublicates= new ArrayList<>(hashSet);

            System.out.println("Список с удаленными дубликатами,\nи с сохраненным порядком элементов: "+listRemoveDublicates);
        }
        input.close();

    }
}


