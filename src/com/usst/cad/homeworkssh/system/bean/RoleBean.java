/**

 * FileName:     RoleBean.java

 * @Description: TODO(用一句话描述该文件做什么)

* All rights Reserved, Designed By 乔秋飞

 * Copyright:    Copyright(C) 2014-2015

 * Company       上海理工大学.

 * @author:    乔秋飞
 * Email:      1063157465@qq.com
 * @version    V1.0 
 * Createdate:         2014-7-25 下午07:59:33
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
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.usst.cad.homeworkssh.system.bean.ResourceBean;
import com.usst.cad.homeworkssh.system.bean.UserBean;

/**
 * 类名称：         RoleBean.java
 * 类描述：         TODO(用一句话描述该文件做什么)
 * 创建人：         
 * 创建时间 ：   2014-7-25 下午07:59:33
 * 修改人：         乔秋飞
 * Email:     1063157465@qq.com
 * 修改时间 ：   2014-7-25 下午07:59:33
 * 修改备注 ：  
 * 版本：               v1.0
 */
@Entity
@Table(name="SYSTEM_ROLE")
public class RoleBean {
	private long id;
	private String name;
	private String description;
	private Set<UserBean> users;
	private Set<ResourceBean> resources=new HashSet<ResourceBean>();
	private Date createTime;
	private Date modifyTime;
	
	@Id
	@GeneratedValue
	@Column(length=20)
	public long getId() {
		return id;
	}
	@Temporal(TemporalType.DATE)
	@Column
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Temporal(TemporalType.DATE)
	@Column
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Column(length=50)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=255)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@ManyToMany(cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch=FetchType.LAZY)
	@JoinTable(name="SYSTEM_USER_ROLE",joinColumns={@JoinColumn(name="role_id")},inverseJoinColumns={@JoinColumn(name="user_id")})
	public Set<UserBean> getUsers() {
		return users;
	}
	public void setUsers(Set<UserBean> users) {
		this.users = users;
	}
	@ManyToMany(cascade={CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch=FetchType.LAZY)
	@OrderBy(value="priority")
	@JoinTable(name="SYSTEM_ROLE_RESOURCE",joinColumns={@JoinColumn(name="role_id")},inverseJoinColumns={@JoinColumn(name="resource_id")})
	public Set<ResourceBean> getResources() {
		return resources;
	}
	public void setResources(Set<ResourceBean> resources) {
		this.resources = resources;
	}

}
