package zjq.demo.service.facade;
/**
 * @author:zhangjq
 * @time:2017年4月18日 下午4:10:49
 * @version:v1.0
 */
public class Memory implements AbstractFacade{

	@Override
	public void open() {
		System.out.println("Memory open !!");
	}

	@Override
	public void shutDown() {
		System.out.println("Memory shutDown !!");
	}

}
