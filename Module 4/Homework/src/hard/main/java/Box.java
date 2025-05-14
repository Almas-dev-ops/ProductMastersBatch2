public class Box<T> {
    private T item;

    public Box(T item) {
        this.item = item;
    }

    void setItem(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }
void showType (){
    System.out.println(getClass() + "Тип класса: " + getClass() +"\n" +
            "Тип объекта: "+ item);
    System.out.println();
}
}
