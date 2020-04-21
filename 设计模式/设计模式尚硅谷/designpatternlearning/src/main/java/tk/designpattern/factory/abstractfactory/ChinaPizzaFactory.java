package tk.designpattern.factory.abstractfactory;

public class ChinaPizzaFactory implements PizzaFactory {
    @Override
    public Pizza createPizza(String orderType) {
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
