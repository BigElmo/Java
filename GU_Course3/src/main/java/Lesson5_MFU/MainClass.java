package Lesson5_MFU;

public class MainClass {

    public static void main(String[] args) {
        MFU xerox = new MFU(1, 3);
        xerox.printDoc(5);
        xerox.printDoc(6);
        xerox.scanDoc(3);
        xerox.copyDoc(3);
    }
}
