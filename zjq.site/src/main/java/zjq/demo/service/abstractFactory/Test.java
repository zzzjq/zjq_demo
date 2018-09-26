package zjq.demo.service.abstractFactory;
/**
 * 抽象工厂模式
 * 多个工厂，创建不同的实例类
 * 
 * @author:zhangjq
 * @time:2017年4月18日 下午3:18:33
 * @version:v1.0
 */
public class Test {

	public static void main(String[] args){
		//抽象工厂模式
		Provider provider = new SmsSenderFactory();
		Sender sender = provider.produce();

		Provider provider2 = new MailSenderFactory();
		Sender sender2 = provider2.produce();
		
		sender.send();
		sender2.send();
		
		//静态工厂+抽象工厂模式
		MailSenderFactory mailSenderFactory = AbstractFactory.getAbstractFactory().getMailSenderFactory();
		SmsSenderFactory smsSenderFactory = AbstractFactory.getAbstractFactory().getSmsSenderFactory();
		Sender sender3 = mailSenderFactory.produce();
		Sender sender4 = smsSenderFactory.produce();
		
		sender3.send();
		sender4.send();
	}
}
