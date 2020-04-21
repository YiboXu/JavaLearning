package tk.designpattern.visitor;

/**
 * 访问者模式
 * 访问者模式适用于数据结构相对稳定的系统。 比如这里需要获取男人和女人针对成功，失败，漂亮...等状态的判断标准.
 * 对于这个需求, 人只会分为男人和女人，不会再有新的种类, 同时各种类似于成功,失败, 漂亮这样额状态有很多，会不断变化，所以不适合在男人和女人的类中对这些状态进行扩展
 * 这样的场景适合访问者
 *
 * - 定义基本数据结构，比如这里的Person, Woman, Man
 * - 定义访问者抽象类 Action,里面有针对每种数据结构的方法,来获取各种不同的人对一个状态(访问者)的判断标准, 由于人的种类是固定不变的，所以这里方法的个数也是固定的
 * - 定义各种状态(继承Action),实现对不同人对当前状态的判断标准
 * - 定义一个ObjectStructure类，来将各种不同的人聚合在一起，并且一个方法，来获取所有不同人对某种状态的评判标准
 *
 * 缺点:
 * 访问者模式的缺点其实也就是使得增加新的数据结构变得困难。  比如这里想增加一个黄种人，那么不管要增加黄种人的类，还要讲对应的访问者里面
 * 都添加对黄种人的操作方法。
 *
 * 所以大多时候我们并不需要访问者模式，因为我们很难找到数据结构不变化的情况，但当你需要访问者模式时，那就是真的需要它了。
 */
public class Client {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.attach(new Woman());
        objectStructure.attach(new Man());

        //获取男人和女人对于不同状态的评判标准
        //男人和女人对于成功的标准
        objectStructure.action(new Success());
        //男人和女人对于失败的标准
        objectStructure.action(new Fail());
        //男人和女人对于漂亮的标准
        objectStructure.action(new Beauty());
        //如果需要增加新的状态，只用新增这个类继承Action
        //objectStructure.action(new Xxxxx());
    }
}
