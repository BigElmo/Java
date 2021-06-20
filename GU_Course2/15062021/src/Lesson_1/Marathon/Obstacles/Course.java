package Lesson_1.Marathon.Obstacles;

import Lesson_1.Marathon.Competitors.Competitor;
import Lesson_1.Marathon.Competitors.Team;

public class Course {
    private final Obstacle[] obstacles;

    public Course(Obstacle...obstacles) {
        this.obstacles = obstacles;
    }
    public void doIt(Team team) {
        for (Competitor c : team.competitors) {
            for (Obstacle o : obstacles) {
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }
        }
    }
}
