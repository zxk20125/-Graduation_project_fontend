package cn.zxk.service.impl;

import cn.zxk.mapper.TResWeightMapper;
import cn.zxk.pojo.TResWeight;
import cn.zxk.pojo.TResWeightExample;
import cn.zxk.service.TResWeightSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TResWeightSerivceImpl implements TResWeightSerivce {

	@Autowired
	private TResWeightMapper mapper;
	
	@Override
	public List<TResWeight> Select() {
		TResWeightExample example = new TResWeightExample();
		return mapper.selectByExample(example);
	}

	@Override
	public int Insert(TResWeight resWeight) {
		//判断是否存在
		TResWeightExample example = new TResWeightExample();
		example.createCriteria().andResWeightEqualTo(resWeight.getResWeight());
		List<TResWeight> query = mapper.selectByExample(example);
		if(query!=null && !query.isEmpty()) {
			return 0;
		}
//		TResWeight resWeight = new TResWeight();
//		resWeight.setResWeight(weight);
//		resWeight.setResWeightMoney(money);
		
		return mapper.insertSelective(resWeight);
	}

	@Override
	public int Update(TResWeight resWeight) {
//		TResWeight resWeight = new TResWeight(id, weight, money);
		return mapper.updateByPrimaryKeySelective(resWeight);
	}

	@Override
	public int Delete(int id) {
		return mapper.deleteByPrimaryKey(id);
	}

	//id查询
	@Override
	public TResWeight selectById(int id) {
		return mapper.selectByPrimaryKey(id);
	}

}
