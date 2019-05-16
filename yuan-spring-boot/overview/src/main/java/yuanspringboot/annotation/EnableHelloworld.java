package yuanspringboot.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 *模块注解。
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
//@Import(HelloworldConfiguration.class)
@Import(HelloworldImportSelector.class)//EnableHelloWorld-->HelloworldImportSelector->HelloworldConfiguration->HelloWord,此方式弹性更大。
public @interface EnableHelloworld {
}
