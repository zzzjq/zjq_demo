package zjq.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/** 年月 <code>yyyy-MM</code> */
	public static final String MONTH_PATTERN = "yyyy-MM";

	/** 年月日 <code>yyyyMMdd</code> */
	public static final String DEFAULT_PATTERN = "yyyyMMdd";

	/** 年月日时分秒 <code>yyyyMMddHHmmss</code> */
	public static final String FULL_PATTERN = "yyyyMMddHHmmss";

	/** 年月日时分秒毫秒 <code>yyyyMMddHHmmssSSS</code> */
	public static final String FULL_PATTERN_MILLISECOND = "yyyyMMddHHmmssSSS";

	/** 中文格式的年月日格式 <code>yyyy-MM-dd</code> */
	public static final String CHINESE_PATTERN = "yyyy-MM-dd";

	/** 中文格式的年月日时分秒格式 <code>yyyy-MM-dd HH:mm:ss</code> */
	public static final String FULL_CHINESE_PATTERN = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 把字符串转化成日期型。
	 *
	 * @param String
	 *            字符串
	 * @param DateFormat
	 *            日期格式
	 * @return Date 转化后的日期
	 */
	public static Date getDate(String name, String df, Date defaultValue) {
		if (name == null) {
			return defaultValue;
		}
		SimpleDateFormat formatter = new SimpleDateFormat(df);
		try {
			return formatter.parse(name);
		} catch (ParseException e) {
		}
		return defaultValue;
	}

	public static Date getDate(String name) {
		return getDate(name, DateUtil.CHINESE_PATTERN, null);
	}

	public static Date getDateTime(String name) {
		return getDateTime(name, null);
	}

	public static Date getDateTime(String name, Date defaultValue) {
		return getDate(name, FULL_CHINESE_PATTERN, defaultValue);
	}
	
	/**
	 * 获取指定格式的日期字符串
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String getDateStringByPattern(Date date, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(date);
	}

	/**
	 * 获取yyyy-MM-dd格式字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateToString(Date date) {
		return getDateStringByPattern(date, CHINESE_PATTERN);
	}

	/**
	 * 获取yyyy-MM-dd HH:mm:ss格式字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String getFullTimeToString(Date date) {
		return getDateStringByPattern(date, FULL_CHINESE_PATTERN);
	}

	/**
	 * 清除日期中的小时，分钟，秒
	 *
	 * @param date
	 * @return
	 */
	public static Date clearHMS(Date date) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.HOUR_OF_DAY, 0);
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		now.set(Calendar.MILLISECOND, 0);
		return now.getTime();
	}

	/**
	 * 获取后一天的时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getNextDate(Date date) {
		return getAroundDate(date, 1);
	}
	
	/**
	 * 获取前一天的时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getPrevDate(Date date) {
		return getAroundDate(date, -1);
	}

	/**
	 * 获取 i 天后的时间
	 * 
	 * @param date
	 * @param i
	 * @return
	 */
	public static Date getAroundDate(Date date, int i) {
		if (date == null) {
			return null;
		}
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.DATE, now.get(Calendar.DATE) + i);
		return now.getTime();
	}

	/**
	 * 获取date 59时59分59秒
	 *
	 * @return
	 */
	public static Date toDayEnd(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, cal.get(Calendar.DATE));
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}
	
	/**
	 * 获取前一天0时0分0秒
	 *
	 * @return
	 */
	public static Date toLastDayStart(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获取前一天59时59分59秒
	 *
	 * @return
	 */
	public static Date toLastDayEnd(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 1);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}

	/**
	 * 获取当天的零时零分零秒
	 *
	 * @return
	 */
	public static Date getTodayStart() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获取当天59时59分59秒
	 *
	 * @return
	 */
	public static Date getTodayEnd() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	/**
	 * 获取月份的最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getLastDayOfMonth(Date date) {
		// 获取前月的最后一天
		Calendar cale = Calendar.getInstance();
		cale.setTime(date);
		cale.add(Calendar.MONTH, 1);
		cale.set(Calendar.DAY_OF_MONTH, 0);
		return cale.getTime();
	}

	public static void main(String[] args) {
		System.out.println(getPrevDate(new Date()));
		System.out.println(clearHMS(new Date()));
	}

}