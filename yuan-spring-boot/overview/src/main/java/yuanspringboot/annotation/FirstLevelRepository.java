package yuanspringboot.annotation;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * 一级{@link Repository @Repository}
 * @ClassName FirstLevelRepository
 * @Author Administrator
 * @Date 2019/4/17 21:45
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repository
public @interface FirstLevelRepository {
    String value() default "";
}
