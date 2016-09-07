/**

 * FileName:     IUserService.java

 * @Description: TODO(用一句话描述该文件做什么)

* All rights Reserved, Designed By 乔秋飞

 * Copyright:    Copyright(C) 2014-2015

 * Company       上海理工大学.

 * @author:    乔秋飞
 * Email:      1063157465@qq.com
 * @version    V1.0 
 * Createdate:         2014-7-29 下午08:49:31
 *
 * Modification  History:

 * Date         Author        Version        Discription

 * -----------------------------------------------------------------------------------

 * 2014-7-29       wu.zh          1.0             1.0

 * Why & What is modified: <修改原因描述>

 */
package com.usst.cad.homeworkssh.system.service;

import java.io.Serializable;
import java.util.List;

import com.usst.cad.homeworkssh.basic.model.SessionInfo;
import com.usst.cad.homeworkssh.basic.model.easyuimodel.TreeNode;
import com.usst.cad.homeworkssh.basic.service.IBaseService;
import com.usst.cad.homeworkssh.system.bean.RoleBean;
import com.usst.cad.homeworkssh.system.bean.UserBean;
import com.usst.cad.homeworkssh.system.model.pagemodel.User;

/**
 * 类名称：         IUserService.java
 * 类描述：         TODO(用一句话描述该文件做什么)
 * 创建人：         
 * 创建时间 ：   2014-7-29 下午08:49:31
 * 修改人：         乔秋飞
 * Email:     1063157465@qq.com
 * 修改时间 ：   2014-7-29 下午08:49:31
 * 修改备注 ：  
 * 版本：               v1.0
 */
public interface IUserService extends IBaseService<UserBean>{

	/**
	 * @Title:        login
	 * @Description:  TODO(这里用一句话描述这个方法的作用)
	 * @param:        @param user
	 * @param:        @return   
	 * @return:       User   
	 * @author:       乔秋飞 
	 * Email:         1063157465@qq.com
	 * @throws Exception 
	 * @throws
	 * @Date          2014-7-31 下午09:37:08
	 */
	public SessionInfo login(User user) throws Exception;
	public List<TreeNode> tree(Serializable id ) throws Exception;
	public String list(UserBean userBean ,int page,int rows) throws Exception;
	public String getUserRoles(Long id)throws Exception;
	public String setUserRoles(UserBean userBean,String ids)throws Exception;

}
