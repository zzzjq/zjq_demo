package zjq.demo.mq;

import javax.annotation.PostConstruct;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.rocketmq.common.protocol.heartbeat.MessageModel;

/**
 * 消费者控制类
 * 
 * @author:zhangjq
 * @time:2017年5月12日 下午6:20:07
 * @version:v1.0
 */
public class MessageManager {

	static final private Logger logger = LoggerFactory.getLogger(MessageManager.class);

	@Autowired
	private TradeHandler handler;

	private String nameAddrs;

	@PostConstruct
	public void init() {
		logger.info("zjq消费者加载");
		new Consumer(nameAddrs, "zjqGroup", "trade", "123", MessageModel.BROADCASTING, handler);
	}

	public void setNameAddrs(String nameAddrs) {
		this.nameAddrs = nameAddrs;
	}

}
