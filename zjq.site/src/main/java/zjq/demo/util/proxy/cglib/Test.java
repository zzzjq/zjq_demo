package zjq.demo.util.proxy.cglib;
/**
 * @author:zhangjq
 * @time:2017年8月30日 上午11:55:42
 * @version:v1.0
 */
public class Test {

	public static void main(String[] zjq){
		CglibProxy cglibProxy = new CglibProxy();
		Service service = Factory.getInstance(cglibProxy);
		service.say();
		service.doo();
	}
}
