package tk.designpattern.stratge;

public class CannotFly extends FlyStrategy {
    @Override
    public void fly() {
        System.out.println("我不可以飞");
    }
}
