package cn.zxk.service;

import cn.zxk.pojo.TLogistics;

public interface TLogisticsSerivce {

//	//更新物流
//	int logisticsInsert(String waybill_id,int staff_id,String logistice_type,String start_dot_address,String start_dot_name,String target_dot_address,String target_dot_name);

	//更新物流
	int logisticsInsert(TLogistics logistics);

	int getDotId(TLogistics logistics);
}
