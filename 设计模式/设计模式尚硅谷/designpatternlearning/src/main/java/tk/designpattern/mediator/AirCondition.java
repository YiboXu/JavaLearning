package tk.designpattern.mediator;

public class AirCondition extends Colleague {
    public AirCondition(String name, Mediator mediator) {
        super(name, mediator);
    }

    @Override
    public void open() {
        System.out.println("AirCondition is open");
    }

    @Override
    public void close() {
        System.out.println("AirCondition is closed");
    }

    @Override
    public void sendMessage(String message) {
        this.getMediator().sendMessage(message,this);
    }
}
