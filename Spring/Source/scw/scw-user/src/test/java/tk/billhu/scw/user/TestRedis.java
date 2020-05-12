package tk.billhu.scw.user;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class TestRedis {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;
    //@Autowired
    //RedisTemplate<Object,Country> countryRedisTemplate;

    //@Autowired
    //CountryMapper countryMapper;

    /**
     * Redis常见的五大数据类型
     *  String（字符串）、List（列表）、Set（集合）、Hash（散列）、ZSet（有序集合）
     *  stringRedisTemplate.opsForValue()[String（字符串）]
     *  stringRedisTemplate.opsForList()[List（列表）]
     *  stringRedisTemplate.opsForSet()[Set（集合）]
     *  stringRedisTemplate.opsForHash()[Hash（散列）]
     *  stringRedisTemplate.opsForZSet()[ZSet（有序集合）]
     */
    @Test
    public void test01(){
        stringRedisTemplate.opsForValue().append("msg","Hello Redis");
        logger.info(stringRedisTemplate.opsForValue().get("msg"));
    }

    /*
    @Test
    public void test02(){
        Country country = countryMapper.selectCountryById((long)2);
        redisTemplate.opsForValue().set("country",country);
        Country country2 = (Country)redisTemplate.opsForValue().get("country");
        logger.info(country2.toString());
    }

    //用redisTemplate和countryRedisTemplate的区别仅仅在于保存在Redis中的数据格式不一样
    //redisTemplate保存的是JDK序列化后的字节码
    //countryRedisTemplate保存的是Json格式的数据
    //用countryRedisTemplate需要自己配置一个RedisTemplate的Bean，将其默认序列化器设置为Json格式， 参看tk.springboot.caceh.RedisConfig
    @Test
    public void test03(){
        Country country = countryMapper.selectCountryById((long)3);
        countryRedisTemplate.opsForValue().set("countryjson",country);
        logger.info(countryRedisTemplate.opsForValue().get("countryjson").toString());
    }
     */
}
