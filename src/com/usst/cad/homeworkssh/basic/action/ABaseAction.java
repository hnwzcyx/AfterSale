/**

 * FileName:     ABaseAction.java

 * @Description: TODO(用一句话描述该文件做什么)

* All rights Reserved, Designed By 乔秋飞

 * Copyright:    Copyright(C) 2014-2015

 * Company       上海理工大学.

 * @author:    乔秋飞
 * Email:      1063157465@qq.com
 * @version    V1.0 
 * Createdate:         2014-7-26 下午09:58:47
 *
 * Modification  History:

 * Date         Author        Version        Discription

 * -----------------------------------------------------------------------------------

 * 2014-7-26       wu.zh          1.0             1.0

 * Why & What is modified: <修改原因描述>

 */
package com.usst.cad.homeworkssh.basic.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Value;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;
import com.usst.cad.homeworkssh.basic.model.constants.AppConstants;
import com.usst.cad.homeworkssh.basic.model.constants.ErrorMessageConstants;
import com.usst.cad.homeworkssh.basic.model.type.ResponseType;
import com.usst.cad.homeworkssh.basic.service.IBaseService;
import com.usst.cad.homeworkssh.basic.util.DataUtil;
import com.usst.cad.homeworkssh.basic.util.DateUtil;

/**
 * 类名称：         ABaseAction.java
 * 类描述：         TODO(用一句话描述该文件做什么)
 * 创建人：         
 * 创建时间 ：   2014-7-26 下午09:58:47
 * 修改人：         乔秋飞
 * Email:     1063157465@qq.com
 * 修改时间 ：   2014-7-26 下午09:58:47
 * 修改备注 ：  
 * 版本：               v1.0
 */
@SuppressWarnings("serial")
public class ABaseAction<T> extends ActionSupport implements IBaseAction<T>{

	protected T baseEntity;
	protected IBaseService<T> baseService;
	
	protected HttpServletRequest httpRequest;
	protected HttpServletResponse httpResponse;
	
	public void setHttpRequest(HttpServletRequest request){
		this.httpRequest = request;
	}
	
	public void setHttpResponse(HttpServletResponse response){
		this.httpResponse = response;
	}
	/**
	 * 类名称：         ABaseAction.java
	 * 类描述：         TODO(导出表格参数)
	 * 创建人：         
	 * 创建时间 ：   2014-8-23 下午09:58:47
	 * 修改人：         zhangchao
	 * Email:     1063157465@qq.com
	 * 修改时间 ：   
	 * 修改备注 ：  
	 * 版本：               v1.0
	 */
	@Value("${resmanagement.attachment}")
	public String basePath;
	/* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.action.IBaseAction#add()
		 */
	protected long id ;
	protected int page;// 当前页
	protected int rows;// 每页显示记录数
	
	protected String sort;// 排序字段名
	protected String order;// 按什么排序(asc,desc)
	
	
	protected String downLoadPath; // 下载文件目录
	protected String resultPath; // 下载文件跳转result名
	protected String fileName; // 下载服务端文件名
	protected String downLoadFileName; // 下载的文件名
	
	/* 下载Ding */
	protected File attachment;
	protected String attachmentFileName;
	protected InputStream downloadFileInputStream;
	
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


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
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

	public String getDownLoadPath() {
		return downLoadPath;
	}

	public void setDownLoadPath(String downLoadPath) {
		this.downLoadPath = downLoadPath;
	}



	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		try {
			this.fileName = new String(fileName.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	@Override
	public String add() throws Exception {
	   
		return null;
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.action.IBaseAction#delete()
		 */
		 
	@Override
	public String delete() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.action.IBaseAction#downLoad()
		 */
		 
	//@Override
	//public String downLoad() throws Exception {
		// TODO Auto-generated method stub
		//return null;
	//}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.action.IBaseAction#get()
		 */
		 
	@Override
	public String get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.action.IBaseAction#getDownLoadInputStream()
		 */
		 
	//@Override
	//public InputStream getDownLoadInputStream() throws Exception {
		// TODO Auto-generated method stub
		//return null;
	//}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.action.IBaseAction#list()
		 */
		 
	@Override
	public String list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.action.IBaseAction#update()
		 */
		 
	@Override
	public String update() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String downLoad() throws Exception {
		if (DataUtil.notEmptyString(resultPath)) {
			return resultPath;
		}
		return AppConstants.SUCCESS_DOWNLOAD_RESULT;
	}
	
		 /* (non-Javadoc)
		 * @see com.usst.cad.resmanagement.basic.action.IBaseAction#update()
		 */
		 
	@SuppressWarnings({ "deprecation", "unused" })
	public InputStream getDownLoadInputStream() throws Exception {
		InputStream is;
		this.downLoadFileName = java.net.URLDecoder.decode(downLoadFileName);
		this.downLoadFileName = new String(this.downLoadFileName.getBytes(), "ISO-8859-1");
		is = new FileInputStream(new File(basePath + downLoadPath + fileName));
		if (is == null)
			this.addActionError(ErrorMessageConstants.Common.FILE_NOT_FOUND);
		return is;
	}
	
	
	public String response(ResponseType responseType, String response) throws IOException {
		ServletActionContext.getResponse().setContentType(responseType.toText());
		ServletActionContext.getResponse().getWriter().write(response);
		return null;
	}
	
	public String response(ResponseType responseType, Object... objects) throws IOException {
		return response(responseType, append(objects));
	}

	public String response(Object... objects) throws IOException {
		return response(ResponseType.JSON, objects);
	}

	public String response(boolean success) throws IOException {
		return response(success, "");
	}

	public String response(boolean success, String msg) throws IOException {
		if (success) {
			return response("{\"success\":" + true + ",\"msg\":\"" + msg + "\"}");
		} else {
			return response("{\"success\":" + false + ",\"msg\":\"" + msg + "\"}");
		}
	}

	public String response(boolean success, JsonElement je) throws Exception {
		Gson gson = new Gson();
		String returnData = gson.toJson(je);
		if (success) {
			return response("{\"success\":" + true + ",\"data\":" + returnData + "}");
		} else {
			return response("{\"success\":" + false + ",\"data\":" + returnData + "}");
		}
	}

	public String response(ResponseType responseType, boolean success, String msg) throws IOException {
		if (success) {
			return response(responseType, "{\"success\":" + true + ",\"msg\":\"" + msg + "\"}");
		} else {
			return response(responseType, "{\"success\":" + false + ",\"msg\":\"" + msg + "\"}");
		}
	}

	public static String append(Object... objects) {
		if (objects.length == 1) {
			return objects[0].toString();
		}
		StringBuilder sb = new StringBuilder();
		for (Object o : objects) {
			sb.append(o);
		}
		return sb.toString();
	}
	
	/**
	 * 
	 */
	public String getDownLoadFileName() {
		return downLoadFileName;
	}

	public void setDownLoadFileName(String downLoadFileName) {
		try {
			this.downLoadFileName = new String(downLoadFileName.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// this.downLoadFileName = downLoadFileName;
	}
	
	/**
	 * 
	 * 
	 * @参数： @param path
	 * @参数： @return
	 * @return String
	 * @throws
	 */
	public String getRealPath(String path) {
		File f = new File(basePath == null ? "D:/smattachment/" : basePath);
		if (!f.isFile())
			if (!f.isDirectory())
				f.delete();
		f.mkdir();
		File returnPath = new File(f, path);
		returnPath.mkdirs();
		// System.out.println(returnPath.getAbsolutePath());
		return returnPath.getAbsolutePath();
	}
	
	
	/*--- 下载  实现---*/
	public File getAttachment() {
		return attachment;
	}
	public void setAttachment(File attachment) {
		this.attachment = attachment;
	}

	public String getAttachmentFileName() {
		return attachmentFileName;
	}

	public void setAttachmentFileName(String attachmentFileName) {
		this.attachmentFileName = attachmentFileName;
	}

	public InputStream getDownloadFileInputStream() throws Exception {
		InputStream is = null;
		try {
			is = new FileInputStream(attachment);
		} catch (FileNotFoundException e) {
			System.out.println("下载文件缺失！");
			e.printStackTrace();
		}
		return is;
	}

	
	
	/**
	 * 处理下载
	 * 20140818 zhangchao
	 * @param attachmentFileName
	 * @param savePath
	 * @return
	 * @throws Exception
	 */
	protected String downloadHandle(String attachmentFileName, String savePath) throws Exception {
		if (null == attachmentFileName || null == savePath)
			return "DownloadError";
		setAttachment(new File(savePath + "/" + attachmentFileName));
		setAttachmentFileName(new String(attachmentFileName.substring(14).getBytes(), "ISO8859-1"));
		return "Download";
	}
	
	/**
	 * 导出excel文件
	 * 20140818
	 *  张超
	 * @param jsonArray
	 * @return
	 * @throws Exception
	 */
	protected String exportHandle(String exportFileName, String jsonArray, List<String> keyList) throws Exception {
		if (null == exportFileName || null == jsonArray)
			return null;

		String exportPath = this.getRealPath("/explort/");// 导出文件夹
		// 保存文件的真实姓名
		String explortFileRealName = DateUtil.formatDate(new Date(System.currentTimeMillis()), DateUtil.DATEUPLOADFORMAT) + exportFileName + ".xls";
		File exportFile = new File(exportPath, "/" + explortFileRealName);

		Gson gson = new Gson();
		ArrayList<HashMap<String, String>> list = null;
		try {
			list = gson.fromJson(jsonArray, new TypeToken<ArrayList<HashMap<String, String>>>() {
			}.getType());
		} catch (Exception e) {
			System.out.println("json 格式不合法！");
			e.printStackTrace();
			return null;
		}

		// 先创建工作簿对象
		HSSFWorkbook workbook2003 = new HSSFWorkbook();
		// 创建工作表对象并命名
		HSSFSheet sheet = workbook2003.createSheet(exportFileName);

		// 设置第一行（表头）
		HSSFRow headRow = sheet.createRow(0);
		for (int i = 0; i < keyList.size(); i++) {
			headRow.createCell(i).setCellValue(keyList.get(i));
		}
		// 设置正文(第一行开始)
		for (int i = 1; i <= list.size(); i++) {
			HSSFRow row = sheet.createRow(i);
			HashMap<String, String> map = list.get(i - 1);
			for (int j = 0; j < keyList.size(); j++) {
				row.createCell(j).setCellValue(map.get(keyList.get(j)));
			}
		}

		// 保存文件
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(exportFile);
			workbook2003.write(fos);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return this.downloadHandle(explortFileRealName, exportPath);
	}
	
	protected ArrayList<HashMap<String, String>> formatToList(String jsonArray) throws Exception{
		Gson gson = new Gson();
		ArrayList<HashMap<String, String>> list = null;
		try {
			list = gson.fromJson(jsonArray, new TypeToken<ArrayList<HashMap<String, String>>>() {
			}.getType());
			return list;
		} catch (Exception e) {
			System.out.println("json 格式不合法！");
			e.printStackTrace();
			return null;
		}
	}
	
	protected void saveFileStream(HSSFWorkbook workbook2003,File exportFile) throws Exception{
		// 保存文件
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(exportFile);
			workbook2003.write(fos);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	


}
