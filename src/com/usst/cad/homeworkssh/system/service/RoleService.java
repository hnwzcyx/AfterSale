/**

 * FileName:     RoleService.java

 * @Description: TODO(用一句话描述该文件做什么)

* All rights Reserved, Designed By 乔秋飞

 * Copyright:    Copyright(C) 2014-2015

 * Company       上海理工大学.

 * @author:    乔秋飞
 * Email:      1063157465@qq.com
 * @version    V1.0 
 * Createdate:         2014-7-29 下午09:01:40
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
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import org.apache.commons.beanutils.BeanUtils;
import com.usst.cad.homeworkssh.basic.model.CriterionList;
import com.usst.cad.homeworkssh.basic.model.easyuimodel.TreeNode;
import com.usst.cad.homeworkssh.basic.model.json.DateJsonValueProcessor;
import com.usst.cad.homeworkssh.basic.service.ABaseService;
import com.usst.cad.homeworkssh.basic.util.DataUtil;
import com.usst.cad.homeworkssh.basic.util.DateUtil;
import com.usst.cad.homeworkssh.system.bean.ResourceBean;
import com.usst.cad.homeworkssh.system.bean.RoleBean;
import com.usst.cad.homeworkssh.system.dao.IRoleDao;
import com.usst.cad.homeworkssh.system.model.pagemodel.RolePage;

/**
 * 类名称：         RoleService.java
 * 类描述：         TODO(用一句话描述该文件做什么)
 * 创建人：         
 * 创建时间 ：   2014-7-29 下午09:01:40
 * 修改人：         乔秋飞
 * Email:     1063157465@qq.com
 * 修改时间 ：   2014-7-29 下午09:01:40
 * 修改备注 ：  
 * 版本：               v1.0
 */
@Service("RoleService")
public class RoleService extends ABaseService<RoleBean> implements IRoleService{
	
	private IRoleDao roleDao;

	public IRoleDao getRoleDao() {
		return roleDao;
	}
    
	@Resource(name="RoleDao")
	public void setRoleDao(IRoleDao roleDao) {
		this.baseDao = roleDao;
	}

	private IResourceService resourceService;

		 

	public IResourceService getResourceService() {
		return resourceService;
	}
    @Resource(name="ResourceService")
	public void setResourceService(IResourceService resourceService) {
		this.resourceService = resourceService;
	}

	@Override
	public String list(RolePage rolePage) {
		List<RoleBean> list = new ArrayList<RoleBean>();
		CriterionList criterionList = CriterionList.CreateCriterion();
		if(rolePage.getName()!=null){
			criterionList.put(Restrictions.like("name", rolePage.getName(), MatchMode.ANYWHERE));
		}		
		long total = this.getCount(criterionList);
		System.out.println(rolePage==null);
		if(rolePage.getOrder()!=null&&rolePage.getOrder().trim().equals("desc")){
			criterionList.put(Order.desc(rolePage.getSort()));
		} else if(rolePage.getOrder()!=null&&rolePage.getOrder().trim().equals("asc")){
			criterionList.put(Order.asc(rolePage.getSort()));
		}else {
			criterionList.put(Order.asc("id"));
		}
		
		list = this.getList(criterionList, (rolePage.getPage()-1)*rolePage.getRows(), rolePage.getRows());
		Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("total", total);
        resultMap.put("rows", list);           
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new DateJsonValueProcessor(DateUtil.DATETIMEFORMAT));
        jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
        return JSONObject.fromObject(resultMap,jsonConfig ).toString();
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.system.service.IRoleService#getRoleAuths(java.lang.String)
		 */
		 
	@Override
	public String getRoleAuths(String id) throws Exception {
		RoleBean roleBean = new RoleBean();
		List<TreeNode> listTreeNodes = new ArrayList<TreeNode>();
		CriterionList criterionList = CriterionList.CreateCriterion();
		criterionList.put(Restrictions.idEq(Long.valueOf(id)));
		roleBean = this.getObject(criterionList);
		if(roleBean.getResources()!=null){
			for(ResourceBean resourceBean:roleBean.getResources()){
				/*if(resourceBean.getResourceBean()==null){
					TreeNode treeNode = new TreeNode();
					treeNode = loopResources(resourceBean);
					listTreeNodes.add(treeNode);
				}*/
				TreeNode treeNode = new TreeNode();;
				BeanUtils.copyProperties(treeNode, resourceBean);
				treeNode.setText(resourceBean.getName());
				/*if(resourceBean.getResourceBean()!=null){
					treeNode.setPid(String.valueOf(resourceBean.getResourceBean().getId()));
				}*/
				listTreeNodes.add(treeNode);
			}
		}
		 JsonConfig jsonConfig = new JsonConfig();
         jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		System.out.println(JSONArray.fromObject(listTreeNodes,jsonConfig).toString());
		return JSONArray.fromObject(listTreeNodes).toString();
	}
	
	private TreeNode loopResources(ResourceBean resourceBean) throws IllegalAccessException, InvocationTargetException{		
			TreeNode treeNode = new TreeNode();
			BeanUtils.copyProperties(treeNode, resourceBean);
			treeNode.setText(resourceBean.getName());
			List<TreeNode> list = new ArrayList<TreeNode>();
			/*for(ResourceBean rBean : resourceBean.getResourceBeans()){
					list.add(loopResources(rBean));
					treeNode.setChildren(list);
					continue ;
			}*/
			return treeNode;
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.system.service.IRoleService#setRoleAuths(com.usst.cad.resmanagement.system.model.pagemodel.RolePage)
		 */
		 
	@Override
	public String setRoleAuths(RolePage rolePage) throws Exception  {
		RoleBean roleBean = new RoleBean();
		CriterionList criterionList = CriterionList.CreateCriterion();
		criterionList.put(Restrictions.idEq(Long.valueOf(rolePage.getId())));
		roleBean = this.getObject(criterionList);
		if(rolePage.getIds()!=null&&!rolePage.getIds().equalsIgnoreCase("")){
			Long[] ids = DataUtil.getArrayId(rolePage.getIds());
			CriterionList resourcecCriterionList = CriterionList.CreateCriterion();
			resourcecCriterionList.put(Restrictions.in("id", ids));
			roleBean.setResources(new HashSet<ResourceBean>(resourceService.getList(resourcecCriterionList)));
		}
		
		return null;
	}
	
	
}
