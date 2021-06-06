public class Cat extends Animal {
    static int catCount;

    Cat(String name) {
        super(name);
        catCount++;
    }

    void run(int range) {
        if(range > 200) {
            System.out.println("Кошки больше 200м не бегают!");
        } else {
            super.run(range);
        }
    }

    void swim (int range) {
        System.out.println("Кошки плавают вообще не очень :Р");
    }
}
