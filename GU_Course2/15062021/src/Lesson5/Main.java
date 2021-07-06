package Lesson5;

import java.util.Arrays;

public class Main {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;
    static final int QUARTER = SIZE / 4;

    public static void main(String[] args) {
        singleThreadMethod();
        doubleThreadMethod();
        quadThreadMethod();
    }

    public static void singleThreadMethod() {
        System.out.println("Single thread method");
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Single thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
        System.out.println();
    }

    public static void doubleThreadMethod() {
        System.out.println("Double thread method");
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr1.length; i++) {
                    arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.out.println("Thread 1 finished");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr2.length; i++) {
                    arr2[i] = (float) (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.out.println("Thread 2 finished");
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);
        System.out.println("Double thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
        System.out.println();
    }

    public static void quadThreadMethod() {
        System.out.println("Quad thread method");
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        float[] arr1 = new float[QUARTER];
        float[] arr2 = new float[QUARTER];
        float[] arr3 = new float[QUARTER];
        float[] arr4 = new float[QUARTER];
        System.arraycopy(arr, 0, arr1, 0, QUARTER);
        System.arraycopy(arr, QUARTER, arr2, 0, QUARTER);
        System.arraycopy(arr, QUARTER*2, arr3, 0, QUARTER);
        System.arraycopy(arr, QUARTER*3, arr4, 0, QUARTER);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr1.length; i++) {
                    arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.out.println("Thread 1 finished");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr2.length; i++) {
                    arr2[i] = (float) (arr2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.out.println("Thread 2 finished");
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr3.length; i++) {
                    arr3[i] = (float) (arr3[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.out.println("Thread 3 finished");
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arr4.length; i++) {
                    arr4[i] = (float) (arr4[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.out.println("Thread 4 finished");
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(arr1, 0, arr, 0, QUARTER);
        System.arraycopy(arr2, 0, arr, QUARTER, QUARTER);
        System.arraycopy(arr3, 0, arr, QUARTER*2, QUARTER);
        System.arraycopy(arr4, 0, arr, QUARTER*3, QUARTER);
        System.out.println("Quad thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
        System.out.println();
    }
}
