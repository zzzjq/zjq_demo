package zjq.demo.service.aopservice;

import java.util.Calendar;

/**
 * @author:zhangjq
 * @time:2017年12月20日 下午2:39:48
 * @version:v1.0
 */
public class TimeAopService {

	private static Calendar ca = Calendar.getInstance();

	public void getTime() {
		System.out.println("time :" + ca.getTime().toString());
	}

	public void end() {
		System.out.println("end");
	}

}
