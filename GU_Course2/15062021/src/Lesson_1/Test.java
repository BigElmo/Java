package Lesson_1;

public class Test{

}

class Tetst1 {
    public static void main(String[] args) {
        int i = 8;
        System.out.println(i++);
        System.out.println(i+1);
        System.out.println(i);
    }
}


















//
//class Task1 {
//    public static void main(String[] args) {
//        System.out.println(new Task1());
//    }
//}
//


class A {
    {
        System.out.println("dym a");
    }

    static {
        System.out.println("stat a");
    }

    A(){
        System.out.println("A");
    }

    public static void main(String[] args) {
        new A();
    }
}































//class TestEquals {
//    public static void main(String[] args) {
//        String s1 = new String("Bicycle");
//        String s2 = new String("bicycle");
//        System.out.println(s1.equals(s2) == s2.equals(s1));
//    }
//}


































//
//class TestInc {
//    public static void main(String[] args) {
//        int x = 0;
//        System.out.print(x++==++x);
//    }
//}


// 1 --------------------------
class Mountain {
    static String name = "Himalaya";
    static Mountain getMountain() {
        System.out.println("Getting Name ");
        return null;
    }
    public static void main(String[ ] args) {
        System.out.println( getMountain().name );
    }
}
// -----------------------------------














// 2 ---------------------
//class Test2 {
//    static void method(int... a) {
//        System.out.println("inside int...");
//    }
//    static void method(long a, long b) {
//        System.out.println("inside long");
//    }
//    static void method(Integer a, Integer b) {
//        System.out.println("inside INTEGER");
//    }
//    public static void main(String[] args) {
//        int a = 2;
//        int b = 3;
//        method(a,b);
//    }
//}
// ------------------------------




















// 3
//class Switch {
//    public static void main(String[] args) {
//        int i = 3;
//        switch(i) {
//            default:
//                System.out.println("default");
//            case 1:
//                System.out.println("1");
//            case 2:
//                System.out.println("2");
//        }
//    }
//}
















//4
//Перечислите все валидные сигнатуры конструкторов класса Clazz:
//
//        Clazz(String name)
//        Clazz Clazz(String name)
//        int Clazz(String name)
//        void Clazz(String name)
//        Clazz(name)
//        Clazz()




















// 5 вывести алфавит

class Test5 {
    public static void main(String[] args) {
        for (char i = 'а'; i <= 'я'; i++) {
            System.out.print((int)i + " ");
        }
    }
}



















//class TestStr {
//    public static void main(String[] args) {
//        String s = new String("ssssss");
//        StringBuffer sb = new StringBuffer("bbbbbb");
//        s.concat("-aaa");
//        sb.append("-aaa");
//        System.out.println(s);
//        System.out.println(sb);
//    }
//}