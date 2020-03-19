package tk.springboot.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;

//如果application.yml里面配置了mybatis的属性，就不要开启下面的注释配置mybatis
//@org.springframework.context.annotation.Configuration
public class MybatisConfig {
    //@Bean
    public ConfigurationCustomizer mybatisConfig(){
        return new ConfigurationCustomizer(){
            @Override
            public void customize(Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
