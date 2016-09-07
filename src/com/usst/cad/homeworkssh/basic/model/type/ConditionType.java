/**

 * FileName:     ConditionType.java

 * @Description: TODO(用一句话描述该文件做什么)

* All rights Reserved, Designed By 乔秋飞

 * Copyright:    Copyright(C) 2014-2015

 * Company       上海理工大学.

 * @author:    乔秋飞
 * Email:      1063157465@qq.com
 * @version    V1.0 
 * Createdate:         2014-7-30 下午03:36:56
 *
 * Modification  History:

 * Date         Author        Version        Discription

 * -----------------------------------------------------------------------------------

 * 2014-7-30       wu.zh          1.0             1.0

 * Why & What is modified: <修改原因描述>

 */
package com.usst.cad.homeworkssh.basic.model.type;



/**
 * 类名称：         ConditionType.java
 * 类描述：         TODO(用一句话描述该文件做什么)
 * 创建人：         
 * 创建时间 ：   2014-7-30 下午03:36:56
 * 修改人：         乔秋飞
 * Email:     1063157465@qq.com
 * 修改时间 ：   2014-7-30 下午03:36:56
 * 修改备注 ：  
 * 版本：               v1.0
 */
public enum ConditionType {
	EQ("大于"), LE("小于等于"), GE("大于等于"), LT("小于"), GT("大于"), LIEK("类似于"), BETWEENT("两者之间"), NOT("否定"), OR("或"), DESCORDER(
	"按什么降序"), ACSORDER("按什么升序");
	private final String text;
	ConditionType(String text) {
		this.text = text;
	}

	public String toText() {
		return text;
	}

	public static ConditionType fromValue(String text) {
		for (ConditionType type : values()) {
			if (type.toText().endsWith(text)) {
				return type;
			}
		}
		throw new IllegalArgumentException("not support value: " + text);
	}

}
