package javasrc.annotation;

import java.lang.annotation.*;

/**
 * @Author: Administrator
 * @Despcription:
 * @Date: Created in 2018/7/27 17:50
 * @Modified by:
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@Repeatable(RepeatedValues.class)
public @interface CanBeRepeated {
    String value();
}
