package zjq.test.data.stack;
/**
 * 栈基础接口
 * @author:zhangjq
 * @time:2017年9月27日 上午11:28:21
 * @version:v1.0
 */
public interface Stack {

	public int getSize();
	
	public boolean isEmpty();
	
	public void push(Object o);
	
	public Object pop() throws Exception;
	
	public Object peek() throws Exception;

}
