package tk.designpattern.stratge;

public class WildDuck extends Duck {
    public WildDuck(FlyStrategy flyStrategy, SwimStrategy swimStrategy) {
        super(flyStrategy, swimStrategy);
    }

    @Override
    public void getInfo() {
        System.out.println("我是野鸭");
        this.getFlyStrategy().fly();
        this.getSwimStrategy().swim();
    }
}
