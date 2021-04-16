package cn.zxk.service;

import cn.zxk.pojo.TWaybill;

import java.util.List;

public interface TWaybillSerivce {

	//id查询
	TWaybill selectAllByWbId(String waybill_id);
	
	//查询
	List<TWaybill> selectAll();
	
	//统计数据条
	int dataCount(String waybill_id);
	
	//取消订单
	int quxiao(String waybill_id);
	
	//删除订单
	int shanchu(String waybill_id);
}
