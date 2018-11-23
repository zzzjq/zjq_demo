package zjq.demo.rocketmq.consumer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import zjq.demo.rocketmq.consumer.listener.ConsumerListener;
import zjq.demo.rocketmq.consumer.listener.MessageListenerHandle;
import zjq.test.thread.ThreadPoolBuilder;

/**
 * mq消费者
 * 维护事件容器，key=topic，value=实际消费消息事件者
 * 监听容器内的topic，收到topic时，事件源会根据topic找到实际消费消息事件者来处理
 * 
 * @author zhangjq
 * @date 2018年11月23日下午2:51:03
 *
 **/
public class DefaultConsumer {
	
	static final private Logger logger = LoggerFactory.getLogger(DefaultConsumer.class);

	private String nameAddrs;

	private String group;

	private DefaultMQPushConsumer consumer;

	private ConcurrentHashMap<String, ConsumerListener> hold;

	private MessageModel messageModel;

	private String instanceName;

	public void init() {
		consumer = new DefaultMQPushConsumer(group);
		consumer.setNamesrvAddr(nameAddrs);
		if(instanceName != null) {
			consumer.setInstanceName(instanceName);
		}
		consumer.setMessageModel(messageModel);
		try {
			for (Map.Entry<String, ConsumerListener> entry : hold.entrySet()) {
				String topic = entry.getKey();
				ConsumerListener listener = entry.getValue();
				consumer.subscribe(topic, "*");
				logger.info("注册topic:{},listener:{}", topic, listener);
			}
			MessageListenerHandle handle = new MessageListenerHandle(ThreadPoolBuilder.build().buildPool(4, 4, 0L,
					TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()), hold);
			consumer.registerMessageListener(handle);
			consumer.start();
			logger.info("消费者启动成功");
		} catch (MQClientException e) {
			logger.error("消费者启动异常, error:{}", e);
		}
	}

	public void setNameAddrs(String nameAddrs) {
		this.nameAddrs = nameAddrs;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public void setConsumer(DefaultMQPushConsumer consumer) {
		this.consumer = consumer;
	}

	public void setHold(ConcurrentHashMap<String, ConsumerListener> hold) {
		this.hold = hold;
	}

	public void setMessageModel(MessageModel messageModel) {
		this.messageModel = messageModel;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

}
