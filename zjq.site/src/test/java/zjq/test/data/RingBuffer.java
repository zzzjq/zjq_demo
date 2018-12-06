package zjq.test.data;

/**
 * RingBuffer
 * 
 * @author zhangjq
 * @date 2018年12月6日下午4:15:08
 *
 **/
public class RingBuffer {

	private Object[] ring;

	private int head;

	private int tail;
	
	private int size;
	
	private static final int CAP = 16;
	
	public RingBuffer() {
		ring = new Object[CAP];
		head = tail = 0;
		size = CAP;
	}
	
	public RingBuffer(int cap) {
		if(cap <= 0)
			cap = CAP;
		ring = new Object[cap];
		size = cap;
	}
	
	public int num() {
		return tail - head + 1;
	}
	
	public boolean isEmpty() {
		return head == tail;
	}
	
	public boolean isFull() {
		return (tail + 1) % size == head;
	}
	
	public void put(Object o) {
		if(isFull())
			return;
		ring[tail] = o;
		tail = (tail + 1) % size;
	}
	
	public Object get(int i) {
		if(isEmpty() || i <= 0)
			return null;
		return ring[i];
	}
	
	public static void main(String[] args) {
		RingBuffer r = new RingBuffer();
		System.out.println(r.num());
		System.out.println(r.isFull());
		System.out.println(r.isEmpty());
		for(int i = 0; i <= 20; i++) {
			r.put(new Object());
		}
		System.out.println(r.num());
		System.out.println(r.isFull());
		System.out.println(r.isEmpty());
	}

}
