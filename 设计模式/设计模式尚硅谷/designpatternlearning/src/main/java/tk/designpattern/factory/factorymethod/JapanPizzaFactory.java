package tk.designpattern.factory.factorymethod;

public class JapanPizzaFactory extends PizzaFactory {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        switch(orderType){
            case "milk":
                pizza = new JapanMilkPizza("日本牛奶");
                break;
            case "cheese":
                pizza = new JapanCheesePizza("日本芝士");
                break;
            default:
                break;
        }

        return pizza;
    }
}
