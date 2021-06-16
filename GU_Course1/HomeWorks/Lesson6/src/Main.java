public class Main {

    public static void main(String[] args) {
	// write your code here
        Animal dog1 = new Dog("Бобик");
        Animal dog2 = new Dog("Шарик");
        Animal cat1 = new Cat("Барсик");
        Animal cat2 = new Cat("Мурзик");
        Animal cat3 = new Cat("Том");

        System.out.println("Всего животных: " + Animal.animalCount);
        System.out.println("Всего собак: " + Dog.dogCount);
        System.out.println("Всего кошек: " + Cat.catCount);
        System.out.println();

        dog1.run(100);
        dog2.swim(50);
        cat1.run(100);
        cat2.swim(50);
        cat3.run(300);
    }
}
