package Lesson5_MFU;

public class MainClass {

    public static void main(String[] args) {
        MFU xerox = new MFU(2, 5);
        xerox.printDoc(5);
        xerox.scanDoc(3);
//        xerox.copyDoc(3);
    }
}
