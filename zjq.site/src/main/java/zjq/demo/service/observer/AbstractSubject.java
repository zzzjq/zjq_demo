package zjq.demo.service.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:zhangjq
 * @time:2017年5月3日 下午4:48:57
 * @version:v1.0
 */
public abstract class AbstractSubject implements Subject{
	
	private List<Observer> list = new ArrayList<Observer>();
	
	@Override
	public void add(Observer observer) {
		list.add(observer);
	}

	@Override
	public void del(Observer observer) {
		list.remove(observer);
	}

	@Override
	public void notifyAlls() {
	    list.stream().forEach(e -> e.update());
	}

}
