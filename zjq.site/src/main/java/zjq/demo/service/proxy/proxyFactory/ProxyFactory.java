package zjq.demo.service.proxy.proxyFactory;

import java.lang.reflect.Proxy;

/**
 * @author:zhangjq
 * @time:2017年11月28日 上午10:38:50
 * @version:v1.0
 */
public class ProxyFactory {

	public static <T> T newInstance(Class<T> Interface){
		final MyInvocationHandler<T> handler = new MyInvocationHandler<T>(Interface);
		return (T) Proxy.newProxyInstance(
				Thread.currentThread().getContextClassLoader(),
				new Class[]{Interface},
				handler);
	}
}
