package zjq.demo.mq;

import java.util.List;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.common.message.MessageExt;

/**
 * 自定义消息消费接口
 * 其他所有业务接口实现该接口的消费逻辑即可
 * 
 * @author:zhangjq
 * @time:2017年5月12日 下午6:08:58
 * @version:v1.0
 */
public interface MessageHandler {

	boolean handleMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context);
}
