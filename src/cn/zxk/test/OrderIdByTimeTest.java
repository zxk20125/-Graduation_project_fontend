package cn.zxk.test;

import cn.zxk.mapper.TOrderMapper;
import cn.zxk.util.OrderIdByTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class OrderIdByTimeTest {

	@Autowired
	private TOrderMapper mapper;
	
	@Test
	public void testGetOrderIdByTime() {
		String id = OrderIdByTime.getOrderIdByTime();
		System.out.println(id);
	}


}
