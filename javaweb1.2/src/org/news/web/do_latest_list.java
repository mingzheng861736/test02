package org.news.web;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import org.news.entity.*;
import org.news.service.*;
import org.news.util.PrintUtil;
import org.news.util.ReturnResult;
@WebServlet("/do_latest_list")
public class do_latest_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private News_detailService news_detailService = null;
	private News_commentService news_commentService = null;
	public do_latest_list() {
		news_detailService = new News_detailService();
		news_commentService = new News_commentService();
	}
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReturnResult returnresult = null;
		try {
			String scid = request.getParameter("categoryId");
			int cid = (scid == null) ? 1 : Integer.parseInt(scid);
			// 最新新闻
			List<News_detail> latestdetailList = news_detailService.getLatestNews_details(cid, 3);
			// 最新评论新闻
			List<News_detail> latestcommentList = news_commentService.getLatestNews_comments(cid, 3);
			Map<String, List<News_detail>> latestmap = new HashMap<>();
			latestmap.put("latestdetailList", latestdetailList);
			latestmap.put("latestcommentList", latestcommentList);
			returnresult = new ReturnResult(1, latestmap, "");
			PrintUtil.write(returnresult, response);
		} catch (Exception e) {
			returnresult = new ReturnResult(-1, null, e.getMessage());
			PrintUtil.write(returnresult, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
