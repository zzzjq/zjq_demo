package zjq.demo.service.abstractFactory;
/**
 * @author:zhangjq
 * @time:2017年4月18日 下午3:18:00
 * @version:v1.0
 */
public class SmsSenderFactory implements Provider{

	@Override
	public Sender produce() {
		return new SmsSender();
	}

}
