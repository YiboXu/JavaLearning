package tk.designpattern.factory.abstractfactory;

public class JapanCheesePizza extends Pizza {
    public JapanCheesePizza(String name){
        super(name);
    }

    @Override
    public void prepare() {
        System.out.println(super.getName() + " 披萨正在准备......");
    }
}
