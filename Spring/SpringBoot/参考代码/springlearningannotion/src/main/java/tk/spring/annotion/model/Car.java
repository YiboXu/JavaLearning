package tk.spring.annotion.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Car {
    private static Logger logger = LogManager.getLogger(Car.class);

    public Car(){
        logger.info("Car is created");
    }

    public void init(){
        logger.info("Car is initialized");
    }

    public void destroy(){
        logger.info("Car is destroyed");
    }
}
