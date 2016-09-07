
package com.usst.cad.homeworkssh.basic.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;

import com.usst.cad.homeworkssh.basic.model.SRMException;
import com.usst.cad.homeworkssh.basic.model.constants.AppConstants;



public class DataUtil {
	private static int DEFAULT_SCALE = 2;

	/**
	 * 
	 * description:按精度控制Double数值输出 
	 * 
	 * @param value
	 * @return
	 */
	public static String getDoubleString(double value) {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(DEFAULT_SCALE, BigDecimal.ROUND_HALF_UP);
		return bd.toString();
	}

	public static String getDoubleString(Object value) {
		return getDoubleString(Double.parseDouble(value.toString()));
	}

	/**
	 * 
	 * description:按精度控制Double数值输出
	 * 
	 * @param value
	 * @return
	 */
	public static String getDoubleString(double value, int scale) {
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(scale, BigDecimal.ROUND_HALF_UP);
		return bd.toString();
	}

	public static int parseInt(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new NumberFormatException(value.toString() + "不能转换为整数");
		}
	}

	public static double parseDouble(Object value) {
		try {
			return Double.parseDouble(value.toString());
		} catch (NumberFormatException e) {
			throw new NumberFormatException(value.toString() + "不能转换为double");
		}
	}

	/**
	 * 
	 * description:将id数组转为字符串 data 
	 * 
	 * @param ids
	 * @return
	 */
	public static String arrayToString(int[] ids) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ids.length; i++) {
			sb.append(ids[i]);
			if (i != (ids.length - 1)) {
				sb.append(",");
			}
		}
		return sb.toString();

	}
	/**
	 * 
	 * @Title:        getRandPassword
	 * @Description: 获得一个随机的八位字符串
	 * @param:           
	 * @return:       String   
	 * @throws
	 * @author        乔秋飞
	 * @Date          2014-7-10 下午03:48:12
	 */

	public static String getRandPassword() {
		String passwordChar = "abcdefghijklmnopqrstuvwxyz1234567890";
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			sb.append(passwordChar.charAt(rand.nextInt(passwordChar.length())));
		}
		return sb.toString();
	}
/**
 * 
 * @Title:        notEmptyString
 * @Description:  检测一个字符串是否为空
 * @param:        @param value 要检测的字符串 
 * @return:       如果非空则返回true 否则false
 * @throws
 * @author        乔秋飞
 * @Date          2014-7-10 下午03:49:15
 */
	public static boolean notEmptyString(String value) {
		if (value != null && !"".endsWith(value)) {
			return true;
		} else {
			return false;
		}
	}

	public static String getNumberString(String value, int length) {
		return DataUtil.getNumberString(value, 0, length);
	}

	public static String getNumberString(String value, int prefix, int length) {
		if (DataUtil.notEmptyString(value)) {
			return String.valueOf(Long.parseLong(value) + 1);
		} else {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < length - 1; i++) {
				sb.append('0');
			}
			return String.valueOf(prefix) + sb.toString();
		}
	}
	
	/*
	 * 在合同号前面增加A以与旧的合同号进行区别预投合同和预投工作令
	 */
	public static String getNumberStringToYT(String value, String type, int length) {
		//public static String getNumberStringToYT(String value,int length) {
		Date time=new Date(System.currentTimeMillis());
		String year=DateUtil.formatDate(time).substring(2, 4);//14
		if (DataUtil.notEmptyString(value)) {
			//if(!year.equals(value.substring(1, 3))){
			if(!year.equals(value.substring(0, 2))){
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < length - 1; i++) {
					sb.append('0');
				}
				sb.append("1");
				return DateUtil.formatDate(time).substring(2, 4)+AppConstants.LINE + type + sb.toString();
			 // return AppConstants.IDENTITY+DateUtil.formatDate(time).substring(2, 4)+AppConstants.LINE + type + sb.toString();
				//return DateUtil.formatDate(time).substring(2, 4)+AppConstants.LINE  + sb.toString();
			}else{
				/*if(value.substring(5, value.length()).equals("999")||value.substring(5, value.length()).equals("9999")){
					String temp1="";
					 temp1=value.substring(5, value.length());
					long tempNum=Long.parseLong(temp1)+1;
					return DateUtil.formatDate(time).substring(2, 4)+value.substring(3, 5)+String.valueOf(tempNum).substring(0, String.valueOf(tempNum).length());
				}else{
			String temp="";
			if(Long.parseLong(value.substring(1, 2))==0){
				 temp="1"+value.substring(5, value.length());
			}
			else{ temp=value.substring(1, 2)+value.substring(5, value.length());}
			long tempNum=Long.parseLong(temp)+1;
			 return DateUtil.formatDate(time).substring(2, 4)+value.substring(3, 5)+String.valueOf(tempNum).substring(1, String.valueOf(tempNum).length());
			 }
			 */
				if(value.substring(4, value.length()).equals("9999")||value.substring(4, value.length()).equals("99999")){
					String temp1="";
					 temp1=value.substring(4, value.length());
					long tempNum=Long.parseLong(temp1)+1;
					return DateUtil.formatDate(time).substring(2, 4)+value.substring(2, 4)+String.valueOf(tempNum).substring(0, String.valueOf(tempNum).length());
				}else{
			String temp="";
			//if(Long.parseLong(value.substring(1, 2))==0){
			if(Long.parseLong(value.substring(1, 2))==0){   //不懂  +String.valueOf(tempNum).substring(0, String.valueOf(tempNum).length())不懂
				 temp="1"+value.substring(4, value.length());
			}
			else{ temp=value.substring(1, 2)+value.substring(4, value.length());}
			
			long tempNum=Long.parseLong(temp)+1;
			 return DateUtil.formatDate(time).substring(2, 4)+value.substring(2, 4)+String.valueOf(tempNum).substring(1, String.valueOf(tempNum).length());
			 }
			}
			//return DateUtil.formatDate(time).substring(2, 4)+value.substring(3, 5)+String.valueOf(tempNum).substring(1, String.valueOf(tempNum).length());}}
		} else {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < length - 1; i++) {
				sb.append('0');
			}
			sb.append("1");
			return DateUtil.formatDate(time).substring(2, 4)+AppConstants.LINE + type + sb.toString();
			//return DateUtil.formatDate(time).substring(2, 4)+AppConstants.LINE + sb.toString();
		}
	}
	/*
	 * 在合同号前面增加A以与旧的合同号进行区别预投合同
	 */
	public static String getNumberStringToFYT(String value,int length) {
		Date time=new Date(System.currentTimeMillis());
		String year=DateUtil.formatDate(time).substring(2, 4);
		if (DataUtil.notEmptyString(value)) {
			if(!year.equals(value.substring(1,3))){
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < length - 1; i++) {
					sb.append('0');
				}
				sb.append("1");
				return AppConstants.IDENTITY+DateUtil.formatDate(time).substring(2, 4)+AppConstants.LINE + sb.toString();
			}else{
				if(value.substring(4, value.length()).equals("9999")||value.substring(4, value.length()).equals("99999")){
					String temp1="";
					 temp1=value.substring(4, value.length());
					long tempNum=Long.parseLong(temp1)+1;
					return AppConstants.IDENTITY+DateUtil.formatDate(time).substring(2, 4)+AppConstants.LINE +String.valueOf(tempNum).substring(0, String.valueOf(tempNum).length());
				}else{
			String temp=value.substring(1, 2)+value.substring(4, value.length());
			long tempNum=Long.parseLong(temp)+1;
			return AppConstants.IDENTITY+DateUtil.formatDate(time).substring(2, 4)+AppConstants.LINE +String.valueOf(tempNum).substring(1, String.valueOf(tempNum).length());
			}}
		} else {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < length - 1; i++) {
				sb.append('0');
			}
			sb.append("1");
			return AppConstants.IDENTITY+DateUtil.formatDate(time).substring(2, 4)+AppConstants.LINE + sb.toString();
		}
	}

	
	public static String getNumberStringToContractCode(String prjMan,String value,String y_or_f,int length) {
		Date time=new Date(System.currentTimeMillis());
		String year=DateUtil.formatDate(time).substring(2,4);
		if (DataUtil.notEmptyString(value)) {
			if(!year.equals(value.substring(1,3)))
			{
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < length - 1; i++) {
					sb.append('0');
				}
				sb.append("1");
				return prjMan+DateUtil.formatDate(time).substring(2, 4) + y_or_f + sb.toString();
			}
			else{
			String temp=value.substring(1, 2)+value.substring(4, value.length());
			long tempNum=Long.parseLong(temp)+1;
			return value.substring(0, 4)+String.valueOf(tempNum).substring(1, String.valueOf(tempNum).length());}
		} else {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < length - 1; i++) {
				sb.append('0');
			}
			sb.append("1");
			return prjMan+DateUtil.formatDate(time).substring(2, 4) + y_or_f + sb.toString();
		}
	}

	/**
	 * 
	 * @Title:        getIndexStringId
	 * @Description:  获取以逗号分隔的字符串索引位置字符串,eg str = "12,3,5"字符串 调用getIndexString(str,2)返回3
	 * @param:        @param value
	 * @param:        @param index
	 * @param:        @return
	 * @param:        @throws SRMException   
	 * @return:       long   
	 * @throws
	 * @author        乔秋飞
	 * @Date          2014-7-10 下午04:03:56
	 */
	
	
	public static long getIndexStringId(String value, int index) throws SRMException {
		try {
			String[] ids = value.split(",");
			return Long.parseLong(ids[index - 1]);
		} catch (Exception e) {
			throw new SRMException("字符串不合法");
		}
	}
    /**
     * 
     * @Title:        getArrayId
     * @Description:  将以逗号分隔字符串形式的ids值转换为long型的ids数组
     * @param:        @param value
     * @param:        @return
     * @param:        @throws SRMException   
     * @return:       Long[]   
     * @author        乔秋飞
     * @throws
     * @Date          2014-7-10 下午04:12:51
     */
	public static Long[] getArrayId(String value) throws SRMException {
		String[] idArray = value.split(",");
		Long[] ids = new Long[idArray.length];
		for (int i = 0; i < idArray.length; i++) {
			ids[i] = Long.parseLong(idArray[i]);
		}
		return ids;
	}
/**
 * 
 * @Title:        getDoubleForTwo
 * @Description:  将一个double型的数据转换为具有两位小数的double型数据
 * @param:        @param value
 * @param:        @return   
 * @return:       double   
 * @author        乔秋飞
 * @throws
 * @Date          2014-7-10 下午04:14:57
 */
	public static double getDoubleForTwo(double value) {
		try {
			String temp = String.format("%.2f", value);
			return Double.parseDouble(temp);
		} catch (NumberFormatException e) {
			throw new NumberFormatException(String.valueOf(value) + "不能转换为double");
		}
	}

/**
 * 
 * @Title:        formateDouble
 * @Description:  格式化double型数据，形成格式为###,###,###.##格式字符串
 * @param:        @param d
 * @param:        @return   
 * @return:       String   
 * @author        乔秋飞
 * @throws
 * @Date          2014-7-10 下午04:16:21
 */
	public static String formateDouble(double d) {
		try {
			return new DecimalFormat("###,###,###.##").format(d);
		} catch (Exception e) {
			throw new NumberFormatException("转换失败");
		}
	}

}
