package org.news.dao;
import org.news.entity.*;
import java.util.*;
//主题接口
public interface News_categoryDao {
	// 获取主题列表
	public List<News_category> getNews_categorys(boolean all) throws Exception;
	//根据主题id获得主题实体对象
	public News_category getNews_categoryById(int id) throws Exception;
}
