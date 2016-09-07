/**

 * FileName:     Role.java

 * @Description: TODO(用一句话描述该文件做什么)

* All rights Reserved, Designed By 乔秋飞

 * Copyright:    Copyright(C) 2014-2015

 * Company       上海理工大学.

 * @author:    乔秋飞
 * Email:      1063157465@qq.com
 * @version    V1.0 
 * Createdate:         2014-7-27 上午10:06:17
 *
 * Modification  History:

 * Date         Author        Version        Discription

 * -----------------------------------------------------------------------------------

 * 2014-7-27       wu.zh          1.0             1.0

 * Why & What is modified: <修改原因描述>

 */
package com.usst.cad.homeworkssh.system.model.pagemodel;

import java.io.Serializable;

/**
 * 类名称：         Role.java
 * 类描述：         TODO(用一句话描述该文件做什么)
 * 创建人：         
 * 创建时间 ：   2014-7-27 上午10:06:17
 * 修改人：         乔秋飞
 * Email:     1063157465@qq.com
 * 修改时间 ：   2014-7-27 上午10:06:17
 * 修改备注 ：  
 * 版本：               v1.0
 */
public class RolePage implements Serializable{
	private String ids;
	private String id;
	private String name;
	private String description;
	private String createTime;
	private String modifyTime;
	private int page;// 当前页
	private int rows;// 每页显示记录数
	
	
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	private String sort;// 排序字段名
	private String order;// 按什么排序(asc,desc)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	
}
