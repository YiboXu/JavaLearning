package tk.designpattern.basicruler.singleResponsibility;

/**
 * 在类级别上遵守单一职责原则, 适用于对于包含方法比较多的类
 * 一个类指负责一个职责，是的功能扩展更安全，避免了修改职责1导致对职责2个影响
 * 这种方式有一个缺点就是开销比较高，所以如果方法比较少的话，可以考虑在方法级别遵守单一职责原则
 *
 * 单一职责原则注意事项和细节:
 * - 降低类的复杂度，一个类只负责一项职责
 * - 提高类的可图形， 可维护性
 * - 降低变更引起的风险
 * - 通常情况下，我们应当遵守单一职责原则，只有逻辑足够简单，才可以在代码级别违反单一职责原则
 * - 只有类中方法数量足够少，才可以在方法级别保持单一职责原则
 */
class RoadVehicle{
    public void run(String name){
        System.out.println(name + " 在路上运行");
    }
}

class AirVehicle{
    public void run(String name){
        System.out.println(name + " 在天上运行");
    }
}

class WaterVehicle{
    public void run(String name){
        System.out.println(name + " 在水上运行");
    }
}

public class Vehicle1 {
    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        WaterVehicle waterVehicle = new WaterVehicle();
        AirVehicle airVehicle = new AirVehicle();

        roadVehicle.run("汽车");
        waterVehicle.run("轮船");
        airVehicle.run("飞机");
    }
}
