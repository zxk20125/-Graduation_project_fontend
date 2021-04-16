package cn.zxk.controller.qiantaiCustomer.dot;

import cn.zxk.pojo.TCustomer;
import cn.zxk.pojo.TDot;
import cn.zxk.service.TdotService;
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
@RequestMapping("/qtCustomer/dot")
public class QDotController {

	@Resource
	private TdotService service;
	
	@RequestMapping("/select.do")
	private void select(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
			throws ServletException, IOException {
		TCustomer cutomer = (TCustomer) session.getAttribute("customer");

		req.setAttribute("cutomer", cutomer);

		req.getRequestDispatcher("/WEB-INF/qtCuView/dot/wangdian.jsp").forward(req, resp);
	}
	
	@RequestMapping("/dotselect.do")
	@ResponseBody
	private List<TDot> dotselect(String dotCity){
//		System.out.println(dotCity);

		String city;
		try {
			city = dotCity.substring(0, 3)+dotCity.substring(4, 7);
		} catch (StringIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
		
			return null;
		}
		
		List<TDot> dotByCity = service.dotByCity(city);
		
		if(dotByCity==null&&!dotByCity.isEmpty()) {
			return null;
		}
		return dotByCity;
	}

	@RequestMapping("/dotNameSelect.do")
	@ResponseBody
	private TDot dotNameSelect(String dotName) {
		return service.selectByName(dotName);
	}
}
