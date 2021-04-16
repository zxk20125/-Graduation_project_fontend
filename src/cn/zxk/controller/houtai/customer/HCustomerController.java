package cn.zxk.controller.houtai.customer;

import cn.zxk.pojo.TCustomer;
import cn.zxk.service.TCustomerService;
import com.alibaba.fastjson.JSON;
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
@RequestMapping("/houtai/customer")
public class HCustomerController {

	@Resource
	private TCustomerService serivce;
	
	//客户列表
	@RequestMapping("/list.do")
	@ResponseBody
	private void customerList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	
		List<TCustomer> customers = serivce.customerSelectAll();
		// 共享数据
		req.setAttribute("customers", customers);

		// 请求转发跳转到staff_list.jsp
		req.getRequestDispatcher("/WEB-INF/houtaiView/customer/customer_list.jsp").forward(req, resp);
	}
	
	//显示
	@RequestMapping("/update.do")
	@ResponseBody
	private TCustomer customerList(int id) {
		TCustomer customer = serivce.customerSelectById(id);
		return customer;
	}
	
	//保存修改信息
	@RequestMapping("/doupdate.do")
	@ResponseBody
	private int customerDoUpdate(String data) {
		TCustomer customer = JSON.parseObject(data, TCustomer.class);
//		System.out.println(customer);
		int i = serivce.customerUpdate(customer);
		return i;
	}
}
