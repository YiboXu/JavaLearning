package tk.spring.mybatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tk.spring.mybatis.Dao.CountryDao;
import tk.spring.mybatis.model.Country;

import java.util.List;

public class TestCountry {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("mybatis.xml");
        CountryDao countryDao = (CountryDao) context.getBean("countryDao");
        List<Country> countries = countryDao.selectAll();

        countries.stream().forEach(System.out::println);
    }
}
