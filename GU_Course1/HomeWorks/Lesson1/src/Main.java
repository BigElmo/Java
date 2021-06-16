public class Main {

    public static void main(String[] args) {
//  4. Создать массив из 5 сотрудников.
        Person[] personArray = new Person[5];
        personArray[0] = new Person("Александр Иванов", "Системный администратор", "a_ivanov@corp.com", "89998887766", 65000, 34);
        personArray[1] = new Person("Алексей Соколов", "Веб-разработчик", "a_sokolov@corp.com", "89990007766", 72000, 31);
        personArray[2] = new Person("Иван Карпов", "Руководитель ИТ-отдела", "i_karpov@corp.com", "89147776655", 97000, 45);
        personArray[3] = new Person("Дмитрий Джафар", "1С-разработчик", "d_jafar@corp.com", "88917776643", 110000, 46);
        personArray[4] = new Person("Елена Наумова", "1С-разработчик", "e_naumova@corp.com", "87768884411", 92000, 41);

//  5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
        for(Person person : personArray) {
            if(person.age > 40) person.printInfo();
        }
    }
}
