package tk.designpattern.state;

/**
 * 状态模式
 * 1) 状态模式（ State Pattern State PatternState PatternState Pattern State PatternState PatternState PatternState Pattern ）：它 主要用来解决对象在多种状态转换时，需外 输出不同的行为问题。状态和是一对应，之间可以相互转换
 * 2) 当一个对象的内在状态改变 时，允 许改变其行为，这个对象看起来像是改变其类
 *
 * 状态模式的注意事项和细节 状态模式的注意事项和细节
 * 1) 代码有很强的可读性。状态模式将每个行为封装到对应一类 中
 * 2) 方便维护。将容易产生问题的 if -else语句删除了，如果把每个状态的行为都放到一 个类中，每次调用方法时都要判断当前是什么状态不但会产出很多 if -else 语句， 而且容易出 错
 * 3) 符合“开闭原则”。容易增删状 态
 * 4) 会产生很多类。每个状态都要一对应的，当过时加大维护难 度
 * 5) 应用场景：当 一个事件或者对象有很多种状 态，之间会相互转换不同的态要求有不同的行为时侯，可以考虑使用状态模式
 *
 * State里面定义了所有状态下能进行的操作
 * 然后创建各个状态类来继承State,同时实现State里面定义的方法，这样不同的状态下就可以产生不同的操作
 * 创建一个上下文类(Activity)，里面聚合了一个State.
 */
public class Client {
    public static void main(String[] args) {
        Context activity = new Context(ReadyForPay.instance);

        while(!activity.getState().equals(NoMoney.instance) && !activity.getState().equals(NoGift.instance)) {
            activity.pay();
            activity.roll();
            activity.getGift();
        }
    }
}
