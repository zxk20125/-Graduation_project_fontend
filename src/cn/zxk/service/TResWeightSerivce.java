package cn.zxk.service;

import cn.zxk.pojo.TResWeight;

import java.util.List;

public interface TResWeightSerivce {
	// 查询
		List<TResWeight> Select();

		// 添加
		int Insert(TResWeight resWeight);

		// 修改
		int Update(TResWeight resWeight);

		// 删除(根据id)
		int Delete(int id);
		
		//id查询
		TResWeight selectById(int id);
}
