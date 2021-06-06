public class Dog extends Animal {
    static int dogCount;

    Dog(String name) {
        super(name);
        dogCount++;
    }

    void swim(int range) {
        if(range > 10) {
            System.out.println("Собаки больше 10м не плавают!");
        } else {
            super.swim(range);
        }
    }

    void run(int range) {
        if(range > 500) {
            System.out.println("Собаки больше 500м не бегают!");
        } else {
            super.run(range);
        }
    }
}
