public class Animal {
    static int animalCount;
    String name;
    int runLimit;
    int swimLimit;

    Animal(String name, int runLimit, int swimLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        animalCount++;
    }

    void run(int range) {
        if(range > runLimit) {
            System.out.println(name + " столько не пробежит!");
        } else {
            System.out.println(name + " пробежал " + range + "м");
        }
    }

    void swim(int range) {
        if(range > swimLimit) {
            System.out.println(name + " столько не проплывёт!");
        } else {
            System.out.println(name + " проплыл " + range + "м");
        }
    }
}
