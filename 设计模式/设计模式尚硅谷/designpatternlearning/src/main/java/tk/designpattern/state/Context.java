package tk.designpattern.state;

public class Context {
    private int money = 200;
    private State state;
    private int giftTotal = 1;

    public Context(State state) {
        this.state = state;
    }

    //支付
    public void pay(){
        state.pay(this);
    }

    //抽奖
    public void roll(){
        state.roll(this);
    }

    //兑换奖品
    public void getGift(){
        state.getGift(this);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getGiftTotal() {
        return giftTotal;
    }

    public void setGiftTotal(int giftTotal) {
        this.giftTotal = giftTotal;
    }

    //获取状态
    public State getState(){
        return state;
    }
}
