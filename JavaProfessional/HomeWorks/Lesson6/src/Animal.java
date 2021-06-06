public class Animal {
    static int animalCount;
    String name;

    Animal(String name) {
        this.name = name;
        animalCount++;
    }

    void run(int range) {
        System.out.println(name + " пробежал " + range + "м");
    }

    void swim(int range) {
        System.out.println(name + " проплыл " + range + "м");
    }
}
