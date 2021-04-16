package cn.zxk.controller.houtai.dot;

import cn.zxk.pojo.TDot;
import cn.zxk.service.TdotService;
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
@RequestMapping("/houtai/dot")
public class HDotController {

	@Resource
	private TdotService serivce;
	
	@RequestMapping("/list.do")
	@ResponseBody
	private void dotList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<TDot> dots = serivce.dotselectAll();
		// 共享数据
		req.setAttribute("dots", dots);

		// 请求转发跳转到staff_list.jsp
		req.getRequestDispatcher("/WEB-INF/houtaiView/dot/dot_list.jsp").forward(req, resp);
	}
	
	@RequestMapping("/update.do")
	@ResponseBody
	private TDot dotUpdate(int id) {
		TDot dot = serivce.dotselectById(id);
		return dot;
	}
	
	@RequestMapping("/doupdate.do")
	@ResponseBody
	private int dotDoUpdate(String data) {
		  TDot dot = JSON.parseObject(data, TDot.class);
		  int i = serivce.dotUpdate(dot);
		return i;
	}
	
	@RequestMapping("/insert.do")
	private void dotInsert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/houtaiView/dot/dot_insert.jsp").forward(req, resp);
	}
	
	@RequestMapping("/doinsert.do")
	@ResponseBody
	private int dotDoInsert(String data) {
		 TDot dot = JSON.parseObject(data, TDot.class);
//		 System.out.println(dot);
		 int i = serivce.dotInsert(dot);
		return i;
	}
}
