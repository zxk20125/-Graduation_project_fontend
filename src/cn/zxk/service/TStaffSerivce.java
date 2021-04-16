package cn.zxk.service;

import cn.zxk.pojo.TStaff;

import java.util.List;

public interface TStaffSerivce {
	
	//查询员工
	List<TStaff> staffSelect();
	
	//根据id查询员工信息
	TStaff staffSelectById(int staff_id);
	
	//员工端登录
	TStaff staffLogin(String login_name,String password);
	
	//添加员工
	int staffInsert(String name,String login_name,String password,int age,String sex,String phone,String dot_name);
	
	//删除员工
	int staffDelete(int staffId);
	
	//修改员工信息
	int staffUpdate(int staff_id,String staff_name,String login_name,String password,int age,String sex,String phone,String dot_name);
}
