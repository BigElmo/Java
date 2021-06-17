package Lesson_1.Marathon.Obstacles;

import Lesson_1.Marathon.Competitors.Competitor;
import Lesson_1.Marathon.Competitors.Team;

public class Course {
    private final Obstacle[] obstacles = new Obstacle[3];

    public Course(Obstacle obs1, Obstacle obs2, Obstacle obs3) {
        obstacles[0] = obs1;
        obstacles[1] = obs2;
        obstacles[2] = obs3;
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
