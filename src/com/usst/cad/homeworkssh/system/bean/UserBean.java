/**

 * FileName:     User.java

 * @Description: TODO(用一句话描述该文件做什么)

* All rights Reserved, Designed By 乔秋飞

 * Copyright:    Copyright(C) 2014-2015

 * Company       上海理工大学.

 * @author:    乔秋飞
 * Email:      1063157465@qq.com
 * @version    V1.0 
 * Createdate:         2014-7-25 下午07:53:14
 *
 * Modification  History:

 * Date         Author        Version        Discription

 * -----------------------------------------------------------------------------------

 * 2014-7-25       wu.zh          1.0             1.0

 * Why & What is modified: <修改原因描述>

 */
package com.usst.cad.homeworkssh.system.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.usst.cad.homeworkssh.system.bean.RoleBean;

/**
 * 类名称：         User.java
 * 类描述：         TODO(用一句话描述该文件做什么)
 * 创建人：         
 * 创建时间 ：   2014-7-25 下午07:53:14
 * 修改人：         乔秋飞
 * Email:     1063157465@qq.com
 * 修改时间 ：   2014-7-25 下午07:53:14
 * 修改备注 ：  
 * 版本：               v1.0
 */
@Entity
@Table(name="SYS_USERS")
public class UserBean {
	private long id;
	private String loginAccount;
	private String password;
	private String name;
	private String email;
	private String telephone;
	private String mobile;
	private String department;
	private String position;
	private String description;
	private Date creatDateTimeDate;
	private Date modifyDateTimeDate;
	private Set<RoleBean> roles = new HashSet<RoleBean>();
	private boolean systemUser;
	private long companyId;
	
	@Id
	@GeneratedValue
	@Column(length=20)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(length=50,nullable=false)
	public String getLoginAccount() {
		return loginAccount;
	}
	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}
	@Column(length=50,nullable=true)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(length=50)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=50)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length=50)
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@Column(length=50)
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Column(length=50)
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Column(length=25)
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Column(length=255)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Temporal(TemporalType.DATE)
	@Column
	public Date getCreatDateTimeDate() {
		return creatDateTimeDate;
	}
	public void setCreatDateTimeDate(Date creatDateTimeDate) {
		this.creatDateTimeDate = creatDateTimeDate;
	}
	@Temporal(TemporalType.DATE)
	@Column
	public Date getModifyDateTimeDate() {
		return modifyDateTimeDate;
	}
	public void setModifyDateTimeDate(Date modifyDateTimeDate) {
		this.modifyDateTimeDate = modifyDateTimeDate;
	}
	
	@ManyToMany(cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch=FetchType.LAZY)
	@JoinTable(name="SYSTEM_USER_ROLE",joinColumns={@JoinColumn(name="user_id")},inverseJoinColumns={@JoinColumn(name="role_id")})
	public Set<RoleBean> getRoles() {
		return roles;
	}
	public void setRoles(Set<RoleBean> roles) {
		this.roles = roles;
	}

	public boolean isSystemUser() {
		return systemUser;
	}
	public void setSystemUser(boolean systemUser) {
		this.systemUser = systemUser;
	}
	@Column(length=19)
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	
}
