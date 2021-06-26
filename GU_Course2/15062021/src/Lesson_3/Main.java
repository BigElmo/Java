package Lesson_3;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        //Задание 1.
        String[] strArr = {"Alexey", "Boris", "Anna", "Kate", "Egor", "John", "Roman", "Lucy", "Bruce", "Pavel",
                "Alexey", "Boris", "Andrey", "Kate", "Boris", "Egor", "John", "Roman", "Lucy", "Bruce", "Pavel"};
        HashMap<String, Integer> hm = new HashMap<>(20);
        for (String str : strArr) {
            if (!hm.containsKey(str)) {
                hm.put(str, 0);
            }
            hm.put(str, hm.get(str) + 1);
        }
        System.out.println(hm);
        System.out.println();

        //Задание 2.
        Phonebook book = new Phonebook(100);
        book.addPhone("Dmitriy", 89089089008L);
        book.addPhone("Dmitriy", 89149149149L);
        book.addPhone("Ivan", 89649649649L);
        System.out.println(book.getPhone("Dmitriy"));
        System.out.println(book.getPhone("Alexey"));
        System.out.println();
        book.printPhone("Dmitriy");
        book.printPhone("Alexey");
        book.printPhone("Ivan");
        book.printPhone("Roman");
    }
}
