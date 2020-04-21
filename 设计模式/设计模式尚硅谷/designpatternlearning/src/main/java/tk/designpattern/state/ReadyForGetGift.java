package tk.designpattern.state;

public class ReadyForGetGift extends State {
    public static ReadyForGetGift instance = new ReadyForGetGift();
    private ReadyForGetGift(){}

    @Override
    public void pay(Context context) {
        System.out.println("您已经支付过积分了");
    }

    @Override
    public void roll(Context context) {
        System.out.println("您还没有支付积分，无法抽奖");
    }

    @Override
    public void getGift(Context context) {
        if(context.getGiftTotal() > 0){
            System.out.println("获取奖品成功");
            context.setState(ReadyForPay.instance);
        }else{
            System.out.println("礼物已经兑光了");
            context.setState(NoGift.instance);
        }
    }
}
