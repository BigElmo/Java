import java.util.Arrays;
import java.util.Random;

public class HomeWork3 {
// Генератор целочисленных массивов
    public static int[] getRandomArray(int length, int min, int max) {
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }
// Принтер целочисленных массивов
    public static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    //К заданию 5
    public static int[] getArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }
    //К заданию 6
    public static int getMinElement(int[] array) {
        int min = array[0];
        for (int element : array) {
            if (element < min) min = element;
        }
        return min;
    }
    //К заданию 6
    public static int getMaxElement(int[] array) {
        int max = array[0];
        for (int element : array) {
            if (element > max) max = element;
        }
        return max;
    }
    //К заданию 7
    public static boolean checkBalance(int[] array) {
        int leftSum = 0;
        int rightSum = 0;
        for (int i : array) {
            rightSum += i;
        }
        for (int i : array) {
            leftSum += i;
            rightSum -= i;
            if (leftSum == rightSum) return true;
        }
        return false;
    }
    //К заданию 8
    public static void changeArray(int[] array, int n) {
        int index;
        if (n > 0) {
            for (int i = 0; i < array.length - n; i++) {
                index = array[i];
                array[i] = array[i + n];
                array[i + n] = index;
            }
        }
        else {
            for (int i = array.length - 1; i >= n * -1; i--) {
                index = array[i];
                array[i] = array[i + n];
                array[i + n] = index;
            }
        }
    }

    public static void main(String[] args) {
        //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        //С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] array1 = getRandomArray(20, 0, 1);
        System.out.println("Массив 1 до изменений:");
        printArray(array1);
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == 0) array1[i] = 1;
            else array1[i] = 0;
        }
        System.out.println("Массив 1 после изменений:");
        printArray(array1);
        System.out.println();

        //2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
        int[] array2 = new int[100];
        System.out.println("Массив 2 до изменений:");
        printArray(array2);
        for (int i = 0; i < array2.length; i++) {
            array2[i] = i + 1;
        }
        System.out.println("Массив 2 после изменений:");
        printArray(array2);
        System.out.println();

        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] array3 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println("Массив 3 до изменений:");
        printArray(array3);
        for (int i = 0; i < array3.length; i++) {
            if (array3[i] < 6) array3[i] *= 2;
        }
        System.out.println("Массив 3 после изменений:");
        printArray(array3);
        System.out.println();

        //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
        //заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно). Определить элементы
        //одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
        int[][] array4 = new int[10][10];
        System.out.println("Массив 4:");
        for (int i = 0; i < array4.length; i++) {
            for (int j = 0; j < array4.length; j++) {
                if (i == j) {
                    array4[i][j] = 1;
                    array4[i][array4.length-1-i] = 1;
                    array4[array4.length-1-j][j] = 1;
                }
                System.out.print(array4[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();

        //5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий
        //одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
        int[] array5 = getArray(20, 33);
        System.out.println("Массив 5:");
        printArray(array5);
        System.out.println();

        //6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
        int[] array6 = getRandomArray(20, 0, 100);
        System.out.println("Массив 6. Минимум " + getMinElement(array6) + "; максимум " + getMaxElement(array6));
        printArray(array6);
        System.out.println();

        //7. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если
        //в массиве есть место, в котором сумма левой и правой части массива равны.
        //**Примеры:
        //    checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
        //    checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1
        int[] array7_1 = { 2, 2, 2, 1, 2, 2, 10, 1 };
        int[] array7_2 = { 1, 1, 1, 2, 1 };
        int[] array7_3 = getRandomArray(10, 0, 10);
        System.out.println("Задание 7:");
        System.out.println("2, 2, 2, 1, 2, 2, 10, 1 - " + checkBalance(array7_1));
        System.out.println("1, 1, 1, 2, 1 - " + checkBalance(array7_2));
        printArray(array7_3);
        System.out.println(checkBalance(array7_3));
        System.out.println();

        //8. *** Написать метод, которому на вход подается одномерный массив и число n
        //(может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
        //Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        //Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
        //При каком n в какую сторону сдвиг можете выбирать сами.
        int[] array8 = getRandomArray(10, 0, 100);
        System.out.println("Массив 8 до изменений:");
        printArray(array8);
        changeArray(array8, -2);
        System.out.println("Массив 8 после изменений:");
        printArray(array8);
        System.out.println();
    }
}
