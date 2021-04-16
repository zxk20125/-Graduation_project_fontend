package cn.zxk.service.impl;

import cn.zxk.mapper.TDotMapper;
import cn.zxk.mapper.TStaffMapper;
import cn.zxk.pojo.TDot;
import cn.zxk.pojo.TStaff;
import cn.zxk.pojo.TStaffExample;
import cn.zxk.pojo.TStaffExample.Criteria;
import cn.zxk.service.TStaffSerivce;
import cn.zxk.service.TdotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TStaffSerivceImpl implements TStaffSerivce {

	@Autowired
	private TStaffMapper mapper;
	
	@Autowired
	private TdotService dService;
	
	@Autowired
	private TDotMapper doMapper;
	
	/* (non-Javadoc)
	 * @see cn.zxk.service.TStaffSerivce#staffSelect()
	 * 查询全部员工信息
	 */
	@Override
	public List<TStaff> staffSelect() {
		TStaffExample example = new TStaffExample();
		List<TStaff> staff = mapper.selectByExample(example);
		for (TStaff tStaff : staff) {
			TDot dot = doMapper.selectByPrimaryKey(tStaff.getDotId());
			tStaff.setDot(dot);
		}
		
		return staff;
	}
	
	/* (non-Javadoc)
	 * @see cn.zxk.service.TStaffSerivce#staffSelectById(int)
	 * 根据id查询员工信息
	 */
	@Override
	public TStaff staffSelectById(int staff_id) {
		TStaff staff = mapper.selectByPrimaryKey(staff_id);
		TDot dot = doMapper.selectByPrimaryKey(staff.getDotId());
		staff.setDot(dot);
		return staff;
	}
	
	/* (non-Javadoc)
	 * @see cn.zxk.service.TStaffSerivce#staffLogin(java.lang.String, java.lang.String)
	 * 员工登录
	 */
	@Override
	public TStaff staffLogin(String login_name, String password) {
		TStaffExample example = new TStaffExample();
		example.setDistinct(true);
		Criteria criteria = example.createCriteria();
		criteria.andStaffLoginNameEqualTo(login_name);
		criteria.andStaffPasswordEqualTo(password);
		
		List<TStaff> staffQuery = mapper.selectByExample(example);
		
		return (staffQuery!=null&&!staffQuery.isEmpty())?staffQuery.get(0):null;
	}


	/* (non-Javadoc)
	 * @see cn.zxk.service.TStaffSerivce#staffInsert(java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String)
	 * 添加员工
	 */
	@Override
	public int staffInsert(String name, String login_name,String password, int age, String sex, String phone,String dot_name) {
		TStaffExample example = new TStaffExample();
		example.createCriteria().andStaffLoginNameEqualTo(login_name);
		List<TStaff> squery = mapper.selectByExample(example);
		if(squery!=null && !squery.isEmpty()) {
			return 0;
		}
		TStaff staff = new TStaff();
		staff.setStaffName(name);
		staff.setStaffLoginName(login_name);
		staff.setStaffPassword(password);
		staff.setStaffAge(age);
		staff.setStaffSex(sex);
		staff.setStaffPhone(phone);
		staff.setHiredate(new Date());
		
		int dot_id=0;
		
		dot_id = dService.dotIdSelectByName(dot_name);
		
		staff.setDotId(dot_id);
		
		return mapper.insert(staff);
	}


	/* (non-Javadoc)
	 * @see cn.zxk.service.TStaffSerivce#staffDelete(int)
	 * 删除员工
	 */
	@Override
	public int staffDelete(int staffId) {
		return mapper.deleteByPrimaryKey(staffId);
	}


	/* (non-Javadoc)
	 * @see cn.zxk.service.TStaffSerivce#staffUpdate()
	 * 修改员工信息
	 */
	@Override
	public int staffUpdate(int staff_id,String staff_name,String login_name,String password,int age,String sex,String phone,String dot_name) {
		Integer dot_id = null;
		
		dot_id = dService.dotIdSelectByName(dot_name);
		System.out.println(dot_id+"00");
		TStaff staff = new TStaff(staff_id, staff_name, login_name, password, age, sex, phone, null, dot_id,null);
		int i = mapper.updateByPrimaryKeySelective(staff);
		return i;
	}

}
