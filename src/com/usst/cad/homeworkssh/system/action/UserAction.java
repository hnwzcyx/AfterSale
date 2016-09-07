/**

 * FileName:     UserAction.java

 * @Description: TODO(用一句话描述该文件做什么)

* All rights Reserved, Designed By 乔秋飞

 * Copyright:    Copyright(C) 2014-2015

 * Company       上海理工大学.

 * @author:    乔秋飞
 * Email:      1063157465@qq.com
 * @version    V1.0 
 * Createdate:         2014-7-29 下午07:34:09
 *
 * Modification  History:

 * Date         Author        Version        Discription

 * -----------------------------------------------------------------------------------

 * 2014-7-29       wu.zh          1.0             1.0

 * Why & What is modified: <修改原因描述>

 */
package com.usst.cad.homeworkssh.system.action;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.usst.cad.homeworkssh.basic.action.ABaseAction;
import com.usst.cad.homeworkssh.basic.model.SessionInfo;
import com.usst.cad.homeworkssh.system.bean.UserBean;
import com.usst.cad.homeworkssh.system.model.pagemodel.User;
import com.usst.cad.homeworkssh.system.service.IUserService;

/**
 * 类名称：         UserAction.java
 * 类描述：         TODO(用一句话描述该文件做什么)
 * 创建人：         
 * 创建时间 ：   2014-7-29 下午07:34:09
 * 修改人：         乔秋飞
 * Email:     1063157465@qq.com
 * 修改时间 ：   2014-7-29 下午07:34:09
 * 修改备注 ：  
 * 版本：               v1.0
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class UserAction extends ABaseAction<User> implements ModelDriven<UserBean>{
	@Resource(name="UserService")
	private IUserService userService;
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String ids;
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	private UserBean userBean = new UserBean();
	public String view(){
		
		return "view";
	}

	public String list() throws Exception{
		String jsonResult = "";
		userBean.setLoginAccount("sa");
		userBean.setName("sa");
		HttpSession session = getSession();
		SessionInfo sessionInfo =(SessionInfo)session.getAttribute("sessionInfo");
		if(sessionInfo.isSystemUser()){
			userBean.setSystemUser(true);
		}
		/*if(sessionInfo.getCompanyId()=="0"){
			userBean.setCompanyId(0);
		}else{
			userBean.setCompanyId(Long.valueOf(sessionInfo.getCompanyId()));
		}*/
		jsonResult = userService.list(userBean, page, rows);
		return response(jsonResult);
	}

		 
	@Override
	public UserBean getModel() {
		
		return userBean;
	}
	
	public String add() throws IOException {
		userBean.setCreatDateTimeDate(new Date());
		userBean.setModifyDateTimeDate(new Date());
		try {
			userService.add(userBean);
			return response(true,"保存成功!");
		} catch (Exception e) {
			
			e.printStackTrace();
			return response(false,"保存失败!");
		}
		
	}
	
	public String edit() throws Exception  {
	/*	UserBean newUserBean = new UserBean();
		newUserBean = userService.getObject(Long.valueOf(userBean.getId()));
	    newUserBean.setName(userBean.getName());
	    newUserBean.setLoginAccount(userBean.getLoginAccount());
	    newUserBean.setDescription(userBean.getDescription());*/
	    userBean.setModifyDateTimeDate(new Date());
	    try {
			userService.modify(userBean);
			return response(true,"编辑成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return response(false,"编辑失败!");
		}		
		
	}
	


	public String delete() throws IOException{
		try {
			if(userBean.getRoles()!=null){
				userBean.setRoles(null);
			}
			userService.remove(Long.valueOf(userBean.getId()));
			
			return response(true,"删除成功!");
		} catch (Exception e) {
			return response(false,"删除失败!");

		}
	}
	
	public String getUserRoles() throws Exception{
		
		return response(userService.getUserRoles(Long.valueOf(userBean.getId())));
	}
	
	public String setUserRoles() throws Exception{
		userService.setUserRoles(userBean, ids);
		return response(true,"绑定成功!");
	}
	
	private HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}

}
