package cn.zxk.service;

import cn.zxk.pojo.TResSort;

import java.util.List;

public interface TResSortSerivce {

	// 查询
	List<TResSort> ssSelect();

	// 添加
	int ssInsert(TResSort resSort);

	// 修改
	int ssUpdate(TResSort resSort);

	// 删除(根据id)
	int ssDelete(int id);
	
	//id查询
	TResSort selctById(int id);
}
