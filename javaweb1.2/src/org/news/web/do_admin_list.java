package org.news.web;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.news.entity.NewsPage;
import org.news.service.News_detailService;
import org.news.util.PrintUtil;
import org.news.util.ReturnResult;
@WebServlet("/do_admin_list")
public class do_admin_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private News_detailService news_detailService = null;
	public do_admin_list() {
		news_detailService = new News_detailService();
	}
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReturnResult returnresult = null;
		try {
			// 新闻列表
			String scid = request.getParameter("categoryId");
			int cid = (scid == null) ? 1 : Integer.parseInt(scid);
			String scurrPageNo = request.getParameter("currPageNo");
			int currPageNo = (scurrPageNo == null) ? 1 : Integer.parseInt(scurrPageNo);
			NewsPage newspage = new NewsPage();
			newspage.setId(cid);
			newspage.setPageSize(20);
			newspage.setCurrPageNo(currPageNo);
			newspage = news_detailService.getNews_details(newspage);
			returnresult = new ReturnResult(1, newspage, "");
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
