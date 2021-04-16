package cn.zxk.test;

import cn.zxk.service.TSendSerivce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TSendSerivceImplTest {

	@Autowired
	private TSendSerivce serivce;
	
//	@Test
//	public void testDeliver() {
//		serivce.Deliver("112019042322404744", 1);
//	}

//	@Test
//	public void testSignfor() {
//		serivce.signforOrDeny("112019042322404744",0,null);
//	}

	@Test
	public void testisnotsend() {
		int i = serivce.isnotsend("112019052209150495");
		System.out.println(i);
	}

}
