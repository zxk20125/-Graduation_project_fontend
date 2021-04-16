package cn.zxk.controller.qiantaiCustomer.freight;

import cn.zxk.pojo.TCustomer;
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

@Controller
@RequestMapping("/qtCustomer/freight")
public class QFreightController {

	@Resource
	private fregihtSerivce serivce;
	
	//显示估算页面
	@RequestMapping("/xianshi.do")
	private void xianshi(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
			throws ServletException, IOException {
		TCustomer cutomer = (TCustomer) session.getAttribute("customer");

		req.setAttribute("cutomer", cutomer);

		req.getRequestDispatcher("/WEB-INF/qtCuView/yunfeigusuan/gusuan.jsp").forward(req, resp);
	}
	
	//估算
	@RequestMapping("/gusuan.do")
	@ResponseBody
	private String gusuan(int weight,String resSort,String sad,String ead) {
//		System.out.println(weight);
//		System.out.println(resSort);
//		System.out.println(sad);
//		System.out.println(ead);
		BigDecimal money = serivce.getYunfeigusuan(weight, resSort, sad, ead);
//		System.out.println(money);
		return money.toString();
	}
}
