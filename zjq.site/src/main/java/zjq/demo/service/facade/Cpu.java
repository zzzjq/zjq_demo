package zjq.demo.service.facade;
/**
 * @author:zhangjq
 * @time:2017年4月18日 下午4:08:15
 * @version:v1.0
 */
public class Cpu implements AbstractFacade{

	@Override
	public void open() {
		System.out.println("Cpu open !!");
	}

	@Override
	public void shutDown() {
		System.out.println("Cpu open !!");
	}

}
