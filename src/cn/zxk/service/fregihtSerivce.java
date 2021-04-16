package cn.zxk.service;

import cn.zxk.pojo.TOrder;

import java.math.BigDecimal;

public interface fregihtSerivce {

//	//运费估算
//	String freightEstimate(String start_address,String end_address,int res_weight);
//	
//	//运费
//	BigDecimal getFreight(int res_weight,String res_sort,String start_address,String end_address,int insured_price);

	
	//运费估算(修改)
	BigDecimal getYunfeigusuan(int weight,String resSort,String start_address,String end_address);
	
	//运费计算
	BigDecimal getyunfei(TOrder order);
	
	//运费计算(修改)
	BigDecimal getYunfei(TOrder order);
}
