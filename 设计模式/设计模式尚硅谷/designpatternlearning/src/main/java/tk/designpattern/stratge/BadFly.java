package tk.designpattern.stratge;

public class BadFly extends FlyStrategy {
    @Override
    public void fly() {
        System.out.println("我飞的很低");
    }
}
