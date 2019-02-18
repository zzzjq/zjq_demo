package zjq.test.common;

/**
 * 父类静态变量 > 父类静态初始块 > 子类静态变量 > 子类静态初始块 > 
 * 父类成员变量 > 父类非静态初始块 > 父类构造器 > 
 * 子类成员变量 > 子类非静态初始块 > 子类构造器
 * 
 * 静态变量和静态块之间的顺序是以代码顺序，不一定是静态变量优先，只是为了测试输出
 * @author zhangjq
 * @date 2019年2月18日下午3:47:32
 *
 **/
public class ClassInitTest extends SuperClass {
	private static String a = "子类静态变量";

	private String b = "子类成员变量";

	static {
		System.out.println(a);
		System.out.println("子类静态块");
	}

	{
		System.out.println(b);
		System.out.println("子类代码块");
	}

	public ClassInitTest() {
		System.out.println("子类构造器");
	}
	
	public static void main(String[] args) {
		new ClassInitTest();
	}
	
}

class SuperClass {
	private static String a = "父类静态变量";

	private String b = "父类成员变量";

	static {
		System.out.println(a);
		System.out.println("父类静态块");
	}

	{
		System.out.println(b);
		System.out.println("父类代码块");
	}

	public SuperClass() {
		System.out.println("父类构造器");
	}
}
