package tk.designpattern.mediator;

public class Window extends Colleague {
    public Window(String name, Mediator mediator) {
        super(name, mediator);
    }

    @Override
    public void open() {
        System.out.println("Window is open");
    }

    @Override
    public void close() {
        System.out.println("Window is closed");
    }

    @Override
    public void sendMessage(String message) {
        this.getMediator().sendMessage(message,this);
    }
}
