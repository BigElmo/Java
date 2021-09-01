public class Main {

    public static void main(String[] args) {
        System.out.println("Holla!");
//        1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
        String[] strArr = {"A", "B", "C", "D", "E", "F"};
        Integer[] intArr = {1, 2, 3, 4, 5, 6};
        changeElements(strArr, 1, 3);
        changeElements(intArr, 1, 3);
        printArr(strArr);
        System.out.println();
        printArr(intArr);
    }

    public static <T> void printArr(T[] arr) {
        for (T element : arr) {
            System.out.print(element + "  ");
        }
    }

    public static <T> void changeElements(T[] arr, int e1, int e2) {
        T temp = arr[e1];
        arr[e1] = arr[e2];
        arr[e2] = temp;
    }
}