package tk.springmvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tk.springmvc.service.CompanyService;

public class TestJpa {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        CompanyService companyService = (CompanyService) applicationContext.getBean("companyService");
        companyService.queryAll().stream().forEach(System.out::println);
    }
}
