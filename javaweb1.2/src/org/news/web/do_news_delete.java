package org.news.web;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.news.service.News_detailService;
import org.news.util.PrintUtil;
import org.news.util.ReturnResult;
@WebServlet("/do_news_delete")
public class do_news_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private News_detailService news_detailService = null;
	public do_news_delete() {
		news_detailService = new News_detailService();
	}
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReturnResult returnresult = null;
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			// 删除新闻记录
			news_detailService.deleteNews_detail(id);
			returnresult = new ReturnResult(1, null, "删除新闻成功!");
		} catch (Exception e) {
			returnresult = new ReturnResult(-1, null, e.getMessage());
		}
		PrintUtil.write(returnresult, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
