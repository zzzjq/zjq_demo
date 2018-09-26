package zjq.test.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author:zhangjq
 * @time:2017年5月22日 上午10:27:59
 * @version:v1.0
 */
public class ZjqDate {

	private static final String FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	
	/** 线程局部变量 **/
	private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<>();

	/** 获取DateFormat，线程安全 **/
	private static DateFormat getFormat(String format) {
		DateFormat df = threadLocal.get();
		if (df == null) {
			df = new SimpleDateFormat(format);
			threadLocal.set(df);
		}
		return df;
	}

	public static String getYYYYMMDDHHMMSS() {
		return getFormat(FORMAT_YYYYMMDDHHMMSS).format(new Date());
	}

	public static Date getDate(long time) {
		Calendar c1 = Calendar.getInstance();
		c1.setTimeInMillis(time);
		return c1.getTime();
	}

	/***
	 * 获取当前日期的年月日
	 */
	public static void get() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		System.out.println("===年===" + year);
		System.out.println("===月===" + month);
		System.out.println("===日===" + day);
		System.out.println("===时===" + hour);
		System.out.println("===分===" + minute);
		System.out.println("===秒===" + second);
		
		
		System.out.println(cal.get(Calendar.DAY_OF_YEAR));
	}

	public static void main(String[] args) {
		System.out.println(getYYYYMMDDHHMMSS());
		get();
	}
}
