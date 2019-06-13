package zjq.demo.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author:zhangjq
 * @time:2017年12月20日 下午2:48:35
 * @version:v1.0
 */
public class Main {
	
	public static void main(String[] args) throws Exception{
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext(
				"aop/annotation.xml");
		ac.start();
		HelloWorldService h = (HelloWorldService) ac.getBean("helloWorldService");
		Person person = new Person();
		person.setName("zjq");
		//person.setAge("18");
		System.out.println(h.say(person));
		System.out.println(h.run(person, "hahahaha"));
	}
	
}
