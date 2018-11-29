package zjq.test.common;

/**
 * 调用父类方法的时候，子类的static块并没有加载 默认构造器只有当类里面没有构造器，jvm才会生成。
 * 
 * @author:zhangjq
 * @time:2017年9月21日 下午4:49:39
 * @version:v1.0
 */
public class StaticTest extends superClass {

	static {
		System.out.println("test");
	}

	public StaticTest() {
		super();
		System.out.println("调用父类构造器");
	}

	public static void main(String[] args) throws Exception {
		System.out.println(new StaticTest().value);
		System.out.println(new superClass().value);
	}

}

class superClass {

	public static int value = 1;

	static {
		System.out.println("super");
	}

	public superClass() {
		System.out.println("super con");
	}
}
