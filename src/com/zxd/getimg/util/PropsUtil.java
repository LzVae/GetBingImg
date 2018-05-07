package com.zxd.getimg.util;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;



/**
 * 
 * 属性文件助手类，封装了一些读取配置文件的通用方法
 * @author zhuxindong  E-mail:501801307@qq.com
 * @date 创建时间：2018年3月30日 下午2:54:15
 * @version 1.0
 */
public final class PropsUtil {
	
	
	
	/**
	 * 加载属性文件
	 * @param fileName
	 * @return
	 */
	public static Properties loadProps(String fileName) {
		
		Properties properties = null;
		InputStream is = null;
		
		try {
			is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
			
			if (is == null) {
				throw new FileNotFoundException(fileName+" file is not found");	
			}
			
			properties = new Properties();
			properties.load(is);	
			
		} catch (Exception e) {
			System.err.println("Load Properties File Failure,exception:"+e);
		}finally {
			if (is != null) {
				try {
					is.close();
				} catch (Exception e2) {
					System.err.println("Close Inputstream Failure,exception:"+e2);
				}
			}
		}
		
		return properties;
	}
	
	
	
	
	
	/**
	 * 获取字符串类型的属性，可以通过defaultValue指定默认值
	 * @param properties
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static String getString(Properties properties, String key, String defaultValue) {
		
		String value = defaultValue;
		if (properties.containsKey(key)) {
			value = properties.getProperty(key);
		}
		
		return value;
	}
	
	/**
	 * 获取字符串类型的属性，默认值为空字符串
	 * @param properties
	 * @param key
	 * @return
	 */
	public static String getString(Properties properties,String key) {
		
		return getString(properties, key, "");
		
	}
	
	
	
	
	
	
}
