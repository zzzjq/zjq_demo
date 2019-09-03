package zjq.demo.annotation.hahaha;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

/**
 * 
 * @author zhangjingqi
 * @date 2019年9月3日下午3:38:20
 *
 **/
@Service
public class Test {

	@Zjq(type = ZjqEnums.GO, value = "hahaha")
	public void test() {
		System.out.println("test");
	}
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext c = 
				new ClassPathXmlApplicationContext("aop/aspectj-aop.xml");
		c.start();
		Test t = (Test) c.getBean("test");
		t.test();
	}
}
