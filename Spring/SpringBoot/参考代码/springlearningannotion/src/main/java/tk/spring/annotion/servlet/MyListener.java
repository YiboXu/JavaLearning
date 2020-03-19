package tk.spring.annotion.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    private static Logger logger = LogManager.getLogger(MyListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("MyListener.....contextInitialized.......");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("MyListener.....contextDestroyed.......");
    }
}
