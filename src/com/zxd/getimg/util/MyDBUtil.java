package com.zxd.getimg.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zxd.getimg.helper.ConfigHelper;

public class MyDBUtil {

	public static final String DRIVER_CLASS_NAME = ConfigHelper.getJDBCDriver();
    public static final String URL = ConfigHelper.getJDBCUrl();     
    public static final String USERNAME = ConfigHelper.getJDBCUserName();
    public static final String PASSWORD = ConfigHelper.getJDBCPassWord();

    // 注册数据库驱动
    static {
    	try {
             Class.forName(DRIVER_CLASS_NAME);
         } catch (ClassNotFoundException e) {
             System.out.println("注册失败！");
             e.printStackTrace();
         }
     }
 
     // 获取连接
     public static Connection getConn(){
    	 Connection connection =null;
    	 try {
			connection= DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
         return connection;
     }
     
     
     
 
     // 关闭连接
     public static void closeConn(Connection conn) {
         if (null != conn) {
             try {
                 conn.close();
             } catch (SQLException e) {
                 System.out.println("关闭连接失败！");
                 e.printStackTrace();
             }
         }
     }
	
	
	
	
	
	
}
