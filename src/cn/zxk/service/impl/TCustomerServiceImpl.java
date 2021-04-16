package cn.zxk.service.impl;

import cn.zxk.mapper.TCustomerMapper;
import cn.zxk.pojo.TCustomer;
import cn.zxk.pojo.TCustomerExample;
import cn.zxk.pojo.TCustomerExample.Criteria;
import cn.zxk.service.TCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TCustomerServiceImpl implements TCustomerService {

	@Autowired
	private TCustomerMapper mapper;
	
	/* (non-Javadoc)
	 * @see cn.zxk.service.TCustomerService#CustomerLogin(java.lang.String, java.lang.String)
	 * 客户登录
	 * 返回客户信息
	 */
	@Override
	public TCustomer customerLogin(String login_name, String password) {
		TCustomerExample example = new TCustomerExample();
		Criteria criteria = example.createCriteria();
		criteria.andCustomerLoginNameEqualTo(login_name);
		criteria.andCustomerPasswordEqualTo(password);
		
		List<TCustomer> customerList = mapper.selectByExample(example);
		
		return (customerList!=null && !customerList.isEmpty())?customerList.get(0):null;
	}

	//修改个人信息
	@Override
	public int customerUpdate(TCustomer c) {
		return mapper.updateByPrimaryKeySelective(c);
	}

	
	/* (non-Javadoc)
	 * @see cn.zxk.service.TCustomerService#customerRegister(java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 *注册
	 */
	@Override
	public int customerRegister(TCustomer customer) {
		//验证是否存在改帐号
		TCustomerExample example = new TCustomerExample();
		example.createCriteria().andCustomerLoginNameEqualTo(customer.getCustomerLoginName());
		List<TCustomer> query = mapper.selectByExample(example);
		if(query!=null && !query.isEmpty()) {
			System.out.println("已经有帐号");
			return 0;
		}
		
		
//		TCustomer customer = new TCustomer();
//		customer.setCustomerLoginName(login_name);
//		customer.setCustomerPassword(password);
//		customer.setCustomerAge(age);
//		customer.setCustomerPhone(phone);
//		customer.setCustomerSex(sex);
//		
//		//身份证
//		customer.setCustomerName(name);
//		customer.setIdCardNo(id_card_no);
//		mapper.insertSelective(customer);
		int i = mapper.insertSelective(customer);
		return i;
	}

	//客户信息列表
	@Override
	public List<TCustomer> customerSelectAll() {
		TCustomerExample example = new TCustomerExample();
		return mapper.selectByExample(example);
	}

	//根据id查询查询
	@Override
	public TCustomer customerSelectById(int id) {
		return mapper.selectByPrimaryKey(id);
	}


}
