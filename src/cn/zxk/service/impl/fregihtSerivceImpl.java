package cn.zxk.service.impl;

import cn.zxk.mapper.TResSortMapper;
import cn.zxk.mapper.TResWeightMapper;
import cn.zxk.mapper.TShipAddressMapper;
import cn.zxk.pojo.*;
import cn.zxk.pojo.TShipAddressExample.Criteria;
import cn.zxk.service.fregihtSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Lu
 *
 */
@Service
public class fregihtSerivceImpl implements fregihtSerivce {

	@Autowired
	private TShipAddressMapper asMapper;

	@Autowired
	private TResWeightMapper weightMapper;

	@Autowired
	private TResSortMapper rsMapper;

//	@Override
//	public String freightEstimate(String start_address, String end_address, int res_weight) {
//		// 运送地址运费
//		BigDecimal asMoney = new BigDecimal(0);
//
//		TShipAddressExample addressExample = new TShipAddressExample();
//		Criteria cShipAddress = addressExample.createCriteria();
//		cShipAddress.andStartAddressEqualTo(start_address);
//		cShipAddress.andEndAddressEqualTo(end_address);
//		List<TShipAddress> asQuery = asMapper.selectByExample(addressExample);
//		if (asQuery != null && !asQuery.isEmpty()) {
//			for (TShipAddress tShipAddress : asQuery) {
//				asMoney = tShipAddress.getShipAddressMoney();
//			}
//		}
//
//		// 重量运费
//		BigDecimal wMoney = new BigDecimal(0);
//		TResWeightExample WeightExample = new TResWeightExample();
//		WeightExample.setOrderByClause("res_weight ASC");
//		List<TResWeight> wQuery = weightMapper.selectByExample(WeightExample);
//		for (TResWeight tResWeight : wQuery) {
//			wMoney = tResWeight.getResWeightMoney();
//			if (tResWeight.getResWeight() >= res_weight) {
//				break;
//			}
//		}
//		BigDecimal freight = asMoney.add(wMoney);
//
//		return freight.toString();
//	}
//
//	// 计算运费
//	@Override
//	public BigDecimal getFreight(int res_weight, String res_sort, String start_address, String end_address,
//			int insured_price) {
//		// 运送地址运费
//		BigDecimal asMoney = new BigDecimal(0);
//
//		TShipAddressExample addressExample = new TShipAddressExample();
//		Criteria cShipAddress = addressExample.createCriteria();
//		cShipAddress.andStartAddressEqualTo(start_address);
//		cShipAddress.andEndAddressEqualTo(end_address);
//		List<TShipAddress> asList = asMapper.selectByExample(addressExample);
//		
//		if (asList != null && !asList.isEmpty()) {
//			for (TShipAddress tShipAddress : asList) {
//				asMoney = tShipAddress.getShipAddressMoney();
//			}
//		}
//
//		// 重量运费
//		BigDecimal wMoney = new BigDecimal(0);
//		TResWeightExample WeightExample = new TResWeightExample();
//		WeightExample.setOrderByClause("res_weight ASC");
//		List<TResWeight> wQuery = weightMapper.selectByExample(WeightExample);
//		for (TResWeight tResWeight : wQuery) {
//			wMoney = tResWeight.getResWeightMoney();
//			if (tResWeight.getResWeight() >= res_weight) {
//				break;
//			}
//		}
//		
//		//物品类别定价
//		BigDecimal rsMoney = new BigDecimal(0);
//		TResSortExample example = new TResSortExample();
//		example.createCriteria().andResSortEqualTo(res_sort);
//		List<TResSort> selectByExample = rsMapper.selectByExample(example);
//		for (TResSort tResSort : selectByExample) {
//			rsMoney = tResSort.getResSortMoney();
//		}
//		
//		//是否保价
//		BigDecimal ipMoney = new BigDecimal(0);
//		if(insured_price==1) {
//			ipMoney = new BigDecimal(2) ;
//		}
//		
//		
//		return asMoney.add(wMoney).add(rsMoney).add(ipMoney);
//	}

	
	//运费预估
	@Override
	public BigDecimal getYunfeigusuan(int weight, String resSort, String start_address, String end_address) {
		
		BigDecimal sortMoney = new BigDecimal(0);
		BigDecimal asMoney = new BigDecimal(0);
		// 重量计算（修改前）
//		TResWeight resWeight = new TResWeight();
//		TResWeightExample wep = new TResWeightExample();
//		wep.createCriteria().andResWeightEqualTo(weight);
//		List<TResWeight> selectByExample = weightMapper.selectByExample(wep);
//		if (selectByExample != null && !selectByExample.isEmpty()) {
//			for (TResWeight tResWeight : selectByExample) {
//				resWeight = tResWeight;
//			}
//		}
//		weightMoney = resWeight.getResWeightMoney();

		//重量计算（修改后）
		int wm;
		if(weight==1) {
			wm = 6;
		}else if(weight==0){
			wm = 0;
		}else{
			// 重量(公斤)×2×续重运费+首重运费-续重运费
			wm = weight * 2 * 1 + 6 - 1;
		}
		
		BigDecimal weightMoney = new BigDecimal(wm);
		// 物品类别计算
		if (resSort != null && resSort != "") {
			TResSort tResSort = new TResSort();
			TResSortExample sop = new TResSortExample();
			sop.createCriteria().andResSortEqualTo(resSort);
			List<TResSort> selectByExample2 = rsMapper.selectByExample(sop);
			for (TResSort tResSort2 : selectByExample2) {
				tResSort = tResSort2;
			}
			sortMoney = tResSort.getResSortMoney();

		}

		// 运输地方
		if (start_address != null && start_address != "") {
			if (end_address != null && end_address != "") {

				TShipAddress shipAddress = new TShipAddress();
				TShipAddressExample asep = new TShipAddressExample();
				Criteria criteria = asep.createCriteria();
				criteria.andStartAddressEqualTo(start_address);
				criteria.andEndAddressEqualTo(end_address);
				List<TShipAddress> selectByExample3 = asMapper.selectByExample(asep);

				if (selectByExample3 != null && !selectByExample3.isEmpty()) {
					for (TShipAddress tShipAddress : selectByExample3) {
						shipAddress = tShipAddress;
					}
					asMoney = shipAddress.getShipAddressMoney();
				}

			}
		}
		if(asMoney.equals(new BigDecimal(0))||sortMoney.equals( new BigDecimal(0)))
			return new BigDecimal(0);
		return weightMoney.add(sortMoney).add(asMoney);
	}

	// 运费计算
	/*
	 * (non-Javadoc) 改签的运费计算
	 * 
	 * @see cn.zxk.service.fregihtSerivce#getyunfei(cn.zxk.pojo.TOrder)
	 */
	@Override
	public BigDecimal getyunfei(TOrder order) {
		BigDecimal weightMoney = new BigDecimal(0);
		BigDecimal sortMoney = new BigDecimal(0);
		BigDecimal asMoney = new BigDecimal(0);
		// 重量计算
		TResWeight resWeight = new TResWeight();
		TResWeightExample wep = new TResWeightExample();
		wep.createCriteria().andResWeightEqualTo(order.getWeight());
		List<TResWeight> selectByExample = weightMapper.selectByExample(wep);
		if (selectByExample != null && !selectByExample.isEmpty()) {
			for (TResWeight tResWeight : selectByExample) {
				resWeight = tResWeight;
			}
		}
		weightMoney = resWeight.getResWeightMoney();

		// 物品类别计算
		if (order.getResSort() != null && order.getResSort() != "") {
			TResSort tResSort = new TResSort();
			TResSortExample sop = new TResSortExample();
			sop.createCriteria().andResSortEqualTo(order.getResSort());
			List<TResSort> selectByExample2 = rsMapper.selectByExample(sop);
			for (TResSort tResSort2 : selectByExample2) {
				tResSort = tResSort2;
			}
			sortMoney = tResSort.getResSortMoney();

		}

		// 运输地方
		if (order.getSenderAddress() != null && order.getReceivingAddress() != "") {
			if (order.getSenderAddress() != null && order.getReceivingAddress() != "") {

				TShipAddress shipAddress = new TShipAddress();
				TShipAddressExample asep = new TShipAddressExample();
				Criteria criteria = asep.createCriteria();
				criteria.andStartAddressEqualTo(order.getSenderAddress());
				criteria.andEndAddressEqualTo(order.getReceivingAddress());
				List<TShipAddress> selectByExample3 = asMapper.selectByExample(asep);

				if (selectByExample3 != null && !selectByExample3.isEmpty()) {
					for (TShipAddress tShipAddress : selectByExample3) {
						shipAddress = tShipAddress;
					}
					asMoney = shipAddress.getShipAddressMoney();
				}

			}
		}

		if (order.getInsuredPrice() == 1) {
			return weightMoney.add(sortMoney).add(asMoney).add(new BigDecimal(5));
		}

		return weightMoney.add(sortMoney).add(asMoney);
	}

//	public BigDecimal getweightMoney(TOrder order) {
//		// 重量计算
//				int wm;
//				// 重量(公斤)×2×续重运费+首重运费-续重运费
//				if(order.getWeight()==1) {
//					wm = 6;
//				}else if(order.getWeight()==0){
//					wm = 0;
//				}else{
//					// 重量(公斤)×2×续重运费+首重运费-续重运费
//					wm = order.getWeight() * 2 * 1 + 6 - 1;
//				}
//				BigDecimal weightMoney = new BigDecimal(wm);
//				return weightMoney;
//	}
	
	/*
	 * (non-Javadoc) 改后的运费计算
	 * 
	 * @see cn.zxk.service.fregihtSerivce#getYunfei(cn.zxk.pojo.TOrder)
	 */
	@Override
	public BigDecimal getYunfei(TOrder order) {

		// 重量计算
		int wm;
		// 重量(公斤)×2×续重运费+首重运费-续重运费
		if(order.getWeight()==1) {
			wm = 6;
		}else if(order.getWeight()==0){
			wm = 0;
		}else{
			// 重量(公斤)×2×续重运费+首重运费-续重运费
			wm = order.getWeight() * 2 * 1 + 6 - 1;
		}
		
		BigDecimal weightMoney = new BigDecimal(wm);

		
		BigDecimal sortMoney = new BigDecimal(0);
		BigDecimal asMoney = new BigDecimal(0);
		
		// 是否保价
		if (order.getInsuredPrice() == 1) {
			weightMoney = weightMoney.add(new BigDecimal(1));
		}
			// 获取保价对应价格
			if (order.getResSort() != null && order.getResSort() != "") {
				TResSort tResSort = new TResSort();
				TResSortExample sop = new TResSortExample();
				sop.createCriteria().andResSortEqualTo(order.getResSort());
				List<TResSort> selectByExample2 = rsMapper.selectByExample(sop);
				for (TResSort tResSort2 : selectByExample2) {
					tResSort = tResSort2;
				}
				sortMoney = tResSort.getResSortMoney();
			}
		

		// 运输地方
		if (order.getSenderAddress() != null && order.getReceivingAddress() != "") {
			if (order.getSenderAddress() != null && order.getReceivingAddress() != "") {

				TShipAddress shipAddress = new TShipAddress();
				TShipAddressExample asep = new TShipAddressExample();
				Criteria criteria = asep.createCriteria();
				criteria.andStartAddressEqualTo(order.getSenderAddress());
				criteria.andEndAddressEqualTo(order.getReceivingAddress());
				List<TShipAddress> selectByExample3 = asMapper.selectByExample(asep);

				if (selectByExample3 != null && !selectByExample3.isEmpty()) {
					for (TShipAddress tShipAddress : selectByExample3) {
						shipAddress = tShipAddress;
					}
					asMoney = shipAddress.getShipAddressMoney();
				}

			}
		}

		return weightMoney.add(sortMoney).add(asMoney);
	}

}
