package zjq.test.common;
/**
 * 栈溢出
 * 不停的新建方法，超过栈深度
 * @author:zhangjq
 * @time:2017年11月15日 下午5:30:13
 * @version:v1.0
 */
public class StackOverFlowTest {

	public void test(){
		this.test();
	}
	
	public static void main(String[] args){
		StackOverFlowTest test = new StackOverFlowTest();
		test.test();
	}
}
