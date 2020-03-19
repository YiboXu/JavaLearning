package tk.spring.annotion.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import tk.spring.annotion.model.RainBow;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     *
     * @param importingClassMetadata 标注了@Import的类的注解信息
     * @param registry Bean注册器，可以用其registerBeanDefinition方法来自己注册组件
     *                            还可以用其来找到容器中所有注册了的Bean的信息
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean containRed = registry.containsBeanDefinition("tk.spring.annotion.model.Red");
        boolean containBlue = registry.containsBeanDefinition("tk.spring.annotion.model.Blue");

        if(containRed && containBlue){
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
            registry.registerBeanDefinition("rainBow",rootBeanDefinition);
        }
    }
}
