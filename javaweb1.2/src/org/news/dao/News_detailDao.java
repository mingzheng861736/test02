package org.news.dao;
import org.news.entity.*;
import java.util.*;
public interface News_detailDao {
	/*
	 * 分页查询新闻列表
	 * 参数:
		      NewsPage page: 新闻分页的实体
		返回值: NewsPage page: 新闻分页的实体
*/
	public NewsPage getNews_details(NewsPage page) throws Exception;
	//根据新闻id获得新闻实体对象
	public News_detail getNews_detailById(int id) throws Exception;
	public List<News_detail> getLatestNews_details(int id,int limit)
			throws Exception;
	// 新增新闻
	public int addNews_detail(News_detail detail) throws Exception;
//修改新闻
	public int updateNews_detail(News_detail detail) throws Exception;
//删除新闻
	public int deleteNews_detail(int id) throws Exception;
}
