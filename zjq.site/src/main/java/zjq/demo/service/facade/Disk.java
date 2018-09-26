package zjq.demo.service.facade;
/**
 * @author:zhangjq
 * @time:2017年4月18日 下午4:10:55
 * @version:v1.0
 */
public class Disk implements AbstractFacade{

	@Override
	public void open() {
		System.out.println("Disk open !!");
	}

	@Override
	public void shutDown() {
		System.out.println("Disk shutDown !!");
	}

}
