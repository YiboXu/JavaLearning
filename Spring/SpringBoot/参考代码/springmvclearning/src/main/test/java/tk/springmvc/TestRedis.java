package tk.springmvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class TestRedis {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        RedisTemplate redis = (RedisTemplate) applicationContext.getBean("redisTemplate");
        redis.opsForValue().set("message","Hello,Bill Hu");
        System.out.println(redis.opsForValue().get("message"));
    }
}
