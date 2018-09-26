package zjq.test.main;
/**
 * 单例模式-双重锁
 * 线程安全并且效率高
 * 
 * @author:zhangjq
 * @time:2017年10月26日 下午2:22:41
 * @version:v1.0
 */
public class Singleton {

	private static Singleton SINGLETON;
	
	private Singleton(){}
	
	public static Singleton getInstance(){
		if(SINGLETON == null){
			synchronized (SINGLETON) {
				if(SINGLETON == null)
					SINGLETON = new Singleton();
			}
		}
		return SINGLETON;
	}
}
