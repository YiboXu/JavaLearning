package tk.springboot.caceh;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

@Configuration
public class CacheConfig {
    //BeanId需要和@Cacheable(cacheNames = {"country"},keyGenerator = "myKeyGenerator") 里面的keyGenerator匹配
    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return method.getName()+"["+ Arrays.asList(params)+"]";
            }
        };
    }
}
