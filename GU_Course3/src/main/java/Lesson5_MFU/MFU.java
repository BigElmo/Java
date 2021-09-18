package Lesson5_MFU;

public class MFU {
    private final int printTimeSec;
    private final int scanTimeSec;
    private final int copyTimeSec;

    public MFU(int printTimeSec, int scanTimeSec) {
        this.printTimeSec = printTimeSec;
        this.scanTimeSec = scanTimeSec;
        this.copyTimeSec = scanTimeSec + printTimeSec;
    }

    public void scanDoc(int page_count) {
        Thread scan = new Thread(() -> {
            for (int i = 1; i <= page_count; i++) {
                try {
                    System.out.println("Идёт сканирование страницы " + i);
                    Thread.sleep(scanTimeSec * 1000L);
                    System.out.println("Сканирование страницы " + i + " завершено.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        scan.start();
    }

    public void copyDoc(int page_count) {
        scanDoc(page_count);
        printDoc(page_count);
    }

    public void printDoc(int page_count) {
        Thread print = new Thread(() -> {
            for (int i = 1; i <= page_count; i++) {
                try {
                    System.out.println("Идёт печать страницы " + i);
                    Thread.sleep(printTimeSec * 1000L);
                    System.out.println("Печать страницы " + i + " завершено.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        print.start();
    }
}
