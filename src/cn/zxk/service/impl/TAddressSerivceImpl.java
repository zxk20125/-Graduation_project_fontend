package cn.zxk.service.impl;

import cn.zxk.mapper.TAddressMapper;
import cn.zxk.mapper.TCustomerMapper;
import cn.zxk.pojo.TAddress;
import cn.zxk.pojo.TAddressExample;
import cn.zxk.pojo.TCustomer;
import cn.zxk.service.TAddressSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TAddressSerivceImpl implements TAddressSerivce {

	@Autowired
	private TAddressMapper mapper;
	
	@Autowired
	private TCustomerMapper cuMapper;
	
	//根据地址角色（寄出人地址为0，收货人地址为1）查询地址
//	@Override
//	public List<TAddress> addressSelectByRole(int role) {
//		TAddressExample example = new TAddressExample();
//		example.createCriteria().andRoleEqualTo(role);
//		List<TAddress> selectByExample = mapper.selectByExample(example);
//		for (TAddress tAddress : selectByExample) {
//			TCustomer customer = cuMapper.selectByPrimaryKey(tAddress.getCustomerId());
//			tAddress.setCustomer(customer);
//		}
//		return selectByExample;
//	}

	//根据id查询地址信息
	@Override
	public TAddress addressSelectById(int id) {
		return mapper.selectByPrimaryKey(id);
	}

	//查询全部地址
	@Override
	public List<TAddress> addressSelectAll() {
		TAddressExample example = new TAddressExample();
		List<TAddress> addressQuery = mapper.selectByExample(example);
		for (TAddress tAddress : addressQuery) {
			TCustomer customer = cuMapper.selectByPrimaryKey(tAddress.getCustomerId());
			tAddress.setCustomer(customer);
		}
		return addressQuery;
	}

	//添加地址
	@Override
	public int addressInsert(TAddress address) {
//		TAddress tAddress = new TAddress();
//		tAddress.setCustomerId(customer_id);
//		tAddress.setAddressName(name);
//		tAddress.setAddress(address);
//		tAddress.setPhone(phone);
////		tAddress.setRole(role);
		
		return mapper.insertSelective(address);
	}

	//删除地址
	@Override
	public int addressDelete(int id) {
		return mapper.deleteByPrimaryKey(id);
	}

	//根据客户ID查询
	@Override
	public List<TAddress> addressSelectByCustomerId(Integer customer_id) {
		if(customer_id==null) {
			return null;
		}
		TAddressExample example = new TAddressExample();
		example.createCriteria().andCustomerIdEqualTo(customer_id);
		List<TAddress> addressQuery = mapper.selectByExample(example);
		
		TCustomer customer = cuMapper.selectByPrimaryKey(customer_id);
		for (TAddress tAddress : addressQuery) {
			tAddress.setCustomer(customer);
		}
		return addressQuery;
	}

	//修改地址
	@Override
	public int addressUpdate(TAddress address) {
		int i = mapper.updateByPrimaryKeySelective(address);
		return i;
	}

}
