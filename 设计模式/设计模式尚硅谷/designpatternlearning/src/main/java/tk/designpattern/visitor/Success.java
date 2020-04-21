package tk.designpattern.visitor;

public class Success extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println("男人有钱就是成功");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("女人贤惠就是成功");
    }
}
