public class Cat extends Animal {
    static int catCount;

    Cat(String name) {
        super(name, 200, 0);
        catCount++;
    }

    void swim(int range) {
        System.out.println(name + " Не умеет плавать!");
    }
}
