package zjq.demo.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * 
 * @author zhangjq
 * @date 下午4:00:41
 *
 **/
@Service("hello")
public class HelloWorldService {
	
	public void say() {
		System.out.println("hello");
	}

	public static void main(String[] args) {
		ApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		HelloWorldService hello = (HelloWorldService) cpx.getBean("hello");
		hello.say();
	}
}
