package cn.zxk.service.impl;

import cn.zxk.mapper.TDotMapper;
import cn.zxk.mapper.TLogisticsMapper;
import cn.zxk.pojo.TDot;
import cn.zxk.pojo.TDotExample;
import cn.zxk.pojo.TLogistics;
import cn.zxk.pojo.TOrder;
import cn.zxk.service.TLogisticsSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TLogisticsSerivceImpl implements TLogisticsSerivce {

	@Autowired
	private TLogisticsMapper mapper;

	@Autowired
	private TDotMapper dotMapper;

	//更新物流
	@Override
	public int logisticsInsert(TLogistics logistics) {
		logistics.setTime(new Date());
		int i = mapper.insertSelective(logistics);
		return i;
	}

	@Override
	public int getDotId(TLogistics logistics) {
		TDotExample dotExample =new TDotExample();
		dotExample.createCriteria().andDotNameLike(logistics.getTargetDotName());
		return dotMapper.selectByExample(dotExample).get(0).getDotId();
	}

//	//更新物流
//	@Override
//	public int logisticsInsert(String waybill_id, int staff_id, String logistice_type, String start_dot_address,
//			String start_dot_name, String target_dot_address, String target_dot_name) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	
	//更新物流
//	@Override
//	public int logisticsInsert(String waybill_id, int staff_id, String logistice_type, String start_dot_address, String start_dot_name,
//			String target_dot_address, String target_dot_name) {
//		TLogistics logistics = new TLogistics(null, waybill_id, staff_id, logistice_type, start_dot_address, start_dot_name, target_dot_address, target_dot_name, new Date(),null);
//	
//		return mapper.insertSelective(logistics);
//	}

}
