package cn.zxk.controller.qiantaiCustomer.freight;

import cn.zxk.pojo.TResSort;
import cn.zxk.service.TResSortSerivce;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/qtCustomer/resSort")
public class QResSortController {

	@Resource
	private TResSortSerivce serivce;
	
	@RequestMapping("/list.do")
	@ResponseBody
	private List<TResSort> list(){
		List<TResSort> list = serivce.ssSelect();
		/*
		 * for (TResSort tResSort : list) { System.out.println(tResSort); }
		 */
		return list;
	}
}
