package cn.zxk.controller.qiantaiCustomer.order;

import cn.zxk.pojo.TCustomer;
import cn.zxk.pojo.TWaybill;
import cn.zxk.service.TWaybillSerivce;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/qtCustomer/order")
public class QOrderController {

	@Resource
	private TWaybillSerivce wbSerivce;

	// 显示我的订单页面
	@RequestMapping("/myorder.do")
	private void xianshi(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
			throws ServletException, IOException {

		TCustomer customer = (TCustomer) session.getAttribute("customer");
		req.setAttribute("customer", "customer");

		List<TWaybill> wb = wbSerivce.selectAll();
		List<TWaybill> waybills = new ArrayList<TWaybill>();
		List<TWaybill> waybills2 = new ArrayList<TWaybill>();
		// 我寄的
		if (wb != null && !wb.isEmpty()) {
			for (TWaybill tWaybill : wb) {
				if (tWaybill.getOrder().getCustmerId() == customer.getCustomerId()) {
					waybills.add(tWaybill);

				}
			}
			// 我收的
			for (TWaybill tWaybill : waybills) {
				if (tWaybill.getOrder().getReceiverPhone().equals(customer.getCustomerPhone())) {
					waybills2.add(tWaybill);
				}
			}
		}
		req.setAttribute("waybills", waybills);
		req.setAttribute("waybills2", waybills2);

		req.getRequestDispatcher("/WEB-INF/qtCuView/order/myorder.jsp").forward(req, resp);
	}

	// 订单跟踪显示页面（订单物流）
	@RequestMapping("/orderTracking.do")
	private void orderTracking(String waybill_id, HttpServletRequest req, HttpServletResponse resp, HttpSession session)
			throws ServletException, IOException {
		TCustomer customer = (TCustomer) session.getAttribute("customer");
		req.setAttribute("customer", "customer");

		if (waybill_id.substring(0, 1).equals("%20")) {
			waybill_id = waybill_id.substring(1);
		}
		if (waybill_id.substring(0, 1).equals(" ")) {
			waybill_id = waybill_id.substring(1);
			
		}
		TWaybill waybill = wbSerivce.selectAllByWbId(waybill_id);
		req.setAttribute("waybill", waybill);
		req.getRequestDispatcher("/WEB-INF/qtCuView/order/ordertracking.jsp").forward(req, resp);
	}

	// 搜索
	@RequestMapping("/sousuo.do")
	@ResponseBody
	private int sousuo(HttpSession session, HttpServletRequest req, String id) {
		TCustomer customer = (TCustomer) session.getAttribute("customer");
		if (customer == null) {
			return 0;
		}
		if (id.substring(0, 1).equals(" ")) {
			id = id.substring(1);
		}
		req.setAttribute("customer", customer);

		try {
			TWaybill selectAllByWbId = wbSerivce.selectAllByWbId(id);
		} catch (Exception e) {
			return 0;
		}

		return 1;
	}
	
	//取消订单
	@RequestMapping("/quxiao.do")
	@ResponseBody
	private int quxiao(TWaybill waybillId) {
//		System.out.println(waybillId);
//		if (waybillId.substring(0, 1).equals(" ")) {
//			waybillId = waybillId.substring(1);
//		}
		int i = wbSerivce.quxiao(waybillId.getWaybillId());
		return i;
	}

	//删除订单
	@RequestMapping("/shanchu.do")
	@ResponseBody
	private int shanchu(TWaybill waybillId) {
		int i = wbSerivce.shanchu(waybillId.getWaybillId());
		return i;
	}
}
