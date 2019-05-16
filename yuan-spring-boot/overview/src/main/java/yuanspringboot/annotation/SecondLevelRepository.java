package yuanspringboot.annotation;

import java.lang.annotation.*;

/**
 * 二级。{@link org.springframework.stereotype.Repository}
 * @ClassName SecondLevelRepository
 * @Author Administrator
 * @Date 2019/4/17 22:04
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@FirstLevelRepository
public @interface SecondLevelRepository {
    String value() default "";
}
