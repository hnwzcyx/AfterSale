/**

 * FileName:     ResponseType.java

 * @Description: TODO(用一句话描述该文件做什么)

* All rights Reserved, Designed By 乔秋飞

 * Copyright:    Copyright(C) 2014-2015

 * Company       上海理工大学.

 * @author:    乔秋飞
 * Email:      1063157465@qq.com
 * @version    V1.0 
 * Createdate:         2014-7-26 下午10:13:05
 *
 * Modification  History:

 * Date         Author        Version        Discription

 * -----------------------------------------------------------------------------------

 * 2014-7-26       wu.zh          1.0             1.0

 * Why & What is modified: <修改原因描述>

 */
package com.usst.cad.homeworkssh.basic.model.type;

/**
 * 类名称：         ResponseType.java
 * 类描述：         TODO(用一句话描述该文件做什么)
 * 创建人：         
 * 创建时间 ：   2014-7-26 下午10:13:05
 * 修改人：         乔秋飞
 * Email:     1063157465@qq.com
 * 修改时间 ：   2014-7-26 下午10:13:05
 * 修改备注 ：  
 * 版本：               v1.0
 */
public enum ResponseType {
	JSON("text/json;charset=UTF-8"), HTML("text/html;charset=UTF-8");
	
	private final String text;

	ResponseType(String text) {
		this.text = text;
	}

	public String toText() {
		return text;
	}

}
