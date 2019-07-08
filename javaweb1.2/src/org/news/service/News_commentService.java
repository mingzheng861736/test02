package org.news.service;
import org.news.dao.*;
import org.news.dao.impl.*;
import org.news.entity.*;
import java.util.*;
public class News_commentService {
	public List<News_comment> getNews_commentsByNId(int id) throws Exception {
		News_commentDao dao=new News_commentDaoImpl();
		return dao.getNews_commentsByNId(id);
	}
//查询最新评论的新闻列表
	public List<News_detail> getLatestNews_comments(int id, int limit) throws Exception {
		News_commentDao dao=new News_commentDaoImpl();
		return dao.getLatestNews_comments(id, limit);
	}
	public int AddNews_comment(News_comment comment) throws Exception {
		News_commentDao dao=new News_commentDaoImpl();
		return dao.AddNews_comment(comment);
	}
	public static void main(String[] args) throws Exception {
		News_commentService service=new News_commentService();
		List<News_detail> details=service.getLatestNews_comments(3, 2);
		for (News_detail news_detail : details) {
			System.out.println(news_detail.getTitle());
		}
	}
}
