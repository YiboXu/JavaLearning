package tk.designpattern.stratge;

public class ToyDuck extends Duck {
    public ToyDuck(FlyStrategy flyStrategy, SwimStrategy swimStrategy) {
        super(flyStrategy, swimStrategy);
    }

    @Override
    public void getInfo() {
        System.out.println("我是玩具鸭");
        this.getFlyStrategy().fly();
        this.getSwimStrategy().swim();
    }
}
