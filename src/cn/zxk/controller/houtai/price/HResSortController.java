package cn.zxk.controller.houtai.price;

import cn.zxk.pojo.TResSort;
import cn.zxk.service.TResSortSerivce;
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
@RequestMapping("/houtai/resSort")
public class HResSortController {

	@Resource
	private TResSortSerivce serivce;
	
	@RequestMapping("/res_sort_list.do")
	private void List(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<TResSort> resSorts = serivce.ssSelect();
		// 共享数据
		req.setAttribute("resSorts", resSorts);

		// 请求转发跳转到staff_list.jsp
		req.getRequestDispatcher("/WEB-INF/houtaiView/price/res_sort_list.jsp").forward(req, resp);
	}
	
	@RequestMapping("/update.do")
	@ResponseBody
	private TResSort update(int id) {
		TResSort resSort = serivce.selctById(id);
		return resSort;
	}
	
	@RequestMapping("/doupdate.do")
	@ResponseBody
	private int doupdate(String data) {
		  TResSort resSort = JSON.parseObject(data, TResSort.class);
		int i = serivce.ssUpdate(resSort);
		return i;
	}
	
	@RequestMapping("/insert.do")
	@ResponseBody
	private int insert(String data) {
		 TResSort resSort = JSON.parseObject(data, TResSort.class);
			int i = serivce.ssInsert(resSort);
			return i;
	}
	
	@RequestMapping("/delete.do")
	@ResponseBody
	private int delete(int id) {
		return serivce.ssDelete(id);
	}
}
