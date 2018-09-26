package zjq.demo.service.abstractFactory;

/**
 * @author:zhangjq
 * @time:2017年4月18日 下午4:49:56
 * @version:v1.0
 */
public class AbstractFactory {
	
	private AbstractFactory(){}
	
	//内部类，维护单例
	private static class SingleFactory{
		private static final AbstractFactory abstractFactory = new AbstractFactory();
	}
	
	//获取实例
	public static AbstractFactory getAbstractFactory(){
		return SingleFactory.abstractFactory;
	}
	
	/*//synchronized关键字，锁住对象。
	private static AbstractFactory abstractFactory = null;
	
	public static AbstractFactory getAbstractFactory(){
		if(abstractFactory == null){
			synchronized (abstractFactory) {
				if(abstractFactory == null){
					abstractFactory = new AbstractFactory(); 
				}
			}
		}
		return abstractFactory;
	}*/
	
	public MailSenderFactory getMailSenderFactory(){
		return new MailSenderFactory();
	}
	
	public SmsSenderFactory getSmsSenderFactory(){
		return new SmsSenderFactory();
	}
}
