package tk.designpattern.bridge;

/**
 * 桥接模式的注意事项和细节
 * 1) 实现了抽象和实现部分的分离，从而极大的提供了系统的灵活性，让抽象部分和实现部分独立开来，者有助于系统进行分层设计，从而产生更好的结构化系统.
 * 2) 对于系统的高层部分，只需要直到抽象部分和实现部分的接口就可以了，其他的部分由具体业务来完成
 * 3) 桥接模式替代多层继承方案，可以减少子类的个数，降低系统的管理和维护成本.
 * 4) 桥接模式的引入增加了系统的理解和设计难度，由于聚合关联关系建立在抽象层，要求开发者震度i抽象进行设计和编程
 * 5) 桥接模式要求正确识别出系统中两个独立变化的维度，因此其使用方位由一定的局限性，即需要由这样应用场景.
 */
public class Client {
    public static void main(String[] args) {
        Phone phone1 = new FoldedPhone(PhoneBrand.HUAWEI);
        Phone phone2 = new FoldedPhone(PhoneBrand.XIAOMI);
        phone1.call();
        phone2.call();
    }
}
