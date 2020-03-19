package tk.spring.annotion.ext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener implements ApplicationListener {
    private static Logger logger = LogManager.getLogger(MyApplicationListener.class);
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        logger.info(event.getTimestamp()+" 监听到事件: "+ event);
    }
}
