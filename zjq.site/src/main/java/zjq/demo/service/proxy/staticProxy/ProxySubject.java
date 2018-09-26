package zjq.demo.service.proxy.staticProxy;
/**
 * 静态代理
 * 
 * @author:zhangjq
 * @time:2017年5月25日 下午5:13:24
 * @version:v1.0
 */
public class ProxySubject implements Subject{
	
	private Subject subject;
	
	public ProxySubject(Subject subject){
		this.subject = subject;
	}

	@Override
	public void say() {
		System.out.println("I'm Proxy !!");
		subject.say();
		System.out.println("yes !!");
	}
	
	
}
