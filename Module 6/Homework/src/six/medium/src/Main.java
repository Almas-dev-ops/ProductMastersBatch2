package six.medium.src;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>();
        array.add("Молоко");
        array.add("Молоко");
        array.add("Молоко");
        array.add("Банан");
        array.add("Банан");
        array.add("Колобок");
        array.add("Пицца");
        array.add("Колобок");
        array.add("Колобок");


        HashMap<String, Integer> frequencyMap = new HashMap<>();
        for (String element : array) {
            if (frequencyMap.containsKey(element)) {
                frequencyMap.put(element, frequencyMap.get(element) + 1);
            } else {
                frequencyMap.put(element, 1);
            }
        }
        for (String key : frequencyMap.keySet()) {
            System.out.println(key + " = " + frequencyMap.get(key));
        }

    }
}