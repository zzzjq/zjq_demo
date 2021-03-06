package zjq.demo.service.abstractFactory;

/**
 * 抽象工厂模式
 * 
 * @author:zhangjq
 * @time:2017年4月18日 下午3:18:33
 * @version:v1.0
 */
public class Test {

	public static void main(String[] args) {
		// 单例+抽象工厂模式
		MailSenderFactory mailSenderFactory = AbstractFactory.getAbstractFactory().getMailSenderFactory();
		SmsSenderFactory smsSenderFactory = AbstractFactory.getAbstractFactory().getSmsSenderFactory();
		Sender sender3 = mailSenderFactory.produce();
		Sender sender4 = smsSenderFactory.produce();

		sender3.send();
		sender4.send();
	}
}
