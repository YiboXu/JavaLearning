package tk.designpattern.visitor;

public class Beauty extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println("男人长得帅就是漂亮");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("女人长得丰满就是漂亮");
    }
}
