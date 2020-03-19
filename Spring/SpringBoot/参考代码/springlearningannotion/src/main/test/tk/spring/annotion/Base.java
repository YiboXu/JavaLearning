package tk.spring.annotion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Map;

public class Base {
    static Logger logger;
    private AnnotationConfigApplicationContext applicationContext;

    public Base(Class<?> configClass){
        //logger = LoggerFactory.getLogger(this.getClass());
        logger = LogManager.getLogger(this.getClass());
        applicationContext = new AnnotationConfigApplicationContext(configClass);
    }

    //打印出当前容器中所定义的所有Bean名字
   public void printAllDefinedBeanNames(){
        logger.info("所有实例化了的Bean的名字");
        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(logger::info);
    }

    //打印一个类的所有实例
    public <T> void printBeansOfType(Class<T> typeClass){
        logger.info("所有实例化了类型为"+typeClass.toString()+"的Bean");
        Map<String, T> beans = applicationContext.getBeansOfType(typeClass);
        beans.entrySet().stream().map(element -> element.toString()).forEach(logger::info);
    }

    //通过id获取bean
    public Object getBeanById(String beanId){
        Object object = applicationContext.getBean(beanId);
        return object;
    }

    //打印环境变量
    public void printEnvironments(){
        applicationContext.getEnvironment().getSystemEnvironment().entrySet().stream().forEach(x->logger.info(x));
    }

    //发布事件
    public void publishEvent(Object event){
        applicationContext.publishEvent(event);
    }
    //关闭容器
    public void close(){
        applicationContext.close();
    }
}
