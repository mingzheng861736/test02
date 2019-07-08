package org.news.web;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.news.entity.*;
import org.news.service.*;
import org.news.util.PrintUtil;
import org.news.util.ReturnResult;
import java.util.*;
@WebServlet("/do_category_list")
public class do_category_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private News_categoryService news_categoryService = null;
	public do_category_list() {
		news_categoryService = new News_categoryService();
	}
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReturnResult returnresult = null;
		List<News_category> categorys = null;
		try {
			String opt = request.getParameter("opt");
			if (opt.equals("list")) {
				categorys = news_categoryService.getNews_categorys(true);
			} else {
				categorys = news_categoryService.getNews_categorys(false);
			}
			returnresult = new ReturnResult(1, categorys, "");
			PrintUtil.write(returnresult, response,"yyyy-MM-dd");
		} catch (Exception e) {
			returnresult = new ReturnResult(-1, null, e.getMessage());
			PrintUtil.write(returnresult, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
