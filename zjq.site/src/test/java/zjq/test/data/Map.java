package zjq.test.data;
/**
 * @author:zhangjq
 * @time:2017年10月26日 下午2:37:01
 * @version:v1.0
 */
public class Map<K,V> {

	K key;
	V value;
	
	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	public void put(K k , V v){
		this.key = k;
		this.value = v;
	}

	public static void main(String[] args){
		Map<String, String> map = new Map<String, String>();
		map.put("aa", "bb");
		System.out.print(map.getKey());
	}
}
