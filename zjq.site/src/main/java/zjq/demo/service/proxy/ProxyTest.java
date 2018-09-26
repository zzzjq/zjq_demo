package zjq.demo.service.proxy;

/**
 *  一：先生成一个handler对象：zjq.demo.service.proxy.MyInvocationHandler@7451b0af
	二：new一个要被代理的接口实现类：zjq.demo.service.proxy.ServiceImpl@6ea53502
	三：拿到被代理的类加载器：zjq.demo.service.proxy.ServiceImpl@6ea53502.classloader = sun.misc.Launcher$AppClassLoader@160bc7c0
	四：拿到被代理的类接口名：[interface zjq.demo.service.proxy.Service]
	五：拿到被代理的类的方法：com.sun.jdi.InvocationException occurred invoking method.
 * @author:zhangjq
 * @time:2017年5月25日 下午5:01:09
 * @version:v1.0
 */
public class ProxyTest {

	public static void main(String[] args){
		MyInvocationHandler handler = new MyInvocationHandler(new ServiceImpl());
		Service service = (Service) handler.getProxy();
		service.add("123");
		service.say("789");
	}
}
