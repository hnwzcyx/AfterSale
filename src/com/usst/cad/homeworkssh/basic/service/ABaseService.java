/**

 * FileName:     ABaseService.java

 * @Description: TODO(用一句话描述该文件做什么)

* All rights Reserved, Designed By 乔秋飞

 * Copyright:    Copyright(C) 2014-2015

 * Company       上海理工大学.

 * @author:    乔秋飞
 * Email:      1063157465@qq.com
 * @version    V1.0 
 * Createdate:         2014-7-26 下午04:52:48
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

import com.usst.cad.homeworkssh.basic.dao.IBaseDao;
import com.usst.cad.homeworkssh.basic.model.ConditionList;
import com.usst.cad.homeworkssh.basic.model.CriterionList;

/**
 * 类名称：         ABaseService.java
 * 类描述：         TODO(用一句话描述该文件做什么)
 * 创建人：         
 * 创建时间 ：   2014-7-26 下午04:52:48
 * 修改人：         乔秋飞
 * Email:     1063157465@qq.com
 * 修改时间 ：   2014-7-26 下午04:52:48
 * 修改备注 ：  
 * 版本：               v1.0
 */
public abstract class ABaseService<T> implements IBaseService<T> {
	
	
	public IBaseDao<T> baseDao;
	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.service.IBaseService#add(java.lang.Object)
		 */


	@Override
	public Serializable add(T object) throws Exception {

		return baseDao.add(object);
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.service.IBaseService#executeSQL(java.lang.String)
		 */
		 
	@Override
	public int executeSQL(String sql) {
		return baseDao.executeSQL(sql);
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.service.IBaseService#getCount()
		 */
		 
	@Override
	public long getCount() {
		return baseDao.getTotalCount(baseDao.getCriteria());
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.service.IBaseService#getCount(com.usst.cad.resmanagement.basic.model.CriterionList)
		 */
		 
	@Override
	public long getCount(CriterionList conditions) {
		// TODO Auto-generated method stub
		return baseDao.getTotalCount(baseDao.getConditionCriteria(conditions));
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.service.IBaseService#getCount(com.usst.cad.resmanagement.basic.model.ConditionList)
		 */
		 
	@Override
	public long getCount(ConditionList conditions) {
		// TODO Auto-generated method stub
		return 0;
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.service.IBaseService#getCount(org.hibernate.criterion.DetachedCriteria)
		 */
		 
	@Override
	public long getCount(DetachedCriteria dc) {
		
		return baseDao.getTotalCount(dc);
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.service.IBaseService#getIds(java.util.List)
		 */
		 

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.service.IBaseService#getList(com.usst.cad.resmanagement.basic.model.CriterionList, long, long)
		 */
		 
	@Override
	public List<T> getList(CriterionList conditions, long start, long limit) {
    
		return baseDao.getList(baseDao.getConditionCriteria(conditions), start, limit);
	
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.service.IBaseService#getList(com.usst.cad.resmanagement.basic.model.ConditionList, long, long)
		 */
		 
	@Override
	public List<T> getList(ConditionList conditions, long start, long limit) {

		return null;
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.service.IBaseService#getList(long, long)
		 */
		 
	@Override
	public List<T> getList(long start, long limit) {

		return null;
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.service.IBaseService#getList()
		 */
		 
	@Override
	public List<T> getList() {

		return baseDao.getList(baseDao.getCriteria());
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.service.IBaseService#getList(com.usst.cad.resmanagement.basic.model.CriterionList)
		 */
		 
	@Override
	public List<T> getList(CriterionList conditions) {

		return baseDao.getList(baseDao.getConditionCriteria(conditions));
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.service.IBaseService#getList(com.usst.cad.resmanagement.basic.model.ConditionList)
		 */
		 
	@Override
	public List<T> getList(ConditionList conditions) {

		return null;
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.service.IBaseService#getList(org.hibernate.criterion.DetachedCriteria, long, long)
		 */
		 
	@Override
	public List<T> getList(DetachedCriteria dc, long start, long limit) {
		// TODO Auto-generated method stub
		return null;
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.service.IBaseService#getList(org.hibernate.criterion.DetachedCriteria)
		 */
		 
	@Override
	public List<T> getList(DetachedCriteria dc) {
	
		return baseDao.getList(dc);
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.service.IBaseService#getListByHql(java.lang.String, java.lang.Object)
		 */
		 
	@Override
	public List<?> getListByHql(String hql, Object parameters) {
		
		return baseDao.getListByHql(hql, parameters);
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.service.IBaseService#getObject(java.io.Serializable)
		 */
		 
	@Override
	public T getObject(Serializable id) throws Exception {

		return baseDao.getObject(id);
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.service.IBaseService#getObject(com.usst.cad.resmanagement.basic.model.CriterionList)
		 */
		 
	@Override
	public T getObject(CriterionList conditions) throws Exception {
		// TODO Auto-generated method stub
		return baseDao.getObject(baseDao.getConditionCriteria(conditions));
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.service.IBaseService#getObjectByHql(java.lang.String, java.lang.Object)
		 */
		 
	@Override
	public Object getObjectByHql(String hql, Object parameters) {
	
		return baseDao.getObjectByHql(hql, parameters);
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.service.IBaseService#getValue(org.hibernate.criterion.DetachedCriteria)
		 */
		 
	@Override
	public void getValue(DetachedCriteria dc) {
		
		
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.service.IBaseService#list2Map(java.util.List)
		 */
		 
	@Override
	public Map<Long, T> list2Map(List<T> list) {
		
		return null;
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.service.IBaseService#modify(java.lang.Object)
		 */
		 
	@Override
	public void modify(T object) throws Exception {
		baseDao.modify(object);
		
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.service.IBaseService#remove(java.io.Serializable)
		 */
		 
	@Override
	public void remove(Serializable id) throws Exception {
		baseDao.remove(id);
		
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.service.IBaseService#remove(java.lang.Object)
		 */
		 
	@Override
	public void remove(T object) throws Exception {
		baseDao.remove(object);
		
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.service.IBaseService#removeAll(java.util.Collection)
		 */
		 
	@Override
	public void removeAll(Collection<T> objects) throws Exception {
		baseDao.removeAll(objects);
		
	}

}
