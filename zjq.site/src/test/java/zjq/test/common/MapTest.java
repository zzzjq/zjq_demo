package zjq.test.common;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String args[]) {
		Map<String, String> mmmp = new HashMap<String, String>();
		Map<String, String> mmp = new HashMap<String, String>();
		mmmp.put("11", "111");
		mmmp.put("22", "222");
		mmmp.put("33", "333");
		mmmp.put("44", "444");
		mmmp.put("55", "555");
		mmp.putAll(mmmp);
		mmmp.remove("11");
		// mmmp.clear();//清空map
		System.out.println(mmp.size());
		System.out.println(mmmp.size());
		/** 获取values数组 **/
		System.out.println(mmmp.values());
		/** 判断是否存在key，找hash就行 **/
		System.out.println(mmmp.containsKey("11"));
		System.out.println(mmmp.containsKey("22"));
		/** 判断是否存在value，效率低，要循环 **/
		System.out.println(mmmp.containsValue("111"));
		System.out.println(mmmp.containsValue("222"));
		/** 获取所有的key-value **/
		for (Map.Entry<String, String> entry : mmp.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
		/** 获取所有的key **/
		for (String key : mmmp.keySet()) {
			System.out.println(key);
		}
	}

}
