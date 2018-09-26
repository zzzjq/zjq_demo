package zjq.demo.service.abstractFactory;
/**
 * @author:zhangjq
 * @time:2017年4月18日 下午3:15:15
 * @version:v1.0
 */
public class MailSenderFactory implements Provider{

	@Override
	public Sender produce() {
		return new MailSender();
	}

}
