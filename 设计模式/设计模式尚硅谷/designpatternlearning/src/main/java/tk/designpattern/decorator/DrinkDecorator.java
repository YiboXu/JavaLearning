package tk.designpattern.decorator;

public class DrinkDecorator extends Drink {
    private Drink drink;

    public DrinkDecorator(Drink drink) {
        this.drink = drink;
    }

    public String getDescription(){
        return drink.getDescription();
    }

    public double cost(){
        return  drink.cost();
    }
}
