package Lesson3;

import java.io.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("NiHao!");
        Random random = new Random();
        File file = new File("file1.txt");
        byte[] random_barr = new byte[50];
        random.nextBytes(random_barr);

        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
            out.write(random_barr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] task1_barr = new byte[50];
        try (FileInputStream in = new FileInputStream(file)) {
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
