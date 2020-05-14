package tk.billhu.scw.order.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import tk.billhu.scw.order.component.OssTemplate;

@SpringBootConfiguration
public class OssConfig {
    @ConfigurationProperties(prefix = "oss")
    @Bean
    public OssTemplate ossTemplate(){
        return new OssTemplate();
    }
}
