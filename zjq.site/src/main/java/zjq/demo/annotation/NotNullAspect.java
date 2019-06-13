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

	//("@annotation()")只能用于方法注解
	//限定两个参数，第二个为string的方法，其他方法不会进入切面
	@Pointcut("execution(* zjq.demo.annotation.HelloWorldService.*(*,String))")
	//@Pointcut("execution(* zjq.demo.annotation.HelloWorldService.*(..))")
	public void pointcut() {

	}

	/**
	 * Object[] getArgs：返回目标方法的参数
		Signature getSignature：返回目标方法的签名
		Object getTarget：返回被织入增强处理的目标对象
		Object getThis：返回AOP框架为目标对象生成的代理对象
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
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
