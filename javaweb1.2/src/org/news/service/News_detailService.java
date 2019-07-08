package org.news.service;
import org.news.entity.*;
import java.util.List;
import org.news.dao.*;
import org.news.dao.impl.*;
public class News_detailService {
	public NewsPage getNews_details(NewsPage page) throws Exception {
		News_detailDao dao = new News_detailDaoImpl();
		return dao.getNews_details(page);
	}
	public News_detail getNews_detailById(int id) throws Exception {
		News_detailDao dao = new News_detailDaoImpl();
		return dao.getNews_detailById(id);
	}
	public List<News_detail> getLatestNews_details(int id, int limit) throws Exception {
		News_detailDao dao = new News_detailDaoImpl();
		return dao.getLatestNews_details(id, limit);
	}
	// 新增新闻
	public int addNews_detail(News_detail detail) throws Exception {
		News_detailDao dao = new News_detailDaoImpl();
		return dao.addNews_detail(detail);
	}
	// 修改新闻
	public int updateNews_detail(News_detail detail) throws Exception {
		News_detailDao dao = new News_detailDaoImpl();
		return dao.updateNews_detail(detail);
	}
	// 删除新闻
	public int deleteNews_detail(int id) throws Exception {
		News_detailDao dao = new News_detailDaoImpl();
		return dao.deleteNews_detail(id);
	}
	public static void main(String[] args) throws Exception {
		News_detailService service = new News_detailService();
		List<News_detail> details = service.getLatestNews_details(3, 5);
		for (News_detail news_detail : details) {
			System.out.println(news_detail.getTitle());
		}
	}
}
