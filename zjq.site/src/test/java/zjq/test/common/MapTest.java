package zjq.test.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jboss.netty.util.internal.ConcurrentHashMap;

public class MapTest {

	public static void main(String args[]){
		Map<String,String> mmmp = new HashMap<String,String>();
		Map<String,String> mmp = new HashMap<String,String>();
		Map<String, Object> cmp = new ConcurrentHashMap<String, Object>();
		List<String> list = new ArrayList<String>();
		mmmp.put("11", "111");
		mmmp.put("22", "222");
		mmmp.put("33", "333");
//		mmmp.put("44", "444");
//		mmmp.put("55", "555");
		list.add(0, "12");
		list.add("345");
		int aa = mmmp.hashCode();

		mmmp.remove("11");
		mmp.putAll(mmmp);
		//mmmp.clear();//清空map
		int vv = mmp.size();
		for(Map.Entry<String, String> entry : mmp.entrySet()){
			if("333".equals(entry.getValue()))
				mmp.remove(entry.getKey());
		}
		for(Map.Entry<String, String> entry : mmp.entrySet()){
			System.out.println(entry.getKey()+"-"+entry.getValue());
		}
		Iterator i = list.listIterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
			
		System.out.println(vv);
		System.out.println(aa);
	}
}
