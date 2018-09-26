package zjq.test.data.list;

/**
 * @author:zhangjq
 * @time:2017年9月25日 下午3:09:29
 * @version:v1.0
 */
public class ListArray {
	
	private final static int LENGTH = 8;

	private int size;

	private Object[] elements;
	
	public ListArray(){
		size = 0;
		elements = new Object[LENGTH];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean contains(Object o) {
		for (int i = 0; i < size; i++) {
			if (o.toString().equals(elements[i].toString()))
				return true;
		}
		return false;
	}

	public void insert(int i, Object o) throws Exception {
		if (i < 0 || i > size)
			throw new Exception("OUT OF BOARD");
		if (size >= elements.length)
			expandSpace();
		for (int j = size; j > i; j--) {
			elements[j] = elements[j - 1];
			elements[i] = o;
			size++;
		}

	}

	/** 扩容 **/
	private void expandSpace() {
		Object[] a = new Object[elements.length * 2];
		for (int i = 0; i < elements.length; i++) {
			a[i] = elements[i];
		}
		elements = a;
	}

	public boolean remove(Object o) throws Exception {
		int i = indexOf(o);
		if (i < 0)
			return false;
		remove(i);
		return true;
	}

	public Object remove(int i) throws Exception {
		if (i < 0 || i >= size)
			throw new Exception("OUT OF BOARD");
		Object object = elements[i];
		for (int j = i; j < size - 1; j++) {
			elements[j] = elements[j + 1];
			elements[--size] = null;
		}
		return object;
	}

	public int indexOf(Object o) {
		for (int i = 0; i < size; i++) {
			if (o.toString().equals(elements[i].toString()))
				return i;
		}
		return -1;
	}

	public Object get(int i) throws Exception {
		if (i < 0 || i >= size)
			throw new Exception("OUT OF BOARD");
		return elements[i];
	}

}
