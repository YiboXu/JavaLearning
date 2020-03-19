package tk.springboot.config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tk.springboot.component.MyLocaleResolver;
import org.springframework.web.servlet.LocaleResolver;
import tk.springboot.component.MyLoginInspector;
import tk.springboot.servlet.MyFilter;
import tk.springboot.servlet.MyListener;
import tk.springboot.servlet.MyServlet;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration;
import java.util.Arrays;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main").setViewName("dashboard");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyLoginInspector()).addPathPatterns("/**")
                .excludePathPatterns("/login","/","/userLogin","/webjars/**","/assets/**","/css/**","dist/**","img/**","/js/**");
    }

    //注入自己的国际化解析器
    @Bean("localeResolver")
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    //注入自定义的servlet
    @Bean
    public ServletRegistrationBean myServlet(){
        return new ServletRegistrationBean(new MyServlet(),"/myservlet");
    }

    //注入自定义的Filter
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/myservlet"));

        return filterRegistrationBean;
    }

    //注入自定义的Listener
    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean(new MyListener());
        return servletListenerRegistrationBean;
    }

    //修改容器配置
    //有一个WebServerFactoryCustomizerBeanPostProcessor，它会再servlet容器初始化之前调用每个xxxxCustomizer的customize方法.
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
       return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>(){

           @Override
           public void customize(ConfigurableWebServerFactory factory) {
               factory.setPort(8081);
           }
       };
    }
}
