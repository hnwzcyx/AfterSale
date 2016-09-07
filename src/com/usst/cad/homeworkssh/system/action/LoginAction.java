/**

 * FileName:     LoginAction.java

 * @Description: TODO(用一句话描述该文件做什么)

* All rights Reserved, Designed By 乔秋飞

 * Copyright:    Copyright(C) 2014-2015

 * Company       上海理工大学.

 * @author:    乔秋飞
 * Email:      1063157465@qq.com
 * @version    V1.0 
 * Createdate:         2014-7-29 下午07:35:28
 *
 * Modification  History:

 * Date         Author        Version        Discription

 * -----------------------------------------------------------------------------------

 * 2014-7-29       wu.zh          1.0             1.0

 * Why & What is modified: <修改原因描述>

 */
package com.usst.cad.homeworkssh.system.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.bcel.generic.NEW;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.usst.cad.homeworkssh.basic.action.ABaseAction;
import com.usst.cad.homeworkssh.basic.model.SRMException;
import com.usst.cad.homeworkssh.basic.model.SessionInfo;
import com.usst.cad.homeworkssh.basic.model.easyuimodel.TreeNode;
import com.usst.cad.homeworkssh.basic.model.type.ResponseType;
import com.usst.cad.homeworkssh.basic.util.IpUtil;
import com.usst.cad.homeworkssh.system.bean.UserBean;
import com.usst.cad.homeworkssh.system.model.pagemodel.User;
import com.usst.cad.homeworkssh.system.service.IUserService;
import com.usst.cad.homeworkssh.system.service.LoginService;
import com.usst.cad.homeworkssh.system.service.UserService;

/**
 * 类名称：         LoginAction.java
 * 类描述：         TODO(用一句话描述该文件做什么)
 * 创建人：         
 * 创建时间 ：   2014-7-29 下午07:35:28
 * 修改人：         乔秋飞
 * Email:     1063157465@qq.com
 * 修改时间 ：   2014-7-29 下午07:35:28
 * 修改备注 ：  
 * 版本：               v1.0
 */
@SuppressWarnings("serial")
@Controller
@Scope(value="prototype")
public class LoginAction extends ABaseAction<UserBean> implements ModelDriven<UserBean>{
	
	private UserBean userBean = new UserBean();
	
	@Resource(name="LoginService")
	private LoginService loginService;
	
	
		 
	@Override
	public UserBean getModel() {
		return userBean;
	}
	


	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public String login() throws Exception{
		
		SessionInfo sessionInfo =loginService.login(userBean.getLoginAccount(),userBean.getPassword());
		HttpSession session = getSession();
		if(sessionInfo!=null){
			session.setAttribute("sessionInfo", sessionInfo);
			/*return response(ResponseType.HTML,true,sessionInfo.getLoginName()+",欢迎您!");*/
			session.setAttribute("menuInfo", loginService.getMenu(sessionInfo.getAuthIds()));
			return SUCCESS;
		}
		/*return response(false,"用户名或密码 错误！");*/
		return ERROR;
	}
	
	/*public String getMenu() throws SRMException, IOException{
		HttpSession session = getSession();
		SessionInfo sessionInfo = (SessionInfo)session.getAttribute("sessionInfo");		
		return response(loginService.getMenu(sessionInfo.getAuthIds()));
	}*/
	
	private HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}


	public String logout() throws IOException{
		HttpSession session = getSession();
		session.removeAttribute("sessionInfo");
		return response(true);
	}
	
}
