package tk.designpattern.stratge;

public abstract class Duck {
    private FlyStrategy flyStrategy;
    private SwimStrategy swimStrategy;

    public Duck(FlyStrategy flyStrategy, SwimStrategy swimStrategy) {
        this.flyStrategy = flyStrategy;
        this.swimStrategy = swimStrategy;
    }

    public FlyStrategy getFlyStrategy() {
        return flyStrategy;
    }

    public SwimStrategy getSwimStrategy() {
        return swimStrategy;
    }

    public abstract void getInfo();
}
