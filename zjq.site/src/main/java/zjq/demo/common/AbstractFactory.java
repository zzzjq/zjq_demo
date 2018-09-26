package zjq.demo.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import zjq.demo.exception.BizException;

/**
 * 工厂类
 * 单例模式实现
 * @author:zhangjq
 * @time:2017年4月13日 下午2:10:23
 * @version:v1.0
 */
public class AbstractFactory {
	
	/**
	 * 日志
	 */
	static
	final
	private Logger logger = LoggerFactory.getLogger(AbstractFactory.class);
	
	/**
	 * 提供成员变量
	 */
	static 
	private AbstractFactory abstractFactory;

	/**
	 * 构造器私有化
	 */
	private AbstractFactory() {}
	
	/**
	 * 调用工厂创建实例
	 * 方法锁
	 * 单例
	 * @return
	 */
	static 
	synchronized 
	public AbstractFactory getFactory() {
		if (abstractFactory == null)
			abstractFactory = new AbstractFactory();
		return abstractFactory;
	}
	
	/**
	 * 调用工厂创建实例
	 * 对象锁
	 * 单例
	 * @return
	 */
	static 
	public AbstractFactory getNewFactory(){
		if (abstractFactory == null){
			synchronized (abstractFactory) {
				if (abstractFactory == null)
					abstractFactory = new AbstractFactory();
			}
		}
		return abstractFactory;
	}

	/**
	 * 例1：判断一个字符串长度
	 * @param str
	 * @throws BizException
	 */
	public Integer doSomeThing(final String str) throws BizException {

		return new Executor<Integer>() {

			@Override
			Integer execute() {
				return str.length();
			}

		}.returnResult();

	}

	abstract class Executor<T> {
				
		public Executor(){
			
		}

		//回调函数
		abstract T execute();

		public T returnResult() throws BizException {
			T result = null;
			try {
				result = execute();
			} catch (Exception E) {
				throw new BizException();
			} finally {
				logger.info("");
			}
			return result;
		}
	}
	
	/**单例**/
	public static void main(String[] args) {
		AbstractFactory abstractFactory = AbstractFactory.getFactory();
		AbstractFactory abstractFactory2 = AbstractFactory.getNewFactory();
		System.out.println(abstractFactory.toString());
		System.out.println(abstractFactory2.toString());
		System.out.println(abstractFactory.equals(abstractFactory2));
	}

}
