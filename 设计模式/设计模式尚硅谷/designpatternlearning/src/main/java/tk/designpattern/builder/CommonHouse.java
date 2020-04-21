package tk.designpattern.builder;

/**
 * 创痛方式解决敢放需求问题分析
 * 优点: 比较好理解，简单易操作
 * 缺点: 设计的程序结构，过于简单，没有设计缓存层对象，程序的扩展和维护不好.
 *       这种设计方案，把产品(房子)和创建产品的过程(建房子流程)封装在一起，耦合性增强了.
 * 解决方案: 将产品和产品建造过程解耦 ==>建造者模式.
 */
public class CommonHouse extends AbstractHouse {
    @Override
    public void buildBasic() {
        System.out.println("基础搭建");
    }

    @Override
    public void buildWalls() {
        System.out.println("搭建围墙");
    }

    @Override
    public void buildRoof() {
        System.out.println("搭建屋顶");
    }
}
