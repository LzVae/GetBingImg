package com.zxd.getimg.constant;

/**
 * 定义一些常量
* @Title: ConfigConstant.java  
* @Package com.zxd.getimg.constant  
* @Description: TODO
* @author zhuxindong  E-mail:501801307@qq.com
* @date 创建时间：2018年5月7日 下午8:10:48
* @version 1.0
*/

public interface ConfigConstant {

	/**
	 * JDBC相关配置
	 */
	String JDBC_DRIVER = "jdbc.driver";
	
	String JDBC_URL = "jdbc.url";
	
	String JDBC_USERNAME = "jdbc.username";
	
	String JDBC_PASSWORD = "jdbc.password";
	
	/**
	 * 是否储存在磁盘
	 */
	String STORE_DISK = "store.disk";
	
	
	/**
	 * 是否储存到数据库
	 */
	String STORE_DB = "store.db";
	
	
	/**
	 * 存放在磁盘上的路径
	 */
	String DISK_PATH = "disk.path";
	
	
	
	
}
