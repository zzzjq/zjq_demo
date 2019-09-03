package zjq.demo.annotation.hahaha;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 好玩的注解
 * 
 * @author zhangjingqi
 * @date 2019年9月3日下午3:26:09
 *
 **/
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(value = { ElementType.METHOD })
public @interface Zjq {

	String value();

	ZjqEnums type();

}
