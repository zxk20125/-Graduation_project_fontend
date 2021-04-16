package cn.zxk.service.impl;

import cn.zxk.mapper.TSendMapper;
import cn.zxk.mapper.TWaybillMapper;
import cn.zxk.pojo.TSend;
import cn.zxk.pojo.TSendExample;
import cn.zxk.pojo.TWaybill;
import cn.zxk.service.TSendSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TSendSerivceImpl implements TSendSerivce {

	@Autowired
	private TSendMapper mapper;
	
	@Autowired
	private TWaybillMapper wbMapper;
	
	//派送
//	@Override
//	public int Deliver(String wall_id, int staff_id) {
//		TSend send = new TSend(null, wall_id, staff_id, new Date(), null, null, null,null);
//		return mapper.insertSelective(send);
//	}

	//签收或拒签
	@Override
	public int signforOrDeny(String wall_id,int sign_state,String reject_reasons) {
		TSendExample example = new TSendExample();
		example.setOrderByClause("send_time DESC");
		List<TSend> sendList = mapper.selectByExample(example);
		TSend sd = sendList.get(0);
		sd.setSignState(sign_state);
		sd.setStime(new Date());
		sd.setRejectReasons(reject_reasons);
		if(sign_state==0) {
			Date date = new Date();
			TWaybill waybill = new TWaybill();
			waybill.setWaybillId(wall_id);
			waybill.setPaymentTime(new Date());
			waybill.setFinishTime(new Date());
			
			wbMapper.updateByPrimaryKeySelective(waybill);
		}
		return mapper.updateByPrimaryKeySelective(sd);
	}

	//派送
	@Override
	public int Deliver(TSend send) {
		send.setSendTime(new Date());
		int i = mapper.insertSelective(send);
		return i;
	}

	@Override
	public int isnotsend(String wall_id) {
		TSendExample example = new TSendExample();
		example.createCriteria().andWaybillIdEqualTo(wall_id);
		List<TSend> selectByExample = mapper.selectByExample(example);
		for (TSend tSend : selectByExample) {
			return 1;
		}
		return 0;
	}

}
