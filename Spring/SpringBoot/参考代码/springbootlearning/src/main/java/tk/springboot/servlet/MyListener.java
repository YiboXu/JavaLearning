package tk.springboot.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    private static Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("ServletContextListener - MyListener is initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
