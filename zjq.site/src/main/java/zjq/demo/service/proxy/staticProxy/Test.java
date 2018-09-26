package zjq.demo.service.proxy.staticProxy;
/**
 * 静态代理测试
 * @author:zhangjq
 * @time:2017年5月25日 下午5:15:09
 * @version:v1.0
 */
public class Test {

	public static void main(String[] args){
		ProxySubject ps = new ProxySubject(new RealSubject());
		ps.say();
	}
}
