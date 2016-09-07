/**

 * FileName:     RoleAction.java

 * @Description: TODO(用一句话描述该文件做什么)

* All rights Reserved, Designed By 乔秋飞

 * Copyright:    Copyright(C) 2014-2015

 * Company       上海理工大学.

 * @author:    乔秋飞
 * Email:      1063157465@qq.com
 * @version    V1.0 
 * Createdate:         2014-8-18 下午03:53:19
 *
 * Modification  History:

 * Date         Author        Version        Discription

 * -----------------------------------------------------------------------------------

 * 2014-8-18       wu.zh          1.0             1.0

 * Why & What is modified: <修改原因描述>

 */
package com.usst.cad.homeworkssh.system.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.beanutils.BeanUtils;
import com.usst.cad.homeworkssh.basic.action.ABaseAction;
import com.usst.cad.homeworkssh.basic.model.json.DateJsonValueProcessor;
import com.usst.cad.homeworkssh.basic.util.DateUtil;
import com.usst.cad.homeworkssh.system.bean.RoleBean;
import com.usst.cad.homeworkssh.system.model.pagemodel.RolePage;
import com.usst.cad.homeworkssh.system.service.IRoleService;

/**
 * 类名称：         RoleAction.java
 * 类描述：         TODO(用一句话描述该文件做什么)
 * 创建人：         
 * 创建时间 ：   2014-8-18 下午03:53:19
 * 修改人：         乔秋飞
 * Email:     1063157465@qq.com
 * 修改时间 ：   2014-8-18 下午03:53:19
 * 修改备注 ：  
 * 版本：               v1.0
 */
@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class RoleAction extends ABaseAction<RolePage> implements ModelDriven<RolePage>{
	private RolePage rolePage = new RolePage();
	
	@Resource(name="RoleService")
	private IRoleService roleService;

		 
	@Override
	public RolePage getModel() {
		return rolePage;
	}

	public String list() throws IOException{	
		
		return response(roleService.list(rolePage));
	}
	
	public String add() throws IllegalAccessException, InvocationTargetException, IOException {
		RoleBean roleBean = new RoleBean();
		//BeanUtils.copyProperties(roleBean, rolePage);
		roleBean.setName(rolePage.getName());
		roleBean.setDescription(rolePage.getDescription());
		roleBean.setCreateTime(new Date());
		roleBean.setModifyTime(new Date());
		try {
			roleService.add(roleBean);
			return response(true,"保存成功！");
		} catch (Exception e) {
			return response(false,"保存失败！");

		}
	}
	
	public String delete() throws IOException{
		try {
			roleService.remove(Long.valueOf(rolePage.getId()));
			return response(true,"删除成功！");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return response(false,"删除失败!");
			
		} catch (Exception e) {

			e.printStackTrace();
			return response(false,"删除失败!");
		}
	}
	
	public String edit() throws NumberFormatException, Exception{
		RoleBean roleBean = new RoleBean();
		roleBean = roleService.getObject(Long.valueOf(rolePage.getId()));
		roleBean.setName(rolePage.getName());
		roleBean.setDescription(rolePage.getDescription());
		roleBean.setModifyTime(new Date());
		try {
			roleService.modify(roleBean);
			return response(true,"编辑成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return response(false,"编辑失败!");
		}
	}
	
	public String getRoleAuths() throws Exception{
		if(rolePage.getId()!=null){
			return response(roleService.getRoleAuths(rolePage.getId()));
		}
		return null;
	}
	
	public String setRoleAuths() throws IOException{		
		try {
			roleService.setRoleAuths(rolePage);
			return response(true,"授权成功!");
		} catch (Exception e) {
			e.printStackTrace();
			return response(false,"授权失败!");
		}
	}
	
	public String getRoles() throws IOException{
		JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class,new DateJsonValueProcessor(DateUtil.DATETIMEFORMAT));
        jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		return response(JSONArray.fromObject(roleService.getList(),jsonConfig).toString());
	}
}
