package org.news.web;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.news.entity.News_user;
import org.news.service.News_UserService;
import org.news.util.PrintUtil;
import org.news.util.ReturnResult;
@WebServlet("/do_login")
public class do_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private News_UserService news_UserService = null;
	public do_login() {
		news_UserService = new News_UserService();
	}
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReturnResult returnresult = null;
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			HttpSession session = request.getSession();
			News_user user = news_UserService.findUser(username, password);
			if (user != null) {
				session.setAttribute("user", user);
				session.setMaxInactiveInterval(10 * 60);
				returnresult=new ReturnResult(1, null, "");
			} else {
				returnresult=new ReturnResult(-1, null, "用户名或密码错误!");
			}
		} catch (Exception e) {
			returnresult=new ReturnResult(-1, null, e.getMessage());
		}
		PrintUtil.write(returnresult, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
