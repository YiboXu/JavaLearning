package tk.spring.annotion.ext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class MyUserService {
    private static Logger logger = LogManager.getLogger(MyUserService.class);

    @EventListener(ApplicationEvent.class)
    public void listener(ApplicationEvent event){
        logger.info(event.getTimestamp()+" MyUserService 监听到事件: "+ event);
    }
}
