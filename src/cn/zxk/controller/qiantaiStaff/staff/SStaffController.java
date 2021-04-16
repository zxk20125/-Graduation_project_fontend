package cn.zxk.controller.qiantaiStaff.staff;

import cn.zxk.pojo.TStaff;
import cn.zxk.service.TStaffSerivce;
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
@RequestMapping("/qtStaff/staff")
public class SStaffController {


	@Resource
	private TStaffSerivce serivce;
	
	// 登录
		@RequestMapping("/login.do")
		@ResponseBody
		private int login(String loginName,String password, HttpSession session) {
			//System.out.println(loginName+password);
			TStaff staff = serivce.staffLogin(loginName, password);
//			System.out.println(staff);
			session.setAttribute("staff", staff);
			if(loginName.equals("admin")) {
				return 0;
			}
			if (staff != null) {
				return 1;
			}
			return 0;
		}

		// 退出登录
		@RequestMapping("/logout.do")
		private void logout(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws Exception {
			session.removeAttribute("staff");
			// 重定向到登录页面
			resp.sendRedirect(req.getContextPath() + "/view/login.jsp");
		}

		
		//员工主页
		@RequestMapping("/index.do")
		private void staffList(HttpServletRequest req, HttpServletResponse resp,HttpSession session) throws ServletException, IOException {
			TStaff staff =(TStaff) session.getAttribute("staff");
			// 共享数据
			req.setAttribute("staff", staff);

			// 请求转发跳转到staff_list.jsp
			req.getRequestDispatcher("/WEB-INF/qtStView/index.jsp").forward(req, resp);
		}
	
}
