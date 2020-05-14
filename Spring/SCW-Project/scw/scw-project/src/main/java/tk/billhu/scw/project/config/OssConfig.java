package tk.billhu.scw.project.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.billhu.scw.project.component.OssTemplate;

@SpringBootConfiguration
public class OssConfig {
    @ConfigurationProperties(prefix = "oss")
    @Bean
    public OssTemplate ossTemplate(){
        return new OssTemplate();
    }
}
