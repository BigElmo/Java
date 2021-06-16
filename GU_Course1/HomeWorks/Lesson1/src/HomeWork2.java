public class HomeWork2 {

//  1. Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах
//  от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
    public static boolean isInRange(int a, int b) {
        int sum = a + b;
        return ((sum >= 10) && (sum <= 20));
    }

//  2. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать
//  в консоль, положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
    public static void printPositiveOrNegative(int a) {
        if (a >= 0) System.out.println("Number is positive");
        else System.out.println("Number is negative");
    }

//  3. Написать метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число
//  отрицательное, и вернуть false если положительное.
    public static boolean isNegative(int a) {
        return (a < 0);
    }

//  4. Написать метод, которому в качестве аргументов передается строка и число, метод должен отпечатать в консоль
//  указанную строку, указанное количество раз;
    public static void printString(String str, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(str);
        }
    }

//  5. * Написать метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true, не високосный - false).
//  Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static boolean isLeapYear(int year) {
        return ((year % 400 == 0) || (year % 4 == 0) && (year % 100 != 0));
    }
}
