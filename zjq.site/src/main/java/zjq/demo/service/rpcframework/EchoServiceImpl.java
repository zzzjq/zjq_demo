package zjq.demo.service.rpcframework;
/**
 * @author:zhangjq
 * @time:2017年5月25日 下午3:27:58
 * @version:v1.0
 */
public class EchoServiceImpl implements EchoService{

	@Override
	public String echo(String ping) {
		return ping != null ? ping + "I'm ok" : "I'm ok";
	}

}
