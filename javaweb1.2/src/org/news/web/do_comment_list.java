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
@WebServlet("/do_comment_list")
public class do_comment_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private News_commentService news_commentService = null;
	public do_comment_list() {
		news_commentService = new News_commentService();
	}
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReturnResult returnresult = null;
		try {
			String sid = request.getParameter("id");
			int id = Integer.parseInt(sid);
			// 新闻评论列表
			List<News_comment> commentList = news_commentService.getNews_commentsByNId(id);
			returnresult = new ReturnResult(1, commentList, "");
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
