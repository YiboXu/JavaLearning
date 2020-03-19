package tk.springmvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tk.springmvc.dao.CountryDao;
import tk.springmvc.dao.impl.CountryJdbcDaoImpl;
import tk.springmvc.service.CountryService;

public class TestJdbc {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        CountryService countryService = (CountryService) applicationContext.getBean("countryJdbcService");
        countryService.selectAll().stream().forEach(System.out::println);
    }
}
