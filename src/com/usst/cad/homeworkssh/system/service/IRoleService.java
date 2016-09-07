/**

 * FileName:     IRoleService.java

 * @Description: TODO(用一句话描述该文件做什么)

* All rights Reserved, Designed By 乔秋飞

 * Copyright:    Copyright(C) 2014-2015

 * Company       上海理工大学.

 * @author:    乔秋飞
 * Email:      1063157465@qq.com
 * @version    V1.0 
 * Createdate:         2014-7-29 下午09:01:02
 *
 * Modification  History:

 * Date         Author        Version        Discription

 * -----------------------------------------------------------------------------------

 * 2014-7-29       wu.zh          1.0             1.0

 * Why & What is modified: <修改原因描述>

 */
package com.usst.cad.homeworkssh.system.service;

import com.usst.cad.homeworkssh.basic.service.IBaseService;
import com.usst.cad.homeworkssh.system.bean.RoleBean;
import com.usst.cad.homeworkssh.system.model.pagemodel.RolePage;

/**
 * 类名称：         IRoleService.java
 * 类描述：         TODO(用一句话描述该文件做什么)
 * 创建人：         
 * 创建时间 ：   2014-7-29 下午09:01:02
 * 修改人：         乔秋飞
 * Email:     1063157465@qq.com
 * 修改时间 ：   2014-7-29 下午09:01:02
 * 修改备注 ：  
 * 版本：               v1.0
 */
public interface IRoleService extends IBaseService<RoleBean> {

	public String list(RolePage rolePage);

	/**
	 * @Title:        getRoleAuths
	 * @Description:  TODO(这里用一句话描述这个方法的作用)
	 * @param:        @param id   
	 * @return:       void   
	 * @author:       乔秋飞 
	 * Email:         1063157465@qq.com
	 * @throws Exception 
	 * @throws
	 * @Date          2014-8-19 下午01:37:51
	 */
	public String getRoleAuths(String id) throws Exception;
	public String setRoleAuths(RolePage rolePage) throws Exception;
}
