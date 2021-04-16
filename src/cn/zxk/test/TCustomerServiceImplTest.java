package cn.zxk.test;

import cn.zxk.pojo.TCustomer;
import cn.zxk.service.TCustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TCustomerServiceImplTest {

	@Autowired
	private TCustomerService serivce;

	// 登录
	@Test
	public void testCustomerLogin() {
		TCustomer customer = serivce.customerLogin("Lu", "123");
		System.out.println(customer);
	}

	// 修改个人信息
	@Test
	public void testcustomerUpdate() {
//		int customer = serivce.customerUpdate(1, "luu", "男", 22, null);
//		System.out.println(customer);
	}

	//注册
//	@Test
//	public void testcustomerRegister() {
//		int i = serivce.customerRegister("lu", "123", 2, "男", "13729909370", null, null);
//		System.out.println(i);
//	}
}
