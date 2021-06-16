package Lesson_1;

public abstract class Animal {
    private int a;
//    protected int z;

    abstract void breathing();
}


class Cat extends Animal {
    private int b;
    protected int z;

    public Cat(int b, int z) {
      //  System.out.println("Cat");
        this.b = b;
        this.z = z;
    }

    @Override
    void breathing() {
        System.out.println("Дышит воздухом над водой");
    }
}

class Dolphin extends Animal {

    @Override
    void breathing() {
        System.out.println("Дышит жабрами под водой");
    }
}


//
class SuperCat extends Cat {

    public SuperCat(int b, int z) {
        super(b, z);
       // System.out.println("SuperCat");
    }


}


//class Cat {
//    private int b;
//    protected int z;
//
//    private int age;
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        if (age > 0) {
//            this.age = age;
//        } else {
//            System.out.println("Возратс не может быть отрицательным!");
//        }
//    }
//
//    public Cat(int b, int z) {
//        // super(10);
//        //  System.out.println("Cat");
//        this.b = b;
//        this.z = z;
//    }
//
//    void test() {
//        System.out.println(b + " " + z + " возраст " + age);
//    }
//
//    public int getB() {
//        return b;
//    }
//
//    public void setB(int b) {
//        this.b = b;
//    }
//
//    public int getZ() {
//        return z;
//    }
//
//    public void setZ(int z) {
//        this.z = z;
//    }
//
////    public static void main(String[] args) {
////        Cat cat1 = new Cat(10, 5);
////        Cat cat2 = new Cat(15, 20);
////
////        cat1 = cat2;
////
////        cat2.setB(50);
////
////        cat1.setAge(-10);
////
////        cat1.test();
////        cat2.test();
////    }
//}

class MainTest {
    public static void main(String[] args) {

//        Cat cat1 = new Cat(10, 5);
//        Cat cat2 = new Cat(15, 20);
//
//        //cat1 = cat2;
//
//        cat2.setB(50);
//
//        cat1.setAge(-10);
//
//        cat1.test();
//        cat2.test();
        // SuperCat superCat = new SuperCat(10,11);



//        Animal[] mass = {new Cat(10, 5), new Dolphin()};
//
//        for (Animal animal : mass) {
//            animal.breathing();
//        }
//        MainTest mainTest = new MainTest();
//        mainTest.PrtMsg();

     //   PrtMsg();
    }

    static void PrtMsg() {
        System.out.println(1);
    }


}