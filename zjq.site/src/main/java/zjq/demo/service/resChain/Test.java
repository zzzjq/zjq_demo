package zjq.demo.service.resChain;
/**
 * @author:zhangjq
 * @time:2017年5月3日 下午4:19:07
 * @version:v1.0
 */
public class Test {

	public static void main(String[] args){
		MyHandler h1 = new MyHandler("1");
		MyHandler h2 = new MyHandler("2");
		MyHandler h3 = new MyHandler("3");
		
		h1.setHandle(h2);
		h2.setHandle(h3);
		
		h1.operator();
	}
}
