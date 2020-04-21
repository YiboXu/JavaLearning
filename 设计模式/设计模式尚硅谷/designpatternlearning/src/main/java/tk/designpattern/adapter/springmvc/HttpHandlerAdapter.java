package tk.designpattern.adapter.springmvc;

public class HttpHandlerAdapter implements Adapter {
    @Override
    public boolean support(Controller controller) {
        return (controller instanceof HttpController);
    }

    @Override
    public void handle(Controller controller) {
        System.out.println("Handle HttpController Request.....");
    }
}
