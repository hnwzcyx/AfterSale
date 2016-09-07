package com.usst.cad.homeworkssh.basic.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import com.usst.cad.homeworkssh.basic.model.constants.AppConstants;



public class DateUtil {

	public static final String DATEFORMAT = "MM/dd/yyyy";
	public static final String DATETIMEFORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String MONTHFORMAT = "yyyy-MM";
	public static final String YEARMINUTE = "MM/dd/yyyy HH:mm";
	public static final String MINUTE = "HH:mm";
	public static final String ACCESSDATAFORMAT = "yyyy/MM/dd HH:mm:ss";
	public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
	public static final String MERGE_DATE_PATTERN = "yyyyMMdd";
	public static final String DATEUPLOADFORMAT = "yyyyMMddHHmmss";
	public static final String SECOND = "HH:mm:ss";
	public static final String CRON_EXPRESSION = "s m H d M ? yyyy";
	public static final String SAP_FORMAT = "yyyyMMdd";

	/**
	 * 
	 * description:将日期字符串按特定的格式转为Date对象 data 
	 * 
	 * @param dateString
	 *            :日期字符串
	 * @param dateFormat
	 *            :日期格式
	 * @return
	 * @throws ParseException
	 */
	public static Date formatString(String dateString, String dateFormat) throws ParseException {
		DateFormat df = new SimpleDateFormat(dateFormat);
		try {
			return df.parse(dateString);
		} catch (ParseException e) {
			throw new ParseException("日期格式错误", 0);
		}
	}

	public static Date formatString(String dateString) throws ParseException {
		return formatString(dateString, DEFAULT_DATE_PATTERN);
	}

	/**
	 * 
	 * description:将日期对象转为特定的日期字符串 data 
	 * 
	 * @param date
	 * @param strFormat
	 * @return
	 */
	public static String formatDate(Date date, String strFormat) {
		if (date == null) {
			return AppConstants.EMPTY;
		}
		DateFormat df = new SimpleDateFormat(strFormat);
		return df.format(date);
	}

	public static String formatDate(Date date) {
		return formatDate(date, DEFAULT_DATE_PATTERN);
	}

	
   /**
    * 
    * @Title:        getCurrentYear
    * @Description:  获得今年的年份
    * @param:         
    * @return:       int   
    * @author:       乔秋飞 
    * Email:         1063157465@qq.com
    * @throws
    * @Date          2014-7-10 下午04:37:57
    */
	public static int getCurrentYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}
/**
 * 
 * @Title:        formateAddOneDate
 * @Description:  在给定的时间上增加一天
 * @param:        dateString： 日期格式的字符串
 * @param:        @throws ParseException   
 * @return:       Date   返回日期
 * @author:       乔秋飞 
 * Email:         1063157465@qq.com
 * @throws
 * @Date          2014-7-10 下午04:41:19
 */
	public static Date formateAddOneDate(String dateString) throws ParseException {
		Date date = formatString(dateString);
		Date addOneDate = new Date(date.getTime() + 24 * 60 * 60 * 1000);
		return addOneDate;
	}
/**
 * 
 * @Title:        getCurrentDateFormatString
 * @Description:  生成一个唯一标识的字符串
 * @param:        @return   
 * @return:       String   
 * @author:       乔秋飞 
 * Email:         1063157465@qq.com
 * @throws
 * @Date          2014-7-10 下午04:49:21
 */
	public static String getCurrentDateFormatString() {
		return UUID.randomUUID().toString() + DateUtil.formatDate(new Date(), DateUtil.DATEUPLOADFORMAT);
	}

/**
 * 
 * @Title:        getCurrentDateFormatStringPdf
 * @Description:  生成一个以.pdf结尾的唯一字符串
 * @param:        @return   
 * @return:       String   
 * @author:       乔秋飞 
 * Email:         1063157465@qq.com
 * @throws
 * @Date          2014-7-10 下午04:50:00
 */
	public static String getCurrentDateFormatStringPdf() {
		return UUID.randomUUID().toString() + DateUtil.formatDate(new Date(), DateUtil.DATEUPLOADFORMAT)
				+ AppConstants.POINT + AppConstants.FileCategory.PDF;
	}

	/**
	 * 
	 * @Title:        getCurrentDateFormatStringExcel
	 * @Description:  生成一个以.excel结尾的唯一字符串
	 * @param:        @return   
	 * @return:       String   
	 * @author:       乔秋飞 
	 * Email:         1063157465@qq.com
	 * @throws
	 * @Date          2014-7-10 下午04:50:43
	 */
	public static String getCurrentDateFormatStringExcel() {
		return UUID.randomUUID().toString() + DateUtil.formatDate(new Date(), DateUtil.DATEUPLOADFORMAT)
				+ AppConstants.POINT + AppConstants.FileCategory.EXCEL;
	}
	
/**
 * 
 * @Title:        getMinuxTimeToNow
 * @Description:  计算一个给定时间与现在时间之间的时间间隔
 * @param:        date 给定时间      
 * @return:       long   返回时间间隔的毫秒数
 * @author:       乔秋飞 
 * Email:         1063157465@qq.com
 * @throws
 * @Date          2014-7-10 下午04:51:33
 */
	public static long getMinuxTimeToNow(Date date){
		Date now=new Date();
		return now.getTime()-date.getTime();
	}
	
	/**
	 * 
	 * @Title:        getDateTime
	 * @Description:  获取给定天数的毫秒数
	 * @param:        dates ：int型的天数
	 * @param:        @return   
	 * @return:       long   
	 * @author:       乔秋飞 
	 * Email:         1063157465@qq.com
	 * @throws
	 * @Date          2014-7-10 下午04:53:55
	 */
	public static long getDateTime(int dates){
		return dates*24*60*60*1000;
	}

	/**
	 * 
	 * @Title:        getFirstDate
	 * @Description:  获取指定年份月份的第一天
	 * @param:        @param year 指定的年份
	 * @param:        @param month 指定的月份
	 * @param:        @return   
	 * @return:       Date   
	 * @author:       乔秋飞 
	 * Email:         1063157465@qq.com
	 * @throws
	 * @Date          2014-7-10 下午05:46:11
	 */
	public static Date getFirstDate(int year,int month){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		
		return cal.getTime();
	}

	/**
	 * 
	 * @Title:        getFirstDate
	 * @Description:  获取指定年份月份的最后一天
	 * @param:        @param year 指定的年份
	 * @param:        @param month 指定的月份
	 * @param:        @return   
	 * @return:       Date   
	 * @author:       乔秋飞 
	 * Email:         1063157465@qq.com
	 * @throws
	 * @Date          2014-7-10 下午05:46:11
	 */
	
	public static Date getLastDate(int year,int month){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, value);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		
		return cal.getTime();
	}
	
	/**
	 * 
	 * @Title:        getAfterDays
	 * @Description:  获得指定日期后i天
	 * @param:        @param date 指定的日期
	 * @param:        @param i 天数
	 * @param:        @return   
	 * @return:       Date   
	 * @author:       乔秋飞 
	 * Email:         1063157465@qq.com
	 * @throws
	 * @Date          2014-7-10 下午05:47:44
	 */
	public static Date getAfterDays(Date date,int i){
		Date resultDate=null;
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_YEAR, i);
		resultDate=c.getTime();
		return resultDate;
	}
	
/*	public static Date str2Date(String str) {
		Date date = null;
		try {
			date = new SimpleDateFormat(DEFAULT_DATE_PATTERN).parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	*/
}
