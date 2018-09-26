package zjq.demo.service.event;
/**
 *	@author zhangjq
 *	@date 	2018年4月24日 下午7:28:18
 *
 **/
public interface Listener<T extends Event> {

	public void handleEvent(Event event);
}
