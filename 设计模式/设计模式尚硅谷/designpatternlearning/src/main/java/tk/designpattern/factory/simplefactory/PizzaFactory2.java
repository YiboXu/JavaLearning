package tk.designpattern.factory.simplefactory;

/**
 * 静态工厂模式
 * 只需要一个工厂的时候使用
 */
public class PizzaFactory2 {
    public static Pizza orderPizza(String type){
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

