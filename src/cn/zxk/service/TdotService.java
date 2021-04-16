package cn.zxk.service;

import cn.zxk.pojo.TDot;

import java.util.List;

public interface TdotService {

	//通过所在城市查询网点信息
	List<TDot> dotByCity(String city);
	
	//查询全部
	List<TDot> dotselectAll();
	
	//id查询
	TDot dotselectById(int id);
	
	//修改
	int dotUpdate(TDot dot);
	
	//添加网点
	int dotInsert(TDot dot);
	
	//删除网点
	int dotDelete(int dotId);
	
	//根据网点名查询网点id
	Integer dotIdSelectByName(String dot_name);
	
	//根据网点名查询网点信息
	TDot selectByName(String dot_name);
}
