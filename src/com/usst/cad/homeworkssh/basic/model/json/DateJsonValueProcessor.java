/**

 * FileName:     DateJsonValueProcessor.java

 * @Description: TODO(用一句话描述该文件做什么)

* All rights Reserved, Designed By 乔秋飞

 * Copyright:    Copyright(C) 2014-2015

 * Company       上海理工大学.

 * @author:    乔秋飞
 * Email:      1063157465@qq.com
 * @version    V1.0 
 * Createdate:         2014-8-13 下午02:56:51
 *
 * Modification  History:

 * Date         Author        Version        Discription

 * -----------------------------------------------------------------------------------

 * 2014-8-13       wu.zh          1.0             1.0

 * Why & What is modified: <修改原因描述>

 */
package com.usst.cad.homeworkssh.basic.model.json;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * 类名称：         DateJsonValueProcessor.java
 * 类描述：         TODO(用一句话描述该文件做什么)
 * 创建人：         
 * 创建时间 ：   2014-8-13 下午02:56:51
 * 修改人：         乔秋飞
 * Email:     1063157465@qq.com
 * 修改时间 ：   2014-8-13 下午02:56:51
 * 修改备注 ：  
 * 版本：               v1.0
 */
public class DateJsonValueProcessor implements JsonValueProcessor {
	public static final String Default_DATE_PATTERN = "yyyy-MM-dd";
	private DateFormat dateFormat;
	
	 public DateJsonValueProcessor(String datePattern) {  
	        try {  
	            dateFormat = new SimpleDateFormat(datePattern);  
	        } catch (Exception e) {  
	            dateFormat = new SimpleDateFormat(Default_DATE_PATTERN);   
	        }  
	    }  
		 /* (non-Javadoc)
		 * @see net.sf.json.processors.JsonValueProcessor#processArrayValue(java.lang.Object, net.sf.json.JsonConfig)
		 */
		 
	@Override
	public Object processArrayValue(Object arg0, JsonConfig arg1) {
		// TODO Auto-generated method stub
		return process(arg0);
	}

	
		 /* (non-Javadoc)
		 * @see net.sf.json.processors.JsonValueProcessor#processObjectValue(java.lang.String, java.lang.Object, net.sf.json.JsonConfig)
		 */
		 
	@Override
	public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
		// TODO Auto-generated method stub
		return process(arg1);
	}
	
	 private Object process(Object value) {  
		 if(value instanceof Date){  
	          
	            return dateFormat.format((Date)value);  
	        }  
	        return value == null ? "" : value.toString();  
	    }  
  

}
