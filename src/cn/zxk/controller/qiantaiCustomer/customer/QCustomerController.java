package cn.zxk.controller.qiantaiCustomer.customer;

import cn.zxk.pojo.TCustomer;
import cn.zxk.service.TCustomerService;
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
@RequestMapping("/qtCustomer/customer")
public class QCustomerController {

	@Resource
	private TCustomerService serivce;
	
	@RequestMapping("/login.do")
	@ResponseBody
	private int login(String customer_login_name,String customer_password,HttpSession session) {
		
		TCustomer customer = serivce.customerLogin(customer_login_name, customer_password);
		session.setAttribute("customer", customer);
		
		if(customer!=null) {
			return 1;
		}
		return 0;
	}
	
	@RequestMapping("/index.do")
	private void staffList(HttpServletRequest req, HttpServletResponse resp,HttpSession session) throws ServletException, IOException {
		TCustomer customer =(TCustomer) session.getAttribute("customer");
		// 共享数据
		req.setAttribute("customer", customer);

		// 请求转发跳转到staff_list.jsp
		req.getRequestDispatcher("/WEB-INF/qtCuView/index.jsp").forward(req, resp);
	}
	
	//个人中心
	@RequestMapping("/member.do")
	private void member(HttpServletRequest req, HttpServletResponse resp,HttpSession session) throws ServletException, IOException {
		TCustomer customer =(TCustomer) session.getAttribute("customer");
		// 共享数据
		req.setAttribute("customer", customer);

		// 请求转发跳转到staff_list.jsp
		req.getRequestDispatcher("/WEB-INF/qtCuView/member.jsp").forward(req, resp);
	}
	
	//个人信息
	@RequestMapping("/geren.do")
	private void gerenxinxi(HttpServletRequest req, HttpServletResponse resp,HttpSession session) throws ServletException, IOException {
		TCustomer customer =(TCustomer) session.getAttribute("customer");
		// 共享数据
		req.setAttribute("customer", customer);

		// 请求转发跳转到staff_list.jsp
		req.getRequestDispatcher("/WEB-INF/qtCuView/gerenxinxi.jsp").forward(req, resp);
	}
	
	//注册
	@RequestMapping("/register.do")
	@ResponseBody
	private int register(TCustomer data) {
	
		int i = serivce.customerRegister(data);
		return i;
	}
	
	//修改个人信息
	@RequestMapping("/gerenUpdate.do")
	@ResponseBody
	private int gerenUpdate(TCustomer data,HttpSession session) {
		TCustomer customer =(TCustomer) session.getAttribute("customer");
		data.setCustomerId(customer.getCustomerId());
		int i = serivce.customerUpdate(data);
	return i;	
	}
}
