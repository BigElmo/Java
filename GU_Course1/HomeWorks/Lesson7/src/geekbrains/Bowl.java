package geekbrains;

public class Bowl {
    protected int foodQuantity;

    Bowl(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public void increaseFood(int foodQuantity) {
        this.foodQuantity += foodQuantity;
    }

    public void decreaseFood(int foodQuantity) {
        this.foodQuantity -= foodQuantity;
        if(this.foodQuantity == 0) {
            increaseFood(50);
            System.out.println("Миска пуста! Добавлено 50 еды");
        }
    }
}
