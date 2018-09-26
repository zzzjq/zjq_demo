package zjq.test.data.queue;
/**
 * 顺序式队列
 * @author:zhangjq
 * @time:2017年9月27日 下午2:19:03
 * @version:v1.0
 */
public class QueueArray implements Queue{
	
	private static final int CAP = 7;
	
	private Object[] elements;	
	
	private int size;
	
	private int front;
	
	private int end;
	
	public QueueArray(){
		this(CAP);
	}
	
	public QueueArray(int cap){
		size = cap + 1;
		elements = new Object[size];
		front = end = 0;
	}

	@Override
	public int getSize() {
		return (end - front + size) % size;
	}

	@Override
	public boolean isEmpty() {
		return front == end;
	}

	@Override
	public void enQueue(Object o) {
		if(getSize() == size -1)
			expand();
		elements[end] = o;
		end = (end+1)% size;
	}
	private void expand(){
		Object[] a = new Object[elements.length * 2];
		int i = front;
		int j = 0;
		while(i != end){
			a[j++] = elements[i];
			i = (i+1)%size;
		}
		elements = a;
		size = elements.length;
		front = 0;
		end = j;
	}

	@Override
	public Object deQueue() throws Exception {
		if(isEmpty())
			throw new Exception();
		Object o = elements[front];
		elements[front] = null;
		front = (front+1)%size;
		return o;
	}

	@Override
	public Object peek() throws Exception {
		if(isEmpty())
			throw new Exception();
		return elements[front];
	}

}
