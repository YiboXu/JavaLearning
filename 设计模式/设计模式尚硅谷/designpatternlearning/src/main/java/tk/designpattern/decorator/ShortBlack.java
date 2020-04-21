package tk.designpattern.decorator;

public class ShortBlack extends Coffee {

    public ShortBlack() {
        super.setDescription("This is a ShortBlack");
    }

    @Override
    public double cost() {
        return super.cost() + 10;
    }

    @Override
    public String toString() {
        return this.getDescription();
    }
}
