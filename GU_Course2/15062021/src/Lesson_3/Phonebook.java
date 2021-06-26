package Lesson_3;

import java.util.HashMap;

public class Phonebook {
    private HashMap<String, Long> contacts;

    public Phonebook(int size) {
        contacts = new HashMap<>(size);
    }

    public void addPhone(String name, Long phone) {
        contacts.put(name, phone);
    }

    public Long getPhone(String name) {
        return contacts.getOrDefault(name, 0L);
    }
}
