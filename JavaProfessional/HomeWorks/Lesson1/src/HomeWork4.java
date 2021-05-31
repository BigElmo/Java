import java.util.Scanner;

public class HomeWork4 {

    public final char PLAYER_DOT = 'X';
    public final char AI_DOT = '0';

    public static char[][] initMap(int mapSize) {
        char[][] map = new char[mapSize][mapSize];
        for(int i = 0; i < mapSize; i++) {
            for(int j = 0; j < mapSize; j++) {
                map[i][j] = '.';
            }
        }
        return map;
    }

    public static void printMap(char[][] map) {
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map.length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        //1. приветствие
        System.out.println("ДОБРО ПОЖАЛОВАТЬ В ИГРУ КРЕСТИКИ-НОЛИКИ");
        //2. приглашение ввести размер поля и количество фишек для победы
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите размер поля от 3 до 5");
        int mapSize = scanner.nextInt();
        System.out.println("Укажите количество фишек для победы от 3 до 5");
        int winSize = scanner.nextInt();
        //3. инициализация поля
        char[][] map = initMap(mapSize);
        //4. вывод поля на экран (доработать вывод сетки координат)
        printMap(map);

        //5. ход игрока
        //6. приглашение указать координаты хода
        //7. проверка координат
        //8. инициализация поля
        //9. вывод поля
        //10. проверка победы игрока

        //11. ход ИИ
        //12. получение координат хода у генератора
        //13. проверка координат
        //14. инициализация поля
        //15. вывод поля
        //16. проверка победы ИИ

    }
}
