import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        System.out.println("Holla!");
        String[] strArr = {"A", "B", "C", "D", "E", "F"};
        Integer[] intArr = {1, 2, 3, 4, 5, 6};
        changeElements(strArr, 1, 3);
        changeElements(intArr, 1, 3);
        printArr(strArr);
        System.out.println();
        printArr(intArr);
        System.out.println();
        ArrayList<String> strList = convertToArrayList(strArr);
        ArrayList<Integer> intList = convertToArrayList(intArr);
        System.out.println(strList);
        System.out.println(intList);
        System.out.println();

        Box<Apple> appleBox = new Box<>();
        for (int i = 0; i < 10; i++) {
            appleBox.addItem(new Apple());
        }
        Box<Orange> orangeBox = new Box<>();
        for (int i = 0; i < 10; i++) {
            orangeBox.addItem(new Orange());
        }
        Box<Apple> appleBox1 = new Box<>();
        for (int i = 0; i < 15; i++) {
            appleBox1.addItem(new Apple());
        }
        System.out.println("Apple box contains " + appleBox.getCount() + " and weight " + appleBox.getWeight());
        System.out.println("Orange box contains " + orangeBox.getCount() + " and weight " + orangeBox.getWeight());
        System.out.println("Apple1 box contains " + appleBox1.getCount() + " and weight " + appleBox1.getWeight());

        System.out.println(appleBox.compare(orangeBox));
        System.out.println(appleBox.compare(appleBox1));
        System.out.println(orangeBox.compare(appleBox1));

        appleBox.addFromBox(appleBox1);
        System.out.println("Apple box contains " + appleBox.getCount() + " and weight " + appleBox.getWeight());
        System.out.println("Orange box contains " + orangeBox.getCount() + " and weight " + orangeBox.getWeight());
        System.out.println("Apple1 box contains " + appleBox1.getCount() + " and weight " + appleBox1.getWeight());
    }

    public static <T> void printArr(T[] arr) {
        for (T element : arr) {
            System.out.print(element + "  ");
        }
    }

//    1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
    public static <T> void changeElements(T[] arr, int e1, int e2) {
        T temp = arr[e1];
        arr[e1] = arr[e2];
        arr[e2] = temp;
    }
//    2. Написать метод, который преобразует массив в ArrayList;
    public static <T> ArrayList<T> convertToArrayList(T[] arr) {
        ArrayList<T> arrList = new ArrayList<>();
        Collections.addAll(arrList, arr);
        return arrList;
    }
}