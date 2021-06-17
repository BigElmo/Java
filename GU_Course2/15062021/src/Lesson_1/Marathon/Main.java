package Lesson_1.Marathon;

public class Main {
    public static void main(String[] args) {
        Course course = new Course(new Cross(100), new Wall(2), new Water(10)); // Создаем полосу препятствий
        Team team1 = new Team("Avengers", new Human("Боб"), new Cat("Барсик"), new Dog("Бобик"), new Dog("Шарик")); // Создаем команду
        course.doIt(team1); // Просим команду пройти полосу
        team1.showResults(); // Показываем результаты
    }
}