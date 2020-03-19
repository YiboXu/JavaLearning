package tk.spring.ioc.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tk.spring.ioc.annotation.dao.MongoDbUserDao;
import tk.spring.ioc.annotation.dao.MySqlUserDao;
import tk.spring.ioc.annotation.dao.OracleUserDao;
import tk.spring.ioc.annotation.service.UserService;

@Configuration
@ComponentScan("tk.spring.ioc.annotation")
public class UserServiceConfiguration {
    @Bean("mySqlUserDao")
    public MySqlUserDao mySqlUserDao(){
        return new MySqlUserDao("BillHu");
    }

    @Bean("oracleUserDao")
    public OracleUserDao oracleUserDao(){
        return new OracleUserDao("Sofica","Yang",1,2,3);
    }

    @Bean("mysqlUserService")
    public UserService mysqlUserService(){
        return new UserService(mySqlUserDao());
    }

    @Bean("oracleUserService")
    public UserService oracleUserService(){
        return new UserService(oracleUserDao());
    }
}
