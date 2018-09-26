package zjq.demo.util.proxy.jdk;
/**
 * @author:zhangjq
 * @time:2017年8月30日 上午11:38:34
 * @version:v1.0
 */
public class AopServiceImpl implements AopService{

	@Override
	public void say() {
		System.out.println("say something");
	}

	@Override
	public void doo() {
		System.out.println("do something");
	}

}
