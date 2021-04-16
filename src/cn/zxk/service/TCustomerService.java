package cn.zxk.service;


import cn.zxk.pojo.TCustomer;

import java.util.List;


public interface TCustomerService {
	    
	    //登录
	    TCustomer customerLogin(String login_name , String password);
	    
	    //客户信息列表
	    List<TCustomer> customerSelectAll();
	    
	    //根据id查询查询
	    TCustomer customerSelectById(int id);
	    
	    //修改个人信息
	    int customerUpdate(TCustomer c);

	    //注册
	    int customerRegister(TCustomer customer);
	    
}
