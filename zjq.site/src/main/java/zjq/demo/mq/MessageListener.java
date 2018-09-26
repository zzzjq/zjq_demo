package zjq.demo.mq;

import java.util.List;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;

/**
 * 自定义消费监听器
 * 
 * @author:zhangjq
 * @time:2017年5月12日 下午6:07:54
 * @version:v1.0
 */
public class MessageListener implements MessageListenerConcurrently {

	private MessageHandler messageHandler;

	@Override
	public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
		if (messageHandler.handleMessage(msgs, context))
			return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
		return ConsumeConcurrentlyStatus.RECONSUME_LATER;
	}

	public void setMessageHandler(MessageHandler messageHandler) {
		this.messageHandler = messageHandler;
	}

}
