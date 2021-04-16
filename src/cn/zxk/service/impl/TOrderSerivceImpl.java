package cn.zxk.service.impl;

import cn.zxk.mapper.TCustomerMapper;
import cn.zxk.mapper.TDotMapper;
import cn.zxk.mapper.TOrderMapper;
import cn.zxk.mapper.TWaybillMapper;
import cn.zxk.pojo.*;
import cn.zxk.service.TOrderSerivce;
import cn.zxk.service.TdotService;
import cn.zxk.service.fregihtSerivce;
import cn.zxk.util.OrderIdByTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TOrderSerivceImpl implements TOrderSerivce {

	@Autowired
	private TOrderMapper mapper;

	@Autowired
	private TWaybillMapper wbMapper;

	@Autowired
	private fregihtSerivce fserivce;

	@Autowired
	private TCustomerMapper cuMapper;

	@Autowired
	private TDotMapper dotMapper;
	
	// 下单
//	@Override
//	public int doOrder(int customer_id, int dot_id, String mailing_address, String receiving_address, int weight,
//			String res_sort, int insured_price, String payment_method, String remarks) {
//
//		// 运费计算
//		String start_address = mailing_address.substring(0, 9);
//		String end_address = receiving_address.substring(0, 9);
//
//		BigDecimal freight = fserivce.getFreight(weight, res_sort, start_address, end_address, insured_price);
//
//		// 订单id
//		String order_id = OrderIdByTime.getOrderIdByTime();
//		TOrder order = new TOrder(order_id, customer_id, dot_id, null, mailing_address, receiving_address, weight,
//				res_sort, insured_price, freight, payment_method, remarks, new Date(),null,null,null);
//
//		int i = 0;
//		i = mapper.insertSelective(order);
//
//		// 运单id
//		String waybill_id = OrderIdByTime.getWallBillIdByTime();
//		TWaybill waybill = new TWaybill();
//		if (payment_method.equals("在线支付")) {
////			new TWaybill(waybillId, orderId, confirmTime, receiptTime, paymentTime, cancelTime, finishTime, order, logistics, send)
////			waybill = new TWaybill(waybill_id, order_id, null, null, new Date(), null, null);
//			waybill.setWaybillId(waybill_id);
//			waybill.setOrderId(order_id);
//			waybill.setPaymentTime(new Date());
//		} else {		
//			waybill.setWaybillId(waybill_id);
//			waybill.setOrderId(order_id);
//		}
//		i = wbMapper.insertSelective(waybill);
//
//		return i;
//	}

	// 接单
//	@Override
//	public int orderTaking(String waybill_id, int staff_id) {
//
//		int i = 0;
//
//		// 运单表插入接单时间
//		TWaybill waybill = new TWaybill();
//		waybill.setWaybillId(waybill_id);
//		waybill.setReceiptTime(new Date());
//		i = wbMapper.updateByPrimaryKeySelective(waybill);
//
//		TWaybill wb = wbMapper.selectByPrimaryKey(waybill_id);
//
//		// 订单表插入员工id
//		String order_id = wb.getOrderId();
//
//		TOrder order = new TOrder();
//		order.setOrderId(order_id);
//		order.setStaffId(staff_id);
//		i = mapper.updateByPrimaryKeySelective(order);
//		return i;
//	}

	// 付款
//	@Override
//	public int paymentUpadate(String waybill_id) {
//		TWaybill waybill = new TWaybill();
//		waybill.setWaybillId(waybill_id);
//		waybill.setPaymentTime(new Date());
//		return wbMapper.updateByPrimaryKeySelective(waybill);
//	}

	// 员工确认收件
//	@Override
//	public int confirmUpadate(String waybill_id) {
//		TWaybill waybill = new TWaybill();
//		waybill.setWaybillId(waybill_id);
//		waybill.setConfirmTime(new Date());
//		return wbMapper.updateByPrimaryKeySelective(waybill);
//	}

	// 取消订单
//	@Override
//	public int cancelUpadate(String waybill_id) {
//		TWaybill waybill = new TWaybill();
//		waybill.setWaybillId(waybill_id);
//		waybill.setCancelTime(new Date());
//		wbMapper.updateByPrimaryKeySelective(waybill);
//		return 0;
//	}

	// 完成订单
//	@Override
//	public int finishUpadate(String waybill_id) {
//		TWaybill waybill = new TWaybill();
//		waybill.setWaybillId(waybill_id);
//		waybill.setFinishTime(new Date());
//		wbMapper.updateByPrimaryKeySelective(waybill);
//		return 0;
//	}

	//查询订单
	@Override
	public List<TOrder> orderSelect() {
		TOrderExample example = new TOrderExample();
		
		List<TOrder> orders = mapper.selectByExample(example);
		for (TOrder tOrder : orders) {
			TCustomer customer = cuMapper.selectByPrimaryKey(tOrder.getCustmerId());
			tOrder.setCustomer(customer);
			TWaybillExample wbep = new TWaybillExample();
			wbep.createCriteria().andOrderIdEqualTo(tOrder.getOrderId());
			List<TWaybill> waybillquery = wbMapper.selectByExample(wbep);
			tOrder.setWaybill(waybillquery.get(0));
		}
		return orders;
	}

	//订单id查询
	@Override
	public TOrder orderSelectById(String order_id) {
		return mapper.selectByPrimaryKey(order_id);
	}

	//下单
	@Override
	public int doOrder(TOrder order) {
		String dot_name = order.getSenderAddress().substring(7, 9);
		TDotExample example=new TDotExample();
		example.createCriteria().andDotNameLike("%"+dot_name+"%");
		TDot tDot = dotMapper.selectByExample(example).get(0);
		Date date = new Date();
		String order_id = OrderIdByTime.getOrderIdByTime();
		order.setOrderId(order_id);
		order.setOrderTime(date);
		order.setDotId(tDot.getDotId());

		int i = 0;
		i = mapper.insertSelective(order);
		
		// 运单id
		String waybill_id = OrderIdByTime.getWallBillIdByTime();
		TWaybill waybill = new TWaybill();
		if (order.getPaymentMethod().equals("在线支付")) {
//			new TWaybill(waybillId, orderId, confirmTime, receiptTime, paymentTime, cancelTime, finishTime, order, logistics, send)
//			waybill = new TWaybill(waybill_id, order_id, null, null, new Date(), null, null, null, null, null);
			waybill.setWaybillId(waybill_id);
			waybill.setOrderId(order_id);
			waybill.setPaymentTime(date);
			
		} else {		
			waybill.setWaybillId(waybill_id);
			waybill.setOrderId(order_id);
		}
		i = wbMapper.insertSelective(waybill);
		return i;
	}

	
	//接单
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int jiedan(String orderId, Integer staffId) {
		try {
			TOrder order = new TOrder();
			order.setOrderId(orderId);
			order.setStaffId(staffId);
			if (mapper.updateByPrimaryKeySelective(order)==0) throw new Exception("订单更新失败");
			TWaybill waybill = new TWaybill();
			waybill.setReceiptTime(new Date());
			TWaybillExample example = new TWaybillExample();
			example.createCriteria().andOrderIdEqualTo(orderId);
			if(wbMapper.updateByExampleSelective(waybill, example)==0)throw new Exception("运单更新失败");
			return 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}

	//揽件
	@Override
	public int lanjian(String order_id) {
		TWaybill waybill = new TWaybill();
		waybill.setConfirmTime(new Date());
		TWaybillExample example = new TWaybillExample();
		example.createCriteria().andOrderIdEqualTo(order_id);
		int  i = wbMapper.updateByExampleSelective(waybill, example);
		return i;
	}

	@Override
	public int updateBylanjian(TOrder order) {
		int i = mapper.updateByPrimaryKeySelective(order);
		return i;
	}
	
	
}
