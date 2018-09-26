package zjq.test.data;
/**
 * @author:zhangjq
 * @time:2017年4月27日 上午10:19:04
 * @version:v1.0
 */
public class MyHashMap {

	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;
	
	private int threshold;
	
	private int size;
	
	private int resize;
	
	private HashEntry[] table;
	
	public MyHashMap(){
		table = new HashEntry[DEFAULT_INITIAL_CAPACITY];
		threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
		size = 0;
	}
	
	//hash值和table长度取模，计算地址位置
	private int index(Object key){
		return key.hashCode() & table.length;
	}
	
	public void put(Object key, Object value){
		if(key == null)
			return;
		int index = index(key);
		
		HashEntry entry = table[index];
		
		while(entry != null){
			if(entry.getKey().hashCode() == key.hashCode() &&
					(entry.getKey() == key || 
					 entry.getKey().equals(key))){
				entry.setValue(value);
				return;
			}
			entry = entry.getNext();
		}
		
		add(index, key, value);
	}
	
	private void add(int index, Object key, Object value){
		HashEntry entry = new HashEntry(key, value, table[index]);
		table[index] = entry;
		if(size++ >= threshold){
			resize(table.length * 2);
		}
	}
	
	private void resize(int capacity){
		if(table.length <= capacity)
			return;
		
		HashEntry[] newTable = new HashEntry[capacity];
		
		for(int i = 0; i < table.length; i++){
			HashEntry old = table[i];
			while(old != null){
				HashEntry next = old.getNext();
				int index = index(old.getKey());
				old.setNext(newTable[index]);
				newTable[index] = old;
				old = next;
			}
		}
		
		table = newTable;
		
		threshold = (int) (table.length * DEFAULT_LOAD_FACTOR);
		
		resize++;
	}
	
	//获取value
	public Object get(Object key){
		if(key == null)
			return getForNullKey();
		
		HashEntry entry = getEntry(key);
		return entry == null ? null: entry.getValue();
	}
	
	public HashEntry getEntry(Object key){
		HashEntry entry = table[index(key)];
		while (entry != null){
			if(entry.getKey().hashCode() == key.hashCode() &&
					(entry.getKey() == key ||
					 entry.getKey().equals(key))){
				return entry;
			}
			
			entry = entry.getNext();
		}
		
		return null;
	}
	
	public void remove(Object key){
		if(key == null)
			return;
		
		int index = index(key);
		
		HashEntry pre = null;
		HashEntry entry = table[index];
		
		while(entry != null){
			if(entry.getKey().hashCode() == key.hashCode() &&
					(entry.getKey()==key ||
					 entry.getKey().equals(key))){
				if(pre == null)
					table[index] = entry.getNext();
				else
					pre.setNext(entry.getNext());
				size--;
				return;
			}
			pre = entry;
			entry = entry.getNext();
		}
	}
	
	public boolean containsKey(Object key){
		if(key == null)
			return false;
		return getEntry(key) != null;
	}
	
	public int size(){
		return this.size;
	}
	
	//清空元素
	public void clear(){
		for(int i = 0; i < table.length; i++){
			table[i] = null;
		}
		this.size = 0;
	}
	
	public Object getForNullKey(){
		for(HashEntry entry = table[0];entry != null;entry = entry.next){
			if(entry.getKey() != null){
				return entry.getValue();
			}
		}
		return null;
	}
	
//	public void putForNullKey(Object value){
//		for(HashEntry entry = table[0];entry != null;entry = entry.next){
//			if(entry.getKey() == null){
//				Object oldvalue = entry.value;
//				entry.value = value;
//				return oldvalue;
//			}
//		}
//	}
	
	class HashEntry{

		private final Object key;
		
		private Object value;
		
		private HashEntry next;
		
		public HashEntry(Object key, Object value, HashEntry next){
			this.key = key;
			this.setValue(value);
			this.setNext(next);
		}

		public Object getKey() {
			return key;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

		public HashEntry getNext() {
			return next;
		}

		public void setNext(HashEntry next) {
			this.next = next;
		}
	}

}
