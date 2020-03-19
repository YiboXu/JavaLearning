package tk.spring.annotion.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

public class Cat implements InitializingBean, DisposableBean {
    private static Logger logger = LogManager.getLogger(Cat.class);

    public Cat(){
        logger.info("Cat is created");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("Cat is initialized");
    }

    @Override
    public void destroy() throws Exception {
        logger.info("Cat id destroyed");
    }
}
