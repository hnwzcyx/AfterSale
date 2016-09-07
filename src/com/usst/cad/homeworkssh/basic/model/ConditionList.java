/**

 * FileName:     ConditionList.java

 * @Description: TODO(用一句话描述该文件做什么)

* All rights Reserved, Designed By 乔秋飞

 * Copyright:    Copyright(C) 2014-2015

 * Company       上海理工大学.

 * @author:    乔秋飞
 * Email:      1063157465@qq.com
 * @version    V1.0 
 * Createdate:         2014-7-26 下午04:09:43
 *
 * Modification  History:

 * Date         Author        Version        Discription

 * -----------------------------------------------------------------------------------

 * 2014-7-26       wu.zh          1.0             1.0

 * Why & What is modified: <修改原因描述>

 */
package com.usst.cad.homeworkssh.basic.model;

import java.util.HashSet;



/**
 * 类名称：         ConditionList.java
 * 类描述：         TODO(用一句话描述该文件做什么)
 * 创建人：         
 * 创建时间 ：   2014-7-26 下午04:09:43
 * 修改人：         乔秋飞
 * Email:     1063157465@qq.com
 * 修改时间 ：   2014-7-26 下午04:09:43
 * 修改备注 ：  
 * 版本：               v1.0
 */
@SuppressWarnings("serial")
public class ConditionList extends HashSet<Condition>{
	 /**
	    * 
	    * @Title:        CreateCondition
	    * @Description:  静态方法，获得一个conditionList的set集合
	    * @param:        @return   
	    * @return:       ConditionList   
	    * @author:       乔秋飞 
	    * Email:         1063157465@qq.com
	    * @throws
	    * @Date          2014-7-26 下午03:34:17
	    */
		public static ConditionList CreateCondition() {
			return new ConditionList();
		}
	/**
	 * 
	 * @Title:        put
	 * @Description:  在List中增加一个condition
	 * @param:        @param condition
	 * @param:        @return   
	 * @return:       ConditionList   
	 * @author:       乔秋飞 
	 * Email:         1063157465@qq.com
	 * @throws
	 * @Date          2014-7-26 下午03:35:14
	 */
		public ConditionList put(Condition condition) {
			this.add(condition);
			return this;
		}

}
