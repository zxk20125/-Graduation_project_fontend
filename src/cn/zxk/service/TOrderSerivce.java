package cn.zxk.service;

import cn.zxk.pojo.TOrder;
import cn.zxk.pojo.TStaff;

import java.util.List;

public interface TOrderSerivce {
	
	//下单
//	int doOrder(int customer_id,int dot_id,String mailing_address,String receiving_address,int weight,String res_sort,int insured_price,String payment_method,String remarks);
	
	//接单
//	int orderTaking(String waybill_id,int staff_id);
	
	//付款
//	int paymentUpadate(String waybill_id);
//	
//	//员工确认收件
//	int confirmUpadate(String waybill_id);
//	
//	//取消订单
//	int cancelUpadate(String waybill_id);
//	
//	//完成订单
//	int finishUpadate(String waybill_id);
	
	//订单查询
	List<TOrder> orderSelect();
	
	//订单id查询
	TOrder orderSelectById(String order_id);
	
	//下单
	int doOrder(TOrder order);
	
	//接单
	int jiedan(String order_id,Integer staffId);
	
	//揽件
	int lanjian(String order_id);
	
	//更新
	int updateBylanjian(TOrder order);
}
