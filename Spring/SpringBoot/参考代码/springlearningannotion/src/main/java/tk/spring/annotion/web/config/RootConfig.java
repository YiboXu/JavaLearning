package tk.spring.annotion.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(value="tk.spring.annotion.web",
        excludeFilters = @ComponentScan.Filter(type=FilterType.ANNOTATION,value= Controller.class))
public class RootConfig {
}
