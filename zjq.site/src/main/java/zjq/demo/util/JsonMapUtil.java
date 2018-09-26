package zjq.demo.util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Json字符串转Map
 * @author:zhangjq
 * @time:2017年7月24日 上午11:56:27
 * @version:v1.0
 */
public class JsonMapUtil {
	
	public static <T> T toClaaz(String jsonStr, Class<T> clazz){
		return JSON.parseObject(jsonStr, clazz);
	}
	
	public static Map<String, String> jsonToMap(String content) {
        try {
            return JSONObject.parseObject(content, Map.class);
        } catch (Exception e) {
            return null;
        }
    }
    
    public static Object jsonToObject(String content, Object object) {
        try {
            return JSONObject.parseObject(content, object.getClass());
        } catch (Exception e) {
            return null;
        }
    }

    public static String objectToJson(Object object) {
        try {
            return JSON.toJSONString(object);
        } catch (Exception e) {
            return null;
        }
    }

	public static void main(String[] args){
		String str = "{\"0\":\"zhangsan\",\"1\":\"lisi\",\"2\":\"wangwu\",\"3\":\"maliu\"}";  
		//方法一：JSONOBJECT
		Map map = new HashMap();
		map = (Map) JSONObject.parse(str);
		System.out.println(map.get("0"));
		//方法二：JSONOBJECT
		Map map2 = new HashMap();
		//map2 = JSONObject.parseObject(str);
		map2 = JSONObject.parseObject(str,Map.class);
		System.out.println(map2.get("1"));
		//方法三：JSON.parse
		Map map3 = new HashMap();
		map3 = (Map) JSON.parse(str);
		System.out.println(map3.get("2"));
		//方法四、五：JSON.parseObject
		Map map4 = new HashMap();
		//map4 = JSON.parseObject(str);
		map4 = JSON.parseObject(str,Map.class);
		System.out.println(map4.get("3"));
		Map map5 = new HashMap();
		map5 = toClaaz(str, Map.class);
		System.out.println(map5.get("2"));
	}
}
