package cn.zxk.controller.qiantaiStaff.send;

import cn.zxk.pojo.TSend;
import cn.zxk.pojo.TStaff;
import cn.zxk.service.TSendSerivce;
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
@RequestMapping("/qtStaff/send")
public class SSendController {

	@Resource
	private TSendSerivce serivce;
	
	//显示派送界面
	@RequestMapping("/send.do")
	private void send(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
			throws ServletException, IOException, StringIndexOutOfBoundsException {
		TStaff staff = (TStaff) session.getAttribute("staff");
		req.setAttribute("staff", staff);
		
		req.getRequestDispatcher("/WEB-INF/qtStView/send/paisong.jsp").forward(req, resp);
	}
	
	//设置派送
	@RequestMapping("/dosend.do")
	@ResponseBody
	private int dosend(HttpServletRequest req,HttpSession session,TSend data) {
		TStaff staff = (TStaff) session.getAttribute("staff");
		if(staff==null) {
			return 0;
		}
		if(data.getWaybillId().substring(0,1).equals(" ")) {
			data.setWaybillId( data.getWaybillId().substring(1));
		}
		req.setAttribute("staff", staff);
		data.setStaff(staff);
		data.setStaffId(staff.getStaffId());
		int i = serivce.Deliver(data);
		return i;
	}
	
	//显示处理派送
	@RequestMapping("/finish.do")
	private void finish(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
			throws ServletException, IOException, StringIndexOutOfBoundsException {
		TStaff staff = (TStaff) session.getAttribute("staff");
		req.setAttribute("staff", staff);
		
		req.getRequestDispatcher("/WEB-INF/qtStView/send/chuli.jsp").forward(req, resp);
	}
	
	//签收
	@RequestMapping("/qianshou.do")
	@ResponseBody
	private int qianshou(HttpSession session,HttpServletRequest req,String waybillId) {
		TStaff staff = (TStaff) session.getAttribute("staff");
		if(staff==null) {
			return 0;
		}
		if(waybillId.substring(0,1).equals(" ")) {
			waybillId = waybillId.substring(1);
		}
		
		int j = serivce.isnotsend(waybillId);
		if(j==0) {
			return 2;
		}
		
		req.setAttribute("staff", staff);
		int i = serivce.signforOrDeny(waybillId, 0, null);
		return i;
	}
	
	//拒签
		@RequestMapping("/juqian.do")
		@ResponseBody
		private int juqian(HttpSession session,HttpServletRequest req,String waybillId,String rejectReasons) {
			TStaff staff = (TStaff) session.getAttribute("staff");
			if(staff==null) {
				return 0;
			}
			if(waybillId.substring(0,1).equals(" ")) {
				waybillId = waybillId.substring(1);
			}
			int j = serivce.isnotsend(waybillId);
			if(j==0) {
				return 2;
			}
			req.setAttribute("staff", staff);
			int i = serivce.signforOrDeny(waybillId, 1, rejectReasons);
			return i;
		}
}
