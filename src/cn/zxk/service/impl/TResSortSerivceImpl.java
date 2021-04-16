package cn.zxk.service.impl;

import cn.zxk.mapper.TResSortMapper;
import cn.zxk.pojo.TResSort;
import cn.zxk.pojo.TResSortExample;
import cn.zxk.service.TResSortSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TResSortSerivceImpl implements TResSortSerivce {

	@Autowired
	private TResSortMapper mapper;
	
	// 查询
	@Override
	public List<TResSort> ssSelect() {
		TResSortExample example = new TResSortExample();
	return mapper.selectByExample(example);
	}
	
	// 添加
	@Override
	public int ssInsert(TResSort resSort) {
		//判断是否存在
		TResSortExample example = new TResSortExample();
		example.createCriteria().andResSortEqualTo(resSort.getResSort());
		List<TResSort> query = mapper.selectByExample(example);
		if(query!=null && !query.isEmpty()) {
			return 0;
		}
		
//		TResSort resSort = new TResSort();
//		resSort.setResSort(sort);
//		resSort.setResSortMoney(money);
		return mapper.insertSelective(resSort);
	}

	// 修改
	@Override
	public int ssUpdate(TResSort resSort) {
//		TResSort resSort = new TResSort(id, sort, money);
		return mapper.updateByPrimaryKeySelective(resSort);
	}
	
	// 删除(根据id)
	@Override
	public int ssDelete(int id) {
		return mapper.deleteByPrimaryKey(id);
	}

	//id查询
	@Override
	public TResSort selctById(int id) {
		return mapper.selectByPrimaryKey(id);
	}

}
