package tk.designpattern.factory.simplefactory;

public class JapanPizza extends Pizza {
    public JapanPizza(String name){
        super(name);
    }

    @Override
    public void prepare() {
        System.out.println(super.getName() + " 披萨正在准备......");
    }
}
