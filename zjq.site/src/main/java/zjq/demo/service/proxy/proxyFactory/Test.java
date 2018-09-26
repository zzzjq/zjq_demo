package zjq.demo.service.proxy.proxyFactory;
/**
 * @author:zhangjq
 * @time:2017年11月28日 上午10:41:26
 * @version:v1.0
 */
public class Test {

	public static void main(String[] args){
		DemoInterface Interface = ProxyFactory.newInstance(DemoInterface.class);
		Interface.say();
	}
}
