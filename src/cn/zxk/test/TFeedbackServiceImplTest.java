package cn.zxk.test;

import cn.zxk.pojo.TFeedback;
import cn.zxk.service.TFeedbackService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TFeedbackServiceImplTest {

	@Autowired
	private TFeedbackService service;
	
	@Test
	public void testFeedbackInsert() {
//		service.feedbackInsert(1, "希望好好改进");
	}

	@Test
	public void testFeedbackSelect() {
		List<TFeedback> feedbackSelect = service.feedbackSelect();
		for (TFeedback tFeedback : feedbackSelect) {
			System.out.println(tFeedback);
		}
	}

}
