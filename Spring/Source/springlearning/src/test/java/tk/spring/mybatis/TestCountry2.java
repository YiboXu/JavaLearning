package tk.spring.mybatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tk.spring.mybatis.Dao.CountryDao;
import tk.spring.mybatis.model.Country;

import java.util.List;

public class TestCountry2 {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("mybatis.xml");
        CountryDao countryDao2 = (CountryDao) context.getBean("countryDao2");
        List<Country> countries = countryDao2.selectAll();

        countries.stream().forEach(System.out::println);
    }
}
