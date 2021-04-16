package cn.zxk.test;

import cn.zxk.service.TLogisticsSerivce;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TLogisticsSerivceImplTest {

	@Autowired
	private TLogisticsSerivce serivce;
	
//	@Test
//	public void testLogisticsInsert() {
//		serivce.logisticsInsert("112019042322404744", 2, "收入", "广东省东莞市", "东莞寮步", "广东省东莞市", "东莞虎门");
//	}

}
