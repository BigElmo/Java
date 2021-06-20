package Lesson_2.Exceptions;

public class MyArraySizeException extends Exception {
    int num;

    public MyArraySizeException (String msg, int num) {
        super(msg);
        this.num = num;
    }
}
