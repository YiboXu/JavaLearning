package tk.designpattern.combination;

/**
 * 组合模式解决的问题:
 * 当我们要处理的对象可以生成一颗树形结构，而我们要对书上的节点和叶子进行操作时，它能够提供一致的方式，而不用考虑它时节点还是叶子
 *
 * 组合模式的注意事项和细节
 * 1) 简化客户端操作. 客户端只需要面对一致的对象而不用考虑整体部分或叶子节点的问题.
 * 2) 具有较强的扩展性. 当我们要更改组合对象时, 我们只需要调整内部的层次关系, 客户端不用做出任何改动.
 * 3) 方便创造出复杂的层次结构. 客户端不用理会组合里面的组成细节，容易添加节点或者叶子从而创建出复杂的属性结构
 * 4) 需要遍历组织机构,或者处理的对象具有属性结构时,非常适合使用组合模式
 * 5) 要求较高的抽象性, 如果节点和叶子有很多差异的话,比如很多方法和属性都不一样，那么就不适合使用组合模式.
 */
public class Client {
    public static void main(String[] args) {
        University university = new University("清华大学","清华大学");
        College college1 = new College("软件工程学院","学习软件设计");
        College college2 = new College("物理学院","学习物理知识");

        Department department1 = new Department("网络","网络学习");
        Department department2 = new Department("硬件","硬件学习");
        Department department3 = new Department("量子力学","量子力学");
        Department department4 = new Department("现代物理学","现代物理学");

        university.add(college1);
        university.add(college2);
        college1.add(department1);
        college1.add(department2);
        college2.add(department3);
        college2.add(department4);

        university.print();
    }
}
