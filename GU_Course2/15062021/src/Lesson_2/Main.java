package Lesson_2;

import Lesson_2.Exceptions.MyArrayDataException;
import Lesson_2.Exceptions.MyArraySizeException;

public class Main {

    public static void main(String[] args) {
        MyArray arr = new MyArray(new String[][]{{"1", "Хаха", "3", "4", "5"}, {"5", "6", "7", "8а"}, {"9", "10", "11", "12"}, {"13п", "14", "15", "16"}});
        try {
            System.out.println(arr.getSum());
        } catch (MyArraySizeException | MyArrayDataException sizeException) {
            sizeException.printStackTrace();
        }
    }
}
