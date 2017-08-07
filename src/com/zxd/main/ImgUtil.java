package com.zxd.main;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ImgUtil {
	
	
	
	public String getImgUrl(){
		
		String realimgurl = null;
		try{
			URL url=new URL("http://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1&mkt=zh-CN");
			
			InputStreamReader in=new InputStreamReader(url.openStream(),"UTF-8");
			
			BufferedReader buffin=new BufferedReader(in);
			
			String html;
			
			html=buffin.readLine();
//			System.out.println(html);
				
			String imgurl=html.split("\"url\":\"/")[1].split("\"")[0];

			realimgurl="http://cn.bing.com/"+imgurl;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return realimgurl;		
	}
	
	
	
	public void saveImgOnDisk(String urlString){
		
		try {
			Date date = new Date();
			SimpleDateFormat  simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");  
			String date_today = simpleDateFormat.format(date);
			String imageName = "bingimg_"+ date_today+".jpg";
		
			URL url = new URL(urlString);  
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
			
            FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName)); 
			
            byte[] buffer = new byte[1024];  
            int length;  

            while ((length = dataInputStream.read(buffer)) > 0) {  
                fileOutputStream.write(buffer, 0, length);  
            }  

            dataInputStream.close();  
            fileOutputStream.close();  
            System.out.println("save success！");
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	public void saveImgInDB(String urlString){
		Connection conn = null;
		try {
			
			URL url = new URL(urlString);
			
			conn = MyDBUtil.getConn();
			
			Date date = new Date();
			SimpleDateFormat  simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");  
//			System.out.println(simpleDateFormat.format(date));
			
			String sql = "insert into bing_img (img,img_date)values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setBinaryStream(1, url.openStream(), (long)url.openStream().available());
			ps.setDate(2,new java.sql.Date(new Date().getTime()));
			
			int count = ps.executeUpdate();
            if (count > 0) {
                System.out.println("插入成功！"+ simpleDateFormat.format(date));
            } else {
               System.out.println("插入失败！"+ simpleDateFormat.format(date));
            }
			
			ps.close();
		} catch (Exception e) {
			// TODO Auto-generated catch blocke.printStackTrace();
			e.printStackTrace();
		}finally {
			MyDBUtil.closeConn(conn);
	
		}
		
		
	}
	
	
	
}
