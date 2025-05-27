package six.easy.main.java.src;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> myNumbers = List.of(1,3,4,6,7,8,9,0,7,54,54,23,44,99);

        NumberList numberList = new NumberList(myNumbers);

        numberList.getNumbers();

        numberList.getMinValue();

        numberList.getMaxValue();

        numberList.getSortOfNumbersMinToMax();

        numberList.getSortOfNumbersMaxToMin();

        numberList.getSerchNumber(3);

        numberList.getFilter(7);

        numberList.getSumOfList();

    }
}