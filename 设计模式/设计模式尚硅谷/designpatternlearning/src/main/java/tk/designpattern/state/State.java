package tk.designpattern.state;

public abstract class State {
    //定义所有能做的操作
    //扣积分
    public abstract void pay(Context context);
    //抽奖
    public abstract void roll(Context context);
    //获取奖品
    public abstract void getGift(Context context);
}
