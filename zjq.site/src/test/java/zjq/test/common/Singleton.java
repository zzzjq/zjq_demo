package zjq.test.common;

/**
 * 单例模式
 * 
 * @author zhangjq
 * @date 2018年11月29日下午5:09:16
 *
 **/

// 饿汉模式，线程安全，但是没有lazyloading
public class Singleton {
	private static Singleton instance = new Singleton();

	private Singleton() {
	}

	public static Singleton getInstance() {
		return instance;
	}
}

// 静态内部类
class bb {

	private static class bbFactory {
		public static final bb bb = new bb();
	}

	private bb() {
	}

	public static bb getInstance() {
		return bbFactory.bb;
	}
}

// 懒汉，线程不安全
class CC2 {
	private static CC2 CC;

	private CC2() {
	}

	public static CC2 getCC2() {
		if (CC == null) {
			CC = new CC2();
		}
		return CC;
	}
}

// 懒汉模式,线程安全,效率低
class CC {
	private static CC cc;

	private CC() {
	}

	public synchronized static CC getCC() {
		if (cc == null)
			cc = new CC();
		return cc;
	}
}

// 双重锁定,线程安全,效率高
class Factory {
	private static Factory FACTORY;

	private Factory() {
	}

	public static Factory getFactory() {
		if (FACTORY == null) {
			synchronized (FACTORY) {
				if (FACTORY == null)
					FACTORY = new Factory();
			}
		}
		return FACTORY;
	}
}
