package tk.designpattern.adapter.springmvc;

public interface Adapter {
    boolean support(Controller controller);
    void handle(Controller controller);
}
