package zjq.demo.util.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author:zhangjq
 * @time:2017年8月30日 上午11:41:54
 * @version:v1.0
 */
public class AopTest {

	public static void main(String[] args){
		AopService aopService = new AopServiceImpl();
		MyInvocationHandler handler = new MyInvocationHandler(aopService);
		AopService proxy = (AopService) Proxy.newProxyInstance(
				aopService.getClass().getClassLoader(), 
				aopService.getClass().getInterfaces(),
				handler);
		proxy.say();
		proxy.doo();
	}
}
