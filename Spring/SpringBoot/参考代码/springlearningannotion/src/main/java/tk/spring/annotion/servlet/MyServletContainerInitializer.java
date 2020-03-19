package tk.spring.annotion.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tk.spring.annotion.servlet.service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

//容器启动的时候会将@HandlesTypes指定的这个类型下面的子类（实现类，子接口等）传递过来；
//传入感兴趣的类型；
@HandlesTypes(UserService.class)
public class MyServletContainerInitializer implements ServletContainerInitializer {
    private static Logger logger = LogManager.getLogger(MyServletContainerInitializer.class);
    /**
     * 应用启动的时候，会运行onStartup方法；
     *
     * Set<Class<?>> arg0：感兴趣的类型的所有子类型；
     * ServletContext arg1:代表当前Web应用的ServletContext；一个Web应用一个ServletContext；
     *
     * 1）、使用ServletContext注册Web组件（Servlet、Filter、Listener）
     * 2）、使用编码的方式，在项目启动的时候给ServletContext里面添加组件；
     * 		必须在项目启动的时候来添加；
     * 		1）、ServletContainerInitializer得到的ServletContext；
     * 		2）、ServletContextListener得到的ServletContext；
     */
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        set.stream().forEach(logger::info);

        //注册组件
        //Servlet
        ServletRegistration.Dynamic servlet = servletContext.addServlet("userService",new UserServlet());
        servlet.addMapping("/user");
        //Listener
        servletContext.addListener(MyListener.class);
        //Filter
        FilterRegistration.Dynamic filter = servletContext.addFilter("myFilter",MyFilter.class);
        filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true,"/*");
    }
}
