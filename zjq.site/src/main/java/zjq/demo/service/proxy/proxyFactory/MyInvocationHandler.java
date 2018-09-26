package zjq.demo.service.proxy.proxyFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author:zhangjq
 * @time:2017年11月28日 上午10:36:27
 * @version:v1.0
 */
public class MyInvocationHandler<T> implements InvocationHandler{
	
	private Class<T> Interface;
	
	public MyInvocationHandler(Class<T> Interface){
		this.Interface = Interface;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("proxy method");
		return null;
	}

}
