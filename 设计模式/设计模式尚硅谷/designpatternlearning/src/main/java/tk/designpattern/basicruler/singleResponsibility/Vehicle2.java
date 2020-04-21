package tk.designpattern.basicruler.singleResponsibility;

/**
 * 在类级别上没有遵守单一职责原则，但是在方法级别上遵守了
 * 对于包含少量方法的类，可以在方法级别保持单一职责的原则
 * 对于包含方法比较多，还是需要在类级别保持单一职责的原则
 */
 class Vehicle{
    public void roadRun(String name){
        System.out.println(name + " 在路上运行");
    }
    public void waterRun(String name){
        System.out.println(name + " 在水上运行");
    }
    public void airRun(String name){
        System.out.println(name + " 在天上运行");
    }
}

public class Vehicle2 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.roadRun("汽车");
        vehicle.waterRun("轮船");
        vehicle.airRun("飞机");
    }
}
