package zjq.demo.util;
/**
 *	@author zhangjq
 *	@date 	2018年4月24日 下午2:49:56
 *
 **/

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import com.alibaba.fastjson.JSON;

public class JavaBeanSortUtil {

	public static String build(Object o) throws Exception{
		Class c = o.getClass();
		Arrays.sort(c.getFields());
		return JSON.toJSONString(o);
	}
}
