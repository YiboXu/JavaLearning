package tk.designpattern.factory.factorymethod;

public class JapanMilkPizza extends Pizza {
    public JapanMilkPizza(String name){
        super(name);
    }

    @Override
    public void prepare() {
        System.out.println(super.getName() + " 披萨正在准备......");
    }
}
