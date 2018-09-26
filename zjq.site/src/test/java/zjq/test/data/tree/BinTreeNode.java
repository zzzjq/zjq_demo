package zjq.test.data.tree;

import zjq.test.data.node.Node;

/**
 * @author:zhangjq
 * @time:2018年2月26日 下午1:15:40
 * @version:v1.0
 */
public class BinTreeNode implements Node{
	
	private Object data;
	
	private BinTreeNode parent;
	
	private BinTreeNode leftChild;

	private BinTreeNode rightChild;
	
	private int height;
	
	private int size;
	
	public BinTreeNode(){}
	
	public BinTreeNode(Object object){
		data = object;
		height = 0;
		size = 1;
		parent = leftChild = rightChild = null;
	}
	
	public BinTreeNode getParent(){
		return parent;
	}
	
	public BinTreeNode getLeftChild(){
		return leftChild;
	}
	
	public BinTreeNode getRightChild(){
		return rightChild;
	}

	public int getHeight(){
		return height;
	}
	
	public int getSize(){
		return size;
	}
	
	public boolean hasParent(){
		return parent!=null;
	}
	
	public boolean hasLeftChild(){
		return leftChild!=null;
	}
	
	public boolean hasRightChild(){
		return rightChild!=null;
	}
	
	public boolean isLeaf(){
		return (!hasLeftChild() && !hasRightChild());
	}
	
	public boolean isLeftChild(){
		return (hasParent() 
				&& parent.hasLeftChild()
				&& this == parent.leftChild);
	}
	
	public boolean isRightChild(){
		return (hasParent() 
				&& parent.hasRightChild()
				&& this == parent.rightChild);
	}
	
	public void updateHeight(){
		int newHeight = 0;
		if(hasLeftChild())
			newHeight = Math.max(newHeight, 1+getLeftChild().getHeight());
		if(hasRightChild())
			newHeight = Math.max(newHeight, 1+getRightChild().getHeight());
		if(newHeight == this.getHeight())
			return;
		if(hasParent())
			getParent().updateHeight();
	}
	
	public void updateSize(){
		size = 1;
		if(hasLeftChild())
			size += getLeftChild().getSize();
		if(hasRightChild())
			size += getRightChild().getSize();
		if(hasParent())
			getParent().updateSize();
	}
	
	/**断开当前节点和其父节点**/
	public void server(){
		if(!hasParent())
			return;
		if(isLeftChild())
			parent.leftChild = null;
		if(isRightChild())
			parent.rightChild = null;
		parent.updateHeight();
		parent.updateSize();
		parent = null;
	}
	
	public BinTreeNode setLeftChild(BinTreeNode newNode){
		BinTreeNode oldNode = this.leftChild;
		if(hasLeftChild()){
			leftChild.server();
		}
		if(newNode != null){
			newNode.server();
			this.leftChild = newNode;
			newNode.parent = this;
			this.updateHeight();
			this.updateSize();
		}
		return oldNode;
	}
	
	public BinTreeNode setRightChild(BinTreeNode newNode){
		BinTreeNode oldNode = this.rightChild;
		if(hasLeftChild()){
			rightChild.server();
		}
		if(newNode != null){
			newNode.server();
			this.rightChild = newNode;
			newNode.parent = this;
			this.updateHeight();
			this.updateSize();
		}
		return oldNode;
	}
	
	@Override
	public Object getData() {
		return data;
	}

	@Override
	public void setData(Object o) {
		data = o;
	}

}
