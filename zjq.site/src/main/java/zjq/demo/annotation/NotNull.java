package zjq.demo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义非空注解
 * 
 * @author zhangjingqi
 * @date 2019年6月12日下午6:20:31
 *
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface NotNull {

	String value();
}
