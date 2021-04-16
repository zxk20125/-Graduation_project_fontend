package cn.zxk.controller.houtai.feedback;

import cn.zxk.pojo.TFeedback;
import cn.zxk.service.TFeedbackService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/houtai/feedback")
public class HFeedbackController {

	@Resource
	private TFeedbackService serivce;
	
	@RequestMapping("/list.do")
	private void feedbackList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<TFeedback> feedbacks = serivce.feedbackSelect();
		// 共享数据
		req.setAttribute("feedbacks", feedbacks);

		// 请求转发跳转到staff_list.jsp
		req.getRequestDispatcher("/WEB-INF/houtaiView/feedback/feedback_list.jsp").forward(req, resp);
	}
	
	//删除
	@RequestMapping("/delete.do")
	@ResponseBody
	private int feedbackdelete(int id) {
		int i = serivce.feedbackdelete(id);
		return i;
	}
}
