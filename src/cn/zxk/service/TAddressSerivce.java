package cn.zxk.service;

import cn.zxk.pojo.TAddress;

import java.util.List;

public interface TAddressSerivce {

	//根据地址角色（寄出人地址为0，收货人地址为1）查询地址
//	List<TAddress> addressSelectByRole(int role);
	
	//根据id查询地址信息
	TAddress addressSelectById(int id);
	
	//查询全部地址
	List<TAddress> addressSelectAll();
	
	//添加地址
	int addressInsert(TAddress address);
	
	//删除地址
	int addressDelete(int id);
	
	//根据客户ID查询
	List<TAddress> addressSelectByCustomerId(Integer customer_id);
	
	//修改
	int addressUpdate(TAddress address);
}
