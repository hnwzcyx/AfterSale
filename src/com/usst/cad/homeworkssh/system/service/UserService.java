/**

 * FileName:     UserService.java

 * @Description: TODO(用一句话描述该文件做什么)

* All rights Reserved, Designed By 乔秋飞

 * Copyright:    Copyright(C) 2014-2015

 * Company       上海理工大学.

 * @author:    乔秋飞
 * Email:      1063157465@qq.com
 * @version    V1.0 
 * Createdate:         2014-7-29 下午08:56:35
 *
 * Modification  History:

 * Date         Author        Version        Discription

 * -----------------------------------------------------------------------------------

 * 2014-7-29       wu.zh          1.0             1.0

 * Why & What is modified: <修改原因描述>

 */
package com.usst.cad.homeworkssh.system.service;





import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.usst.cad.homeworkssh.basic.model.CriterionList;
import com.usst.cad.homeworkssh.basic.model.SessionInfo;
import com.usst.cad.homeworkssh.basic.model.easyuimodel.TreeNode;
import com.usst.cad.homeworkssh.basic.model.json.DateJsonValueProcessor;
import com.usst.cad.homeworkssh.basic.service.ABaseService;
import com.usst.cad.homeworkssh.basic.util.DataUtil;
import com.usst.cad.homeworkssh.basic.util.DateUtil;
import com.usst.cad.homeworkssh.system.bean.ResourceBean;
import com.usst.cad.homeworkssh.system.bean.RoleBean;
import com.usst.cad.homeworkssh.system.bean.UserBean;
import com.usst.cad.homeworkssh.system.dao.IUserDao;
import com.usst.cad.homeworkssh.system.model.pagemodel.User;


/**
 * 类名称：         UserService.java
 * 类描述：         TODO(用一句话描述该文件做什么)
 * 创建人：         
 * 创建时间 ：   2014-7-29 下午08:56:35
 * 修改人：         乔秋飞
 * Email:     1063157465@qq.com
 * 修改时间 ：   2014-7-29 下午08:56:35
 * 修改备注 ：  
 * 版本：               v1.0
 */
@Service("UserService")
public class UserService extends ABaseService<UserBean> implements IUserService{
	
	private IUserDao userDao;
	public IUserDao getUserDao() {
		return userDao;
	}
	
	@Resource(name="UserDao")
	public void setUserDao(IUserDao userDao) {
		this.baseDao = userDao;
	}
	
	
	
	private IRoleService roleService;

	public IRoleService getRoleService() {
		return roleService;
	}

	@Resource(name="RoleService")
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	@Override
	public SessionInfo login(User user) throws Exception  {
		CriterionList criterionList = CriterionList.CreateCriterion().put(Restrictions.eq("loginAccount", user.getLoginAccount()))
			.put(Restrictions.eq("password", user.getPassword()));

		UserBean userBeans = this.getObject(criterionList);
		if(userBeans!=null){
			
			return setSessionInfo(userBeans);
		}
		return null;
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.system.service.IUserService#tree(java.io.Serializable)
		 */
		 
	@Override
	public List<TreeNode> tree(Serializable id) throws Exception {	

		
		CriterionList criterionList = CriterionList.CreateCriterion().put(Restrictions.eq("id",Long.parseLong(String.valueOf(id))));
		
		UserBean userBean = this.getObject(criterionList);
		List<TreeNode> firstLeverList = new ArrayList<TreeNode>();
		Map<Serializable, ResourceBean> firstLevelMap = new HashMap<Serializable, ResourceBean>();
		Map<Serializable, ResourceBean> secondLevelMap = new HashMap<Serializable, ResourceBean>();
		Map<Serializable, ResourceBean> thirdLevelMap = new HashMap<Serializable, ResourceBean>();
		Map<Serializable, ResourceBean> otherLevelMap = new HashMap<Serializable, ResourceBean>();
		if(userBean != null){
			Set<RoleBean> roleBeans = userBean.getRoles();
			for(RoleBean roleBean : roleBeans){
				Set<ResourceBean> resourceBeans = roleBean.getResources();
				for(ResourceBean resourceBean : resourceBeans ){

					if(resourceBean.getType()==1){
						firstLevelMap.put(resourceBean.getId(), resourceBean);
					}else if (resourceBean.getType()==2) {
						secondLevelMap.put(resourceBean.getId(), resourceBean);
					}else if(resourceBean.getType()==3){
						thirdLevelMap.put(resourceBean.getId(), resourceBean);
					}else{
						otherLevelMap.put(resourceBean.getId(), resourceBean);
					}
				}
			}			
			for(Serializable firstResourceId:firstLevelMap.keySet()){
				
				TreeNode parentNode = new TreeNode();
				parentNode.setId(String.valueOf(firstResourceId));
				parentNode.setText(firstLevelMap.get(firstResourceId).getName());
				parentNode.setIconCls(firstLevelMap.get(firstResourceId).getIconCls());
				List<TreeNode> secondLevelList = new ArrayList<TreeNode>();
				for(Serializable secondResourceId : secondLevelMap.keySet()){					
					long pid = DataUtil.getIndexStringId(secondLevelMap.get(secondResourceId).getRelation(), 1);				
					if(Long.valueOf(parentNode.getId())==pid){
						TreeNode childNode = new TreeNode();
						Map<String, Object> childAttributesMap = new HashMap<String, Object>();
						childNode.setId(String.valueOf(secondResourceId));
						childNode.setText(secondLevelMap.get(secondResourceId).getName());
						childAttributesMap.put("url", secondLevelMap.get(secondResourceId).getUrl());
						childNode.setIconCls(secondLevelMap.get(secondResourceId).getIconCls());
						childNode.setAttributes(childAttributesMap);
						List<TreeNode> thirdLevelList = new ArrayList<TreeNode>();
						for(Serializable thirdResourceId : thirdLevelMap.keySet()){							
							long cid = DataUtil.getIndexStringId(thirdLevelMap.get(thirdResourceId).getRelation(), 2);
							if(Long.valueOf(childNode.getId())==cid){
								TreeNode childChildNode = new TreeNode();
								Map<String, Object> childChildAttributesMap = new HashMap<String, Object>();
								childChildNode.setId(String.valueOf(thirdResourceId));
								childChildNode.setText(thirdLevelMap.get(thirdResourceId).getName());
								childChildAttributesMap.put("url", thirdLevelMap.get(thirdResourceId).getUrl());
								childChildNode.setIconCls(thirdLevelMap.get(thirdResourceId).getIconCls());
								childChildNode.setAttributes(childChildAttributesMap);
								thirdLevelList.add(childChildNode);								
							}
						}
						childNode.setChildren(thirdLevelList);
						secondLevelList.add(childNode);
					}
					
				}
			parentNode.setChildren(secondLevelList);	
			firstLeverList.add(parentNode);		
			
			}
			return firstLeverList;
		}
		
		return null;
	}

		
		
			 
		@Override
		public String list(UserBean userBean, int page, int rows)
				throws Exception {
			List<UserBean> list = new ArrayList<UserBean>();
			CriterionList criterionList= CriterionList.CreateCriterion().put(Restrictions.like("loginAccount", "",MatchMode.ANYWHERE))
				.put(Restrictions.like("name", "",MatchMode.ANYWHERE));  
			if(userBean.getCompanyId()==0&&!userBean.isSystemUser()){
				criterionList.put(Restrictions.eq("companyId", userBean.getCompanyId()))
				.put(Restrictions.eq("systemUser", userBean.isSystemUser()));
				
			}else if(userBean.getCompanyId()!=0){
				criterionList.put(Restrictions.eq("companyId", userBean.getCompanyId()));
			}
			
			long total = this.getCount(criterionList);
			int start = 0;
			int limit = 0;
			if(page*rows<=total){
				start = (page-1)*rows;
				limit = rows;				
			}else{
				start = (page-1)*rows;
				limit =(int)total - (page-1)*rows;
			}
			list = this.getList(criterionList, start, limit);
            
            /*Map<String, Object> resultMap = new HashMap<String, Object>();
            resultMap.put("total", total);
            resultMap.put("rows", list);  */         
        //    JsonItem jsonItem = new JsonItem();
        //    jsonItem.put("total", total);
        //    jsonItem.put("rows", list);
//            System.out.println(jsonItem.toFormDataString(true));
		//	return JSONObject.fromObject(resultMap).toString();
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(Date.class,new DateJsonValueProcessor(DateUtil.DATETIMEFORMAT));
            jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
            return JSONArray.fromObject(list,jsonConfig ).toString();
		}

		
			 /* (non-Javadoc)
			 * @see com.usst.cad.resmanagement.system.service.IUserService#getUserRoles(java.lang.Long)
			 */
			 
		@Override
		public String getUserRoles(Long id) throws Exception {
			UserBean userBean = new UserBean();
			List<RoleBean> listRoleBeans = new ArrayList<RoleBean>();
			userBean = this.getObject(id);
			if(userBean.getRoles()!=null){
				for(RoleBean roleBean:userBean.getRoles()){
					listRoleBeans.add(roleBean);
				}
			}
			JsonConfig jsonConfig = new JsonConfig();
	        jsonConfig.registerJsonValueProcessor(Date.class,new DateJsonValueProcessor(DateUtil.DATETIMEFORMAT));
	        jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
			return JSONArray.fromObject(listRoleBeans,jsonConfig).toString();
		}

		
			 /* (non-Javadoc)
			 * @see com.usst.cad.resmanagement.system.service.IUserService#setUserRoles(com.usst.cad.resmanagement.system.bean.UserBean)
			 */
			 
		@Override
		public String setUserRoles(UserBean userBean,String ids) throws Exception {
			UserBean newUserBean = new UserBean();
			CriterionList criterionList =CriterionList.CreateCriterion();
			criterionList.put(Restrictions.idEq(Long.valueOf(userBean.getId())));
			newUserBean = this.getObject(criterionList);
			if(ids!=null){
				Long[] idArray = DataUtil.getArrayId(ids);
				CriterionList roleCriterionList= CriterionList.CreateCriterion();
				roleCriterionList.put(Restrictions.in("id", idArray));
				newUserBean.setRoles(new HashSet<RoleBean>(roleService.getList(roleCriterionList)));
			}
			return null;
		}


		private SessionInfo setSessionInfo(UserBean userBean) {
			SessionInfo sessionInfo = new SessionInfo();
			sessionInfo.setUserId(String.valueOf(userBean.getId()));
			sessionInfo.setLoginName(userBean.getLoginAccount());
			sessionInfo.setLoginName(userBean.getPassword());
			
			
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
	
	/*	
		public String getMenu(String Ids) throws SRMException{
			Long[] idsArray = DataUtil.getArrayId(Ids);		
			CriterionList criterionList = CriterionList.CreateCriterion()
					.put(Restrictions.in("id", idsArray))
					.put(Restrictions.eq("hide", 1))
					.put(Order.asc("id"))
					.put(Order.asc("type"))
					.put(Order.asc("priority"));
			List<ResourceBean> resourceBeans = resourceService.getList(criterionList);
			List<TreeNode> treeNodes = convertFromResources(resourceBeans);
			JSONArray treeNodesJsonArray = JSONArray.fromObject(treeNodes);
			
			
			return treeNodesJsonArray.toString();
		}*/
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
			for(ResourceBean resourceBean : resourceBeans){
				TreeNode treeNode = new TreeNode();
				treeNode.setId(String.valueOf(resourceBean.getId()));
				treeNode.setIconCls(resourceBean.getIconCls());
				treeNode.setPid(String.valueOf(resourceBean.getPid()));
				treeNode.setText(resourceBean.getName());
				Map<String, Object> attributes = new HashMap<String, Object>();
				attributes.put("url", resourceBean.getUrl());
				treeNode.setAttributes(attributes);
				treeNodes.add(treeNode);			
			}
			
			return treeNodes;
		}
	

	
	


}
