package zjq.demo.service.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 * @author:zhangjq
 * @time:2017年5月25日 下午4:52:36
 * @version:v1.0
 */
public class MyInvocationHandler implements InvocationHandler{
	
	private Object obj;
	
	public MyInvocationHandler(Object obj){
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//改变了参数，args[]是原始传进来的参数，proxy是修改后的参数。
		//method.invoke执行的就是代理的方法
		//每个方法各执行一遍
		method.invoke(obj, "proxy");
		method.invoke(obj, args);
		return null;
	}

	public Object getProxy(){
		//ClassLoader loader = Thread.currentThread().getContextClassLoader();
		ClassLoader loader2 = obj.getClass().getClassLoader();
		Class<?>[] interfaces = obj.getClass().getInterfaces();
		return Proxy.newProxyInstance(loader2, interfaces, this);
	}
}
