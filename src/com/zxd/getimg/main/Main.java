package com.zxd.getimg.main;

import com.zxd.getimg.helper.ConfigHelper;
import com.zxd.getimg.util.ImgUtil;

public class Main {
	
	
	public static void main(String[] args) {
		
		ImgUtil imgUtil = new ImgUtil();
		
		String imgurl = imgUtil.getImgUrl();
		if ("true".equals(ConfigHelper.getStoreDB())) {
			imgUtil.saveImgInDB(imgurl);
		}
		
		if ("true".equals(ConfigHelper.getStoreDisk())) {
			imgUtil.saveImgOnDisk(imgurl);
		}
		
	}
		
		
		
		
	
	
	
	
	
}
