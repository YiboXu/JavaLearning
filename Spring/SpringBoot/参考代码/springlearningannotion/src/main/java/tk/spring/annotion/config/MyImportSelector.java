package tk.spring.annotion.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

    /**
     *
     * @param importingClassMetadata 标注了@Import的类的注解信息
     * @return 返回需要导入spring容器的的全类名
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"tk.spring.annotion.model.Blue","tk.spring.annotion.model.Red"};
    }
}
