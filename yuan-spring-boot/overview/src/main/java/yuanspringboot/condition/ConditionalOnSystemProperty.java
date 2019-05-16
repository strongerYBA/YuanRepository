package yuanspringboot.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;


/**
 * Java 系统属性，条件判断。
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {
    /**
     * Java 系统属性的名称。
     * @return
     */
    String name();

    /**
     * 系统属性的值。
     * @return
     */
    String value();
}
