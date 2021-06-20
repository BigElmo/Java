package Lesson_2;

import Lesson_2.Exceptions.MyArrayDataException;
import Lesson_2.Exceptions.MyArraySizeException;

public class MyArray {
    private String[][] stringArr;

    public MyArray(String[][] stringArr) {
        this.stringArr = stringArr;
    }

    public int getSum() throws MyArraySizeException, MyArrayDataException {
        if (stringArr.length != 4) throw new MyArraySizeException("Массивов должно быть 4!", stringArr.length);
        int index = 0;
        int sum = 0;
        for (String[] strings : stringArr) {
            if (strings.length != 4) throw new MyArraySizeException("Длина каждого массива должна быть 4!", strings.length);
            for (String e : strings) {
                index++;
                try {
                    sum += Integer.parseInt(e);
                } catch (Exception exception) {
                    exception.printStackTrace();
                    System.out.println("Вы ввели " + e + " вместо целого числа в ячейке " + index);
                }
            }
        }
        return sum;
    }
}
