package tk.spring.annotion.web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;

//web容器启动的时候创建对象；调用方法来初始化容器以前前端控制器
public class MyWebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    //获取根容器的配置类；（Spring的配置文件）   父容器；指定配置类来配置Service,Repositories
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    //获取web容器的配置类（SpringMVC配置文件）  子容器； 指定配置类来配置Controller, ViewResolver, HandlerMapping
    @Override
    protected Class<?>[] getServletConfigClasses() {

        return new Class[]{AppConfig.class};
    }

    //获取DispatcherServlet的映射信息
    //  /：拦截所有请求（包括静态资源（xx.js,xx.png）），但是不包括*.jsp；
    //  /*：拦截所有请求；连*.jsp页面都拦截；jsp页面是tomcat的jsp引擎解析的；
    @Override
    protected String[] getServletMappings() {
        return new String[]{
                "/"
        };
    }

    //添加监听器或其他组件
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        servletContext.addListener(new ServletContextListener() {
            @Override
            public void contextInitialized(ServletContextEvent sce) {
                System.out.println("It's my added Listener in onStartup");
            }
        });

        //添加其他组件
        //servletContext.addxxxxxx
    }
}
