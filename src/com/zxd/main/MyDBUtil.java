package com.zxd.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDBUtil {

	public static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://115.159.82.98:3306/jwxt";     
    public static final String USERNAME = "root";
    public static final String PASSWORD = "8200506";

    // ע�����ݿ�����
    static {
    	try {
             Class.forName(DRIVER_CLASS_NAME);
         } catch (ClassNotFoundException e) {
             System.out.println("ע��ʧ�ܣ�");
             e.printStackTrace();
         }
     }
 
     // ��ȡ����
     public static Connection getConn(){
    	 Connection connection =null;
    	 try {
			connection= DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
         return connection;
     }
     
     
     
 
     // �ر�����
     public static void closeConn(Connection conn) {
         if (null != conn) {
             try {
                 conn.close();
             } catch (SQLException e) {
                 System.out.println("�ر�����ʧ�ܣ�");
                 e.printStackTrace();
             }
         }
     }
	
	
	
	
	
	
}
