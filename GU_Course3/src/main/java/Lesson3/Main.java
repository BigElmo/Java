package Lesson3;

import java.io.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("NiHao!");
        Random random = new Random();
        File file = new File("Project_files/Lesson3_files/file1.txt");
        file.mkdirs();
        byte[] barr = new byte[50];
        random.nextBytes(barr);
//        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
