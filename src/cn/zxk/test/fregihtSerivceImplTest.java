package cn.zxk.test;

import cn.zxk.service.fregihtSerivce;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class fregihtSerivceImplTest {

	@Autowired
	private fregihtSerivce serivce;
	
	//运费估算
//	@Test
//	public void testFreightEstimate() {
//		String freight = serivce.freightEstimate("广东省东莞市", "广东省东莞市东城区", 2);
//		System.out.println(freight);
//	}
//
//	//运费
//	@Test
//	public void testgetFreight() {
//		BigDecimal freight = serivce.getFreight(1, "食品饮料", "广东省东莞市松山湖", "广东省东莞市寮步镇", 1);
//		System.out.println(freight);
//	}
}
