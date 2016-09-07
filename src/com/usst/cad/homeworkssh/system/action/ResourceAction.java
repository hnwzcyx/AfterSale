/**

 * FileName:     ResourceAction.java

 * @Description: TODO(用一句话描述该文件做什么)

* All rights Reserved, Designed By 乔秋飞

 * Copyright:    Copyright(C) 2014-2015

 * Company       上海理工大学.

 * @author:    乔秋飞
 * Email:      1063157465@qq.com
 * @version    V1.0 
 * Createdate:         2014-8-17 上午09:37:39
 *
 * Modification  History:

 * Date         Author        Version        Discription

 * -----------------------------------------------------------------------------------

 * 2014-8-17       wu.zh          1.0             1.0

 * Why & What is modified: <修改原因描述>

 */
package com.usst.cad.homeworkssh.system.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.usst.cad.homeworkssh.basic.action.ABaseAction;
import com.usst.cad.homeworkssh.system.bean.ResourceBean;
import com.usst.cad.homeworkssh.system.model.pagemodel.ResourcePage;
import com.usst.cad.homeworkssh.system.service.ResourceService;

/**
 * 类名称：         ResourceAction.java
 * 类描述：         TODO(用一句话描述该文件做什么)
 * 创建人：         
 * 创建时间 ：   2014-8-17 上午09:37:39
 * 修改人：         乔秋飞
 * Email:     1063157465@qq.com
 * 修改时间 ：   2014-8-17 上午09:37:39
 * 修改备注 ：  
 * 版本：               v1.0
 */


@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class ResourceAction extends ABaseAction<ResourcePage> implements ModelDriven<ResourcePage>{	
	private ResourcePage resourcePage = new ResourcePage();
	@Override
	public ResourcePage getModel() {
		// TODO Auto-generated method stub
		return resourcePage;
	}
	

	public ResourceService getResourceService() {
		return resourceService;
	}
	@Resource(name="ResourceService")
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}


	private ResourceService resourceService;

	public String list() throws IOException{
		String jsonString = "";
		jsonString = resourceService.list(resourcePage);
		System.out.println(jsonString);
		return response(jsonString);
	}
	public String subList() throws IOException{
		String jsonString = "";
		jsonString = resourceService.subList(Long.parseLong(resourcePage.getId()));
		System.out.println(jsonString);
		return response(jsonString);
	}
	
	/*public String list() throws IOException{
		HttpSession httpSession = getSession();		
		return response(resourceService.list(((SessionInfo)httpSession.getAttribute("sessionInfo")).getAuthIds()));
		
	}*/
	
	private HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}
	
	public String add() throws Exception{	
		ResourceBean resourceBean = new ResourceBean();
		BeanUtils.copyProperties(resourceBean, resourcePage);
		resourceService.add(resourceBean);
		return response(true);
		
	}
	
	public String delete() throws Exception {
		ResourceBean resourceBean = resourceService.getObject(Long.valueOf(resourcePage.getId()));	
			resourceService.remove(resourceBean);
			return response(true, "删除成功！");
	}	

	public String edit() throws IOException, Exception, InvocationTargetException{
		ResourceBean resourceBean = new ResourceBean();
		BeanUtils.copyProperties(resourceBean, resourcePage);
		try {
			resourceService.modify(resourceBean);
			return response(true,"编辑成功！");
		} catch (Exception e) {
			e.printStackTrace();
			return response(true,"编辑失败！");

		}
	}
}
