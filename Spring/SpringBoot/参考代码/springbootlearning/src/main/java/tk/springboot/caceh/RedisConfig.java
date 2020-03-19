package tk.springboot.caceh;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import tk.springboot.model.Country;

import java.net.UnknownHostException;

@Configuration
public class RedisConfig {
    @Bean("countryRedisTemplate")
    public RedisTemplate<Object, Country> countryRedisTemplate(RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Country> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        //设置默认序列化器，这样保存在Redis里面的数据就是序列化后的Json
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<Country>(Country.class));
        return template;
    }
}
