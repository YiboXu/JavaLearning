package tk.designpattern.state;

import java.util.Random;

public class ReadyForRoll extends State {
    public static ReadyForRoll instance = new ReadyForRoll();
    private ReadyForRoll(){}
    private static Random random = new Random(37);

    @Override
    public void pay(Context context) {
        System.out.println("您已经支付过积分了");
    }

    @Override
    public void roll(Context context) {
        System.out.println("开始抽奖");
        if(random.nextInt(10) == 1){
            System.out.println("恭喜中奖");
            context.setState(ReadyForGetGift.instance);
        }else{
            System.out.println("很遗憾未中奖");
            context.setState(ReadyForPay.instance);
        }
    }

    @Override
    public void getGift(Context context) {
        System.out.println("您没有获奖，无法获得礼品");
    }
}
