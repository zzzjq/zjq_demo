package zjq.demo.service.proxy.staticProxy;
/**
 * @author:zhangjq
 * @time:2017年5月25日 下午5:12:50
 * @version:v1.0
 */
public class RealSubject implements Subject{

	@Override
	public void say() {
		System.out.println("Real!");
	}

}
