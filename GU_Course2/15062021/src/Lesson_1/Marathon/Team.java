package Lesson_1.Marathon;

public class Team {
    private final String name;
    public Competitor[] competitors = {new Human("Боб"), new Cat("Барсик"), new Dog("Бобик")};

    public Team(String name) {
        this.name = name;
    }

    public void showResults() {
        for (Competitor c : competitors) {
            c.info();
        }
    }
}
