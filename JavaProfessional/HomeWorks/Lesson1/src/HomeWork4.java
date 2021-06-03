import java.util.Random;
import java.util.Scanner;

public class HomeWork4 {

    public static char[][] map;
    public static int mapSize = 3;
    public static int winSize = 3;

    public static final char DOT_EMPTY = '.';
    public static final char DOT_X = 'X';
    public static final char DOT_0 = '0';


    public static void initGame() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Укажите размер поля от 3 до 5");
            mapSize = scanner.nextInt();
        } while (mapSize < 3 || mapSize > 5);
        if(mapSize > 3) {
            do {
                System.out.println("Укажите количество фишек для победы от 3 до " + mapSize);
                winSize = scanner.nextInt();
            } while (winSize < 3 || winSize > mapSize);
        }
        System.out.println("Количесто фишек в ряд для победы - " + winSize);
        map = new char[mapSize][mapSize];
        for(int i = 0; i < mapSize; i++) {
            for(int j = 0; j < mapSize; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for(int i = 0; i <= mapSize; i++) {
            System.out.print(i);
            for(int j = 0; j < mapSize; j++) {
                if(i == 0) {
                    System.out.print("  " + (j + 1));
                } else {
                    System.out.print("  " + map[i-1][j]);
                }
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        System.out.println("-= ХОД ИГРОКА =-");
        Scanner scanner = new Scanner(System.in);
        int x;
        int y;
        do {
            System.out.println("Введите поочерёдно координаты X и Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCorrectTurn(x, y));
        map[y][x] = DOT_X;
    }

    public static void aiTurn() {
        System.out.println("-= ХОД ВЕЛИКОГО РАНДОМА =-");
        Random random = new Random();
        int x;
        int y;
        do {
            x = random.nextInt(mapSize);
            y = random.nextInt(mapSize);
        } while (!isCorrectTurn(x, y));
        map[y][x] = DOT_0;
    }

    public static boolean isWinner(char dot) {
        //Проверки строк и столбцов сделал.
        //Диагональные комбинации проверяются только на длинных диагоналях.
        //Остальные диагонали не придумал, как проверять, чтоб не перечислять все комбинации через if.
        //Есть ощущение, что с диагоналями всё можно было как-то проще сделать...
        int rowCount = 0;
        int colCount = 0;
        int leftDiagCount = 0;
        int rightDiagCount = 0;

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (map[i][j] != dot) {
                    rowCount = 0;
                } else rowCount++;
                if (map[j][i] != dot) {
                    colCount = 0;
                } else colCount++;
                if (map[j][j] != dot) {
                    leftDiagCount = 0;
                } else leftDiagCount++;
                if (map[j][mapSize-j-1] != dot) {
                    rightDiagCount = 0;
                } else rightDiagCount++;
                if ((colCount == winSize) || (rowCount == winSize) || (rightDiagCount == winSize) || (leftDiagCount == winSize)) {
                    return true;
                }
            }
            rightDiagCount = 0;
            leftDiagCount = 0;
            rowCount = 0;
            colCount = 0;
        }
        return false;
    }

    public static boolean isNoWinner() {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isCorrectTurn(int x, int y) {
        if (x < 0 || y < 0 || x >= mapSize || y >= mapSize) {
            return false;
        }
        if (map[y][x] == DOT_EMPTY) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("||| ДОБРО ПОЖАЛОВАТЬ В ИГРУ КРЕСТИКИ-НОЛИКИ |||");
        initGame();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (isWinner(DOT_X)) {
                System.out.println("ИГРОК ПОБЕДИЛ!!!");
                break;
            }
            if (isNoWinner()) {
                System.out.println("НИЧЬЯ!");
                break;
            }
            aiTurn();
            printMap();
            if (isWinner(DOT_0)) {
                System.out.println("ВЕЛИКИЙ РАНДОМ ПОБЕДИЛ!!!");
                break;
            }
            if (isNoWinner()) {
                System.out.println("НИЧЬЯ!");
                break;
            }
        }
        System.out.println("-= ИГРА ЗАКОНЧЕНА =-");
    }
}
