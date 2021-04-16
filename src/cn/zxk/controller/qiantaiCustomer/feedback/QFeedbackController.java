package cn.zxk.controller.qiantaiCustomer.feedback;

import cn.zxk.pojo.TCustomer;
import cn.zxk.pojo.TFeedback;
import cn.zxk.service.TFeedbackService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/qtCustomer/feedback")
public class QFeedbackController {

	@Resource
	private TFeedbackService serivce;

	// 显示反馈建议界面
	@RequestMapping("/insert.do")
	private void insert(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
			throws ServletException, IOException {
		TCustomer cutomer = (TCustomer) session.getAttribute("customer");

		req.setAttribute("cutomer", cutomer);

		req.getRequestDispatcher("/WEB-INF/qtCuView/feedback/fankui.jsp").forward(req, resp);
	}

	// 添加建议
	@RequestMapping("/doinsert.do")
	@ResponseBody
	private int doinsert(HttpServletRequest req, HttpSession session, TFeedback feedback) {
		TCustomer cutomer = (TCustomer) session.getAttribute("customer");
		req.setAttribute("cutomer", cutomer);
		if (cutomer == null) {
			return 0;
		}

		int i = serivce.feedbackInsert(feedback);
		return i;
	}
}
