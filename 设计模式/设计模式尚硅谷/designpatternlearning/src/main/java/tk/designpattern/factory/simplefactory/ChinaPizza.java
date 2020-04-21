package tk.designpattern.factory.simplefactory;

public class ChinaPizza extends Pizza {
    public ChinaPizza(String name){
        super(name);
    }

    @Override
    public void prepare() {
        System.out.println(super.getName() + " 披萨正在准备......");
    }
}
