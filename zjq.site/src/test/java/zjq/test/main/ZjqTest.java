package zjq.test.main;
/**
 * 
 * @author zhangjq
 * @date 2019年3月28日下午7:03:11
 *
 **/
public class ZjqTest {

	private static volatile ZjqTest z;
	
	private ZjqTest() {
		
	}
	
	public static ZjqTest getZjq() {
		if(z == null) {
			synchronized (ZjqTest.class) {
				if(z == null) {
					z = new ZjqTest();
				}
			}
		}
		return z;
	}
}
