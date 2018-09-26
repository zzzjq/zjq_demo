package zjq.demo.util.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author:zhangjq
 * @time:2017年8月30日 上午11:52:01
 * @version:v1.0
 */
public class CglibProxy implements MethodInterceptor{

	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		//切面1
		System.out.println("what do you want to do");
		//被代理对象的方法
		proxy.invokeSuper(obj, args);
		//切面2
		System.out.println("OK");
		return null;
	}

}
