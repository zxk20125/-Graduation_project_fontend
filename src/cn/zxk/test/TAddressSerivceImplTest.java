package cn.zxk.test;

import cn.zxk.pojo.TAddress;
import cn.zxk.service.TAddressSerivce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TAddressSerivceImplTest {

	@Autowired
	private TAddressSerivce serivce;
	
//	@Test
//	public void testAddressSelectByRole() {
//		List<TAddress> addressSelectByRole = serivce.addressSelectByRole(0);
//		for (TAddress tAddress : addressSelectByRole) {
//			System.out.println(tAddress);
//		}
//	}

	@Test
	public void testAddressSelectById() {
		TAddress addressSelectById = serivce.addressSelectById(1);
		System.out.println(addressSelectById);
	}

	@Test
	public void testAddressSelectAll() {
		List<TAddress> addressSelectAll = serivce.addressSelectAll();
		for (TAddress tAddress : addressSelectAll) {
			System.out.println(tAddress);
		}
	}

	@Test
	public void testAddressInsert() {
//		serivce.addressInsert(1, "路飞", "广东省东莞市虎门镇万达广场", "13790907876", 0);
	}

	@Test
	public void testAddressDelete() {
		serivce.addressDelete(6);
	}

}
