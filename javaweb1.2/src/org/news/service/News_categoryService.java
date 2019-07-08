package org.news.service;
import org.news.entity.*;
import java.util.List;
import org.news.dao.*;
import org.news.dao.impl.*;
public class News_categoryService {
	// 获取主题列表
	public List<News_category> getNews_categorys(boolean all) throws Exception {
		News_categoryDao dao=new News_categoryDaoImpl();
		return dao.getNews_categorys(all);
	}
	public News_category getNews_categoryById(int id) throws Exception {
		News_categoryDao dao=new News_categoryDaoImpl();
		return dao.getNews_categoryById(id);
	}
	public static void main(String[] args) throws Exception {
		News_categoryService service=new News_categoryService();
		News_category news_category=service.getNews_categoryById(4);
		System.out.println(news_category.getName());
	}
}
