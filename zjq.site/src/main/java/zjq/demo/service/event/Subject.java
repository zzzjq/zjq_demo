package zjq.demo.service.event;
/**
 *	@author zhangjq
 *	@date 	2018年4月24日 下午7:30:48
 */

import java.util.ArrayList;
import java.util.List;

public class Subject implements EventSource{
	
	private List<Listener<? extends Event>> list = new ArrayList<Listener<? extends Event>>();

	@Override
	public void addListener(Listener<? extends Event> listener) {
		System.out.println("添加监听器");
		this.list.add(listener);
	}

	@Override
	public void removeListener(Listener<? extends Event> listener) {
		this.list.remove(listener);
	}

	@Override
	public void notify(Event event) {
		this.list.stream().forEach(e -> e.handleEvent(event));
	}

}
