package yuanspringboot.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

/**
 * 系统属性条件判断。编程方式的注解。
 * @ClassName OnSystemPropertyCondition
 * @Author Administrator
 * @Date 2019/4/18 21:48
 */
public class OnSystemPropertyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        MultiValueMap<String, Object> attributes = annotatedTypeMetadata.getAllAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
        String propertyName = (attributes.get("name").toString());
        String propertyValue = String.valueOf(attributes.get("value"));
//        String javaPropertValue  = System.getProperty("user.name");
        return propertyValue.equals("[Administrator]");
    }
}
