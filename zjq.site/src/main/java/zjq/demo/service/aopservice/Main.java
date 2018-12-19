package zjq.demo.service.aopservice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author:zhangjq
 * @time:2017年12月20日 下午2:48:35
 * @version:v1.0
 */
public class Main {
	
	public static void main(String[] args) throws Exception{
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(
				"aop/spring-aop.xml");
		ac.start();
		HelloWorldService helloWorldService = (HelloWorldService) ac
				.getBean("helloWorldServiceImpl");
		helloWorldService.say();
	}
}
