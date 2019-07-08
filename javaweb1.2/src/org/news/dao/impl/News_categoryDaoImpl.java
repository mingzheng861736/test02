package org.news.dao.impl;
import java.util.*;
import org.news.dao.BaseDao;
import org.news.dao.News_categoryDao;
import org.news.entity.News_category;
public class News_categoryDaoImpl extends BaseDao implements News_categoryDao {
	// 获取主题列表
	public List<News_category> getNews_categorys(boolean all) throws Exception {
		List<News_category> News_categorysList = new ArrayList<>();
		String sql = "select * from news_category where 1=1 ";
		if (!all) {
			sql += " and id<>1";
		}
		try {
			this.rs = this.executeQuery(sql);
			while (rs.next()) {
				News_category news_category = new News_category();
				news_category.setId(rs.getInt("id"));
				news_category.setName(rs.getString("name"));
				news_category.setCreateDate(rs.getTimestamp("createDate"));
				News_categorysList.add(news_category);
			}
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return News_categorysList;
	}

	@Override
	public News_category getNews_categoryById(int id) throws Exception {
		News_category news_category=null;
		try {
			String sql="select * from news_category where id=?";
			this.rs=this.executeQuery(sql, id);
			if(rs.next()) {
				news_category = new News_category();
				news_category.setId(rs.getInt("id"));
				news_category.setName(rs.getString("name"));
				news_category.setCreateDate(rs.getTimestamp("createDate"));
			}
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return news_category;
	}
}
