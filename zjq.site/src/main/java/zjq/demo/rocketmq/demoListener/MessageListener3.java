package zjq.demo.rocketmq.demoListener;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import zjq.demo.rocketmq.consumer.listener.MessageConsumerListener;

/**
 * 实际消费消息事件者
 * 
 * @author zhangjq
 * @date 2018年11月23日下午3:13:45
 *
 **/
public class MessageListener3 extends MessageConsumerListener {

	static final private Logger logger = LoggerFactory.getLogger(MessageListener3.class);

	@Override
	public boolean onMessage(MessageExt message, ConsumeConcurrentlyContext context) {
		try {
			String msg = new String(message.getBody(), "UTF-8");
			logger.info("MessageListener3 consumer msg:{}", msg);
			// TODO
		} catch (Exception e) {
			logger.error("MessageListener3 consumer msg exception, msgId:{}, error:{}", message.getMsgId(), e);
			return false;
		}
		return true;
	}

}
