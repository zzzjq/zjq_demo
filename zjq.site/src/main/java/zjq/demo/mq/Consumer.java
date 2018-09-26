package zjq.demo.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.protocol.heartbeat.MessageModel;

/**
 * 消费者
 * 
 * @author:zhangjq
 * @time:2017年5月12日 下午5:52:17
 * @version:v1.0
 */
public class Consumer {

	static final private Logger logger = LoggerFactory.getLogger(Consumer.class);

	private String nameAddrs;

	private String group;

	private String topic;

	private String tag;

	private MessageModel messageModel;

	private MessageHandler messageHandler;

	public Consumer(String nameAddrs, String group, String topic, String tag, MessageHandler messageHandler) {
		this.nameAddrs = nameAddrs;
		this.group = group;
		this.topic = topic;
		this.tag = tag;
		this.messageHandler = messageHandler;

		init();
	}

	public Consumer(String nameAddrs, String group, String topic, String tag, MessageModel messageModel,
			MessageHandler messageHandler) {
		this.nameAddrs = nameAddrs;
		this.group = group;
		this.topic = topic;
		this.tag = tag;
		this.messageModel = messageModel;
		this.messageHandler = messageHandler;

		init();
	}

	public void init() {
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(group);
		// consumer.setConsumerGroup(group);
		consumer.setNamesrvAddr(nameAddrs);
		consumer.setInstanceName("zjqConsumer");
		try {
			consumer.subscribe(topic, tag);
			consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
			if (messageModel != null) {
				consumer.setMessageModel(messageModel);
			}
			MessageListener listener = new MessageListener();
			listener.setMessageHandler(messageHandler);
			consumer.registerMessageListener(listener);
			consumer.start();
		} catch (Exception e) {
			logger.info("消费异常");
		}
	}

}
