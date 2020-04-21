package tk.designpattern.mediator;

public abstract class Colleague {
    private String name;
    private Mediator mediator;

    public Colleague(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
        mediator.addColleague(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void open();
    public abstract void close();
    public abstract void sendMessage(String message);
}
