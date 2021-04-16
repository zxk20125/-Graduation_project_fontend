package cn.zxk.controller.houtai.price;

import cn.zxk.pojo.TShipAddress;
import cn.zxk.service.TShipAddressSerivce;
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
@RequestMapping("/houtai/shipAddress")
public class HShipAddressController {
	
	@Resource
	private TShipAddressSerivce serivce;
	
	@RequestMapping("/ship_address_list.do")
	private void shipAddressList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<TShipAddress> shipAddresss = serivce.saSelect();
		// 共享数据
		req.setAttribute("shipAddresss", shipAddresss);

		// 请求转发跳转到staff_list.jsp
		req.getRequestDispatcher("/WEB-INF/houtaiView/price/ship_address_list.jsp").forward(req, resp);
	}
	
	@RequestMapping("/update.do")
	@ResponseBody
	private TShipAddress update(int id) {
		TShipAddress shipAddress = serivce.selectById(id);
		return shipAddress;
	}
	
	@RequestMapping("/doupdate.do")
	@ResponseBody
	private int doupdate(String data) {
		  TShipAddress shipAddress = JSON.parseObject(data, TShipAddress.class);
		int i = serivce.saUpdate(shipAddress);
		return i;
	}
	
	@RequestMapping("/insert.do")
	@ResponseBody
	private int insert(String data) {
		 TShipAddress shipAddress = JSON.parseObject(data, TShipAddress.class);
			int i = serivce.saInsert(shipAddress);
			return i;
	}
	
	@RequestMapping("/delete.do")
	@ResponseBody
	private int delete(int id) {
		return serivce.saDelete(id);
	}
}
