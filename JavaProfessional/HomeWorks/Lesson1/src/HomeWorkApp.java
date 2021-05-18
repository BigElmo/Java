public class HomeWorkApp {


    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 10;
        int b = -55;
        if ((a + b) >= 0) System.out.println("Сумма положительная");
        else System.out.println("Сумма отрицательная");
    }

    public static void printColor() {
        int value = 1000;
        if (value <= 0) System.out.println("Red");
        else if ((value > 0) && (value <= 100)) System.out.println("Yellow");
        else System.out.println("Green");
    }

    public static void compareNumbers() {
        int a = 100;
        int b = 30;
        if (a >= b) System.out.println("А больше или равно Б");
        else System.out.println("А меньше Б");
    }
}
