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
@WebServlet("/do_news_read")
public class do_news_read extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private News_detailService news_detailService = null;
	public do_news_read() {
		news_detailService = new News_detailService();
	}
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReturnResult returnresult = null;
		try {
			String sid = request.getParameter("id");
			int id = Integer.parseInt(sid);
			News_detail detail = news_detailService.getNews_detailById(id);
			returnresult = new ReturnResult(1, detail, "");
			PrintUtil.write(returnresult, response, "yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			returnresult = new ReturnResult(-1, null, e.getMessage());
			PrintUtil.write(returnresult, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
