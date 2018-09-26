package zjq.demo.service.abstractFactory;
/**
 * @author:zhangjq
 * @time:2017年4月18日 下午3:17:20
 * @version:v1.0
 */
public class SmsSender implements Sender{

	@Override
	public void send() {
		System.out.println("sms send!");
	}

}
