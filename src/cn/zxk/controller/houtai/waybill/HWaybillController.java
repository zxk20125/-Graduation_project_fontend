package cn.zxk.controller.houtai.waybill;

import cn.zxk.pojo.TWaybill;
import cn.zxk.service.TWaybillSerivce;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/houtai/waybill")
public class HWaybillController {

	@Resource
	private TWaybillSerivce serivce;

	@RequestMapping("/list.do")
	private void List(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<TWaybill> waybills = serivce.selectAll();
		// 共享数据
		req.setAttribute("waybills", waybills);
//		for (TWaybill tWaybill : waybills) {
//			System.out.println(tWaybill);
//		}
		// 请求转发跳转到staff_list.jsp
		req.getRequestDispatcher("/WEB-INF/houtaiView/waybill/waybill_list.jsp").forward(req, resp);
	}

	@RequestMapping("/orderTracking.do")
	private void orderTracking(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		List<TWaybill> waybills = serivce.selectAll();
//		// 共享数据
//		req.setAttribute("waybills", waybills);
//		for (TWaybill tWaybill : waybills) {
//			System.out.println(tWaybill);
//		}
		// 请求转发跳转到staff_list.jsp
//		req.getRequestDispatcher("/WEB-INF/houtaiView/waybill/waybill_list.jsp").forward(req, resp);
		String waybillId = req.getParameter("waybillId");
		TWaybill waybill = serivce.selectAllByWbId(waybillId);
//		System.out.println(waybill);
		req.setAttribute("waybill", waybill);
		req.getRequestDispatcher("/WEB-INF/houtaiView/waybill/orderTracking.jsp").forward(req, resp);
//		return waybill;
	}
}
