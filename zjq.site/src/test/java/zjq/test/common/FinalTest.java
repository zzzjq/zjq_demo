package zjq.test.common;
/**
 * 
 * @author zhangjingqi
 * @date 2019年10月14日下午5:00:50
 *
 **/
public class FinalTest {

	public final int a;
	
	public final int c;
	
	public static final String b;
	
	public static final String d = "456";
	
	static {
		//静态final常量可以在static块里面初始化
		b = "123";
		//不能在静态块里面初始化非静态常量
		//a = 10;
	}
	
	{
		//可以在非静态块里面初始化非静态常量
		c = 10;
	}	
	
	public FinalTest() {
		//构造器初始化final常量
		a = 10;
		//静态final常量不能在构造器里面初始化
		//b = "123";
	}
	
}
