package cn.zxk.test;

import cn.zxk.pojo.TResWeight;
import cn.zxk.service.TResWeightSerivce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TResWeightServiceImplTest {

	@Autowired
	private TResWeightSerivce service;
	
	@Test
	public void testSelect() {
		List<TResWeight> select = service.Select();
		for (TResWeight tResWeight : select) {
			System.out.println(tResWeight);
		}
	}

	@Test
	public void testInsert() {
//		int i = service.Insert(7, new BigDecimal(22));
//		System.out.println(i);
	}

	@Test
	public void testUpdate() {
//		service.Update(7, 8, null);
	}

	@Test
	public void testDelete() {
		service.Delete(7);
	}

}
