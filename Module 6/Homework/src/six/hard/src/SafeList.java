package six.hard.src;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class SafeList<T> extends AbstractList<T> {

    private final List<T> innerList = new ArrayList<T>();

    @Override
    public int size() {
        return innerList.size();
    }


    public void add(int index, T element) {  // Не позволяет добовлять null и дубликаты.
        if (element == null || innerList.contains(element)) {
            return;
        }
        if (index >= 0 && index <= innerList.size()) {
            innerList.add(index, element);
        }
    }

    @Override
    public T get(int index) {  // При обращении к несществующему индексу возвращяет null, не выбрасывает ошибку.
        if (index >= 0 && index < innerList.size()) {
            return innerList.get(index);
        }
        return null;
    }

    public T set(int index, T element) {
        if (index >= 0 && index < innerList.size()) {
            if (element == null || innerList.contains(element)) {
                return innerList.set(index, element); // Or throw an exception if you prefer
            }
            return innerList.set(index, element);
        }
        return null;


    }

}
