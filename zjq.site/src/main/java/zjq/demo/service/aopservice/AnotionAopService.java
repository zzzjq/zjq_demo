package zjq.demo.service.aopservice;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

/**
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
	
	@Before("pointcut()")
	public void say() {
		System.out.println("AnotionAopService aop");
	}
	
}
