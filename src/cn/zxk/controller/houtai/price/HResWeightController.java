package cn.zxk.controller.houtai.price;

import cn.zxk.pojo.TResWeight;
import cn.zxk.service.TResWeightSerivce;
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
@RequestMapping("/houtai/resWeight")
public class HResWeightController {

	@Resource
	private TResWeightSerivce serivce;
	
	@RequestMapping("/res_weight_list.do")
	private void List(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 List<TResWeight> resWeights = serivce.Select();
		// 共享数据
		req.setAttribute("resWeights", resWeights);

		// 请求转发跳转到staff_list.jsp
		req.getRequestDispatcher("/WEB-INF/houtaiView/price/res_weight_list.jsp").forward(req, resp);
	}
	
	@RequestMapping("/update.do")
	@ResponseBody
	private TResWeight update(int id) {
		TResWeight resWeight = serivce.selectById(id);
		return resWeight;
	}
	
	@RequestMapping("/doupdate.do")
	@ResponseBody
	private int doupdate(String data) {
		TResWeight resWeight = JSON.parseObject(data, TResWeight.class);
		int i = serivce.Update(resWeight);
		return i;
	}
	
	@RequestMapping("/insert.do")
	@ResponseBody
	private int insert(String data) {
		TResWeight resWeight = JSON.parseObject(data, TResWeight.class);
			int i = serivce.Insert(resWeight);
			return i;
	}
	
	@RequestMapping("/delete.do")
	@ResponseBody
	private int delete(int id) {
		return serivce.Delete(id);
	}
}
