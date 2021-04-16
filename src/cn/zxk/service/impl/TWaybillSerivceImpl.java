package cn.zxk.service.impl;

import cn.zxk.mapper.*;
import cn.zxk.pojo.*;
import cn.zxk.service.TOrderSerivce;
import cn.zxk.service.TWaybillSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TWaybillSerivceImpl implements TWaybillSerivce {

	@Autowired
	private TWaybillMapper mapper;

	@Autowired
	private TOrderMapper orMapper;

	@Autowired
	private TCustomerMapper cuMapper;
	
	@Autowired
	private TStaffMapper stMapper;
	
	@Autowired
	private TLogisticsMapper loMapper;

	@Autowired
	private TSendMapper seMapper;

	@Autowired
	private TOrderSerivce orSerivce;
	
	@Autowired
	private TDotMapper dotMapper;
	
//	@Override
//	public TWaybill selectAllByWbId(String waybill_id) {
////		List<TWaybill> waybill = new ArrayList();
//		TWaybill waybill = new TWaybill();
//
//		TWaybillExample wbep = new TWaybillExample();
//		List<TWaybill> wbList = mapper.selectByExample(wbep);
//
//		for (TWaybill tWaybill : wbList) {
//			String orderId = tWaybill.getOrderId();
//			TOrder od = new TOrder();
//			od.setOrderId(orderId);
//			TOrder order = orMapper.selectByPrimaryKey(orderId);
//			tWaybill.setOrder(order);
//			if (tWaybill.getWaybillId().equals(waybill_id)) {
//				waybill = tWaybill;
//			}
//		}
//
//		TLogisticsExample loep = new TLogisticsExample();
//		loep.setOrderByClause("time DESC");
//		loep.createCriteria().andWaybillIdEqualTo(waybill_id);
//		List<TLogistics> loList = loMapper.selectByExample(loep);
//		waybill.setLogistics(loList);
//		
//		
//		TSendExample seep = new TSendExample();
//		seep.setOrderByClause("stime DESC");
//		seep.createCriteria().andWaybillIdEqualTo(waybill_id);
//		List<TSend> seList = seMapper.selectByExample(seep);
//		
//		waybill.setSend(seList);
//		
////		System.out.println("///"+waybill);
//		return waybill;
//	}

	@Override
	public int dataCount(String waybill_id) {
		
		TWaybill waybill = mapper.selectByPrimaryKey(waybill_id);
		TOrderExample orep = new TOrderExample();
		orep.createCriteria().andOrderIdEqualTo(waybill.getOrderId());
		orep.setOrderByClause("waybill_id DESC");
		long l = orMapper.countByExample(orep);
		
		TLogisticsExample loep = new TLogisticsExample();
		loep.createCriteria().andWaybillIdEqualTo(waybill_id);
		long m = loMapper.countByExample(loep);
		
		TSendExample seep = new TSendExample();
		seep.createCriteria().andWaybillIdEqualTo(waybill_id);
		long n = seMapper.countByExample(seep);
		
		return Integer.parseInt(String.valueOf(l+m+n));
	}

//	@Override
//	public List<TWaybill> selectAll() {
//		TWaybillExample example = new TWaybillExample();
//		
//		return mapper.selectByExample(example);
//	}

	//查询
	@Override
	public List<TWaybill> selectAll() {
		TWaybillExample waep = new TWaybillExample();
		waep.setOrderByClause("waybill_id DESC");
		List<TWaybill> waybills = mapper.selectByExample(waep);
		for (TWaybill tWaybill : waybills) {
			List<TOrder> orders = orSerivce.orderSelect();
			for (TOrder tOrder : orders) {
				if(tOrder.getOrderId().equals(tWaybill.getOrderId())) {
					tWaybill.setOrder(tOrder);
				}
			}
			
		}
		return waybills;
	}

	@Override
	public TWaybill selectAllByWbId(String waybill_id) {
		TWaybill waybill = mapper.selectByPrimaryKey(waybill_id);
		String orderId = waybill.getOrderId();
		TOrder order = orMapper.selectByPrimaryKey(orderId);
		TCustomer customer = cuMapper.selectByPrimaryKey(order.getCustmerId());
		order.setCustomer(customer);
		if(order.getStaffId()!=null) {
		TStaff staff = stMapper.selectByPrimaryKey(order.getStaffId());
		
		TDot d = dotMapper.selectByPrimaryKey(staff.getDotId());
		staff.setDot(d);
		
		order.setStaff(staff);
	}
		waybill.setOrder(order);
		
		TLogisticsExample loep = new TLogisticsExample();
		loep.setOrderByClause("time DESC");
		loep.createCriteria().andWaybillIdEqualTo(waybill_id);
		List<TLogistics> logisticsList = loMapper.selectByExample(loep);
		for (TLogistics tLogistics : logisticsList) {
			TStaff staff2 = stMapper.selectByPrimaryKey(tLogistics.getStaffId());
			tLogistics.setStaff(staff2);
		}
		waybill.setLogistics(logisticsList);
		
		TSendExample seep = new TSendExample();
		seep.createCriteria().andWaybillIdEqualTo(waybill_id);
		seep.setOrderByClause("send_time DESC");
		List<TSend> sendList = seMapper.selectByExample(seep);
		for (TSend tSend : sendList) {
			TStaff staff3 = stMapper.selectByPrimaryKey(tSend.getStaffId());
			tSend.setStaff(staff3);
		}
		waybill.setSend(sendList);
		
		return waybill;
	}

	//取消订单
	@Override
	public int quxiao(String waybill_id) {
		TWaybill tWaybill = new TWaybill();
		tWaybill.setWaybillId(waybill_id);
		tWaybill.setCancelTime(new Date());
		int i = mapper.updateByPrimaryKeySelective(tWaybill);
		return i;
	}

	//删除订单
	@Override
	public int shanchu(String waybill_id) {
		TSendExample sp = new TSendExample();
		sp.createCriteria().andWaybillIdEqualTo(waybill_id);
		int i ;
		i = seMapper.deleteByExample(sp);
		
		TLogisticsExample lp = new TLogisticsExample();
		lp.createCriteria().andWaybillIdEqualTo(waybill_id);
		i = loMapper.deleteByExample(lp);
		
		TWaybill waybill = mapper.selectByPrimaryKey(waybill_id);
		String orderId = waybill.getOrderId();
		
		i = mapper.deleteByPrimaryKey(waybill_id);
		
		orMapper.deleteByPrimaryKey(orderId);
		
		return i;
	}
	
	
}
