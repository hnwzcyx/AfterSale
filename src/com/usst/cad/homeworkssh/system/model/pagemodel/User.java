/**

 * FileName:     User.java

 * @Description: TODO(用一句话描述该文件做什么)

* All rights Reserved, Designed By 乔秋飞

 * Copyright:    Copyright(C) 2014-2015

 * Company       上海理工大学.

 * @author:    乔秋飞
 * Email:      1063157465@qq.com
 * @version    V1.0 
 * Createdate:         2014-7-27 上午10:06:04
 *
 * Modification  History:

 * Date         Author        Version        Discription

 * -----------------------------------------------------------------------------------

 * 2014-7-27       wu.zh          1.0             1.0

 * Why & What is modified: <修改原因描述>

 */
package com.usst.cad.homeworkssh.system.model.pagemodel;

import java.io.Serializable;
import java.util.Date;


/**
 * 类名称：         User.java
 * 类描述：         TODO(用一句话描述该文件做什么)
 * 创建人：         
 * 创建时间 ：   2014-7-27 上午10:06:04
 * 修改人：         乔秋飞
 * Email:     1063157465@qq.com
 * 修改时间 ：   2014-7-27 上午10:06:04
 * 修改备注 ：  
 * 版本：               v1.0
 */
@SuppressWarnings("serial")
public class User implements Serializable {
	private String ids;
	private String roleIds;
	private String roleNames;
	private String authIds;
	private String authNames;
	private String authUrls;
	private Date ccreatedatetimeStart;
	private Date cmodifydatetimeStart;
	private Date ccreatedatetimeEnd;
	private Date cmodifydatetimeEnd;
	private String q;
	
	private String loginAccount;
	private String password;
	private Date ccreatedatetime;
	private Date cmodifydatetime;
	
	
	public String getLoginAccount() {
		return loginAccount;
	}
	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCcreatedatetime() {
		return ccreatedatetime;
	}
	public void setCcreatedatetime(Date ccreatedatetime) {
		this.ccreatedatetime = ccreatedatetime;
	}
	public Date getCmodifydatetime() {
		return cmodifydatetime;
	}
	public void setCmodifydatetime(Date cmodifydatetime) {
		this.cmodifydatetime = cmodifydatetime;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public String getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
	public String getRoleNames() {
		return roleNames;
	}
	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}
	public String getAuthIds() {
		return authIds;
	}
	public void setAuthIds(String authIds) {
		this.authIds = authIds;
	}
	public String getAuthNames() {
		return authNames;
	}
	public void setAuthNames(String authNames) {
		this.authNames = authNames;
	}
	public String getAuthUrls() {
		return authUrls;
	}
	public void setAuthUrls(String authUrls) {
		this.authUrls = authUrls;
	}

	public Date getCcreatedatetimeStart() {
		return ccreatedatetimeStart;
	}
	public void setCcreatedatetimeStart(Date ccreatedatetimeStart) {
		this.ccreatedatetimeStart = ccreatedatetimeStart;
	}
	public Date getCmodifydatetimeStart() {
		return cmodifydatetimeStart;
	}
	public void setCmodifydatetimeStart(Date cmodifydatetimeStart) {
		this.cmodifydatetimeStart = cmodifydatetimeStart;
	}
	public Date getCcreatedatetimeEnd() {
		return ccreatedatetimeEnd;
	}
	public void setCcreatedatetimeEnd(Date ccreatedatetimeEnd) {
		this.ccreatedatetimeEnd = ccreatedatetimeEnd;
	}
	public Date getCmodifydatetimeEnd() {
		return cmodifydatetimeEnd;
	}
	public void setCmodifydatetimeEnd(Date cmodifydatetimeEnd) {
		this.cmodifydatetimeEnd = cmodifydatetimeEnd;
	}
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}


}
