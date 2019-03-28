package zjq.test.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author zhangjq
 * @date 2019年3月28日下午5:15:48
 *
 **/
public class MapTest {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", "value");
		map.get("key");
		for(Map.Entry<String, String> entry : map.entrySet()) {
			entry.getValue();
			entry.getKey();
		}
		
		LinkedHashMap<String, String> map2 = new LinkedHashMap<>();
		map2.put("aa", "aa");
		map2.put("bb", "bb");
		
		TreeMap<String, String> map3 = new TreeMap<>();
	}
}
