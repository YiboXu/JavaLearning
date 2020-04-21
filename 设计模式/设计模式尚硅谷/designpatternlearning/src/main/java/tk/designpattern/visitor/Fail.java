package tk.designpattern.visitor;

public class Fail extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println("男人没钱就是失败");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("女人贪慕虚荣就是失败");
    }
}
