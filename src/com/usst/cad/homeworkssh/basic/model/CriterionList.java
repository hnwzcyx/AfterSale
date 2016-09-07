/**

 * FileName:     CriterionList.java

 * @Description: TODO(用一句话描述该文件做什么)

* All rights Reserved, Designed By 乔秋飞

 * Copyright:    Copyright(C) 2014-2015

 * Company       上海理工大学.

 * @author:    乔秋飞
 * Email:      1063157465@qq.com
 * @version    V1.0 
 * Createdate:         2014-7-26 下午03:39:56
 *
 * Modification  History:

 * Date         Author        Version        Discription

 * -----------------------------------------------------------------------------------

 * 2014-7-26       wu.zh          1.0             1.0

 * Why & What is modified: <修改原因描述>

 */
package com.usst.cad.homeworkssh.basic.model;

import java.util.ArrayList;


/**
 * 类名称：         CriterionList.java
 * 类描述：         用于存放Criteriond的List对象
 * 创建人：         
 * 创建时间 ：   2014-7-26 下午03:39:56
 * 修改人：         乔秋飞
 * Email:     1063157465@qq.com
 * 修改时间 ：   2014-7-26 下午03:39:56
 * 修改备注 ：  
 * 版本：               v1.0
 */
@SuppressWarnings("serial")
public class CriterionList extends ArrayList<Object> {
	/**
	 * 
	 * @Title:        CreateCriterion
	 * @Description:  返回一个CriterionList空的对象
	 * @param:        @return   
	 * @return:       CriterionList   
	 * @author:       乔秋飞 
	 * Email:         1063157465@qq.com
	 * @throws
	 * @Date          2014-7-26 下午03:41:38
	 */
	public static CriterionList CreateCriterion() {
		return new CriterionList();
	}
/**
 * 
 * @Title:        put
 * @Description:  增加一个Criterion到CriterionList对象中
 * @param:        @param criterion
 * @param:        @return   
 * @return:       CriterionList   
 * @author:       乔秋飞 
 * Email:         1063157465@qq.com
 * @throws
 * @Date          2014-7-26 下午03:42:49
 */
	public CriterionList put(Object criterion) {
		this.add(criterion);
		return this;
	}
/**
 * 	
 * @Title:        CreateCriterion
 * @Description:  返回一个指定参数的CriterionList对象
 * @param:        @param criterion object类型参数
 * @param:        @return   
 * @return:       CriterionList   
 * @author:       乔秋飞 
 * Email:         1063157465@qq.com
 * @throws
 * @Date          2014-7-26 下午03:43:53
 */
	public static CriterionList CreateCriterion(Object criterion) {
		CriterionList list = new CriterionList();
		list.add(criterion);
		return list;
	}

}
