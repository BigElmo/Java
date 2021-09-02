import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Holla!");
//        String[] strArr = {"A", "B", "C", "D", "E", "F"};
//        Integer[] intArr = {1, 2, 3, 4, 5, 6};
//        changeElements(strArr, 1, 3);
//        changeElements(intArr, 1, 3);
//        printArr(strArr);
//        System.out.println();
//        printArr(intArr);
//        System.out.println();
//        ArrayList<String> strList = convertToArrayList(strArr);
//        ArrayList<Integer> intList = convertToArrayList(intArr);
//        System.out.println(strList);
//        System.out.println(intList);

        Box<Apple> appleBox = new Box<>();
        Apple a1 = new Apple();
        Apple a2 = new Apple();
        appleBox.addItem(a1);
        appleBox.addItem(a2);
        appleBox.getCount();

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