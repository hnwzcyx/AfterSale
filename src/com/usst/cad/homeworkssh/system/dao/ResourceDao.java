/**

 * FileName:     ResourceDao.java

 * @Description: TODO(用一句话描述该文件做什么)

* All rights Reserved, Designed By 乔秋飞

 * Copyright:    Copyright(C) 2014-2015

 * Company       上海理工大学.

 * @author:    乔秋飞
 * Email:      1063157465@qq.com
 * @version    V1.0 
 * Createdate:         2014-7-29 下午08:43:03
 *
 * Modification  History:

 * Date         Author        Version        Discription

 * -----------------------------------------------------------------------------------

 * 2014-7-29       wu.zh          1.0             1.0

 * Why & What is modified: <修改原因描述>

 */
package com.usst.cad.homeworkssh.system.dao;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.usst.cad.homeworkssh.basic.dao.ABaseDao;
import com.usst.cad.homeworkssh.system.bean.ResourceBean;

/**
 * 类名称：         ResourceDao.java
 * 类描述：         TODO(用一句话描述该文件做什么)
 * 创建人：         
 * 创建时间 ：   2014-7-29 下午08:43:03
 * 修改人：         乔秋飞
 * Email:     1063157465@qq.com
 * 修改时间 ：   2014-7-29 下午08:43:03
 * 修改备注 ：  
 * 版本：               v1.0
 */
@Repository("ResourceDao")
public class ResourceDao extends ABaseDao<ResourceBean> implements IResourceDao { 
	@Override
	public DetachedCriteria getCriteria() {
		return DetachedCriteria.forClass(ResourceBean.class);
	}

}
