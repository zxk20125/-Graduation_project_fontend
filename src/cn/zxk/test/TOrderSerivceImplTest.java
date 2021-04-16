package cn.zxk.test;

import cn.zxk.mapper.TOrderMapper;
import cn.zxk.pojo.TOrder;
import cn.zxk.service.TOrderSerivce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TOrderSerivceImplTest {

	@Autowired
	private TOrderSerivce serivce;

	@Autowired
	private TOrderMapper orderMapper;
	
	@Test
	public void testDoOrder() {
		TOrder Order = new TOrder();
		Order.setOrderId("1615381316370758");
		Order.setStaffId(null);
		orderMapper.updateByPrimaryKeySelective(Order);
	}
//
//	@Test
//	public void testOrderTaking() {
//		serivce.orderTaking("112019042322404744", 1);
//	}
//
//	@Test
//	public void testpaymentUpadate() {
//		serivce.paymentUpadate("112019041823212466");
//	}
//	
//	@Test
//	public void testconfirmUpadate() {
//		serivce.confirmUpadate("112019042322404744");
//	}
//	
//	@Test
//	public void testcancel_time() {
//		serivce.cancelUpadate("112019041823212466");
//	}
}
