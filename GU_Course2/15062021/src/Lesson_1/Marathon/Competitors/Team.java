package Lesson_1.Marathon.Competitors;

public class Team {
    private final String name;
    public Competitor[] competitors;

    public Team(String name, Competitor...competitors) {
        this.name = name;
        this.competitors = competitors;
    }

    public void showResults() {
        for (Competitor c : competitors) {
            c.info();
        }
    }
}
