package zjq.demo.service.aopservice;

import java.lang.reflect.InvocationTargetException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

/**
 * ProceedingJoinPoint只能用@Around
 * joinPoint.getArgs()拿到方法的参数
 * 
 * @author zhangjingqi
 * @date 2019年5月21日下午6:02:54
 *
 **/
@Aspect
@Service
public class AnotionAopService {

	@Pointcut("execution(* zjq.demo.service.aopservice.HelloWorldService.*(..))")
	public void pointcut() {

	}

	@Around("pointcut()")
	public void say(ProceedingJoinPoint joinPoint) throws Exception {
		//获取参数
		Object[] args = joinPoint.getArgs();
		for(Object o : args) {
			System.out.println(JSON.toJSONString(o));
		}
		//获取当前切点的对象
		Object target = joinPoint.getTarget();
		System.out.println(target);
		Signature s = joinPoint.getSignature();
		MethodSignature ms  = (MethodSignature) s;
		//获取方法
		System.out.println(joinPoint.getSignature().getName());
		//执行方法
		System.out.println(ms.getMethod().invoke(target, args));
	}

}
