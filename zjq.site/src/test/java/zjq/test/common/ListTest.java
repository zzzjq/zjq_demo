package zjq.test.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author zhangjingqi
 * @date 2019年10月14日上午11:11:37
 *
 **/
public class ListTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		Iterator<String> i = list.iterator();
		while (i.hasNext()) {
			if (i.next().equals("3"))
				i.remove();
		}
		// 异常java.util.ConcurrentModificationException
//		list.forEach(e -> {
//			if(e.equals("3"))
//				list.remove(e);
//		});

		list.forEach(e -> System.out.println(e));
	}
}
