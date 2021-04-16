package cn.zxk.controller.qiantaiCustomer.jijian;

import cn.zxk.pojo.TAddress;
import cn.zxk.pojo.TCustomer;
import cn.zxk.pojo.TOrder;
import cn.zxk.service.TAddressSerivce;
import cn.zxk.service.TOrderSerivce;
import cn.zxk.service.fregihtSerivce;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/qtCustomer/jijian")
public class QJijianController {

	@Resource
	private TAddressSerivce adSerivce;

	@Resource
	private fregihtSerivce fgSerivce;
	
	@Resource
	private TOrderSerivce orSerivce;
	
	// 显示寄件页面
	@RequestMapping("/xianshi.do")
	private void xianshi(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
			throws ServletException, IOException {
		TCustomer cutomer = (TCustomer) session.getAttribute("customer");

		req.setAttribute("cutomer", cutomer);

		List<TAddress> addresss = adSerivce.addressSelectByCustomerId(cutomer.getCustomerId());
		req.setAttribute("addresss", addresss);

		req.getRequestDispatcher("/WEB-INF/qtCuView/jijian/jijian.jsp").forward(req, resp);
	}
	
	//运费计算
	@RequestMapping("/yunfei.do")
	@ResponseBody
	private String yunfei(TOrder data,HttpSession session,HttpServletRequest req) {
		TCustomer cutomer = (TCustomer) session.getAttribute("customer");

		req.setAttribute("cutomer", cutomer);
		
		//修改前
//		BigDecimal decimal = fgSerivce.getyunfei(data);
		
		//修改后
		BigDecimal decimal = fgSerivce.getYunfei(data);
		
		return decimal.toString();
	}
	
	//下单
	@RequestMapping("/xiadan.do")
	@ResponseBody
	private int xiadan(TOrder data,HttpSession session,HttpServletRequest req) {
		TCustomer cutomer = (TCustomer) session.getAttribute("customer");
		req.setAttribute("cutomer", cutomer);
		
		String c1 = data.getSenderAddress().substring(3, 5);
		String c2 = data.getReceivingAddress().substring(3, 5);
		if(!c1.equals(c2)) {
			return 0;
		}
		data.setCustmerId(cutomer.getCustomerId());
		int i = orSerivce.doOrder(data);
		return i;
	}
}
