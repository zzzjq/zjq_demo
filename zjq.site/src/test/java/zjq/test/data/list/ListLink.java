package zjq.test.data.list;

import zjq.test.data.node.Snode;

/**
 * 用单链表节点实现线性表
 * @author:zhangjq
 * @time:2017年9月26日 上午10:48:19
 * @version:v1.0
 */
public class ListLink {

	//头部
	private Snode head;
	
	private int size;
		
	public ListLink(){
		head = new Snode();
		size = 0;
	}
	
	public int getSize(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**根据数据获取前一个节点**/
	private Snode getPreNode(Object o){
		Snode p = head;
		while(p.getNext() != null){
			if(p.getNext().getData().toString().equals(o.toString()))
				return p;
			else
				p = p.getNext();
		}
		return null;
	}
	/**根据数据获取当前节点**/
	private Snode getNode(Object o){
		Snode p = head;
		while(p != null){
			if(p.getData().toString().equals(o.toString()))
				return p;
			else
				p = p.getNext();
		}
		return null;
	}
	/**根据序号获取前一个节点0<=i<size**/
	private Snode getPreNode(int i){
		Snode p = head;
		for(;i>0;i--){
			p = p.getNext();
		}
		return p;
	}
	/**根据序号获取当前节点0<=i<size**/
	private Snode getNode(int i){
		Snode p = head.getNext();
		for(;i>0;i--){
			p = p.getNext();
		}
		return p;
	}
	
	public boolean contains(Object o){
		Snode p = head.getNext();
		while(p != null){
			if(p.getData().toString().equals(o.toString()))
				return true;
			else
				p = p.getNext();
		}
		return false;
	}
	
	public int indexOf(Object o){
		Snode p = head.getNext();
		int i = 0;
		while(p	!= null){
			if(p.getData().toString().equals(o.toString())){
				return i;
			}
			else {
			   p = p.getNext();
			   i++;
			}
		}
		return -1;
	}
	
	public void insert(int i, Object o) throws Exception{
		if(i<0 || i>size)
			throw new Exception();
		Snode p = getPreNode(i);
		Snode tree = new Snode(o, p.getNext());
		p.setNext(tree);
		size ++;
	}
	
	/**在目标元素前面插入新元素**/
	public boolean insertBefore(Object o, Object target){
		Snode p = getPreNode(o);
		if(p != null){
			Snode tree = new Snode(target, p.getNext());
			p.setNext(tree);
			size ++;
			return true;
		}
		return false;
	}
	
	/**在目标元素后面插入新元素**/
	public boolean insertAfter(Object o, Object target){
		Snode p = head.getNext();
		while(p != null){
			if(p.getData().toString().equals(o.toString())){
				Snode tree = new Snode(target, p.getNext());
				p.setNext(tree);
				size ++;
				return true;
			}
			else{
				p = p.getNext();
			}
		}
		return false;
	}
	
	public Object remove(int i) throws Exception{
		if(i<0 || i>size)
			throw new Exception();
		Snode p = getPreNode(i);
		Snode q = getNode(i);
		p.setNext(q.getNext());
		size --;
		return q.getData();
	}
	
	public boolean remove(Object o){
		Snode p = getPreNode(o);
		Snode q = getNode(o);
		if(p != null && q != null){
			p.setNext(q.getNext());
			size --;
			return true;
		}
		return false;
	}
	
	public Object replace(int i, Object o) throws Exception{
		if(i<0 || i>size)
			throw new Exception();
		Snode p = getNode(i);
		Object tar = p.getData();
		p.setData(o);
		return tar;
	}
	
	public Object get(int i) throws Exception{
		if(i<0 || i>size)
			throw new Exception();
		return getNode(i).getData();
	}
	
}
