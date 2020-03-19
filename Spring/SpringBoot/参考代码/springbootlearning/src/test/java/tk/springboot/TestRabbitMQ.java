package tk.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tk.springboot.model.Country;
import tk.springboot.mybatis.mapper.CountryMapper;

@SpringBootTest
public class TestRabbitMQ {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private CountryMapper countryMapper;

    @Test
    public void test01(){
        Country country = countryMapper.selectCountryById((long)2);
        rabbitTemplate.convertAndSend("tacocloud.orders","tacocloud.order.queue",country);
    }

    @Test
    public void test02(){
        Object obj = rabbitTemplate.receiveAndConvert("tacocloud.order.queue");
        System.out.println(obj.getClass());
        System.out.println((Country)obj);
    }
}
