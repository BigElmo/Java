package Lesson3;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("NiHao!");
        Random random = new Random();
        File task1_file1 = new File("task1_file1.txt");
        File task2_file1 = new File("task2_file1.txt");
        File task2_file2 = new File("task2_file2.txt");
        File task2_file3 = new File("task2_file3.txt");
        File task2_file4 = new File("task2_file4.txt");
        File task2_file5 = new File("task2_file5.txt");
        File task2_resultFile = new File("task2_resultFile.txt");
        byte[] random_barr_50 = new byte[50];
        random.nextBytes(random_barr_50);
        byte[] random_barr_100 = new byte[100];
        random.nextBytes(random_barr_100);
        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(task1_file1))) {
            out.write(random_barr_50);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<File> task2_files = new ArrayList<>();
        task2_files.add(task2_file1);
        task2_files.add(task2_file2);
        task2_files.add(task2_file3);
        task2_files.add(task2_file4);
        task2_files.add(task2_file5);
        for (int i = 0; i < task2_files.size(); i++) {
            try (OutputStream out = new BufferedOutputStream(new FileOutputStream("task2_file" + i))) {
                out.write(random_barr_100);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//      1. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
        byte[] task1_barr = new byte[50];
        try (FileInputStream in = new FileInputStream(task1_file1)) {
            int count;
            while ((count = in.read(task1_barr)) > 0) {
                for (int i = 0; i < count; i++) {
                    System.out.print(task1_barr[i] + " ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
