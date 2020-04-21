package tk.designpattern.stratge;

public class CannotSwim extends SwimStrategy{

    @Override
    public void swim() {
        System.out.println("我不会游泳");
    }
}
