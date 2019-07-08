package org.news.web;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.news.entity.News_comment;
import org.news.service.News_commentService;
import org.news.util.PrintUtil;
import org.news.util.ReturnResult;
@WebServlet("/do_comment_add")
public class do_comment_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private News_commentService news_commentService = null;
	public do_comment_add() {
		news_commentService = new News_commentService();
	}
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReturnResult returnresult = null;
		try {
			String author = request.getParameter("author");
			int newsid = Integer.parseInt(request.getParameter("newsid"));
			String contents = request.getParameter("contents");
			String ip = request.getRemoteAddr();
			News_comment comment = new News_comment();
			comment.setAuthor(author);
			comment.setIp(ip);
			comment.setNewsid(newsid);
			comment.setContent(contents);
			news_commentService.AddNews_comment(comment);
			returnresult = new ReturnResult(1, null, "新增评论成功");
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
