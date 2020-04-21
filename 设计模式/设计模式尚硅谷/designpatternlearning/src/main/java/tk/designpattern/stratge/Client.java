package tk.designpattern.stratge;

/**
 * 基本介绍
 * 1) 策略模式(Strategy Pattern)中，定义算法族分别封装起来让他们之间可以 互相替换，此模式让算法的变化独立于使用客 户
 * 2) 这算法体现了几个设计原则，
 * 第一、把变化的代码从不中分离出来；第二、针对接口编程而不是具体类（定义了策略）；三多用组 合/聚合， 少用继承（客户通过组合方式使策略 ）
 *
 * 策略模式的注意事项和细 节
 * 1) 策略模式的关键是： 分析项目中变化部 与不分
 * 2) 策略模式的核心思想是：多 用组 合/聚合 少用继承；行为类组合，而不是的 继承。更有弹 性
 * 3) 体现了“对修改关闭，扩展开放”原则客户端增加行为不用有代码只要添加一种策 略（ 或者 行为）即可， 避免了使用多重转移语句（ if..else if..else if..else if..else elseif..else if..）
 * 4) 提供了可以替换继承关系的办法 ： 策略模式 将算法封装在独立的 Strategy Strategy类中使得 你可以独立于其 Context Context ContextContext改变它，使易于切换、理解扩 展
 * 5) 需要注意的是：每添加一个策略就需要新增一个类, 当策略过多，会导致类过多
 */
public class Client {
    public static void main(String[] args) {
        WildDuck wildDuck = new WildDuck(new GoodFly(),new GoodSwim());
        ToyDuck toyDuck = new ToyDuck(new CannotFly(),new CannotSwim());

        wildDuck.getInfo();
        toyDuck.getInfo();
    }
}
