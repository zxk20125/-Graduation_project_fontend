package cn.zxk.controller.houtai.price;

import cn.zxk.pojo.TShipAddress;
import cn.zxk.service.TResSortSerivce;
import cn.zxk.service.TResWeightSerivce;
import cn.zxk.service.TShipAddressSerivce;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/houtai/price")
public class HPriceController {

	@Resource
	private TShipAddressSerivce saSerivce;
	
	@Resource
	private TResSortSerivce rsSerivce;
	
	@Resource
	private TResWeightSerivce weSerivce;
	
	
	@RequestMapping("/ship_address_list.do")
	private void shipAddressList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<TShipAddress> shipAddresss = saSerivce.saSelect();
		// 共享数据
		req.setAttribute("shipAddresss", shipAddresss);

		// 请求转发跳转到staff_list.jsp
		req.getRequestDispatcher("/WEB-INF/houtaiView/price/ship_address_list.jsp").forward(req, resp);
	}
	
//	@RequestMapping("/res_sort_list.do")
//	private void resSortList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		List<TFeedback> feedbacks = serivce.feedbackSelect();
//		// 共享数据
//		req.setAttribute("feedbacks", feedbacks);
//
//		// 请求转发跳转到staff_list.jsp
//		req.getRequestDispatcher("/WEB-INF/houtaiView/feedback/feedback_list.jsp").forward(req, resp);
//	}
//	
//	@RequestMapping("/res_weight_list.do")
//	private void resWeightList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		List<TFeedback> feedbacks = serivce.feedbackSelect();
//		// 共享数据
//		req.setAttribute("feedbacks", feedbacks);
//
//		// 请求转发跳转到staff_list.jsp
//		req.getRequestDispatcher("/WEB-INF/houtaiView/feedback/feedback_list.jsp").forward(req, resp);
//	}
}
