/**

 * FileName:     IBaseService.java

 * @Description: TODO(用一句话描述该文件做什么)

* All rights Reserved, Designed By 乔秋飞

 * Copyright:    Copyright(C) 2014-2015

 * Company       上海理工大学.

 * @author:    乔秋飞
 * Email:      1063157465@qq.com
 * @version    V1.0 
 * Createdate:         2014-7-26 下午04:47:44
 *
 * Modification  History:

 * Date         Author        Version        Discription

 * -----------------------------------------------------------------------------------

 * 2014-7-26       wu.zh          1.0             1.0

 * Why & What is modified: <修改原因描述>

 */
package com.usst.cad.homeworkssh.basic.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

import com.usst.cad.homeworkssh.basic.model.ConditionList;
import com.usst.cad.homeworkssh.basic.model.CriterionList;



/**
 * 类名称：         IBaseService.java
 * 类描述：         TODO(用一句话描述该文件做什么)
 * 创建人：         
 * 创建时间 ：   2014-7-26 下午04:47:44
 * 修改人：         乔秋飞
 * Email:     1063157465@qq.com
 * 修改时间 ：   2014-7-26 下午04:47:44
 * 修改备注 ：  
 * 版本：               v1.0
 */
public interface IBaseService<T> {

	Serializable add(T object) throws Exception;

	void modify(T object) throws Exception;

	void remove(Serializable id) throws Exception;

	void remove(T object) throws Exception;

	void removeAll(Collection<T> objects) throws Exception;

	T getObject(Serializable id) throws Exception;
	

	T getObject(CriterionList conditions) throws Exception;

	List<T> getList(CriterionList conditions, long start, long limit);

	List<T> getList(ConditionList conditions, long start, long limit);

	List<T> getList(long start, long limit);

	void getValue(DetachedCriteria dc);

	List<T> getList();

	List<T> getList(CriterionList conditions);

	List<T> getList(ConditionList conditions);

	long getCount();

	long getCount(CriterionList conditions);

	long getCount(ConditionList conditions);

	Object getObjectByHql(String hql, Object parameters);

	List<?> getListByHql(String hql, Object parameters);

	Map<Long, T> list2Map(List<T> list);



	int executeSQL(String str);

	/**
	 * 原生方法，无封装
	 */
	List<T> getList(DetachedCriteria dc, long start, long limit);

	List<T> getList(DetachedCriteria dc);

	long getCount(DetachedCriteria dc);
	
}
