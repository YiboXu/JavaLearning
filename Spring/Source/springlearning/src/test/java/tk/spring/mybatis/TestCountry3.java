package tk.spring.mybatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tk.spring.mybatis.mapper.CountryMapper;

public class TestCountry3 {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("mybatis.xml");
        CountryMapper countryMapper = (CountryMapper) context.getBean("countryMapper");
        countryMapper.selectAll().stream().forEach(System.out::println);
    }
}
