package cn.zxk.service;

import cn.zxk.pojo.TSend;

public interface TSendSerivce {

	//派送
	int Deliver(TSend send);
	
	//签收或拒签
	int signforOrDeny(String wall_id,int sign_state,String reject_reasons);
	
	//检查是否有设置派送
	int isnotsend(String wall_id);
}
