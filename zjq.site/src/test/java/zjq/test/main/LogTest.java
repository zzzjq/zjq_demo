package zjq.test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @author zhangjq
 * @date 2019年3月26日上午9:55:11
 *
 **/
public class LogTest {
	
	public final static String PRE = "[";
	public final static String SUF = "]";

	public static void main(String[] args) {
		String[] logs = {
		"[thread-1][100000][2019-03-15 13:07:42.164]login",
		"[thread-1][100000][2019-03-15 13:07:42.165]read db",
		"[thread-1][100000][2019-03-15 13:07:42.166]return json to frontend",
		"[thread-2][100001][2019-03-15 13:07:43.102]login"};
		List<LogData> list = form(logs);
		list.forEach(e ->{
			System.out.println(JSON.toJSONString(e));
		});
		Map<String, Integer> requestMap = getRequestMap(list);
		System.out.println(JSON.toJSONString(requestMap));
		
	}
	
	public static String getMostRequest(Map<String, Integer> requestMap) {
		for(Map.Entry<String, Integer> entry : requestMap.entrySet()) {
			
		}
		return "";
	}
	
	public static List<LogData> form(String[] logs){
		List<LogData> list = new ArrayList<>();
		for(String log : logs) {
			String[] b = log.split(SUF);
			LogData data = new LogData();
			data.setThreadId(b[0].substring(1, b[0].length()));
			data.setRequestId(b[1].substring(1, b[1].length()));
			data.setDate(b[2].substring(1, b[2].length()));
			data.setMsg(b[3]);
			list.add(data);
		}
		return list;
	}
	
	public static Map<String, Integer> getRequestMap(List<LogData> list) {
		Map<String, Integer> map = new HashMap<>();
		list.stream().forEach(e -> {
			if (map.get(e.getRequestId()) != null) {
				map.put(e.getRequestId(), map.get(e.getRequestId()) + 1);
			} else {
				map.put(e.getRequestId(), 1);
			}
		});
		return map;
	}
	
}
class LogData{
	private String threadId;
	
	private String requestId;
	
	private String date;
	
	private String msg;

	public String getThreadId() {
		return threadId;
	}

	public void setThreadId(String threadId) {
		this.threadId = threadId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}

