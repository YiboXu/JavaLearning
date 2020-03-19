package tk.spring.annotion.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.scheduling.quartz.SchedulerContextAware;
import org.springframework.stereotype.Component;
import tk.spring.annotion.model.Blue;

@Component
public class MyAware implements ApplicationContextAware, NotificationPublisherAware {
    @Autowired
    private Blue blue;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext in MyAware");
    }

    @Override
    public void setNotificationPublisher(NotificationPublisher notificationPublisher) {
        System.out.println("setNotificationPublisher in MyAware");
    }
}
