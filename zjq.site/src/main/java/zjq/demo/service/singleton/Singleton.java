package zjq.demo.service.singleton;

/**
 * 单例模式-双重校验锁 线程安全并且效率高
 * 
 * @author:zhangjq
 * @time:2017年10月26日 下午2:22:41
 * @version:v1.0
 */
public class Singleton {

	//volatile 防止两个线程同时通过第一个if判断。
	private volatile static Singleton SINGLETON;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (SINGLETON == null) {
			synchronized (Singleton.class) {
				if (SINGLETON == null)
					SINGLETON = new Singleton();
			}
		}
		return SINGLETON;
	}
}
