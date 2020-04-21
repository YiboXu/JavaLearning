package tk.designpattern.adapter.interfaceadapter;

/**
 * 接口适配器模式
 * 1) 通过设计一个抽象类来实现所有相关的接口，每个实现方法为默认实现或空方法, 那么该抽象类的子类可有选择的覆盖父类的某些方法来实现需求
 * 2) 适用于一个接口不想使用其所有的方法的情况， 比如接口A有5个方法，但是类B只需要用到接口A中的一个方法，类C需要用到接口A中的两个方法，那么就可以设计一个
 *    抽象类D来默认实现接口A中的所有方法，然后在类B和C中创建一个抽象类D的子类来重写需要用到的方法.
 */
public abstract class VoltageAdapter implements Adapter {
    //默认实现
    @Override
    public int computerCharging() {
        return 0;
    }

    @Override
    public int padCharging() {
        return 0;
    }

    @Override
    public int phoneCharging() {
        return 0;
    }
}
