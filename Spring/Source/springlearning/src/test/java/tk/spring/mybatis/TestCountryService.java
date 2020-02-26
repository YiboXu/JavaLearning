package tk.spring.mybatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tk.spring.mybatis.service.CountryService;

public class TestCountryService {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("mybatis.xml");
        CountryService countryService = (CountryService) context.getBean("countryService");
        countryService.transaction();
    }
}
