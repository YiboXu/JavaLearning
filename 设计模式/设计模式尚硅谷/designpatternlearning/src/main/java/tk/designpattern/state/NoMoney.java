package tk.designpattern.state;

public class NoMoney extends State {
    public static NoMoney instance = new NoMoney();
    private NoMoney(){}

    @Override
    public void pay(Context context) {
        System.out.println("积分不足，无法抽奖");
    }

    @Override
    public void roll(Context context) {
        System.out.println("您还没有支付积分，无法抽奖");
    }

    @Override
    public void getGift(Context context) {
        System.out.println("您没有获奖，无法获得礼品");
    }
}
