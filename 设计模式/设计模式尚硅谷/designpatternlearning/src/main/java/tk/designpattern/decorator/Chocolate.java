package tk.designpattern.decorator;

public class Chocolate extends DrinkDecorator {
    public Chocolate(Drink drink) {
        super(drink);
    }

    @Override
    public String getDescription() {
        return super.getDescription()+" with Chocolate";
    }

    @Override
    public double cost() {
        return super.cost() + 100;
    }
}
