/**

 * FileName:     ResourceBean.java

 * @Description: TODO(用一句话描述该文件做什么)

* All rights Reserved, Designed By 乔秋飞

 * Copyright:    Copyright(C) 2014-2015

 * Company       上海理工大学.

 * @author:    乔秋飞
 * Email:      1063157465@qq.com
 * @version    V1.0 
 * Createdate:         2014-7-25 下午08:01:55
 *
 * Modification  History:

 * Date         Author        Version        Discription

 * -----------------------------------------------------------------------------------

 * 2014-7-25       wu.zh          1.0             1.0

 * Why & What is modified: <修改原因描述>

 */
package com.usst.cad.homeworkssh.system.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 类名称：         ResourceBean.java
 * 类描述：         TODO(用一句话描述该文件做什么)
 * 创建人：         
 * 创建时间 ：   2014-7-25 下午08:01:55
 * 修改人：         乔秋飞
 * Email:     1063157465@qq.com
 * 修改时间 ：   2014-7-25 下午08:01:55
 * 修改备注 ：  
 * 版本：               v1.0
 */
@Entity
@Table(name="SYSTEM_RESOURCE")
public class ResourceBean {
	private long id;
	private String name;
	private String relation;
	private int type;
	private String url;
	private String description;
	private Boolean hide;
	private int priority; 
	private String iconCls;

	private long pid;
	/*private ResourceBean resourceBean;
	private Set<ResourceBean> resourceBeans = new HashSet<ResourceBean>();*/
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=50)
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	@Column
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Column(length=50)
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Column(length=255)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column
	public Boolean getHide() {
		return hide;
	}
	public void setHide(Boolean hide) {
		this.hide = hide;
	}
	

	public void setPriority(int priority) {
		this.priority = priority;
	}
	

	@Column	
	public int getPriority() {
		return priority;
	}
	

			 
		/*public void setResourceBean(ResourceBean resourceBean) {
			this.resourceBean = resourceBean;
		}
		

		@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
		@JoinColumn(name="pid")
		public ResourceBean getResourceBean() {
			return resourceBean;
		}
		@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="resourceBean")
		public Set<ResourceBean> getResourceBeans() {
			return resourceBeans;
		}
		public void setResourceBeans(Set<ResourceBean> resourceBeans) {
			this.resourceBeans = resourceBeans;
		}
		*/
		@Column(length=50)
		public String getIconCls() {
			return iconCls;
		}
		public void setIconCls(String iconCls) {
			this.iconCls = iconCls;
		}
		@Column
		public long getPid() {
			return pid;
		}
		public void setPid(long pid) {
			this.pid = pid;
		}
}
