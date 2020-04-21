package tk.designpattern.adapter.springmvc;

public class SimpleHandlerAdapter implements Adapter{
    @Override
    public boolean support(Controller controller) {
        return (controller instanceof SimpleController);
    }

    @Override
    public void handle(Controller controller) {
        System.out.println("Handle SimpleController Request.....");
    }
}
