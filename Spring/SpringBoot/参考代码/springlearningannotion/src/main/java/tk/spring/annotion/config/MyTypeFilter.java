package tk.spring.annotion.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import tk.spring.annotion.controller.PersonController;

import java.io.IOException;

public class MyTypeFilter implements TypeFilter {
    private static Logger logger = LoggerFactory.getLogger(PersonController.class);

    //MetadataReader 可以读取到当前类的信息
    //MetadataReaderFactory 可以读取到其他类的信息
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类的资源信息(比如类路径等)
        Resource resource = metadataReader.getResource();

        logger.info(classMetadata.getClassName() + "-" + resource.getURL());

        //如果类名中包含'er'就通过过滤，从而进行扫描
        if(classMetadata.getClassName().contains("er")){
            return true;
        }
        return false;
    }
}
