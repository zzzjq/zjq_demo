package zjq.demo.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	//限定args参数，两个参数的方法会进来。
	@Pointcut("execution(* zjq.demo.annotation.HelloWorldService.*(..)) && args(i,j)")
	//限定两个参数，第二个为string的方法，其他方法不会进入切面
	//@Pointcut("execution(* zjq.demo.annotation.HelloWorldService.*(*, String))")
	//@Pointcut("execution(* zjq.demo.annotation.HelloWorldService.*(..))")
	private void pointcut(Person i, String j) {
		
	}

	/**
	 * ProceedingJoinPoint joinPoint只能用在@Around
	 * 
	 * Object[] getArgs：返回目标方法的参数
	 * Signature getSignature：返回目标方法的签名
	 * Object getTarget：返回被织入增强处理的目标对象
	 * Object getThis：返回AOP框架为目标对象生成的代理对象
	 * 
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around(value = "pointcut(i,j)")
	private Object around(ProceedingJoinPoint joinPoint, Person i, String j) throws Throwable {
		// 获取方法参数1 通过joinpoint
		Object[] args = joinPoint.getArgs();
		// 获取方法参数2 通过限定args(),这样没有joinPoint的地方也能拿到
		System.out.println("i:" + i);
		System.out.println("j:" + j);
		String value = AnnotationHandler.notNull(args[0]);
		if (value != null) {
			return value;
		}
		// 如果没有问题，就放行
		return joinPoint.proceed();
	}
	
	@AfterReturning(value = "pointcut(i, j)",returning = "returnValue")
	private void after(Object returnValue, Person i, String j) {
		System.out.println("returnValue:" + returnValue);
	}

}
