/**

 * FileName:     Condition.java

 * @Description: TODO(用一句话描述该文件做什么)

* All rights Reserved, Designed By 乔秋飞

 * Copyright:    Copyright(C) 2014-2015

 * Company       上海理工大学.

 * @author:    乔秋飞
 * Email:      1063157465@qq.com
 * @version    V1.0 
 * Createdate:         2014-7-30 下午03:36:17
 *
 * Modification  History:

 * Date         Author        Version        Discription

 * -----------------------------------------------------------------------------------

 * 2014-7-30       wu.zh          1.0             1.0

 * Why & What is modified: <修改原因描述>

 */
package com.usst.cad.homeworkssh.basic.model;

import com.usst.cad.homeworkssh.basic.model.type.ConditionType;



/**
 * 类名称：         Condition.java
 * 类描述：         TODO(用一句话描述该文件做什么)
 * 创建人：         
 * 创建时间 ：   2014-7-30 下午03:36:17
 * 修改人：         乔秋飞
 * Email:     1063157465@qq.com
 * 修改时间 ：   2014-7-30 下午03:36:17
 * 修改备注 ：  
 * 版本：               v1.0
 */
public class Condition {

	private String property;
	private ConditionType conditonType;

	private Object firstValue;

	private Object secondValue;

	private boolean isCascade;
	
	/**
	 * 创建一个新的实例 Condition.
	 *
	 */

	public Condition(String property,ConditionType conditionType,Object firstValue,Object seccondValue,Boolean isCascade) {
		this.property=property;
		this.conditonType=conditionType;
		this.firstValue = firstValue;
		this.secondValue = seccondValue;
		this.isCascade = isCascade;
	}

	public Condition(){
		
	}
	
	public Condition(String property, ConditionType conditionType) {
		this(property, conditionType, null, null, false);
	}

	public Condition(String property, Object firstValue) {
		this(property, ConditionType.EQ, firstValue, null, false);
	}

	public Condition(String property, Object firstValue, boolean isCascade) {
		this(property, ConditionType.EQ, firstValue, null, isCascade);
	}

	public Condition(String property, ConditionType conditionType, Object firstValue) {
		this(property, conditionType, firstValue, null, false);
	}

	public Condition(String property, ConditionType conditionType, Object firstValue, boolean isCascade) {
		this(property, conditionType, firstValue, null, isCascade);
	}

	
	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public ConditionType getConditonType() {
		return conditonType;
	}

	public void setConditonType(ConditionType conditonType) {
		this.conditonType = conditonType;
	}

	public Object getFirstValue() {
		return firstValue;
	}

	public void setFirstValue(Object firstValue) {
		this.firstValue = firstValue;
	}

	public Object getSecondValue() {
		return secondValue;
	}

	public void setSecondValue(Object secondValue) {
		this.secondValue = secondValue;
	}

	public boolean isCascade() {
		return isCascade;
	}

	public void setCascade(boolean isCascade) {
		this.isCascade = isCascade;
	}

}
