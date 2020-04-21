package tk.designpattern.mediator;

public class Lamp extends Colleague {
    public Lamp(String name, Mediator mediator) {
        super(name, mediator);
    }

    @Override
    public void open() {
        System.out.println("Lamp is open");
    }

    @Override
    public void close() {
        System.out.println("Lamp is closed");
    }

    @Override
    public void sendMessage(String message) {
        this.getMediator().sendMessage(message,this);
    }
}
