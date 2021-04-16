package cn.zxk.test;

import cn.zxk.pojo.TLogistics;
import cn.zxk.pojo.TOrder;
import cn.zxk.pojo.TSend;
import cn.zxk.pojo.TWaybill;
import cn.zxk.service.TWaybillSerivce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TWaybillSerivceImplTest {

	@Autowired
	private TWaybillSerivce serivce;

	//订单跟踪
	@Test
	public void testOrderTracking() {
		TWaybill waybill = serivce.selectAllByWbId("112019041823212466");

		for (int i = 0; i < 2; i++) {
			if (waybill.getLogistics() != null && !waybill.getLogistics().isEmpty()) {

				List<TLogistics> logistics = waybill.getLogistics();
				for (TLogistics tLogistics : logistics) {
					if (waybill.getSend() != null && !waybill.getSend().isEmpty()) {
						List<TSend> send = waybill.getSend();
						for (TSend tSend : send) {
							if (tSend.getSendTime().after(tLogistics.getTime())) {
								if(tSend.getSignState()==1) {
									System.out.println("拒签 "+"拒签原因："+tSend.getRejectReasons()+" 时间："+tSend.getStime());
								}else if(tSend.getSignState()==0){
									System.out.println("签收时间："+tSend.getStime());
								}
								System.out.println("派送时间：" + tSend.getSendTime());
							}
						}
					}
					waybill.setSend(null);
					System.out.println("物流更新：" + tLogistics.getTime());
				}
				waybill.setLogistics(null);
			} else {
				System.out.println(waybill.getOrder().getOrderTime());
			}
		}
	}

	@Test
	public void testSelectById() {
		TWaybill waybill = serivce.selectAllByWbId("1615556581837560");
		System.out.println(waybill);

	}

	public static Date[] sort(Date[] a){
	    Date[] temp = a;

	    if(temp.length%2==0){
	        //数组里面的个数为偶数
	        for (int i = 0; i <= temp.length/ 2; i++) {
	            Date temp1 = a[i];
	            temp[i]=temp[temp.length-1-i];
	            temp[temp.length - 1-i] = temp1;
	        }
	    }else{
	        //数组里面的个数为奇数
	        for (int i = 0; i < temp.length / 2; i++) {
	        	Date temp1 = a[i];
	            temp[i]=temp[temp.length-1-i];
	            temp[temp.length - 1-i] = temp1;
	        }
	    }
	    return  temp;
	}
	
	private static Date[] insertTime(Date[] trackTime,Date time) {
		trackTime = Arrays.copyOf(trackTime, trackTime.length+1);
		trackTime[trackTime.length-1] = time;
		return trackTime;
	}
	
	private static Date[] insert2(Date[] trackTime,TWaybill waybill) {
		trackTime = TWaybillSerivceImplTest.insertTime(trackTime, waybill.getOrder().getOrderTime());
		
		trackTime = TWaybillSerivceImplTest.insertTime(trackTime, waybill.getReceiptTime());
		trackTime = TWaybillSerivceImplTest.insertTime(trackTime, waybill.getConfirmTime());
		trackTime = TWaybillSerivceImplTest.insertTime(trackTime, waybill.getFinishTime());
		trackTime = TWaybillSerivceImplTest.insertTime(trackTime, waybill.getCancelTime());
		
		
		List<TLogistics> logistics = waybill.getLogistics();
		for (TLogistics tLogistics : logistics) {
			trackTime = TWaybillSerivceImplTest.insertTime(trackTime, tLogistics.getTime());
		}
		
		List<TSend> send = waybill.getSend();
		for (TSend tSend : send) {
			trackTime = TWaybillSerivceImplTest.insertTime(trackTime, tSend.getSendTime());
			trackTime = TWaybillSerivceImplTest.insertTime(trackTime, tSend.getStime());
		}
		return trackTime;
	}
	
	@Test
	public void testdataCount() {
		int count = serivce.dataCount("112019041823212466");
		System.out.println("数据条："+count);
	}

	@Test
	public void testGetStaffId(){
		serivce.selectAll().forEach(waybill->{
			if( waybill.getOrder().getStaffId()==null){
				System.out.println(waybill.getOrder());
			}
		});
	}
}
