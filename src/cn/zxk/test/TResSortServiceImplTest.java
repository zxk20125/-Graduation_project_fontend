package cn.zxk.test;

import cn.zxk.pojo.TResSort;
import cn.zxk.service.TResSortSerivce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TResSortServiceImplTest {

	@Autowired
	private TResSortSerivce serivce;
	
	@Test
	public void testSsSelect() {
		List<TResSort> ssSelect = serivce.ssSelect();
		for (TResSort tResSort : ssSelect) {
			System.out.println(tResSort);
		}
	}

	@Test
	public void testSsInsert() {
//		int i = serivce.ssInsert("运动器材", new BigDecimal(10));
//		System.out.println(i);
//		
	}

	@Test
	public void testSsUpdate() {
//		serivce.ssUpdate(1, "食品饮料", new BigDecimal(5));
	}

	@Test
	public void testSsDelete() {
		serivce.ssDelete(10);
	}

}
