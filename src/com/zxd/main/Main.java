package com.zxd.main;

public class Main {
	
	
	public static void main(String[] args) {
		
		ImgUtil imgUtil = new ImgUtil();
		
		String imgurl = imgUtil.getImgUrl();
		
		imgUtil.saveImgOnDisk(imgurl);
		imgUtil.saveImgInDB(imgurl);
		
		
		
	}
		
		
		
		
	
	
	
	
	
}
