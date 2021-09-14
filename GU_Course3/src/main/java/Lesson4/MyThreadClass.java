package Lesson4;

public class MyThreadClass {
    private static volatile char currentChar = 'A';
    private static final Object mon = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (mon) {
                for (int i = 0; i < 5; i++) {
                    while (currentChar != 'A') {
                        try {
                            mon.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(currentChar);
                    currentChar = 'B';
                    mon.notifyAll();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (mon) {
                for (int i = 0; i < 5; i++) {
                    while (currentChar != 'B') {
                        try {
                            mon.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(currentChar);
                    currentChar = 'C';
                    mon.notifyAll();
                }
            }
        });
        Thread t3 = new Thread(() -> {
            synchronized (mon) {
                for (int i = 0; i < 5; i++) {
                    while (currentChar != 'C') {
                        try {
                            mon.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(currentChar);
                    currentChar = 'A';
                    mon.notifyAll();
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
