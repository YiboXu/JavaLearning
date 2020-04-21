package tk.designpattern.state;

public class ReadyForPay extends State {
    public static ReadyForPay instance = new ReadyForPay();
    private ReadyForPay(){}

    @Override
    public void pay(Context context) {
        System.out.println("请支付积分");
        if(context.getMoney() > 5){
            context.setMoney(context.getMoney() - 5);
            context.setState(ReadyForRoll.instance);
            System.out.println("积分支付成功");
        }else{
            context.setState(NoMoney.instance);
            System.out.println("积分不足");
        }
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
