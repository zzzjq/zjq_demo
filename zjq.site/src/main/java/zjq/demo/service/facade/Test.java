package zjq.demo.service.facade;
/**
 * 外观模式，解决多个类之间的耦合
 * @author:zhangjq
 * @time:2017年4月18日 下午4:15:27
 * @version:v1.0
 */
public class Test {

	public static void main(String[] agrs) throws Exception{
		AbstractFacade computer = 
				new Computer(new Cpu(), new Memory(), new Disk());
		computer.open();
		Thread.sleep(5000);
		computer.shutDown();
	}
}
