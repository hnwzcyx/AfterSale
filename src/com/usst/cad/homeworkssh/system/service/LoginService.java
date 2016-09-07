/**

 * FileName:     LoginService.java

 * @Description: TODO(用一句话描述该文件做什么)

* All rights Reserved, Designed By 乔秋飞

 * Copyright:    Copyright(C) 2014-2015

 * Company       上海理工大学.

 * @author:    乔秋飞
 * Email:      1063157465@qq.com
 * @version    V1.0 
 * Createdate:         2015-1-30 下午07:32:34
 *
 * Modification  History:

 * Date         Author        Version        Discription

 * -----------------------------------------------------------------------------------

 * 2015-1-30       wu.zh          1.0             1.0

 * Why & What is modified: <修改原因描述>

 */
package com.usst.cad.homeworkssh.system.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.usst.cad.homeworkssh.basic.model.CriterionList;
import com.usst.cad.homeworkssh.basic.model.SRMException;
import com.usst.cad.homeworkssh.basic.model.SessionInfo;
import com.usst.cad.homeworkssh.basic.model.easyuimodel.TreeNode;
import com.usst.cad.homeworkssh.basic.util.DataUtil;
import com.usst.cad.homeworkssh.system.bean.ResourceBean;
import com.usst.cad.homeworkssh.system.bean.RoleBean;
import com.usst.cad.homeworkssh.system.bean.UserBean;

/**
 * 类名称：         LoginService.java
 * 类描述：         TODO(用一句话描述该文件做什么)
 * 创建人：         
 * 创建时间 ：   2015-1-30 下午07:32:34
 * 修改人：         乔秋飞
 * Email:     1063157465@qq.com
 * 修改时间 ：   2015-1-30 下午07:32:34
 * 修改备注 ：  
 * 版本：               v1.0
 */
@Service("LoginService")
public class LoginService {
	@Resource(name="UserService")
	private IUserService userService;
	
	@Resource(name="ResourceService")
    private IResourceService resourceService;
	
	
	
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	/**
	 * @Title:        login
	 * @Description:  TODO(这里用一句话描述这个方法的作用)
	 * @param:        @param loginAccount
	 * @param:        @param password   
	 * @return:       void   
	 * @author:       乔秋飞 
	 * Email:         1063157465@qq.com
	 * @throws Exception 
	 * @throws
	 * @Date          2015-1-30 下午07:44:22
	 */
	public SessionInfo login(String loginAccount, String password) throws Exception {
		
		CriterionList criterionList = CriterionList.CreateCriterion().put(Restrictions.eq("loginAccount", loginAccount))
						.put(Restrictions.eq("password", password));
		UserBean userBean = userService.getObject(criterionList);
		if(userBean!=null){
			return setSessionInfo(userBean);
		}
		return null;
	}
	/**
	 * @Title:        setSessionInfo
	 * @Description:  TODO(这里用一句话描述这个方法的作用)
	 * @param:        @param userBean
	 * @param:        @return   
	 * @return:       SessionInfo   
	 * @author:       乔秋飞 
	 * Email:         1063157465@qq.com
	 * @throws
	 * @Date          2015-1-30 下午07:58:13
	 */
	private SessionInfo setSessionInfo(UserBean userBean) {
		SessionInfo sessionInfo = new SessionInfo();
		sessionInfo.setUserId(String.valueOf(userBean.getId()));
		sessionInfo.setLoginName(userBean.getLoginAccount());
		sessionInfo.setLoginPassword(userBean.getPassword());
		if(userBean.getCompanyId()!=0){
			sessionInfo.setCompanyId(String.valueOf(userBean.getCompanyId()));
		}
		if(userBean.isSystemUser()){
			sessionInfo.setSystemUser(true);
		}
		parseUserInfo(userBean,sessionInfo);
		return sessionInfo;
	}
	/**
	 * @Title:        parseUserInfo
	 * @Description:  TODO(这里用一句话描述这个方法的作用)
	 * @param:        @param userBean
	 * @param:        @param sessionInfo   
	 * @return:       void   
	 * @author:       乔秋飞 
	 * Email:         1063157465@qq.com
	 * @throws
	 * @Date          2015-1-30 下午08:53:23
	 */
	private void parseUserInfo(UserBean userBean, SessionInfo sessionInfo) {
		StringBuffer sbRoleIds = new StringBuffer();
		StringBuffer sbRoleNames = new StringBuffer();
		StringBuffer sbResourceIds = new StringBuffer();
		StringBuffer sbResourceNames = new StringBuffer();
		StringBuffer sbUrls = new StringBuffer();
		int resourceIndex=0;
		int roleIndex=0;
		for(RoleBean roleBean : userBean.getRoles()){
			roleIndex++;
			sbRoleIds.append(roleBean.getId());
			sbRoleNames.append(roleBean.getName());
			if(roleIndex<userBean.getRoles().size()){
				sbRoleIds.append(",");
				sbRoleNames.append(",");
			}
			
			for(ResourceBean resourceBean : roleBean.getResources()){
				resourceIndex++;
				sbResourceIds.append(resourceBean.getId()+",");
				sbResourceNames.append(resourceBean.getName()+",");
				sbUrls.append(resourceBean.getUrl()+",");
			}
		}
		sbResourceIds.substring(0, sbResourceIds.lastIndexOf(","));
		sbResourceNames.substring(0, sbResourceNames.lastIndexOf(","));
		sbUrls.substring(0, sbUrls.lastIndexOf(","));
		sessionInfo.setRoleIds(sbRoleIds.toString());
		sessionInfo.setRoleNames(sbRoleNames.toString());
		sessionInfo.setAuthIds(sbResourceIds.toString());
		sessionInfo.setAuthNames(sbResourceNames.toString());
		sessionInfo.setAuthUrls(sbUrls.toString());
		
	}
	public void setResourceService(IResourceService resourceService) {
		this.resourceService = resourceService;
	}
	public IResourceService getResourceService() {
		return resourceService;
	}
	
	/*public String getMenu(String Ids) throws SRMException{
		Long[] idsArray = DataUtil.getArrayId(Ids);		
		CriterionList criterionList = CriterionList.CreateCriterion()
				.put(Restrictions.in("id", idsArray))
				.put(Restrictions.eq("hide", false))
				.put(Restrictions.le("type", 3))
				.put(Order.asc("priority"))
				.put(Order.asc("type"));
		List<ResourceBean> resourceBeans = resourceService.getList(criterionList);
		List<TreeNode> treeNodes = convertFromResources(resourceBeans);
		JSONArray treeNodesJsonArray = JSONArray.fromObject(treeNodes);
		
		
		return treeNodesJsonArray.toString();
	}*/
	//重写，返回一个list
	public List<TreeNode> getMenu(String Ids) throws SRMException{
		Long[] idsArray = DataUtil.getArrayId(Ids);		
		CriterionList criterionList = CriterionList.CreateCriterion()
				.put(Restrictions.in("id", idsArray))
				.put(Restrictions.eq("hide", false))
				.put(Restrictions.le("type", 3))
				.put(Restrictions.eq("type", 1))
				.put(Order.asc("priority"))
				.put(Order.asc("type"));
		List<ResourceBean> resourceBeans = resourceService.getList(criterionList);
		List<TreeNode> treeNodes = convertFromResources(resourceBeans);
		/*JSONArray treeNodesJsonArray = JSONArray.fromObject(treeNodes);*/
		
		
		return treeNodes;
	}
	/**
	 * @Title:        convertFromResources
	 * @Description:  TODO(这里用一句话描述这个方法的作用)
	 * @param:        @param resourceBeans
	 * @param:        @return   
	 * @return:       List<TreeNode>   
	 * @author:       乔秋飞 
	 * Email:         1063157465@qq.com
	 * @throws
	 * @Date          2015-1-30 下午10:04:14
	 */
	private List<TreeNode> convertFromResources(List<ResourceBean> resourceBeans) {
		List<TreeNode> treeNodes = new ArrayList<TreeNode>();
		List<TreeNode> treeNodesChildrens = new ArrayList<TreeNode>();
		for(ResourceBean resourceBean : resourceBeans){
			TreeNode treeNode = new TreeNode();
			treeNode.setId(String.valueOf(resourceBean.getId()));
			treeNode.setIconCls(resourceBean.getIconCls());
			treeNode.setPid(String.valueOf(resourceBean.getPid()));
			treeNode.setText(resourceBean.getName());
			Map<String, Object> attributes = new HashMap<String, Object>();
			attributes.put("url", resourceBean.getUrl());
			treeNode.setAttributes(attributes);
			CriterionList criterionList = CriterionList.CreateCriterion()
					.put(Restrictions.eq("pid", resourceBean.getId()))
					.put(Restrictions.eq("type", 2));
			List<ResourceBean> resourceChildren = resourceService.getList(criterionList);
			if (!resourceChildren.isEmpty()) {
				for(ResourceBean childrensResourceBean:resourceChildren){
					TreeNode treeNodeChildren = new TreeNode();
					treeNodeChildren.setId(String.valueOf(childrensResourceBean.getId()));
					treeNodeChildren.setIconCls(childrensResourceBean.getIconCls());
					treeNodeChildren.setPid(String.valueOf(childrensResourceBean.getPid()));
					treeNodeChildren.setText(childrensResourceBean.getName());
					Map<String, Object> attributesChileren = new HashMap<String, Object>();
					attributesChileren.put("url", childrensResourceBean.getUrl());
					treeNodeChildren.setAttributes(attributesChileren);
					treeNodesChildrens.add(treeNodeChildren);
				}
				treeNode.setChildren(treeNodesChildrens);
			}
			treeNodes.add(treeNode);
		}
		
		return treeNodes;
	}


}
