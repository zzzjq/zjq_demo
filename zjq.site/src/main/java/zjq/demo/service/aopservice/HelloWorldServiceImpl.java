package zjq.demo.service.aopservice;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * @author:zhangjq
 * @time:2017年12月20日 下午2:38:35
 * @version:v1.0
 */
@Service
public class HelloWorldServiceImpl implements HelloWorldService, InitializingBean {

	@Override
	public void say() {
		System.out.println("say:hello world !");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("HelloWorldService afterPropertiesSet");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("HelloWorldService init");
	}

}
