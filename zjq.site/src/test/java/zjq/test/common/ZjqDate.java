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
	
	/** 年月 <code>yyyy-MM</code> */
	public static final String MONTH_PATTERN = "yyyy-MM";

	/** 年月日 <code>yyyyMMdd</code> */
	public static final String DEFAULT_PATTERN = "yyyyMMdd";

	/** 年月日时分秒 <code>yyyyMMddHHmmss</code> */
	public static final String FULL_PATTERN = "yyyyMMddHHmmss";

	/** 年月日时分秒毫秒 <code>yyyyMMddHHmmssSSS</code> */
	public static final String FULL_PATTERN_MILLISECOND = "yyyyMMddHHmmssSSS";

	/** 标准格式的年月日时分秒 <code>yyyyMMdd HH:mm:ss</code> */
	public static final String FULL_STANDARD_PATTERN = "yyyyMMdd HH:mm:ss";

	/** 中文格式的年月日格式 <code>yyyy-MM-dd</code> */
	public static final String CHINESE_PATTERN = "yyyy-MM-dd";

	/** 中文格式的年月日时分秒格式 <code>yyyy-MM-dd HH:mm:ss</code> */
	public static final String FULL_CHINESE_PATTERN = "yyyy-MM-dd HH:mm:ss";

	public static final String DEFAULT_TIME_PATTERN = "HHmmss";
	
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

	public static String getDateByFormat(String format) {
		return getFormat(format).format(new Date());
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
		System.out.println(getDateByFormat(FULL_PATTERN));
		get();
	}
}
