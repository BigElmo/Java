public class Person {

//  1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
    String fullName;
    String profession;
    String eMail;
    String phone;
    int salary;
    int age;
//  2. Конструктор класса должен заполнять эти поля при создании объекта.
    Person(String fullName, String profession, String eMail, String phone, int salary, int age) {
        this.fullName = fullName;
        this.profession = profession;
        this.eMail = eMail;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
//  3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    void printInfo() {
        System.out.println(this.fullName + " " + this.profession + " " + this.eMail + " " + this.phone + " " + this.salary + " " + this.age);
    }
}
