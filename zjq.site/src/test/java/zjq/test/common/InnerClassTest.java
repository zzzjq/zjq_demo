package zjq.test.common;

import java.io.Serializable;

/**
 * 内部类、静态内部类、static关键字、this关键字
 * 
 * 可以自己继承，使多重继承实现
 * 
 * @author:zhangjq
 * @time:2017年11月15日 下午4:34:51
 * @version:v1.0
 */
public class InnerClassTest {

	// 外部类，静态成员
	public static String a = "aaaa";

	// 外部类，非静态成员
	public String b = "bbbb";

	/* 外部类可以把内部类当做成员 */
	public A aa;
	public B bb;

	//静态内部类, public所有外部类可以访问，private只能自己的外部类能访问
	private static class A {
		private static String str = "A:static object";
		private String str2 = "A:object";

		public void print() {
			/* 静态内部类不能引用外部类的非静态变量和方法 */
			System.out.println("静态内部类");
			System.out.println(a);
			/* System.out.println(b); */
			C();
			/* D(); */
		}

		public static void say() {
			System.out.println("A:static method");
		}
	}

	//非静态内部类
	public class B implements Serializable{
		private String str2 = "B:object";

		public void print() {
			/* 非静态内部类中可以调用外围类的任何成员和方法,不管是静态的还是非静态的 */
			System.out.println("非静态内部类");
			System.out.println(a);
			System.out.println(b);
			C();
			D();
		}
		/* 非静态内部类不能定义静态成员 */
		/* private static String str = "B:static object"; */
		/* 非静态内部类不能定义静态块 */
		/* static{} */
		/* 非静态内部类不能创建静态方法 */
		/* public static void say(){} */

	}

	/* 外部类静态方法 */
	public static void C() {
		/* static方法里面不能用this和super */
		/* this. */
		/* super. */

		/* 可以直接访问静态内部类的静态对象 */
		System.out.println(A.str);
		/* 可以直接访问静态内部类的静态方法 */
		A.say();

		/* 访问类的非静态对象，需要实例化对象 */
		System.out.println(new InnerClassTest().b);

		/* 访问静态内部类的非静态对象，需要实例化对象，但是不需要依赖外部类 */
		System.out.println(new A().str2);
		/* 访问静态内部类的非静态方法，需要实例化对象，但是不需要依赖外部类 */
		new A().print();

		/* 非静态内部类实例化需要先实例化外部类 */
		InnerClassTest.B b = new InnerClassTest().new B();
		System.out.println(b.str2);
		b.print();
	}

	/** 外部类非静态方法 **/
	public void D() {
		// 直接访问外部类静态成员
		System.out.println(a);
		// 直接访问外部类非静态成员
		System.out.println(b);
		
		// 直接访问静态内部类静态成员
		System.out.println(A.str);
		// 不能访问静态内部类非静态成员，需要实例化
		//System.out.println(A.str2);
		aa = new A();
		System.out.println(aa.str2);
		
		System.out.println(bb.str2);
		//this.bb = new InnerClassTest().new B();
		System.out.println(this.bb.str2 + "访问非静态内部类还是要实例化");
		/** 可以直接访问static方法 **/
		C();
	}

}
