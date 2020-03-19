package tk.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("tk.springboot.mybatis.mapper")
//开启缓存注解支持
@EnableCaching
//开启Rabbit注解支持
@EnableRabbit
//开启异步任务支持
@EnableAsync
//开启定时任务
//@EnableScheduling
public class SpringbootlearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootlearningApplication.class, args);
	}

}
