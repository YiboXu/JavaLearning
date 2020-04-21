package tk.designpattern.adapter.objectadapter;

/**
 * 对象适配器模式
 * 1) 通过聚合一个被适配类的实例来避免继承被适配类, 同时目标类也不需要是接口
 *    (使用接口也是可以的，比如下面例子中的PhoneCharging,如果不使用接口，就需要将VoltageAdapter聚合到Phone里作为成员变量)
 * 2) 无法根据需求重写被代理类的方法
 */
public class VoltageAdapter implements PhoneCharging {
    private Voltage220 voltage220;

    public VoltageAdapter(Voltage220 voltage220) {
        this.voltage220 = voltage220;
    }

    @Override
    public int output5() {
        return voltage220.output220()/44;
    }
}
