package cn.zxk.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class OrderIdByTime {
	
	public static String getOrderIdByTime() {
		Long timeStamp = System.currentTimeMillis();
		String stamp = timeStamp.toString();
		 String result="";
		 Random random=new Random();
	        for(int i=0;i<3;i++){
	            result+=random.nextInt(10);
	        }
	        return stamp+result;
	}
	
	public static String getWallBillIdByTime() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		 String newDate=sdf.format(new Date());
		 String result="";
	        Random random=new Random();
	        for(int i=0;i<2;i++){
	            result+=random.nextInt(10);
	        }
	        return "11"+newDate+result;
	}
}
