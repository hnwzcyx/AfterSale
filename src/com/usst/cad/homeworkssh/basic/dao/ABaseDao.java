/**

 * FileName:     AbaseDao.java

 * @Description: TODO(用一句话描述该文件做什么)

* All rights Reserved, Designed By 乔秋飞

 * Copyright:    Copyright(C) 2014-2015

 * Company       上海理工大学.

 * @author:    乔秋飞
 * Email:      1063157465@qq.com
 * @version    V1.0 
 * Createdate:         2014-7-26 下午03:55:31
 *
 * Modification  History:

 * Date         Author        Version        Discription

 * -----------------------------------------------------------------------------------

 * 2014-7-26       wu.zh          1.0             1.0

 * Why & What is modified: <修改原因描述>

 */
package com.usst.cad.homeworkssh.basic.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;


import com.usst.cad.homeworkssh.basic.model.Condition;
import com.usst.cad.homeworkssh.basic.model.ConditionList;

import com.usst.cad.homeworkssh.basic.model.CriterionList;
import com.usst.cad.homeworkssh.basic.model.constants.AppConstants;



/**
 * 类名称：         AbaseDao.java
 * 类描述：         TODO(用一句话描述该文件做什么)
 * 创建人：         
 * 创建时间 ：   2014-7-26 下午03:55:31
 * 修改人：         乔秋飞
 * Email:     1063157465@qq.com
 * 修改时间 ：   2014-7-26 下午03:55:31
 * 修改备注 ：  
 * 版本：               v1.0
 */
public abstract class ABaseDao<T> implements IBaseDao<T> {
	protected HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.dao.IBaseDao#add(java.lang.Object)
		 */
		 
	@Override
	public Serializable add(T object) {
	
		return hibernateTemplate.save(object);
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.dao.IBaseDao#executeSQL(java.lang.String)
		 */
		 
	@Override
	public int executeSQL(final String sql) {
		// TODO Auto-generated method stub
		return hibernateTemplate.execute(new HibernateCallback<Integer>(){
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(sql);
				return query.executeUpdate();
			}
		});
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.dao.IBaseDao#getConditionCriteria(com.usst.cad.resmanagement.basic.model.CriterionList)
		 */
		 
	@Override
	public DetachedCriteria getConditionCriteria(CriterionList criterionList) {
		DetachedCriteria dc = this.getCriteria();
		if(criterionList==null){
			return dc;
		}
		for(Object obj: criterionList){
			if(obj instanceof Criterion){
				dc.add((Criterion)obj);
			}else if (obj instanceof Order) {
				dc.addOrder((Order)obj);
			}
		}
		return dc;
	}

	public DetachedCriteria getConditionCriteria(ConditionList conditionList){
		DetachedCriteria dc = this.getCriteria();
		if(conditionList==null){
			return dc;
		}
		for(Condition condition : conditionList){
			if(condition.isCascade()){
				dc = addCascadeCondition(dc, condition);
			}else{
				getCriteria(dc, condition.getProperty(), condition);
			}
		}
		return dc;
	}
	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.dao.IBaseDao#getCriteria()
		 */
		 
	public DetachedCriteria getCriteria(DetachedCriteria dc,String properties,Condition condition) {
		switch(condition.getConditonType()){
		case BETWEENT:
			dc.add(Restrictions.between(properties, condition.getFirstValue(), condition.getSecondValue()));
			break;
		case EQ:
			dc.add(Restrictions.eq(properties, condition.getFirstValue()));
			break;
		case GE:
			dc.add(Restrictions.ge(properties, condition.getFirstValue()));
			break;
		case GT:
			dc.add(Restrictions.gt(properties, condition.getFirstValue()));
			break;
		case LE:
			dc.add(Restrictions.le(properties, condition.getFirstValue()));
			break;
		case LIEK:
			dc.add(Restrictions.like(properties, condition.getFirstValue()));
			break;
		case LT:
			dc.add(Restrictions.lt(properties, condition.getFirstValue()));
			break;
		case DESCORDER:
			dc.addOrder(Order.desc(properties));
			break;
		case ACSORDER:
			dc.addOrder(Order.asc(properties));
			break;
		case NOT:
			dc.add(Restrictions.ne(properties, condition.getFirstValue()));
			break;
		case OR:
			break;
		default:
			dc.add(Restrictions.eq(properties, condition.getFirstValue()));
		}

		return dc;
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.dao.IBaseDao#getList(org.hibernate.criterion.DetachedCriteria)
		 */
		 
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getList(DetachedCriteria dc) {
		
		return hibernateTemplate.findByCriteria(dc);
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.dao.IBaseDao#getList(org.hibernate.criterion.DetachedCriteria, long, long)
		 */
		 
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getList(DetachedCriteria dc, long start, long limit) {
		
		return hibernateTemplate.findByCriteria(dc, (int)start,(int)limit);
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.dao.IBaseDao#getListByHql(java.lang.String, java.lang.Object)
		 */
		 
	@Override
	public List<?> getListByHql(String hql, Object parameters) {
		if(parameters!=null){
			return	hibernateTemplate.find(hql,parameters);
			
		}else{
			return hibernateTemplate.find(hql);
		}

	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.dao.IBaseDao#getObject(java.io.Serializable)
		 */
		 
	@Override
	public T getObject(Serializable id) {
		DetachedCriteria dc = this.getCriteria();
		dc.add(Restrictions.eq("id", id));
		return 	this.getObject(dc);
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.dao.IBaseDao#getObject(org.hibernate.criterion.DetachedCriteria)
		 */
		 
	@SuppressWarnings("unchecked")
	@Override
	public T getObject(DetachedCriteria dc) {
		if(null!=dc){
			List<T> list = hibernateTemplate.findByCriteria(dc);
			if(list.size()>0){
			 return	list.get(0);
			}
		}
		return null;
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.dao.IBaseDao#getObjectByHql(java.lang.String, java.lang.Object)
		 */
		 
	@Override
	public Object getObjectByHql(String hql, Object parameters) {
		if(null!= parameters){
			return hibernateTemplate.find(hql,parameters).get(0);
		}else{
			return hibernateTemplate.find(hql).get(0);
		}
		
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.dao.IBaseDao#getTotalCount(org.hibernate.criterion.DetachedCriteria)
		 */
		 
	@SuppressWarnings("unchecked")
	@Override
	public long getTotalCount(final DetachedCriteria dc) {
		return (Long) hibernateTemplate.execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = dc.getExecutableCriteria(session);
				long totalCount = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
				criteria.setProjection(null);
				criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
				return totalCount;
			}
		});
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.dao.IBaseDao#modify(java.lang.Object)
		 */
		 
	@Override
	public void modify(T object) {
		hibernateTemplate.update(object);
		
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.dao.IBaseDao#remove(java.lang.Object)
		 */
		 
	@Override
	public void remove(T object) {
		hibernateTemplate.delete(object);
		
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.dao.IBaseDao#remove(java.io.Serializable)
		 */
		 
	@Override
	public void remove(Serializable id) {
		hibernateTemplate.delete(this.getObject(id));
		
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.dao.IBaseDao#remove(java.util.Collection)
		 */
		 
	@Override
	public void removeAll(Collection<T> objects) {
		
		hibernateTemplate.deleteAll(objects);
		
	}
	
	public DetachedCriteria addCascadeCondition(DetachedCriteria dc, Condition condition) {
		String[] classes = condition.getProperty().split("\\.");
		StringBuilder prefix = new StringBuilder();
		for (int i = 0; i < classes.length - 1; i++) {
			if (i == 0) {
				dc.createAlias(classes[0], AppConstants.CASCADE_REPLACE + i);
			} else {
				prefix.replace(0, prefix.length(), AppConstants.CASCADE_REPLACE + (i - 1) + "." + classes[i]);
				dc.createAlias(prefix.toString(), AppConstants.CASCADE_REPLACE);
			}
		}
		dc = getCriteria(dc, AppConstants.CASCADE_REPLACE + (classes.length - 2) + "." + classes[classes.length - 1], condition);
		return dc;
	}
	@Override
	public List<T> getListByIds(Serializable[] ids){
		return null;
	}
}
