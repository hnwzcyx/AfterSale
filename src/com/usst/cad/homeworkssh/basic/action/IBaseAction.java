/**

 * FileName:     IBaseAction.java

 * @Description: TODO(用一句话描述该文件做什么)

* All rights Reserved, Designed By 乔秋飞

 * Copyright:    Copyright(C) 2014-2015

 * Company       上海理工大学.

 * @author:    乔秋飞
 * Email:      1063157465@qq.com
 * @version    V1.0 
 * Createdate:         2014-7-26 下午09:53:14
 *
 * Modification  History:

 * Date         Author        Version        Discription

 * -----------------------------------------------------------------------------------

 * 2014-7-26       wu.zh          1.0             1.0

 * Why & What is modified: <修改原因描述>

 */
package com.usst.cad.homeworkssh.basic.action;

import java.io.InputStream;
import java.io.Serializable;

/**
 * 类名称：         IBaseAction.java
 * 类描述：         TODO(用一句话描述该文件做什么)
 * 创建人：         
 * 创建时间 ：   2014-7-26 下午09:53:15
 * 修改人：         乔秋飞
 * Email:     1063157465@qq.com
 * 修改时间 ：   2014-7-26 下午09:53:15
 * 修改备注 ：  
 * 版本：               v1.0
 */
public interface IBaseAction<T> extends Serializable{
	String add()throws Exception;
	String delete() throws Exception;
	String update() throws Exception;
	String list() throws Exception;
	String get() throws Exception;
	String downLoad() throws Exception;
	InputStream getDownLoadInputStream() throws Exception;

}
