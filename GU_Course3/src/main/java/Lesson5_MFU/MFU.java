package Lesson5_MFU;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MFU {
    private final int printTimeSec;
    private final int scanTimeSec;
    CountDownLatch scanCDL;
    CountDownLatch printCDL;
    ExecutorService scanSvc;
    ExecutorService printSvc;

    public MFU(int printTimeSec, int scanTimeSec) {
        this.printTimeSec = printTimeSec;
        this.scanTimeSec = scanTimeSec;
    }

    public void scanDoc(int page_count) {
        scanCDL = new CountDownLatch(page_count);
        scanSvc = Executors.newSingleThreadExecutor();
        System.out.println("Сканирование...");
        for (int i = 1; i <= page_count; i++) {
            final int w = i;
            scanSvc.execute(() -> {
                try {
                    System.out.println("Идёт сканирование страницы " + w);
                    Thread.sleep(scanTimeSec * 1000L);
                    System.out.println("Сканирование страницы " + w + " завершено.");
                    scanCDL.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        try {
            scanCDL.await();
            System.out.println("Сканирование завершено.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scanSvc.shutdown();
    }

    public void copyDoc(int page_count) {
        scanDoc(page_count);
        printDoc(page_count);
    }

    public void printDoc(int page_count) {
        printCDL = new CountDownLatch(page_count);
        printSvc = Executors.newSingleThreadExecutor();
        System.out.println("Печать...");
        for (int i = 1; i <= page_count; i++) {
            final int w = i;
            printSvc.execute(() -> {
                try {
                    System.out.println("Идёт печать страницы " + w);
                    Thread.sleep(printTimeSec * 1000L);
                    System.out.println("Печать страницы " + w + " завершена.");
                    printCDL.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        try {
            printCDL.await();
            System.out.println("Печать завершена.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printSvc.shutdown();
    }
}
