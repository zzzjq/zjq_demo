package zjq.test.data.stack;
/**
 * @author:zhangjq
 * @time:2017年9月27日 上午11:30:52
 * @version:v1.0
 */
public class StackArray implements Stack{
	
	private static final int LENGTH = 8;
	
	private Object[] elements;
	
	private int top;
	
	public StackArray(){
		top = -1;
		elements = new Object[LENGTH];
	}

	@Override
	public int getSize() {
		return top + 1;
	}

	@Override
	public boolean isEmpty() {
		return top <0;
	}

	@Override
	public void push(Object o) {
		if(getSize() >= elements.length)
			expand();
		elements[++top] = o;
	}

	private void expand(){
		Object[] o = new Object[elements.length * 2];
		for(int i=0;i<elements.length;i++){
			o[i] = elements[i];
		}
		elements = o;
	}

	@Override
	public Object pop() throws Exception {
		if(getSize() < 1)
			throw new Exception();
		Object o = elements[top];
		elements[top--] = null;
		return o;
	}

	@Override
	public Object peek() throws Exception {
		if(getSize() < 1)
			throw new Exception();
		return elements[top];
	}

}
