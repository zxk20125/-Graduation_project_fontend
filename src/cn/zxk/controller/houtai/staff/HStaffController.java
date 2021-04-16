package cn.zxk.controller.houtai.staff;

import cn.zxk.pojo.TStaff;
import cn.zxk.service.TStaffSerivce;
import cn.zxk.util.staffdoupdate;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/houtai/staff")
public class HStaffController {

	@Resource
	private TStaffSerivce serivce;

	// 登录
	@RequestMapping("/login.do")
	@ResponseBody
	private int login(@RequestParam("staff_login_name") String login_name,
			@RequestParam("staff_password") String password, HttpSession session) {

		TStaff staff = serivce.staffLogin(login_name, password);
		if (!login_name.equals("admin")) {
			return 0;
		}
		session.setAttribute("staff", staff);
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

	// 员工列表
	@RequestMapping("/list.do")
	private void staffList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<TStaff> staffs = serivce.staffSelect();
		// 共享数据
		req.setAttribute("staffs", staffs);

		// 请求转发跳转到staff_list.jsp
		req.getRequestDispatcher("/WEB-INF/houtaiView/staff/staff_list.jsp").forward(req, resp);
	}

	// 显示员工详细信息（修改框中的员工信息）
	@RequestMapping("/update.do")
	@ResponseBody
	private TStaff staffUpdate(@RequestParam("id") int staff_id) {
		TStaff staff = serivce.staffSelectById(staff_id);
		System.out.println(staff);
		return staff;
	}

	// 修改员工
	@RequestMapping("/doupdate.do")
	@ResponseBody
	private int staffDoUpdate(String data, String dotName) {
//		System.out.println(data);
//		System.out.println(dotName);

		staffdoupdate staff = JSON.parseObject(data, staffdoupdate.class);
//		System.out.println(staff);
		int i = serivce.staffUpdate(staff.getStaffId(), staff.getStaffName(), staff.getStaffLoginName(),
				staff.getStaffPassword(), staff.getStaffAge(), staff.getStaffSex(), staff.getStaffPhone(),
				staff.getDotName());
		return i;
	}

	// 删除员工
	@RequestMapping("/delete.do")
	@ResponseBody
	private int staffDelete(int id) {
		int i = serivce.staffDelete(id);
		return i;
	}

	// 跳转添加员工页面
	@RequestMapping("/insert.do")
	private void staffInsert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/houtaiView/staff/staff_insert.jsp").forward(req, resp);
	}
	
	//添加员工
	@RequestMapping("/doinsert.do")
	@ResponseBody
	private int staffDoInsert(String data) {
//		System.out.println(data);
		staffdoupdate staff = JSON.parseObject(data, staffdoupdate.class);
		int i = serivce.staffInsert(staff.getStaffName(), staff.getStaffLoginName(), staff.getStaffPassword(), staff.getStaffAge(), staff.getStaffSex(), staff.getStaffPhone(), staff.getDotName());
		return i;
	}
}
