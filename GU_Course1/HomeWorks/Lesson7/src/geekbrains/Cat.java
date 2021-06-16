package geekbrains;

public class Cat {
    private boolean isFull;
    protected final int appetite;
    protected final String name;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        isFull = false;
    }

    public void feed(Bowl bowl) {
        isFull = (appetite <= bowl.foodQuantity);
        if(isFull) {
            System.out.println(name + " Поел");
            bowl.decreaseFood(appetite);
        } else System.out.println(name + " !!! МАЛО ЕДЫ !!!");
    }
}
