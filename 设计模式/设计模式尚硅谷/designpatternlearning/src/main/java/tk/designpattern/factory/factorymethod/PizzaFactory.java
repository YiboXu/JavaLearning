package tk.designpattern.factory.factorymethod;

/**
 * 工厂方法模式
 * 定义一个创建对象的抽象方法， 由子类决定要实例化的类. 工厂发发模式将对象的实例化推迟到子类.
 * 多个工厂类由公用的方法，可以通过定义工厂发发模式来充分重用代码,将公用方法定义在抽象类中，将需要变化的方法定义为抽象类由子类来重写.
 */
public abstract class PizzaFactory {
    abstract Pizza createPizza(String orderType);

    public Pizza orderPizza(String orderType){
        Pizza pizza = this.createPizza(orderType);

        if(pizza != null) {
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }else{
            System.out.println("订单失败");
        }

        return pizza;
    }
}
