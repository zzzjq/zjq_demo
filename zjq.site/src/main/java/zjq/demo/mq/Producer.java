package zjq.demo.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

/**
 * 生产者
 * 
 * @author:zhangjq
 * @time:2017年5月12日 下午5:19:25
 * @version:v1.0
 */
public class Producer {

	static final private Logger logger = LoggerFactory.getLogger(Producer.class);

	private String nameAddrs;

	private String group;

	private DefaultMQProducer producer;

	public void init() {
		producer = new DefaultMQProducer(group);
		producer.setNamesrvAddr(nameAddrs);
		producer.setInstanceName("zjqProducer");
		producer.setSendMsgTimeout(1000);
		try {
			producer.start();
		} catch (Exception e) {
			logger.info("MQ启动异常" + e);
		} finally {
			logger.info("MQ启动完成");
		}
	}

	public SendResult send(Message message)
			throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
		SendResult result = producer.send(message);
		return result;
	}

	public void setNameAddrs(String nameAddrs) {
		this.nameAddrs = nameAddrs;
	}

	public void setGroup(String group) {
		this.group = group;
	}

}
