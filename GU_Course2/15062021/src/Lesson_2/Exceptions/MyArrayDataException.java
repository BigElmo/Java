package Lesson_2.Exceptions;

public class MyArrayDataException extends Exception{
    int num;

    public MyArrayDataException (String msg, int num) {
        super(msg);
        this.num = num;
    }
}
