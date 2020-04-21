package tk.designpattern.factory.abstractfactory;

import tk.designpattern.factory.factorymethod.ChinaPizzaFactory;
import tk.designpattern.factory.factorymethod.JapanPizzaFactory;
import tk.designpattern.factory.factorymethod.PizzaFactory;

public class OrderService {
    private PizzaFactory pizzaFactory;

    public void setPizzaFactory(PizzaFactory pizzaFactory) {
        this.pizzaFactory = pizzaFactory;
    }

    public void order(){
        System.out.println(pizzaFactory.orderPizza("milk"));
        System.out.println(pizzaFactory.orderPizza("cheese"));
    }

    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        orderService.setPizzaFactory(new ChinaPizzaFactory());
        orderService.order();
    }
}
