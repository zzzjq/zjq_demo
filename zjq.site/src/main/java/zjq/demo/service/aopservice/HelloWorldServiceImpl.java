package zjq.demo.service.aopservice;

import org.springframework.stereotype.Service;

/**
 * @author:zhangjq
 * @time:2017年12月20日 下午2:38:35
 * @version:v1.0
 */
@Service
public class HelloWorldServiceImpl implements HelloWorldService {

	@Override
	public void say() {
		System.out.println("say:hello world !");
	}

}
