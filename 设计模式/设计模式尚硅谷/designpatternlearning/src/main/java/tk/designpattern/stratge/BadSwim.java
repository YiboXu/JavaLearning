package tk.designpattern.stratge;

public class BadSwim extends SwimStrategy {
    @Override
    public void swim() {
        System.out.println("我游泳很慢");
    }
}
