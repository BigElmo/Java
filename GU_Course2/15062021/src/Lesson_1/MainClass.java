package Lesson_1;

public class MainClass {
//
//    String str;
//
//    int a;

    public static void main(String[] args) {

        Box box = new Box("sd",1);
        int[] mass = box.getMass();

        mass[1] = 10;


        box.info();



//        Box box1 = new Box("red", 10, "name1");
//        Box box2 = new Box("black", 15, "name2");
//
//        box1.info();
//        box2.info();


//        int a = 1;
//        test1(a);
//        System.out.println(a);
//
//        int[] mass  = {1,2,3};
//        test2(mass);
//        System.out.println(Arrays.toString(mass));
//
//        ArrayList<Integer> arrayList = new ArrayList<>();
//
//
//        calc(1,2,3,4,5);

    }


//    public static void calc(int a, int b) {
//        int res = a + b;
//    }



    public static void calc(int... array) {
        int res = 0;

        for (int i = 0; i < array.length; i++) {
            res += array[i];
        }
    }

//    public static void calc(int[] mass) {
//        int res = 0;
//
//        for (int i = 0; i < mass.length; i++) {
//            res += mass[i];
//        }
//    }




    public static void test1(int a) {
        a++;
    }

    public static void test2(int[] mass) {
        mass[1] = 10;
    }
}
