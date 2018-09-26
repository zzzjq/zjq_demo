package zjq.demo.mq;

import java.util.List;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageExt;

/**
 * 具体业务消费处理器
 * 
 * @author:zhangjq
 * @time:2017年5月12日 下午6:22:25
 * @version:v1.0
 */
@Service
public class TradeHandler implements MessageHandler {

	@Override
	public boolean handleMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
		Message msg = msgs.get(0);
		byte[] body = msg.getBody();
		// dosomething
		return true;
	}

}
