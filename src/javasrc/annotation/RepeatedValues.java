package javasrc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: Administrator
 * @Despcription:
 * @Date: Created in 2018/7/27 17:48
 * @Modified by:
 */


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
public @interface RepeatedValues {
    CanBeRepeated[] value();
}
