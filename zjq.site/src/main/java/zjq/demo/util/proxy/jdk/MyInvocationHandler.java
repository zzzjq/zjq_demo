package zjq.demo.util.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author:zhangjq
 * @time:2017年8月30日 上午11:39:33
 * @version:v1.0
 */
public class MyInvocationHandler implements InvocationHandler{
	
	private Object target;
	
	public MyInvocationHandler(Object target){
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("what do you want to do");
		Object result = method.invoke(target, args);
		System.out.println("OK");
		return result;
	}

}
