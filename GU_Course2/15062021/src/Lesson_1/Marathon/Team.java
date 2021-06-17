package Lesson_1.Marathon;

public class Team {
    private final String name;
    public Competitor[] competitors = new Competitor[4];

    public Team(String name, Competitor comp1, Competitor comp2, Competitor comp3, Competitor comp4) {
        this.name = name;
        competitors[0] = comp1;
        competitors[1] = comp2;
        competitors[2] = comp3;
        competitors[3] = comp4;
    }

    public void showResults() {
        for (Competitor c : competitors) {
            c.info();
        }
    }
}
