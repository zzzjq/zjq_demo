package zjq.test.data.node;

/**
 * 单链表节点
 * @author:zhangjq
 * @time:2017年9月25日 下午3:58:42
 * @version:v1.0
 */
public class Snode implements Node{
	
	private Object element;
	
	private Snode next;
	
	public Snode(){}
	
	public Snode(Object o, Snode next){
		this.setData(o);
		this.setNext(next);
	}
	
	public Snode getNext() {
		return next;
	}

	public void setNext(Snode next) {
		this.next = next;
	}

	@Override
	public Object getData() {
		return element;
	}

	@Override
	public void setData(Object o) {
		this.element = o;
	}

}
