package tk.designpattern.adapter.classadapter;

/**
 * 类适配器模式
 * 1) Java是单继承机制，所以类适配器需要继承被适配类，这一点算是一个缺点，因为这要求目标类必须是接口，有一定局限性
 * 2） 被继承类的方法在Adapter中都会暴露出来，也增加了使用的成本.
 * 3) 由于Adapter其继承了被代理类,所以它可以根据需求重写被代理类的方法, 使得Adapter的灵活性增强了.
 */
public class VoltageAdapter extends Voltage220 implements PhoneCharging{
    @Override
    public int output5() {
        return output220()/44;
    }
}
