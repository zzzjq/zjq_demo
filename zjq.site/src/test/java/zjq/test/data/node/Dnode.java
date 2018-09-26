package zjq.test.data.node;
/**
 * 双向链表节点
 * @author:zhangjq
 * @time:2017年9月26日 上午10:17:32
 * @version:v1.0
 */
public class Dnode implements Node{

	private Object element;
	
	private Dnode pre;
	
	private Dnode next;
	
	public Dnode(){
	}
	
	public Dnode(Object o, Dnode pre, Dnode next){
		this.setData(o);
		this.setPre(pre);
		this.setNext(next);
	}

	public Dnode getNext() {
		return next;
	}

	public void setNext(Dnode next) {
		this.next = next;
	}

	public Dnode getPre() {
		return pre;
	}

	public void setPre(Dnode pre) {
		this.pre = pre;
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
