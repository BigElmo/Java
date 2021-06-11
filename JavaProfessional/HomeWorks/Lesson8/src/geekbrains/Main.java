package geekbrains;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void printArray(String[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(i%5 == 0) System.out.println();
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    private static void printMatches(String playerWord, String guessedWord) {
        int minLenght = Math.min(playerWord.length(), guessedWord.length());
        for (int i = 0; i < minLenght; i++) {
            if (playerWord.charAt(i) == guessedWord.charAt(i)) {
                System.out.print(guessedWord.charAt(i));
            } else System.out.print("#");
        }
        for (int j = 0; j < 15-minLenght; j++) {
            System.out.print("#");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        //new MainWindow(); //Здесь домашка про работу с графикой

        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random random = new Random();
        String guessedWord = words[random.nextInt(words.length)];
        String playerWord = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Отгадайте слово из списка:");
        printArray(words); // Вывод списка слов можно отключить для усложнения игры
        do {
            System.out.println("Введите слово:");
            playerWord = scanner.nextLine();
            if(playerWord.equals(guessedWord)) {
                break;
            } else {
                printMatches(playerWord, guessedWord);
            }
        } while (true);
        System.out.println("Угадали!");
    }
}
