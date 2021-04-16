package cn.zxk.service;

import cn.zxk.pojo.TShipAddress;

import java.util.List;

public interface TShipAddressSerivce {

	//查询全部运送地址定价
	List<TShipAddress> saSelect();
	
	//id查询
	TShipAddress selectById(int id);
	
	//添加运送地址定价
	int saInsert(TShipAddress shipAddress);
	
	//修改
	int saUpdate(TShipAddress shipAddress);
	
	//删除(根据id)
	int saDelete(int sa_id);
}
