/**

 * FileName:     IBaseDao.java

 * @Description: TODO(用一句话描述该文件做什么)

* All rights Reserved, Designed By 乔秋飞

 * Copyright:    Copyright(C) 2014-2015

 * Company       上海理工大学.

 * @author:    乔秋飞
 * Email:      1063157465@qq.com
 * @version    V1.0 
 * Createdate:         2014-7-26 下午03:06:04
 *
 * Modification  History:

 * Date         Author        Version        Discription

 * -----------------------------------------------------------------------------------

 * 2014-7-26       wu.zh          1.0             1.0

 * Why & What is modified: <修改原因描述>

 */
package com.usst.cad.homeworkssh.basic.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;


import com.usst.cad.homeworkssh.basic.model.CriterionList;





/**
 * 类名称：         IBaseDao.java
 * 类描述：         TODO(用一句话描述该文件做什么)
 * 创建人：         
 * 创建时间 ：   2014-7-26 下午03:06:04
 * 修改人：         乔秋飞
 * Email:     1063157465@qq.com
 * 修改时间 ：   2014-7-26 下午03:06:04
 * 修改备注 ：  
 * 版本：               v1.0
 */
public interface IBaseDao<T> {

	/**
	 * 
	 * @Title:        getObject
	 * @Description:  通过id获取T类型对象
	 * @param:        @param id
	 * @param:        @return   
	 * @return:       T   
	 * @author:       乔秋飞 
	 * Email:         1063157465@qq.com
	 * @throws
	 * @Date          2014-7-26 下午03:08:54
	 */
	T getObject(Serializable id);
	
	T getObject(DetachedCriteria dc);
	DetachedCriteria getCriteria();
	Serializable add(T object);
	void modify(T object);
	void remove(T object);
	void remove(Serializable id);
	void removeAll(Collection<T> objects);
	long getTotalCount(DetachedCriteria dc);
	DetachedCriteria getConditionCriteria(CriterionList criterionList);
	List<T> getList(DetachedCriteria dc);
	List<T> getList(DetachedCriteria dc,long start,long limit);
	List<T> getListByIds(Serializable[] ids);
	Object getObjectByHql(String hql,Object parameters);
	List<?> getListByHql(String hql, Object parameters);
	int executeSQL(String sql);
	
}
