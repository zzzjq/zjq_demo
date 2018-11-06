package zjq.demo.service;

/**
 * 范型
 * 
 * @author zhangjq
 * @date 2018年11月6日下午4:54:33
 *
 **/
public class TService<T> {

	/**
	 * 范型定义类
	 * 
	 * @return
	 */
	public T getT() {
		return (T) new Object();
	}

	/**
	 * 范型定义在方法内
	 * 
	 * @return
	 */
	public <T> T getT2() {
		return (T) new Object();
	}
}
