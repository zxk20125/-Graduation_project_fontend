package cn.zxk.service.impl;

import cn.zxk.mapper.TShipAddressMapper;
import cn.zxk.pojo.TShipAddress;
import cn.zxk.pojo.TShipAddressExample;
import cn.zxk.pojo.TShipAddressExample.Criteria;
import cn.zxk.service.TShipAddressSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TShipAddressSerivceImpl implements TShipAddressSerivce {

	@Autowired
	private TShipAddressMapper mapper;
	
	//查询全部运送地址定价
	@Override
	public List<TShipAddress> saSelect() {
		TShipAddressExample example = new TShipAddressExample();
		return mapper.selectByExample(example);
	}

	//添加运送地址定价
	@Override
	public int saInsert(TShipAddress shipAddress) {
		//判断是否已经存在
		TShipAddressExample example = new TShipAddressExample();
		Criteria criteria = example.createCriteria();
		criteria.andStartAddressEqualTo(shipAddress.getStartAddress());
		criteria.andEndAddressEqualTo(shipAddress.getEndAddress());
		
		List<TShipAddress> saquery = mapper.selectByExample(example);
		//如果存在就返回0
		if(saquery!=null && !saquery.isEmpty()) {
			return 0;
		}
	
		
		return mapper.insertSelective(shipAddress);
	}

	//修改
	@Override
	public int saUpdate(TShipAddress shipAddress) {
		return mapper.updateByPrimaryKeySelective(shipAddress);
	}

	//删除(根据id)
	@Override
	public int saDelete(int sa_id) {
		return mapper.deleteByPrimaryKey(sa_id);
	}

	//id查询
	@Override
	public TShipAddress selectById(int id) {
		
		return mapper.selectByPrimaryKey(id);
	}

}
