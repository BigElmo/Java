package Lesson5;

import java.util.Arrays;

public class Main {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;
    static final int QUARTER = SIZE / 4;

    public static void main(String[] args) {
        System.out.println("Hello");
        singleThreadMethod();
        doubleThreadMethod();
        quadThreadMethod();
    }

    public static void singleThreadMethod() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    public static void doubleThreadMethod() {
        System.out.println("doubleThread");
    }

    public static void quadThreadMethod() {
        System.out.println("quadThread");
    }
}
