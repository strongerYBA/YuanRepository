package yuanspringboot.annotation;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import yuanspringboot.Configuration.HelloworldConfiguration;

/**
 * Hello World {@link ImportSelector} 实现。
 * @ClassName HelloworldImportSelector
 * @Author Administrator
 * @Date 2019/4/18 20:40
 */
public class HelloworldImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{new HelloworldConfiguration().getClass().getName()};
    }
}
