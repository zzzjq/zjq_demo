package zjq.demo.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;

public class DateUtil {

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

	public static Date getDateByAddMonth(int number, Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, number);
		return calendar.getTime();
	}

	/**
	 * @param interval
	 *            值类型
	 * @param number
	 *            值，可以为负数
	 * @param date
	 *            原始值
	 * @return 最后值
	 */
	public static int dateAdd(String interval, int number, Date date) {
		long d = DateUtil.date2MysqlDate(date);
		long myTime = 0;
		if (interval.equals("d")) { // 天
			myTime = d + (60 * 60 * 24 * number);
		} else if (interval.equals("w")) { // 星期
			myTime = d + (60 * 60 * 24 * (number * 7));
		} else if (interval.equals("m")) { // 月
			myTime = d + (60 * 60 * 24 * (number * 30));
		} else if (interval.equals("y")) { // 年
			myTime = d + (60 * 60 * 24 * (number * 365));
		} else if (interval.equals("h")) { // 小时
			myTime = d + (60 * 60 * number);
		} else if (interval.equals("n")) { // 分钟
			myTime = d + (60 * number);
		} else if (interval.equals("s")) { // 秒
			myTime = d + number;
		}
		return (int) myTime;
	}

	public static Date getDateByAdd(String interval, int number, Date date) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		if (interval.equals("d")) { // 天
			now.set(Calendar.DATE, now.get(Calendar.DATE) + number);
		} else if (interval.equals("m")) { // 月
			now.set(Calendar.MONTH, now.get(Calendar.MONTH) + number);
		} else if (interval.equals("y")) { // 年
			now.set(Calendar.YEAR, now.get(Calendar.YEAR) + number);
		} else if (interval.equals("h")) { // 小时
			now.set(Calendar.HOUR, now.get(Calendar.HOUR) + number);
		} else if (interval.equals("n")) { // 分钟
			now.set(Calendar.MINUTE, now.get(Calendar.MINUTE) + number);
		} else if (interval.equals("s")) { // 秒
			now.set(Calendar.SECOND, now.get(Calendar.SECOND) + number);
		}
		return now.getTime();
	}

	/**
	 * @param interval
	 *            值类型
	 * @param number
	 *            值，可以为负数
	 * @param date
	 *            原始值
	 * @return 最后值
	 */
	public static int dateAdd(String interval, int number, int datenum) {
		Long l = Long.valueOf("10000000000");
		if (datenum >= l.longValue())
			datenum = datenum / 1000;
		long d = datenum;
		long myTime = 0;
		if (interval.equals("d")) { // 天
			myTime = d + (60 * 60 * 24 * number);
		} else if (interval.equals("w")) { // 星期
			myTime = d + (60 * 60 * 24 * (number * 7));
		} else if (interval.equals("m")) { // 月
			myTime = d + (60 * 60 * 24 * (number * 30));
		} else if (interval.equals("y")) { // 年
			myTime = d + (60 * 60 * 24 * (number * 365));
		} else if (interval.equals("h")) { // 小时
			myTime = d + (60 * 60 * number);
		} else if (interval.equals("n")) { // 分钟
			myTime = d + (60 * number);
		} else if (interval.equals("s")) { // 秒
			myTime = d + number;
		}
		return (int) myTime;
	}

	public static int dateDiff(String interval, long date1, long date2) {
		Long l = Long.valueOf("10000000000");
		if (date1 >= l.longValue())
			date1 = date1 / 1000;
		if (date2 >= l.longValue())
			date2 = date2 / 1000;

		long d = 0;
		if (interval.equals("d")) { // 天
			d = (date1 - date2) / (24 * 60 * 60);
		} else if (interval.equals("w")) { // 星期
			d = (date1 - date2) / (24 * 60 * 60 * 7);
		} else if (interval.equals("m")) { // 月
			d = (date1 - date2) / (24 * 60 * 60 * 30);
		} else if (interval.equals("y")) { // 年
			d = (date1 - date2) / (24 * 60 * 60 * 365);
		} else if (interval.equals("h")) { // 小时
			d = (date1 - date2) / (60 * 60);
		} else if (interval.equals("n")) { // 分钟
			d = (date1 - date2) / (60);
		} else if (interval.equals("s")) { // 秒
			d = date1 - date2;
		}
		return (int) Math.abs(d);
	}

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

	public static Date getDateDf(String name, String df) {
		return getDate(name, df, null);
	}

	/**
	 * 把字符串转化成日期型。 缺省为当前系统时间。
	 *
	 * @param String
	 *            字符串
	 */
	public static Date getDate(String name) {
		return getDate(name, null);
	}

	/**
	 * 把字符串转化成日期型。 缺省为当前系统时间。
	 *
	 * @param String
	 *            字符串
	 */
	public static Date getDateTime(String name) {
		return getDateTime(name, null);
	}

	/**
	 * 把字符串转化成日期型。 缺省为当前系统时间。
	 *
	 * @param String
	 *            字符串
	 */
	public static Date getDateTimeFormat(String name) {
		return getDateTimeFormat(name, null);
	}

	/**
	 * 把字符串转化成日期型。
	 *
	 * @param String
	 *            字符串
	 * @param DateFormat
	 *            日期格式
	 * @return Date 转化后的日期
	 */
	public static Date getDate(String name, Date defaultValue) {
		return getDate(name, "yyyy-MM-dd", defaultValue);
	}

	/**
	 * 把日期转成String
	 *
	 * @param String
	 *            字符串
	 * @param DateFormat
	 *            日期格式
	 * @return Date 转化后的日期
	 */
	public static String getDateToString(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(date);
	}

	public static String getYYYYMMDD(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		return simpleDateFormat.format(date);
	}

	/**
	 * 把字符串转化成日期型。
	 *
	 * @param String
	 *            字符串
	 * @param DateFormat
	 *            日期格式
	 * @return Date 转化后的日期
	 */
	public static Date getDateTime(String name, Date defaultValue) {
		return getDate(name, "yyyy-MM-dd HH:mm:ss", defaultValue);
	}

	/**
	 * 把字符串转化成日期型。
	 *
	 * @param String
	 *            字符串
	 * @param DateFormat
	 *            日期格式
	 * @return Date 转化后的日期
	 */
	public static Date getDateTimeFormat(String name, Date defaultValue) {
		return getDate(name, "yyyyMMdd", defaultValue);
	}

	/**
	 * @param str
	 *            要创建的标准时间格式
	 * @return UNIX时间
	 */
	public static int parseStr(String str) {
		return parseStr(str, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * @param str
	 *            要创建的标准时间格式
	 * @return 时间
	 */
	public static Date parseStrDate(String str, String format) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		SimpleDateFormat sd = new SimpleDateFormat(format);
		ParsePosition pos = new ParsePosition(0);
		return sd.parse(str, pos);
	}

	/**
	 * @param str
	 *            要创建的标准时间格式
	 * @return UNIX时间
	 */
	public static int parseStr(String str, String format) {
		Date d1 = parseStrDate(str, format);
		if (d1 == null)
			return 0;
		return (int) (d1.getTime() / 1000);
	}

	/**
	 * @return 得到日期
	 */
	public static int getDatebyUnix(long l) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return (int) DateUtil.parseStr(formatter.format(l) + " 00:00:00");
	}

	public static Date mysqlDate2Date(int seconds) {
		long l = (long) seconds * 1000;
		Date date = new Date(l);
		return date;
	}

	public static long date2MysqlDate(Date date) {
		return date.getTime() / 1000;
	}

	public static int date2MysqlDateInt(Date date) {
		long l = date2MysqlDate(date);
		return Integer.parseInt(l + "");
	}

	/**
	 * 返回两个日期的时间差，返回的时间差格式可以是: Calendar.YEAR, Calendar.MONTH, Calendar.DATE
	 * 注意：该功能采用递归的方法，效率还有待解决，如果两个时间之差较大，而要求返回的时间格式又很小，这时效率就很差
	 * 但此方法在要求精度较高的情况下比较有效，如求月份差的时候就比较准确，考虑到了各种情况．如闰月，闰年
	 *
	 * @param earlyDate
	 * @param lateDate
	 * @param returnTimeFormat
	 * @return time
	 */
	public static int getBetweenTime(Calendar earlyDate, Calendar lateDate, int returnTimeFormat) {
		earlyDate = (Calendar) earlyDate.clone();
		lateDate = (Calendar) lateDate.clone();
		int time = 0;
		while (earlyDate.before(lateDate)) {
			earlyDate.add(returnTimeFormat, 1);
			time++;
		}
		return time;
	}

	/**
	 * 返回两个日期的时间差，返回的时间差格式可以是: Calendar.YEAR, Calendar.MONTH, Calendar.DATE
	 * 注意：该功能采用递归的方法，效率还有待解决，如果两个时间之差较大，而要求返回的时间格式又很小，这时效率就很差
	 * 但此方法在要求精度较高的情况下比较有效，如求月份差的时候就比较准确，考虑到了各种情况．如闰月，闰年
	 *
	 * @param earlyDate
	 * @param lateDate
	 * @param returnTimeFormat
	 * @return time
	 */
	public static int getBetweenTime(Date earlyDate, Date lateDate, int returnTimeFormat) {
		Calendar cnow = Calendar.getInstance();
		cnow.setTime(earlyDate);
		Calendar clast = Calendar.getInstance();
		clast.setTime(lateDate);

		return getBetweenTime(cnow, clast, returnTimeFormat);
	}

	/**
	 * 得到给定的时间距离现在的天数
	 *
	 * @param last
	 * @return
	 */
	public static int getBetweenDays(Date begin, Date last) {
		return getBetweenTime(begin, last, Calendar.DATE);
	}

	/**
	 * 得到给定的时间距离现在的天数
	 *
	 * @param last
	 * @return
	 */
	public static int getBetweenHours(Date begin, Date last) {
		return getBetweenTime(begin, last, Calendar.HOUR_OF_DAY);
	}

	/**
	 * 得到给定的时间距离现在的分钟数
	 *
	 * @param last
	 * @return
	 */
	public static int getBetweenMins(Date begin, Date last) {
		return getBetweenTime(begin, last, Calendar.MINUTE);
	}

	/**
	 * 得到给定的时间距离现在的月数
	 *
	 * @param last
	 * @return
	 */
	public static int getBetweenMonths(Date begin, Date last) {
		return getBetweenTime(begin, last, Calendar.MONTH);
	}

	/**
	 * 得到给定的时间距离现在的年数
	 *
	 * @param last
	 * @return
	 */
	public static int getBetweenYears(Date begin, Date last) {
		return getBetweenTime(begin, last, Calendar.YEAR);
	}

	/**
	 * 得到给定的时间距离现在的天数
	 *
	 * @param last
	 * @return
	 */
	public static int getBetweenDays(int last) {
		Calendar cnow = Calendar.getInstance();
		Calendar clast = Calendar.getInstance();
		clast.setTime(DateUtil.mysqlDate2Date(last));
		int between = getBetweenTime(clast, cnow, Calendar.DATE);
		return between;
	}

	public static String dateFormate(Date date, String formate, boolean useUSA) {
		if (date != null) {
			SimpleDateFormat sdf = null;
			if (useUSA) {
				sdf = new SimpleDateFormat(formate, Locale.US);
			} else {
				sdf = new SimpleDateFormat(formate);
			}
			return sdf.format(date);
		} else {
			return null;
		}
	}

	public static String dateFormate(Date date, String formate) {
		return dateFormate(date, formate, false);
	}

	public static String dateFormateHuman(int seconds) {
		Date date = DateUtil.mysqlDate2Date(seconds);

		return dateFormateHuman(date);
	}

	public static String dateFormateHuman(Date date) {
		Calendar cnow = Calendar.getInstance();
		Calendar clast = Calendar.getInstance();
		cnow.setTime(new Date());
		clast.setTime(date);

		String format = "";
		if (cnow.get(Calendar.YEAR) == clast.get(Calendar.YEAR) && cnow.get(Calendar.MONTH) == clast.get(Calendar.MONTH)
				&& cnow.get(Calendar.DATE) == clast.get(Calendar.DATE)) {
			format = "H:mm";
		} else if (cnow.get(Calendar.YEAR) == clast.get(Calendar.YEAR)) {
			format = "M月d日";
		} else {
			format = "yyyy年M月d日";
		}

		return dateFormate(date, format);
	}

	public static String getTimeBetweenHuman(int seconds) {
		return getTimeBetweenHuman(mysqlDate2Date(seconds));
	}

	public static String getTimeBetweenHuman(Date date) {
		Calendar cnow = Calendar.getInstance();
		Calendar clast = Calendar.getInstance();
		cnow.setTime(new Date());
		clast.setTime(date);
		String re = "";
		int b = 0;

		if (cnow.get(Calendar.YEAR) == clast.get(Calendar.YEAR) && cnow.get(Calendar.MONTH) == clast.get(Calendar.MONTH)
				&& cnow.get(Calendar.DATE) == clast.get(Calendar.DATE)
				&& cnow.get(Calendar.HOUR_OF_DAY) == clast.get(Calendar.HOUR_OF_DAY)) {
			b = getBetweenMins(clast.getTime(), cnow.getTime());
			re = "分钟";
		} else if (cnow.get(Calendar.YEAR) == clast.get(Calendar.YEAR)
				&& cnow.get(Calendar.MONTH) == clast.get(Calendar.MONTH)
				&& cnow.get(Calendar.DATE) == clast.get(Calendar.DATE)) {
			b = getBetweenHours(clast.getTime(), cnow.getTime());
			re = "小时";
		} else {
			b = getBetweenDays(clast.getTime(), cnow.getTime());
			re = "天";
		}

		return b + re;
	}

	public static String getCurrentDateMillisecond() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FULL_PATTERN_MILLISECOND);
		return simpleDateFormat.format(date);
	}

	public static String dateFormate(int seconds, String formate) {
		Date date = DateUtil.mysqlDate2Date(seconds);
		return dateFormate(date, formate);
	}

	public static String getCurrentDateText(String pattern) {
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return date.format(formatter);
	}

	public static String getCurrentDateText() {
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		return date.format(formatter);
	}

	public static String getCurrentDateTextByPattern(String pattern) {
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return date.format(formatter);
	}

	/**
	 * 得到昨天的时间 yyyy-MM-dd
	 *
	 * @return
	 */
	public static String getYesterday(String pattern) {
		Calendar now = Calendar.getInstance();
		now.setTime(new Date());
		Date date = DateUtil.getDateByAdd("m", 0, now.getTime());
		Calendar dateCal = Calendar.getInstance();
		dateCal.setTime(date);
		date = DateUtil.getDateByAdd("d", -1, date);
		return DateUtil.dateFormate(date, pattern);
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
	 * 获取前一天的时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getPrevDate(Date date) {
		if (date == null) {
			return null;
		}
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - 1);
		return now.getTime();
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

	public static String getDateStringByPattern(Date date, String pattern) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(date);
	}

	public static Date getNextDate(Date date) {
		if (date == null) {
			return null;
		}
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.DATE, now.get(Calendar.DATE) + 1);
		return now.getTime();
	}

	public static Date getNextMonth(Date date) {
		if (date == null) {
			return null;
		}
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.MONTH, now.get(Calendar.MONTH) + 1);
		return now.getTime();
	}

	public static Date createDate(long date) {
		return new Date(date);
	}

	public static Date createDate(String date) {
		try {
			return createDate(Long.parseLong(date));
		} catch (Exception e) {
			return new Date();
		}
	}

	/**
	 * //0,1,2,3,4,5,6分别代表周日周一周二周三周四周五周六 根据date计算在本周的周几的日期
	 *
	 * @author yeshun
	 * @param date
	 *            计算的基础日期
	 * @param dayOfWeek
	 *            本周的周几0~6
	 * @return
	 */
	public static Date getDateByDayOfWeek(Date date, Integer dayOfWeek) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		Integer currentDayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;

		if (dayOfWeek == currentDayOfWeek) {
			return cal.getTime();
		}
		if (dayOfWeek == 0)
			dayOfWeek = 7;

		cal.set(Calendar.DATE, cal.get(Calendar.DATE) + (dayOfWeek - currentDayOfWeek));
		return cal.getTime();
	}

	/**
	 * 获取前一天零时零分零秒
	 *
	 * @return
	 */
	public static String getDayFirstSecond() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return dateFormate(cal.getTime(), FULL_CHINESE_PATTERN);
	}

	/**
	 * 获取date零时零分零秒
	 *
	 * @return
	 */
	public static Date toDaystart(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, cal.get(Calendar.DATE));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
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

	public static Date LocalDateToDate(LocalDate localDate) {
		ZoneId zone = ZoneId.systemDefault();
		Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
		return Date.from(instant);
	}

	public static Date LocalDateTimeToDate(LocalDateTime localDateTime) {
		ZoneId zone = ZoneId.systemDefault();
		Instant instant = localDateTime.atZone(zone).toInstant();
		return Date.from(instant);
	}

	public static LocalDate dateToLocalDate(Date date) {
		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
		return localDateTime.toLocalDate();
	}

	public static LocalDateTime dateToLocalDateTime(Date date) {
		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		return LocalDateTime.ofInstant(instant, zone);
	}

	public static int judgeTime(Date begin, Date last) {

		begin = DateUtil.clearHMS(begin);
		last = DateUtil.clearHMS(last);

		// 将日期转成Date对象作比较
		// 比较两个日期
		return begin.compareTo(last);
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

	/**
	 * 判断当前日期是否为月末最后一天
	 * 
	 * @param date
	 * @return false：不是 ，true是
	 */
	public static boolean isLastDayOfMonth(Date date) {
		date = clearHMS(date);
		return !(date.before(getLastDayOfMonth(date)));
	}

	/**
	 * 获取该期下一个还款日
	 * 
	 * @param date
	 * @param period
	 *            期数
	 * @return
	 */
	public static Date getNextPayDay(Date date, int period) {
		// 获取前月的最后一天
		Calendar cale = Calendar.getInstance();
		cale.setTime(date);
		cale.add(Calendar.MONTH, period);
		return cale.getTime();
	}

	/**
	 * 获取该期下一个还款日
	 * 
	 * @param date
	 * @param period
	 *            期数
	 * @return
	 */
	public static Date getNextReFundDay(Date date, int period) {
		if (isLastDayOfMonth(date)) {// 如果放款日是月末，则约定还款日都是月末

			return getNextPayDayLastDayOfMonth(date, period);
		} else {// 放款日是为非月末，则约定放款日为下个月同日
			return DateUtil.getNextPayDay(date, period);
		}

	}

	/**
	 * 测试使用 构造当月还款数据
	 * 
	 * @param date
	 * @param period
	 * @return
	 */
	public static Date getReFundDay(Date date, int period) {
		period = period - 1;
		if (isLastDayOfMonth(date)) {// 如果放款日是月末，则约定还款日都是月末

			return getNextPayDayLastDayOfMonth(date, period);
		} else {// 放款日是为非月末，则约定放款日为下个月同日
			return DateUtil.getNextPayDay(date, period);
		}

	}

	/**
	 * 获取下一个还款日(月末最后一天)
	 * 
	 * @param date
	 * @param period
	 *            期数
	 * @return
	 */
	public static Date getNextPayDayLastDayOfMonth(Date date, int period) {
		// 获取前月的最后一天
		Calendar cale = Calendar.getInstance();
		cale.setTime(date);
		cale.add(Calendar.MONTH, 1 + period);
		cale.set(Calendar.DAY_OF_MONTH, 0);
		return cale.getTime();
	}

	/**
	 * 获取当前时间前n分钟
	 * 
	 * @param minute
	 * @return
	 */
	public static Date getDateMinAgo(int minute) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, -minute);
		return cal.getTime();
	}

	public static void main(String[] args) {
		Date date = new Date();
//		System.out.println(getDateByAdd("d", -2, DateUtil.clearHMS(date)));
//		System.out.println(getDateByAddMonth(1, date));
//		System.out.println(getDateDf("2018-09-06", DateUtil.DEFAULT_PATTERN));
		System.out.println(toLastDayStart(date));
		System.out.println(toLastDayEnd(date));
		Timestamp t = new Timestamp(toLastDayEnd(date).getTime());
		System.out.println(t);
	}

}