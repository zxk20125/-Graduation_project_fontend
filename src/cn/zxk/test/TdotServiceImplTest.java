package cn.zxk.test;

import cn.zxk.mapper.TDotMapper;
import cn.zxk.pojo.TDot;
import cn.zxk.pojo.TDotExample;
import cn.zxk.service.TdotService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TdotServiceImplTest {

	@Autowired
	private TdotService service;

	@Autowired
	private  TDotMapper dotMapper;
	
	@Test
	public void testDotByCity() {
		List<TDot> dot = service.dotByCity("广东省东莞市");
		for (TDot tDot : dot) {
			System.out.println(tDot);
		}
	}

	@Test
	public void testdotInsert() {
//		int i = service.dotInsert("广东省东莞市", "广东省东莞市虎门大道106号附近", "东莞虎门", "18022824745");
//		System.out.println(i);
	}
	
	@Test
	public void testdotDelete() {
		service.dotDelete(3);
	}
	
	@Test
	public void testdotIdSelectByName() {
		int i = service.dotIdSelectByName("东莞寮步");
	System.out.println(i);
	}

	@Test
	public  void getDotId(){
		TDotExample example=new TDotExample();
		example.createCriteria().andDotNameLike("%荔湾%");
		System.out.println(dotMapper.selectByExample(example).get(0));

	}
}
