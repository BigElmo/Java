public class Dog extends Animal {
    static int dogCount;

    Dog(String name) {
        super(name, 500, 10);
        dogCount++;
    }
}
