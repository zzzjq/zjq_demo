package zjq.demo.service.observer;
/**
 * @author:zhangjq
 * @time:2017年5月3日 下午4:47:36
 * @version:v1.0
 */
public interface Subject {

	public void add(Observer observer);
	
	public void del(Observer observer);
	
	public void notifyAlls();
	
	public void operator();
}
