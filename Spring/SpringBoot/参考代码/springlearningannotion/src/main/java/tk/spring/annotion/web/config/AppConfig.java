package tk.spring.annotion.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@ComponentScan(value="tk.spring.annotion.web",useDefaultFilters = false,
                includeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION,value = Controller.class))
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {


    //配置视图解析器
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/",".jsp");
    }

    //配置静态资源
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
