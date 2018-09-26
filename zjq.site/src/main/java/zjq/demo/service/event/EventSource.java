package zjq.demo.service.event;
/**
 *	@author zhangjq
 *	@date 	2018年4月24日 下午7:29:40
 *
 **/
public interface EventSource {

	void addListener(Listener<? extends Event> listener);
	
	void removeListener(Listener<? extends Event> listener);
	
	void notify(Event event);
}
