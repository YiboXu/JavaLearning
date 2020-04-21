package tk.designpattern.factory.simplefactory;

public class OrderService {
    private PizzaFactory pizzaFactory;

    public void setPizzaFactory(PizzaFactory pizzaFactory) {
        this.pizzaFactory = pizzaFactory;
    }

    public Pizza getPizza(String type){
        Pizza pizza = pizzaFactory.orderPizza(type);
        if(pizza != null){
            pizza.prepare();
            pizza.bake();
            pizza.cute();
            pizza.box();
        }else{
            System.out.println("披萨订购失败");
        }

        return pizza;
    }

    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        orderService.setPizzaFactory(new PizzaFactory());
        System.out.println(orderService.getPizza("china"));
        System.out.println(orderService.getPizza("japan"));
    }
}
