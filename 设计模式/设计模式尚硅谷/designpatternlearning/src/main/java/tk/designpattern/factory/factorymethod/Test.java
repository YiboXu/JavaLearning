package tk.designpattern.factory.factorymethod;

public class Test {
    public static void main(String[] args) {
        PizzaFactory pizzaFactory1 = new ChinaPizzaFactory();
        PizzaFactory pizzaFactory2 = new JapanPizzaFactory();
        System.out.println(pizzaFactory1.orderPizza("milk"));
        System.out.println(pizzaFactory2.orderPizza("cheese"));
    }
}
