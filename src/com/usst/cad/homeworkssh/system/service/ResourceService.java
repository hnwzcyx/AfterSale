/**

 * FileName:     ResourceService.java

 * @Description: TODO(用一句话描述该文件做什么)

* All rights Reserved, Designed By 乔秋飞

 * Copyright:    Copyright(C) 2014-2015

 * Company       上海理工大学.

 * @author:    乔秋飞
 * Email:      1063157465@qq.com
 * @version    V1.0 
 * Createdate:         2014-7-29 下午09:03:12
 *
 * Modification  History:

 * Date         Author        Version        Discription

 * -----------------------------------------------------------------------------------

 * 2014-7-29       wu.zh          1.0             1.0

 * Why & What is modified: <修改原因描述>

 */
package com.usst.cad.homeworkssh.system.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import org.apache.commons.beanutils.BeanUtils;
import com.usst.cad.homeworkssh.basic.model.CriterionList;
import com.usst.cad.homeworkssh.basic.model.easyuimodel.TreeNode;
import com.usst.cad.homeworkssh.basic.service.ABaseService;
import com.usst.cad.homeworkssh.system.bean.ResourceBean;
import com.usst.cad.homeworkssh.system.dao.IResourceDao;
import com.usst.cad.homeworkssh.system.model.pagemodel.ResourcePage;


/**
 * 类名称：         ResourceService.java
 * 类描述：         TODO(用一句话描述该文件做什么)
 * 创建人：         
 * 创建时间 ：   2014-7-29 下午09:03:12
 * 修改人：         乔秋飞
 * Email:     1063157465@qq.com
 * 修改时间 ：   2014-7-29 下午09:03:12
 * 修改备注 ：  
 * 版本：               v1.0
 */
@Service("ResourceService")
public class ResourceService extends ABaseService<ResourceBean> implements IResourceService{
	private IResourceDao resourceDao;

	public IResourceDao getResourceDao() {
		return resourceDao;
	}

	@Resource(name="ResourceDao")
	public void setResourceDao(IResourceDao resourceDao) {
		this.baseDao = resourceDao;
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.system.service.IResourceService#getTree(java.lang.Long[])
		 */
		 

	@Override
	public List<TreeNode> getTree(Long[] ids,long nodeId) {
		List<ResourceBean> list = new ArrayList<ResourceBean>();
		List<TreeNode> listTreeNodes = new ArrayList<TreeNode>();
		CriterionList criterionList = CriterionList.CreateCriterion();
		criterionList.add(Restrictions.in("id", ids));
		if(nodeId==0||String.valueOf(nodeId).equals("")||String.valueOf(nodeId).equals("0")){
			criterionList.add(Restrictions.isNull("resourceBean"));
		}else{
			criterionList.add(Restrictions.eq("id", nodeId));

		}
		list = this.getList(criterionList);
		for(ResourceBean resourceBean :list){
			TreeNode treeNode = new TreeNode();
			Map<String, Object> map = new HashMap<String, Object>();
			try {
				BeanUtils.copyProperties(treeNode, resourceBean);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			treeNode.setText(resourceBean.getName());
			map.put("url", resourceBean.getUrl());
			treeNode.setAttributes(map);
			/*if(resourceBean.getResourceBean()!=null){
				treeNode.setPid(String.valueOf(resourceBean.getResourceBean().getId()));
			}*/
			listTreeNodes.add(treeNode);
		}
		return listTreeNodes;
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.system.service.IResourceService#list(com.usst.cad.resmanagement.system.model.pagemodel.ResourcePage)
		 */
		 
	@Override
	public String list(ResourcePage resource) {
		List<ResourceBean> list = new ArrayList<ResourceBean>();
		List<ResourcePage> listResourcePages = new ArrayList<ResourcePage>();
		CriterionList criterionList = CriterionList.CreateCriterion()
										.put(Restrictions.eq("type", 1))
										.put(Order.asc("type"))
										.put(Order.asc("priority"));
									
		list = this.getList(criterionList);
		for(ResourceBean resourceBean : list){
			ResourcePage resourcePage = new ResourcePage();
			try {
				BeanUtils.copyProperties(resourcePage, resourceBean);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			resourcePage.setId(String.valueOf(resourceBean.getId()));
			/*if(resourceBean.getResourceBean()!=null){
				resourcePage.setPid(String.valueOf(resourceBean.getResourceBean().getId()));
			}*/
			listResourcePages.add(resourcePage);
		}
		return JSONArray.fromObject(listResourcePages).toString();
	}	
	@Override
	public String subList(long pid) {
		List<ResourceBean> list = new ArrayList<ResourceBean>();
		List<ResourcePage> listResourcePages = new ArrayList<ResourcePage>();
		CriterionList criterionList = CriterionList.CreateCriterion()
										.put(Restrictions.eq("pid", pid))
										.put(Order.asc("type"))
										.put(Order.asc("priority"));
									
		list = this.getList(criterionList);
		for(ResourceBean resourceBean : list){
			ResourcePage resourcePage = new ResourcePage();
			try {
				BeanUtils.copyProperties(resourcePage, resourceBean);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			resourcePage.setId(String.valueOf(resourceBean.getId()));
			/*if(resourceBean.getResourceBean()!=null){
				resourcePage.setPid(String.valueOf(resourceBean.getResourceBean().getId()));
			}*/
			listResourcePages.add(resourcePage);
		}
		return JSONArray.fromObject(listResourcePages).toString();
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.system.service.IResourceService#list(java.lang.String)
		 */
		 
	@Override
	public String list(String authsIds) {
		
		return null;
	}

}
