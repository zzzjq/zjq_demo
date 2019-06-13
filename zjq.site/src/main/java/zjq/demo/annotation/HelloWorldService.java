package zjq.demo.annotation;

import org.springframework.stereotype.Service;

/**
 * 
 * @author zhangjingqi
 * @date 2019年6月12日下午9:04:46
 *
 **/
@Service("helloWorldService")
public class HelloWorldService {

	public String say(Person person) {
		return person.getName() + ":" + person.getAge();
	}

	public String run(Person person, String a) {
		return person.getName() + ":" + person.getAge() + ":" + a;
	}
}
