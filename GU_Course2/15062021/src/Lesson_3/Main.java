package Lesson_3;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

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
    }
}
