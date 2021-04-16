package cn.zxk.controller.houtai.address;

import cn.zxk.pojo.TAddress;
import cn.zxk.service.TAddressSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/houtai/address")
public class HAddressController {

	@Autowired
	private TAddressSerivce serivce;
	
	@RequestMapping("/list.do")
	private void addressList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<TAddress> addresss = serivce.addressSelectAll();
		// 共享数据
		req.setAttribute("addresss", addresss);

		// 请求转发跳转到staff_list.jsp
		req.getRequestDispatcher("/WEB-INF/houtaiView/address/address_list.jsp").forward(req, resp);
	}
	
//	@RequestMapping("/list_shoujian.do")
//	private void addressListShoujian(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		List<TAddress> addresss = serivce.addressSelectByRole(1);
//		// 共享数据
//		req.setAttribute("addresss", addresss);
//
//		// 请求转发跳转到staff_list.jsp
//		req.getRequestDispatcher("/WEB-INF/houtaiView/address/address_list_shoujian.jsp").forward(req, resp);
//	}
}
