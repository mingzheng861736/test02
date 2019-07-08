package org.news.dao;
import org.news.entity.*;
import java.util.*;
public interface News_commentDao {
	// 根据新闻id获得评论列表
	public List<News_comment> getNews_commentsByNId(int id) throws Exception;
	// 查询最新评论的新闻列表
	public List<News_detail> getLatestNews_comments(int id, int limit) throws Exception;
	//
	public int AddNews_comment(News_comment comment)throws Exception;
}
