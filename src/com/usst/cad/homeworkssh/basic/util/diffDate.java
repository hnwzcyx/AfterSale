package com.usst.cad.homeworkssh.basic.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class diffDate {
	 /** 
     * 两个日期之间天数
     * @Methods Name getFirstDayOfQuarter 
     * @return Date 
     */  
	 public static int nDaysBetweenTwoDate(Date firstString,Date secondString){  
         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
        //对日期加减
         String first=df.format(firstString);
         String second=df.format(secondString);
         
         Date   firstDate=null;  
         Date   secondDate=null;  
         try   {  
             firstDate   =   df.parse(first);  
             secondDate=df.parse(second);  
         }  
         catch(Exception   e)   {  
             //   日期型字符串格式错误  
         }  
         int   nDay=(int)((secondDate.getTime()-firstDate.getTime())/(24*60*60*1000));  
         return   nDay;  
     }  
	 
	 /** 
	     * 本月第一天
	     * @Methods Name getFirstDayOfQuarter 
	     * @return Date 
	     */  
    public static Date benfirDate(int first){
    	java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-01");
    	java.util.Date firstDay=new java.util.Date();
    	String firstDate=format.format(firstDay);
    	SimpleDateFormat datef1=new SimpleDateFormat("yyyy-MM-dd");
    	Date  firstDate1=null;
    	try {
 			firstDate1 =datef1.parse(firstDate);
 		} catch (Exception  e) {
 		//   日期型字符串格式错误  
 		}   
 		java.sql.Date firstDate2=new java.sql.Date(firstDate1.getTime());
    	return firstDate2;
    }	
    /** 
     * 上下月第一天
     * @Methods Name getFirstDayOfQuarter 
     * @return Date 
     */  
public static Date upDate(Date date,int day){
	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd"); 
	Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.set(Calendar.DAY_OF_MONTH, 1);
    cal.add(Calendar.MONTH, day);
    String firstDate=df.format(cal.getTime());
    
    Date  firstDate1=null;
 	try {
			firstDate1 =df.parse(firstDate);
		} catch (Exception  e) {
		//   日期型字符串格式错误  
		}     
	java.sql.Date firstDate2=new java.sql.Date(firstDate1.getTime());
	return firstDate2;
}	 
    

/** 
 * 上下年第一天
 * @Methods Name getFirstDayOfQuarter 
 * @return Date 
 */  
public static Date yearDate(Date date,int year){
SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd"); 
Calendar cal = Calendar.getInstance();
cal.setTime(date);

cal.set(Calendar.DAY_OF_YEAR, 1);
cal.add(Calendar.YEAR, year);
String firstDate=df.format(cal.getTime());

Date  firstDate1=null;
	try {
		firstDate1 =df.parse(firstDate);
	} catch (Exception  e) {
	//   日期型字符串格式错误  
	}     
java.sql.Date firstDate2=new java.sql.Date(firstDate1.getTime());
return firstDate2;
}	 
    /** 
     * 本月最后一天
     * @Methods Name getFirstDayOfQuarter 
     * @return Date 
     */  
public static Date benlastDate(Date date){
	SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd"); 
	Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.set(Calendar.DAY_OF_MONTH, 1);
    cal.add(Calendar.MONTH, 1);
    cal.add(Calendar.DATE, -1);
    
    String firstDate=df.format(cal.getTime());
    
    Date  firstDate1=null;
 	try {
			firstDate1 =df.parse(firstDate);
		} catch (Exception  e) {
		//   日期型字符串格式错误  
		}     
	java.sql.Date firstDate2=new java.sql.Date(firstDate1.getTime());
	return firstDate2;
}	 
    
    
    /** 
     * 日期转化毫秒
     * @Methods Name getFirstDayOfQuarter 
     * @return Date 
     */  
public static long haomiao(Date date){
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String date1=sdf.format(date);
	//得到毫秒数
	long timeStart=0;
	try {
		 timeStart = sdf.parse(date1).getTime();
	} catch (Exception  e) {
	//   日期型字符串格式错误  
	}
	return timeStart;
}	 
    /** 
     * 每月第一天
     * @Methods Name getFirstDayOfQuarter 
     * @return Date 
     */  
    public static Date meifirDate(int first,Date date){
    	java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-01");
    	Calendar firstDay = Calendar.getInstance();
    	firstDay.setTime(date); 
    	firstDay.set(firstDay.MONTH,first-1);
    
    	String firstDate=format.format(firstDay.getTime());
    	SimpleDateFormat datef1=new SimpleDateFormat("yyyy-MM-dd");
    	Date  firstDate1=null;
    	try {
 			firstDate1 =datef1.parse(firstDate);
 		} catch (Exception  e) {
 		//   日期型字符串格式错误  
 		}   
 		java.sql.Date firstDate2=new java.sql.Date(firstDate1.getTime());
    	return firstDate2;
    }	 
    
    
    /** 
     * 上季度第一天
     * @Methods Name getFirstDayOfQuarter 
     * @return Date 
     */  
    public static Date upfirDate(int first,Date date){
    	java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-01");
    	Calendar firstDay = Calendar.getInstance();
    	firstDay.setTime(date); 
    	//int curMonth = firstDay.get(Calendar.MONTH); 
    	if(first==3){
    	firstDay.add(firstDay.MONTH,-3);
    	}else{
    		firstDay.add(firstDay.MONTH,3);	
    	}
    	String firstDate=format.format(firstDay.getTime());
    	SimpleDateFormat datef1=new SimpleDateFormat("yyyy-MM-dd");
    	Date  firstDate1=null;
    	try {
 			firstDate1 =datef1.parse(firstDate);
 		} catch (Exception  e) {
 		//   日期型字符串格式错误  
 		}   
 		java.sql.Date firstDate2=new java.sql.Date(firstDate1.getTime());
    	return firstDate2;
    }	 
    /** 
     * 得到月初累加每一天
     * @Methods Name getFirstDayOfQuarter 
     * @return Date 
     */  
    public static Date addone(Date date,int i){
    	//起始时间，然后每天加1后的日期
    	 SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd"); 
    	 String second=df.format(new Date(date.getTime()+((long)i * 24 * 60 * 60 * 1000)));
    	 Date  firstDate1=null;
     	try {
  			firstDate1 =df.parse(second);
  		} catch (Exception  e) {
  		//   日期型字符串格式错误  
  		}   
  		java.sql.Date firstDate2=new java.sql.Date(firstDate1.getTime());
    	return firstDate2;
    } 
    /** 
     * 本月总天数 
     * @Methods Name getFirstDayOfQuarter 
     * @return Date 
     */  
    public static int sumdays(int i){
    	java.util.Calendar cal = java.util.Calendar.getInstance();
    	int maxDay = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
    	return maxDay;
    } 
    /** 
     * 每月总天数 
     * @Methods Name getFirstDayOfQuarter 
     * @return Date 
     */  
    public static int days(Date date) {
    	SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy/MM");
    	Calendar firstDay = Calendar.getInstance();
    	firstDay.setTime(date);
    	String dyear=String.valueOf(firstDay.get(Calendar.YEAR));
    	String dmouth=String.valueOf(firstDay.get(Calendar.MONTH)+1);
    	    try{
    	   firstDay.setTime(simpleDate.parse(dyear+"/"+dmouth));
    	    }catch(Exception  e){
    	    
    	    }  
    	    int u=(int)firstDay.getActualMaximum(Calendar.DAY_OF_MONTH);
    	    return u;//根据年月 获取月份天数
    	
	}
    /** 
     * 得到本季度第一天的日期 
     * @Methods Name getFirstDayOfQuarter 
     * @return Date 
     */  
    public static Date getFirstDayOfQuarter(Date date)   {     
        Calendar cDay = Calendar.getInstance();     
        cDay.setTime(date);  
        int curMonth = cDay.get(Calendar.MONTH);  
        if (curMonth >= Calendar.JANUARY && curMonth <= Calendar.MARCH){    
            cDay.set(Calendar.MONTH, Calendar.JANUARY);  
        }  
        if (curMonth >= Calendar.APRIL && curMonth <= Calendar.JUNE){    
            cDay.set(Calendar.MONTH, Calendar.APRIL);  
        }  
        if (curMonth >= Calendar.JULY && curMonth <= Calendar.SEPTEMBER) {  
            cDay.set(Calendar.MONTH, Calendar.JULY);  
        }  
        if (curMonth >= Calendar.OCTOBER && curMonth <= Calendar.DECEMBER) {    
            cDay.set(Calendar.MONTH, Calendar.OCTOBER);  
        }  
        cDay.set(Calendar.DAY_OF_MONTH, cDay.getActualMinimum(Calendar.DAY_OF_MONTH));  
        System.out.println(cDay.getTime());  
        return cDay.getTime();     
    }  
    
    /** 
     * 得到本季度最后一天的日期 
     * @Methods Name getLastDayOfQuarter 
     * @return Date 
     */  
    public static Date getLastDayOfQuarter(Date date)   {     
        Calendar cDay = Calendar.getInstance();     
        cDay.setTime(date);  
        int curMonth = cDay.get(Calendar.MONTH);  
        if (curMonth >= Calendar.JANUARY && curMonth <= Calendar.MARCH){    
            cDay.set(Calendar.MONTH, Calendar.MARCH);  
        }  
        if (curMonth >= Calendar.APRIL && curMonth <= Calendar.JUNE){    
            cDay.set(Calendar.MONTH, Calendar.JUNE);  
        }  
        if (curMonth >= Calendar.JULY && curMonth <= Calendar.SEPTEMBER) {    
            cDay.set(Calendar.MONTH, Calendar.SEPTEMBER);  
        }  
        if (curMonth >= Calendar.OCTOBER && curMonth <= Calendar.DECEMBER) {    
            cDay.set(Calendar.MONTH, Calendar.DECEMBER);  
        }  
        cDay.set(Calendar.DAY_OF_MONTH, cDay.getActualMaximum(Calendar.DAY_OF_MONTH));  
        System.out.println(cDay.getTime());  
        return cDay.getTime();     
    }  
    /** 
     * 获取指定日期所在周的周一 
     * @Methods Name getMonday 
     * @return Date 
     */  
    public static Date getMonday(Date date){  
    	SimpleDateFormat datef=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cDay = Calendar.getInstance();     
        cDay.setTime(date);     
        cDay.set(Calendar.DAY_OF_WEEK, 2);//老外将周日定位第一天，周一取第二天  
        String sTime = datef.format(cDay.getTime()) + " 00:00:00";
        Date   firstDate1=null;
        try {
			firstDate1 =datef.parse(sTime);
		} catch (Exception  e) {
		//   日期型字符串格式错误  
		} 
		java.sql.Date firstDate2=new java.sql.Date(firstDate1.getTime());
    	return firstDate2;    
    }  
    
}
