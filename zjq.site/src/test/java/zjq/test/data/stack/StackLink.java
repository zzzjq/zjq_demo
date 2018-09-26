package zjq.test.data.stack;

import zjq.test.data.node.Snode;

/**
 * @author:zhangjq
 * @time:2017年9月27日 上午11:50:58
 * @version:v1.0
 */
public class StackLink implements Stack{

	private Snode top;
	
	private int size;
	
	public StackLink(){
		top = null;
		size = 0;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public void push(Object o) {
		Snode tree = new Snode(o, top);
		top = tree;
		size ++;
	}

	@Override
	public Object pop() throws Exception {
		if (getSize() <0)
			throw new Exception();
		Object o = top.getData();
		top = top.getNext();
		size --;
		return o;
	}

	@Override
	public Object peek() throws Exception {
		if (getSize() <0)
			throw new Exception();
		return top.getData();
	}
	
}
