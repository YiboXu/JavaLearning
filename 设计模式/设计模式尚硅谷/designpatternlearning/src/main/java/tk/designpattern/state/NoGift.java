package tk.designpattern.state;

public class NoGift extends State {
    public static NoGift instance = new NoGift();
    private NoGift(){}

    @Override
    public void pay(Context context) {
        System.out.println("没有奖品了，不用支付积分抽奖了");
    }

    @Override
    public void roll(Context context) {
        System.out.println("没有奖品了，无法抽奖");
    }

    @Override
    public void getGift(Context context) {
        System.out.println("没有奖品了，无法获得礼品");
    }
}
