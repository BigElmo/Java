package Lesson_3;

import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook {
    private HashMap<String, ArrayList<Long>> contacts;

    public Phonebook(int size) {
        contacts = new HashMap<>(size);
    }

    public void addPhone(String name, Long phone) {
        if (!contacts.containsKey(name)) {
            contacts.put(name, new ArrayList<>());
        }
        contacts.get(name).add(phone);
    }

    public ArrayList<Long> getPhone(String name) {
        return contacts.get(name);
    }

    public void printPhone(String name) {
        System.out.println(name + ":");
        if (!contacts.containsKey(name) || contacts.get(name).isEmpty()) {
            System.out.println("No data");
        } else {
            System.out.println(contacts.get(name));
        }
        System.out.println();
    }
}
