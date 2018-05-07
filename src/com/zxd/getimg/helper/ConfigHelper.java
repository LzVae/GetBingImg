package com.zxd.getimg.helper;

import java.util.Properties;

import com.zxd.getimg.constant.ConfigConstant;
import com.zxd.getimg.util.PropsUtil;




/**
* @Title: ConfigHelper.java  
* @Package com.zxd.getimg.helper  
* @Description: TODO
* @author zhuxindong  E-mail:501801307@qq.com
* @date 创建时间：2018年5月7日 下午8:34:04
* @version 1.0
*/

public final class ConfigHelper {
	
	/**
	 * 加载配置文件，文件名为"autumn-framework"
	 * @see ConfigConstant.CONFIG_PROPS
	 */
	private static final Properties CONFIG_PROPS = 
									PropsUtil.loadProps("config.properties");

	
	/**
	 * 获取JDBC驱动
	 */
	public static String getJDBCDriver() {
		
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_DRIVER);
		
	}
	
	/**
	 * 获取JDBC URL
	 */
	public static String getJDBCUrl() {
		
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_URL);
		
	}
	
	
	
	/**
	 * 获取 JDBC 用户名
	 */
	public static String getJDBCUserName() {

		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_USERNAME);
		
	}
	
	
	/**
	 * 获取 JDBC 密码
	 */
	public static String getJDBCPassWord() {
		
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_PASSWORD);
		
	}
	
	
	/**
	 * 获取 是否存放到磁盘
	 */
	public static String getStoreDisk() {
			
			return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.STORE_DISK);
			
	}
	
	
	/**
	 * 获取 是否存放到数据库
	 */
	public static String getStoreDB() {
			
			return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.STORE_DB);
			
	}
	
	
	
	/**
	 * 获取 存放到磁盘的路径
	 */
	public static String getDiskPath() {
			
			return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.DISK_PATH);
			
	}
	
	
}
