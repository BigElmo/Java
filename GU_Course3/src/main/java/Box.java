import java.util.ArrayList;

public class Box<T> {

    private ArrayList<T> items;
    private int counter;

    public Box() {
        items = new ArrayList<>();
        counter = 0;
    }

    public void addItem(T obj) {
        items.add(obj);
        counter++;
    }

    public int getCount() {
        return counter;
    }

//    public double getWeight() {
//        double boxWeight = 0;
//        for (T item : items) {
//            boxWeight += item.getWeight();
//        }
//        return boxWeight;
//    }
}
