package Lesson3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("NiHao!");
        Random random = new Random();
        long programStartTime = System.currentTimeMillis();

//        Файл для 1-го задания
        byte[] random_barr_50 = new byte[50];
        random.nextBytes(random_barr_50);
        try (OutputStream out = new BufferedOutputStream(new FileOutputStream("task1_file1.txt"))) {
            out.write(random_barr_50);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Файлы для второго задания
        byte[] random_barr_100 = new byte[100];
        random.nextBytes(random_barr_100);
        for (int i = 1; i <= 5; i++) {
            try (OutputStream out = new BufferedOutputStream(new FileOutputStream("task2_file" + i + ".txt"))) {
                out.write(random_barr_100);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        Файл для третьего задания
        String text = "Java — строго типизированный объектно-ориентированный язык программирования общего назначения, " +
                "разработанный компанией Sun Microsystems (в последующем приобретённой компанией Oracle). " +
                "Разработка ведётся сообществом, организованным через Java Community Process; " +
                "язык и основные реализующие его технологии распространяются по лицензии GPL. " +
                "Права на торговую марку принадлежат корпорации Oracle.";
        try (BufferedWriter out = new BufferedWriter(new FileWriter("task3_file1.txt"))) {
            for (int i = 0; i < 100000; i++) {
                out.write(text + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        1. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
        byte[] task1_barr = new byte[128];
        try (InputStream in = new FileInputStream("task1_file1.txt")) {
            int count;
            while ((count = in.read(task1_barr)) > 0) {
                for (int i = 0; i < count; i++) {
                    System.out.print(task1_barr[i] + " ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        2. Последовательно сшить 5 файлов в один (файлы примерно 100 байт).
        ArrayList<InputStream> alis = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            try {
                alis.add(new FileInputStream("task2_file" + i + ".txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        Enumeration<InputStream> eis = Collections.enumeration(alis);
        try (SequenceInputStream seq = new SequenceInputStream(eis);
             FileOutputStream out = new FileOutputStream("task2_result.txt")) {
            int x;
            while ((x = seq.read()) != -1) {
                out.write(x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        3. Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb).
//        Вводим страницу (за страницу можно принять 1800 символов), программа выводит ее в консоль.
//        Контролируем время выполнения: программа не должна загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.
        long task3StartTime = System.currentTimeMillis();
        try (BufferedReader in = new BufferedReader(new FileReader("task3_file1.txt"))) {
            String str;
            while ((str = in.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long programEndTime = System.currentTimeMillis();
        System.out.println("Чтение из файла выполнено за: " + (programEndTime - task3StartTime) + "мс");
        System.out.println("Программа выполнена за: " + (programEndTime - programStartTime) + "мс");
    }
}
