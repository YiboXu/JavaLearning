package tk.spring.annotion.model;

public class RainBow {
    private Red red;
    private Blue blue;

    public RainBow(Red red, Blue blue) {
        this.red = red;
        this.blue = blue;
    }

    @Override
    public String toString() {
        return "RainBow{" +
                "red=" + red +
                ", blue=" + blue +
                '}';
    }
}
