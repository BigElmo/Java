import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> items;

    public Box() {
        items = new ArrayList<>();
    }

    public void addItem(T obj) {
        items.add(obj);
    }

    public int getCount() {
        return items.size();
    }

    public double getWeight() {
        double boxWeight = 0;
        for (T item : items) {
            boxWeight += item.getWeight();
        }
        return boxWeight;
    }

    public boolean compare(Box<?> another) {
        return Math.abs(this.getWeight() - another.getWeight()) < 0.001f;
    }

    public void addFromBox(Box<T> another) {
        if (!another.items.isEmpty()) {
            this.items.addAll(another.items);
            another.items.clear();
        }
    }
}
