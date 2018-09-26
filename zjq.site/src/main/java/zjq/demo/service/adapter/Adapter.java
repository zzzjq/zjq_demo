package zjq.demo.service.adapter;
/**
 * @author:zhangjq
 * @time:2017年10月9日 下午1:11:49
 * @version:v1.0
 */
public class Adapter extends Source implements Target{

	@Override
	public void doo() {
		System.out.println("this is what i want to do!");
	}

}
