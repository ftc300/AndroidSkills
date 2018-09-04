package inso.com.lib.custom_annotation.compile;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Comment:
 * Author: ftc300
 * Date: 2018/9/4
 * Blog: www.ftc300.pub
 * GitHub: https://github.com/ftc300
 */
@Retention(RetentionPolicy.SOURCE) // 注解只在源码中保留
@Target(ElementType.TYPE) // 用于修饰
public @interface Hello {
    String name() default "";
}
