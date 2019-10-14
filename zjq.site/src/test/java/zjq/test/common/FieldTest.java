package zjq.test.common;

/**
 * 属性覆盖
 * 
 * @author zhangjingqi
 * @date 2019年10月14日下午4:53:04
 *
 **/
public class FieldTest {

	private static final String a = "123";

	static class Sub extends FieldTest {
		private static final String a = "456";
	}

	public static void main(String[] args) {
		FieldTest f = new FieldTest();
		Sub s = new Sub();
		System.out.println(f.a);
		System.out.println(s.a);
	}
}
