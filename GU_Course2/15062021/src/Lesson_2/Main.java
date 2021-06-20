package Lesson_2;

public class Main {

    public static int sum(String[][] stringArr) {
        int sum = 0;
        for (String[] strings : stringArr) {
            for (String e : strings) {
                sum += Integer.parseInt(e);
                System.out.println(e);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[][] strings = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        System.out.println(sum(strings));
    }
}
