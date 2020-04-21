package tk.designpattern.factory.factorymethod;

public class ChinaPizzaFactory extends PizzaFactory {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        switch(orderType){
            case "milk":
                pizza = new ChinaMilkPizza("中国牛奶");
                break;
            case "cheese":
                pizza = new ChinaMilkPizza("中国芝士");
                break;
            default:
                break;
        }

        return pizza;
    }
}
