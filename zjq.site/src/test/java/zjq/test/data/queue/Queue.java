package zjq.test.data.queue;

/**
 * 队列接口
 * @author:zhangjq
 * @time:2017年9月27日 下午1:53:30
 * @version:v1.0
 */
public interface Queue {

	public int getSize();

	public boolean isEmpty();

	public void enQueue(Object o);

	public Object deQueue() throws Exception;

	public Object peek() throws Exception;

}
