package tk.designpattern.builder.improve;

/**
 * 建造者模式(JDK里面StringBuilder就用到了建造者模式
 * 特点:
 * - 产品和构建方法分离
 * - 构建方法的实现通过子类来指定
 * - 构建顺序通过指挥者(director)来指定
 *
 * 建造者 模式的注意事项和细节 模式的注意事项和细节
 * 1) 客户 端(使用 程序 )不必知道产品内部组成的细节，将本身与创建过程解 耦，使得相同的创建过程可以不产品对 象
 * 2) 每一个具体建造者都相对独立，而与其他的无关因此可以很方便地替换具体建造者或增加新的， 用户使不同 的具体建造者即可得到的产品对 象
 * 3) 可以更加精细地控制产品的创建过程 。将复杂产品的创建步骤分解在不同方法 中，使得创建过 程更加清晰也方便用序来控制程
 * 4) 增加新的具体建造者无须修改原有类库代码 ， 指挥者类针对抽象建造编程系统扩展方便，符合 “开闭原则 ”
 * 5) 建造者模式所创建的产品一般具有较多共同点， 其组成部分相似如果产品之间 的差异性很大，则不适合使用建造者模式 ，因此其使用范围受到一定的限制 。
 * 6) 如果产品的内部变化复杂， 可能会导致需要定义很多具体建造者类来实现这种导致系统变得很庞 大， 因此在这种情况下，要考虑是否选择建造者模式 .
 * 7) 抽象工厂模式 VS 建造者模 式
 *    抽象工厂模式实现对产品家族的创建，一个是这样系列：具有不同分类维度的产品组合，采用抽象工厂模式不需要关心构建过程只什么由什么工厂生产即可。
 *    而建造者模式则是要求按照指定的蓝图品，它主要目的是通过组装零配件而产生一个新的产品.
 *    如果由构建流程，就用建造者模式， 如果只有如何创建，就用抽象工厂模式
 */
public abstract class HouseBuilder {
    protected House house = new House();
    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void buildRoof();

    public House build(){
        return house;
    }
}
