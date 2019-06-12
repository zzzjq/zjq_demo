package zjq.demo.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 定义切面，获取方法参数
 * 
 * @author zhangjingqi
 * @date 2019年6月12日下午7:10:43
 *
 **/
@Aspect
@Component
public class NotNullAspect {

	@Pointcut("execution(* zjq.demo.annotation.HelloWorldService.*(..))")
	public void pointcut() {

	}

	@Around("pointcut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		// 获取方法参数
		Object[] args = joinPoint.getArgs();
		String value = AnnotationHandler.notNull(args[0]);
		if (value != null) {
			return value;
		}
		// 如果没有问题，就放行
		return joinPoint.proceed();
	}

}
