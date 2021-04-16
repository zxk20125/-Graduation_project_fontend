package cn.zxk.controller.qiantaiCustomer.address;

import cn.zxk.pojo.TAddress;
import cn.zxk.pojo.TCustomer;
import cn.zxk.service.TAddressSerivce;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/qtCustomer/address")
public class QAddressController {

	@Resource
	private TAddressSerivce serivce;

	// 显示地址
	@RequestMapping("/list.do")
	private void list(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
			throws ServletException, IOException {
		TCustomer cutomer = (TCustomer) session.getAttribute("customer");
		req.setAttribute("cutomer", cutomer);

		List<TAddress> addresss = serivce.addressSelectByCustomerId(cutomer.getCustomerId());
		req.setAttribute("addresss", addresss);

		req.getRequestDispatcher("/WEB-INF/qtCuView/address/dizhi.jsp").forward(req, resp);
	}

	//编辑地址
	@RequestMapping("/update.do")
	@ResponseBody
	private void update(HttpServletRequest req, HttpServletResponse resp, HttpSession session,int addressId)
			throws ServletException, IOException {
		TCustomer cutomer = (TCustomer) session.getAttribute("customer");
		req.setAttribute("cutomer", cutomer);

		TAddress address = serivce.addressSelectById(addressId);
		req.setAttribute("address", address);

		req.getRequestDispatcher("/WEB-INF/qtCuView/address/updateaddress.jsp").forward(req, resp);

	}

	//修改
	@RequestMapping("/doupdate.do")
	@ResponseBody
	private int doupdate(TAddress data) {
		int i = serivce.addressUpdate(data);
		return i;
	}
	
	//删除
	@RequestMapping("/dodelete.do")
	@ResponseBody
	private int dodelete(int addressId) {
		int i = serivce.addressDelete(addressId);
		return i;
	}
	
	//显示添加页面
	@RequestMapping("/insert.do")
	private void insert(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
			throws ServletException, IOException {
		TCustomer cutomer = (TCustomer) session.getAttribute("customer");
		req.setAttribute("cutomer", cutomer);
		
		int customerId = Integer.parseInt(req.getParameter("customerId"));
		req.setAttribute("customerId", customerId);
		
		req.getRequestDispatcher("/WEB-INF/qtCuView/address/newaddress.jsp").forward(req, resp);

	}
	
	//添加
	@RequestMapping("/doinsert.do")
	@ResponseBody
	private int doinsert(TAddress address,HttpSession session,HttpServletRequest req) {
		TCustomer cutomer = (TCustomer) session.getAttribute("customer");
		req.setAttribute("cutomer", cutomer);
		
		int i = serivce.addressInsert(address);
		
		return i;
	}
}
