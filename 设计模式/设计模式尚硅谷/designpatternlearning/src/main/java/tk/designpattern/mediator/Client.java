package tk.designpattern.mediator;

import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        AIHome aiHome = new AIHome();
        AirCondition airCondition = new AirCondition("AirCondition",aiHome);
        Lamp lamp = new Lamp("Lamp",aiHome);
        Window window = new Window("Window",aiHome);

        airCondition.sendMessage("open");
        TimeUnit.SECONDS.sleep(3);
        airCondition.sendMessage("close");
    }
}
