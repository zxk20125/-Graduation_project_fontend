package cn.zxk.controller.houtai.order;

import cn.zxk.pojo.TOrder;
import cn.zxk.service.TOrderSerivce;
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
@RequestMapping("/houtai/order")
public class HOrderController {

	@Resource
	private TOrderSerivce serivce;

	@RequestMapping("/list.do")
	private void shipAddressList(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<TOrder> orders = serivce.orderSelect();
		// 共享数据
		req.setAttribute("orders", orders);

		System.out.println(orders);
		// 请求转发跳转到staff_list.jsp
		req.getRequestDispatcher("/WEB-INF/houtaiView/order/order_list.jsp").forward(req, resp);
	}

	@RequestMapping("/remarks.do")
	@ResponseBody
	private TOrder remark(String id) {
		TOrder order = serivce.orderSelectById(id);
		if (order.getRemarks() == null) {
			
			order.setRemarks("无");
		}
		
		return order;
	}
}
