package cn.zxk.controller.houtai;

import cn.zxk.pojo.TStaff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/houtaiIndex.do")
public class IndexController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		TStaff staff = (TStaff)req.getSession().getAttribute("staff");
		req.setAttribute("staff", staff);
		System.out.println(staff);
		//使用请求转发到index.jsp
		req.getRequestDispatcher("WEB-INF/houtaiView/index.jsp").forward(req, resp);
	}

}
