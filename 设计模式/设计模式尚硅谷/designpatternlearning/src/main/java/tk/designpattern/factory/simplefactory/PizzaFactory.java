package tk.designpattern.factory.simplefactory;

/**
 * 简单工厂模式
 * 当需要使用多种工厂的时候, 调用工厂类方法，通过不同参数来获取不同的实例.
 */
public class PizzaFactory {
    public Pizza orderPizza(String type){
        switch (type){
            case "china":
                return new ChinaPizza("China");
            case "japan":
                return new JapanPizza("Japan");
            default:
                return null;
        }
    }
}
