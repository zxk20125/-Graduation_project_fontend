package cn.zxk.controller.qiantaiStaff.order;

import cn.zxk.pojo.*;
import cn.zxk.service.TOrderSerivce;
import cn.zxk.service.TWaybillSerivce;
import cn.zxk.service.TdotService;
import org.springframework.core.annotation.Order;
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
@RequestMapping("/qtStaff/order")
public class SOrderController {

	@Resource
	private TWaybillSerivce wbSerivce;

	@Resource
	private TdotService dotSerivce;

	@Resource
	private TOrderSerivce orSerivce;

	// 显示我的订单页面
	@RequestMapping("/order.do")
	private void xianshi(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
			throws ServletException, IOException, StringIndexOutOfBoundsException {
		TStaff staff = (TStaff) session.getAttribute("staff");
		req.setAttribute("staff", staff);
		Integer staffDotId= staff.getDotId();
		List<TWaybill> waybills = new ArrayList<>();
		wbSerivce.selectAll().forEach(waybill -> {
			if(waybill.getOrder().getDotId().equals(staffDotId)){
				waybills.add(waybill);
			}
		});
		req.setAttribute("waybills", waybills);
		req.getRequestDispatcher("/WEB-INF/qtStView/order/order.jsp").forward(req, resp);

	}

	// 接单
	@RequestMapping("/jiedan.do")
	@ResponseBody
	private void jiedan(HttpSession session, String orderId, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		TStaff staff = (TStaff) session.getAttribute("staff");
		req.setAttribute("staff", staff);
		orSerivce.jiedan(orderId, staff.getStaffId());
        Integer staffDotId= staff.getDotId();
        List<TWaybill> waybills = new ArrayList<>();
        wbSerivce.selectAll().forEach(waybill -> {
            if(waybill.getOrder().getDotId().equals(staffDotId)){
                waybills.add(waybill);
            }
        });
		req.setAttribute("waybills", waybills);
		req.getRequestDispatcher("/WEB-INF/qtStView/order/order.jsp").forward(req, resp);
	}

	//揽件界面
	@RequestMapping("/lanjianjiemian.do")
	private void lanjianjiemian(String waybillId,HttpServletRequest req, HttpServletResponse resp, HttpSession session)
			throws ServletException, IOException, StringIndexOutOfBoundsException {
		TStaff staff = (TStaff) session.getAttribute("staff");
		req.setAttribute("staff", staff);
//		System.out.println(waybillId);
		TWaybill waybill = wbSerivce.selectAllByWbId(waybillId);
		req.setAttribute("waybill",waybill);
		req.getRequestDispatcher("/WEB-INF/qtStView/lanjian/lanjianxianshi.jsp").forward(req, resp);
	}

	// 揽件
	@RequestMapping("/lanjian.do")
	@ResponseBody
	private int lanjian(int weight,String resSort,HttpSession session, String waybillId, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		TStaff staff = (TStaff) session.getAttribute("staff");
		if(staff==null) {
			return 2;
		}
		req.setAttribute("staff", staff);

		TWaybill waybill = wbSerivce.selectAllByWbId(waybillId);
		TOrder order = new TOrder();
		order.setOrderId(waybill.getOrderId());
		order.setWeight(weight);
		order.setResSort(resSort);
		orSerivce.updateBylanjian(order);
		int i = orSerivce.lanjian(waybill.getOrderId());

		return i;
	}

	// 搜索
	@RequestMapping("/sousuo.do")
	@ResponseBody
	private int sousuo(HttpSession session, HttpServletRequest req, String id) {
		TStaff staff = (TStaff) session.getAttribute("staff");
		if (staff == null) {
			return 0;
		}
		if (id.substring(0, 1).equals(" ")) {
			id = id.substring(1);
		}
		req.setAttribute("staff", staff);

		try {
			TWaybill selectAllByWbId = wbSerivce.selectAllByWbId(id);
		} catch (Exception e) {
			return 0;
		}

		return 1;
	}
}
