package tk.designpattern.adapter.springmvc;

/**
 * SpringMVC中对适配器的应用
 * 每种Controller都有一个对应的适配器, 这样我们的Client端就可以用一种相同模式来处理每一个不同的Controller
 * 比如，获得任意一个Controller后，都是通过调用getHandle()来获取其对应的适配器，然后通过获得的适配器来对Controller进行处理
 * 所以如果需要增加一个新的Controller的时候，我们只需要创建新的Controller以及其对应的Adapter就可以了，然后将新的适配器加到adapterList里面
 * 这个Client就是对应的SpringMVC里面的DispatchServlet，来处理各个不同的Controller.
 */

import java.util.Arrays;
import java.util.List;

public class Client {
    private static List<Adapter> adapterList = Arrays.asList(new HttpHandlerAdapter(),new SimpleHandlerAdapter(),new AnnotationHandlerAdapter());

    public static void main(String[] args) {
        Controller controller = new HttpController();
        Adapter adapter = getHandle(controller);
        adapter.handle(controller);
    }

    public static Adapter getHandle(Controller controller){
        for(Adapter adapter:adapterList){
            if(adapter.support(controller)){
                return adapter;
            }
        }

        return null;
    }
}
