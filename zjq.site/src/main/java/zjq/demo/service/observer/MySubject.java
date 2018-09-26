package zjq.demo.service.observer;
/**
 * @author:zhangjq
 * @time:2017年5月3日 下午4:51:03
 * @version:v1.0
 */
public class MySubject extends AbstractSubject{

	@Override
	public void operator() {
		// TODO Auto-generated method stub
		System.out.println("hello.!");
		notifyAlls();
	}

}
