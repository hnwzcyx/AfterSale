package com.usst.cad.homeworkssh.basic.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SRMUtil {

	/**
	 * 取附件 统一命名方式yyyyMMddHHmmss+achmentFileName
	 * 
	 * @param attachment
	 * @return
	 */
	public static String getAttachment(String attachment, int length) {
		if (null != attachment && !"".equals(attachment)) {
			String temp = attachment.substring(14);// 附件真正的名字
			/* 附件长度超过 length 时候处理 */
			if (temp.length() > length) {
				String[] temp2 = temp.split("\\.");
				String returnValue = temp.substring(0, length - 6) + "~." + temp2[temp2.length - 1];
				return returnValue;
			} else {
				return temp;
			}
		} else {
			return "-";
		}
	}

	/**
	 * 保存附件
	 * 
	 * @param attachment
	 * @param attachmentFileName
	 * @param savePath
	 * @param date
	 * @return
	 */
	public static String saveAttachment(File attachment, String attachmentFileName, String savePath, Date date) {

		if (null != attachment && !"".equals(attachmentFileName)) {
			String attachmentSaveName = DateUtil.formatDate(date, DateUtil.DATEUPLOADFORMAT) + attachmentFileName;
			File attachmentSaveFile = new File(savePath + "/" + attachmentSaveName);
			attachment.renameTo(attachmentSaveFile);
			return attachmentSaveName;
		} else
			return null;
	}

	/**
	 * 删除附件
	 * 
	 * @param fileName
	 * @param savePath
	 * @return
	 */
	public static boolean deleteAttachment(String fileName, String savePath) {
		if (fileName != null && !"".equals(fileName)) {
			File f = new File(savePath + "/" + fileName);
			return f.delete();
		} else {
			return true;
		}
	}

	/**
	 * 默认截取15个字符
	 * 
	 * @param attachment
	 * @return 截取后字符串
	 */
	public static String getAttachment(String attachment) {
		return SRMUtil.getAttachment(attachment, 1000);
	}

	/**
	 * 获取标题
	 */
	public static String getTitle(String title, int length) {
		if (null != title && !"".equals(title)) {
			if (title.length() > length)
				return title.substring(0, length - 3) + "...";
			else
				return title;
		}
		return "-";
	}

	/**
	 * 默认显示30个字符
	 * 
	 * @param title
	 * @return
	 */
	public static String getTitle(String title) {
		return SRMUtil.getTitle(title, 30);
	}

	/**
	 * 获取所有的状态
	 * @param i
	 * @return
	 */
	public static List<Integer> getStates(int i) {
		if (0 == i)
			return null;
		List<Integer> states = new ArrayList<Integer>();
		while (i != 0) {
			states.add(i % 10);
			i /= 10;
		}
		return states;

	}
}
