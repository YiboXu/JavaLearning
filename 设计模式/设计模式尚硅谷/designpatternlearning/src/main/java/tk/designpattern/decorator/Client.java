package tk.designpattern.decorator;

public class Client {
    public static void main(String[] args) {
        Chocolate chocolate = new Chocolate(new ShortBlack());
        System.out.println(chocolate);
        System.out.println(chocolate.cost());
    }
}
