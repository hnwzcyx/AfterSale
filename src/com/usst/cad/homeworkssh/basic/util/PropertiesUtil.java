package com.usst.cad.homeworkssh.basic.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesUtil {

	private static final String PROPERTIES_FILE = "system.properties";

	/**
	 * 
	 * @Title:        readData
	 * @Description:  读取指定键值的数据
	 * @param:        @param key
	 * @param:        @return   
	 * @return:       String   
	 * @author:       乔秋飞 
	 * Email:         1063157465@qq.com
	 * @throws
	 * @Date          2014-7-10 下午07:02:12
	 */
	public static String readData(String key) {
		Properties props = new Properties();
		try {
			InputStream in = Resources.getResourceAsStream(PROPERTIES_FILE);
			props.load(in);
			in.close();
			String value = props.getProperty(key);
			return value;
		} catch (FileNotFoundException e) {
			System.out.println("Properties File is not Found!");
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			System.out.println("Properties File Load Error!");
			e.printStackTrace();
			return "";
		}

	}
/**
 * 
 * @Title:        writeData
 * @Description:  增加一个指定键值的数据
 * @param:        @param key
 * @param:        @param value   
 * @return:       void   
 * @author:       乔秋飞 
 * Email:         1063157465@qq.com
 * @throws
 * @Date          2014-7-10 下午07:02:58
 */
	public static void writeData(String key, String value) {
		Properties props = new Properties();
		try {
			File file = Resources.getResourceAsFile(PROPERTIES_FILE);
			if (!file.exists()) {
				file.createNewFile();
			}
			InputStream in = new FileInputStream(file);
			props.load(in);
			in.close();
			OutputStream os = new FileOutputStream(Resources.getResourceAsFile(PROPERTIES_FILE));
			props.setProperty(key, value);
			props.store(os, "Update " + key + "' value");
			os.close();
		} catch (IOException e) {
		}
	}

}
