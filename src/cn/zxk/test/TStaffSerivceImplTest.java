package cn.zxk.test;

import cn.zxk.pojo.TStaff;
import cn.zxk.service.TStaffSerivce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TStaffSerivceImplTest {

	@Autowired
	private TStaffSerivce serivce;

	@Test
	public void testStaffSelect() {
		List<TStaff> staffSelect = serivce.staffSelect();
		for (TStaff tStaff : staffSelect) {
			System.out.println(tStaff);
		}
	}

	@Test
	public void testStaffLogin() {
		TStaff staff = serivce.staffLogin("liaasdf21sdsi", "123");
		System.out.println(staff);
	}

	@Test
	public void testStaffInsert() {
		int i = serivce.staffInsert("高七", "gao", "123", 21, "男", "13845467372", "东莞寮步");
		System.out.println(i);
	}

	@Test
	public void testStaffDelete() {
		serivce.staffDelete(4);
	}

	@Test
	public void testStaffUpdate() {
		serivce.staffUpdate(1,null, null, null, 25, null, null, "东莞虎门");
	}

}
