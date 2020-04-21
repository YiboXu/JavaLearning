package tk.designpattern.adapter.springmvc;

public class AnnotationHandlerAdapter implements Adapter {
    @Override
    public boolean support(Controller controller) {
        return (controller instanceof AnnotationController);
    }

    @Override
    public void handle(Controller controller) {
        System.out.println("Handle AnnotationController Request.....");
    }
}
