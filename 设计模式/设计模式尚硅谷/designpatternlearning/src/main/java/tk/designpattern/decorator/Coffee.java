package tk.designpattern.decorator;

public class Coffee extends Drink{

    public Coffee(){
        super.setDescription("This is a coffee");
    }

    @Override
    public double cost() {
        return 100;
    }

    @Override
    public String toString() {

        return this.getDescription();
    }
}
