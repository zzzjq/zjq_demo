package zjq.demo.service.abstractFactory;
/**
 * @author:zhangjq
 * @time:2017年4月18日 下午3:14:18
 * @version:v1.0
 */
public class MailSender implements Sender{

	@Override
	public void send() {
		System.out.println("mail send!");
	}

}
