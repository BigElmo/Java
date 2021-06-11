package geekbrains;

public class Main {

    public static void main(String[] args) {
        Bowl bowl = new Bowl(100);

        Cat[] catBand = new Cat[] {
                new Cat("Барсик", 50),
                new Cat("Мурзик", 50),
                new Cat("Василий", 30),
                new Cat("Бася", 10),
                new Cat("Мурка", 5),
                new Cat("Царапка", 15),
                new Cat("Щекотка", 20),
                new Cat("Борис", 20),
                new Cat("Леопольд", 5),
                new Cat("Том", 30)
        };

        for (Cat cat : catBand) {
            cat.feed(bowl);
        }
    }
}
