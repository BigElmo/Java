package Lesson_3;

public class Main {

    public static void main(String[] args) {

//        String[] strArr = {"Alexey", "Boris", "Anna", "Kate", "Egor", "John", "Roman", "Lucy", "Bruce", "Pavel",
//                "Alexey", "Boris", "Andrey", "Kate", "Boris", "Egor", "John", "Roman", "Lucy", "Bruce", "Pavel"};
//        HashMap<String, Integer> hm = new HashMap<>(20);
//        for (String str : strArr) {
//            if (!hm.containsKey(str)) {
//                hm.put(str, 0);
//            }
//            hm.put(str, hm.get(str) + 1);
//        }
//        System.out.println(hm);

        Phonebook book = new Phonebook(100);
        book.addPhone("Dmitriy", 89089089008L);
        System.out.println(book.getPhone("Dmitriy"));
        System.out.println(book.getPhone("Alexey"));


    }
}
