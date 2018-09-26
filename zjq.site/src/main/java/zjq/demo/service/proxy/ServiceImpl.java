package zjq.demo.service.proxy;
/**
 * @author:zhangjq
 * @time:2017年5月25日 下午4:51:37
 * @version:v1.0
 */
public class ServiceImpl implements Service{

	@Override
	public void add(String a) {
		System.out.println("add Service !!" + a);
	}

	@Override
	public void say(String b) {
		System.out.println("say:" + b);
	}

}
