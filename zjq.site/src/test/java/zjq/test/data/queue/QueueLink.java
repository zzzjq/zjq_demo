package zjq.test.data.queue;

import zjq.test.data.node.Snode;

/**
 * 链式队列，队首不存放数据。
 * @author:zhangjq
 * @time:2017年9月27日 下午3:02:21
 * @version:v1.0
 */
public class QueueLink implements Queue{
	
	private Snode front;
	
	private Snode end;
	
	private int size;
	
	public QueueLink(){
		front = new Snode();
		front = end;
		size = 0;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void enQueue(Object o) {
		Snode tree = new Snode(o, null);
		end.setNext(tree);
		end = tree;
		size ++;
	}

	@Override
	public Object deQueue() throws Exception {
		if(size<1)
			throw new Exception();
		Snode tree = front.getNext();
		front.setNext(tree.getNext());
		size --;
		if(size <1)
			front = end;
		return tree.getData();
	}

	@Override
	public Object peek() throws Exception {
		if(size<1)
			throw new Exception();
		return front.getNext().getData();
	}

}
