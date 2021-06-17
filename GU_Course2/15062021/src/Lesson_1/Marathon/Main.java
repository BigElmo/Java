package Lesson_1.Marathon;

public class Main {
    public static void main(String[] args) {
        Course course = new Course(); // Создаем полосу препятствий
        Team team1 = new Team("Avengers"); // Создаем команду
        course.doIt(team1); // Просим команду пройти полосу
        team1.showResults(); // Показываем результаты
    }
}