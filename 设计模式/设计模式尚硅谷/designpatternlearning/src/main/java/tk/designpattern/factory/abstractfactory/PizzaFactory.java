package tk.designpattern.factory.abstractfactory;

/**
 * 抽象工厂模式
 * 从设计层面看，抽象工厂模式就是对简单工厂模式的改进
 * 将工厂抽象成两层, PizzaFactory(抽象工厂)和具体实现的工厂子类. 可以根据创建对象类型使用对应的工厂子类.
 * 这样将单个的简单工厂类变成了工厂簇, 更利于代码的维护和扩展.
 */
public interface PizzaFactory {
    Pizza createPizza(String orderType);
}
