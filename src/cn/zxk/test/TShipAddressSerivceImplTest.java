package cn.zxk.test;

import cn.zxk.pojo.TShipAddress;
import cn.zxk.service.TShipAddressSerivce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TShipAddressSerivceImplTest {

	@Autowired
	private TShipAddressSerivce serivce;
	
	@Test
	public void testSaSelect() {
		List<TShipAddress> saSelect = serivce.saSelect();
		for (TShipAddress tShipAddress : saSelect) {
			System.out.println(tShipAddress);
		}
	}

	@Test
	public void testSaInsert() {
//		int i = serivce.saInsert("广东省东莞市寮步镇", "广东省东莞市石排镇", new BigDecimal(5.00));
//		System.out.println(i);
	}

	@Test
	public void testSaUpdate() {
//		int i = serivce.saUpdate(1, "广东省东莞市松山湖", "广东省东莞市寮步镇", null);
//		System.out.println(i);
	}

	@Test
	public void testSaDelete() {
		serivce.saDelete(4);
	}

}
