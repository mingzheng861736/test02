package org.news.dao.impl;
import org.news.dao.*;
import org.news.entity.*;
import java.util.*;
public class News_detailDaoImpl extends BaseDao implements News_detailDao {
	@Override
	public NewsPage getNews_details(NewsPage page) throws Exception {
		List<News_detail> details = new ArrayList<>();
		try {
			String sql = "select * from news_detail where 1=1 ";
			String countsql = "select count(*) from news_detail where 1=1 ";
			int id = page.getId();// 主题id
			int totalRecordCount = 0;// 总记录数
			int startIndex = (page.getCurrPageNo() - 1) * page.getPageSize();
			if (id == 1) {
				sql += "order by createdate desc limit ?,?";
				totalRecordCount = this.getRecordCount(countsql);
				rs = this.executeQuery(sql, startIndex, page.getPageSize());
			} else {
				sql += " and categoryid=? order by createdate desc limit ?,?";
				countsql += " and categoryid=?";
				totalRecordCount = this.getRecordCount(countsql, id);
				rs = this.executeQuery(sql, id, startIndex, page.getPageSize());
			}
			while (rs.next()) {
				News_detail detail = new News_detail();
				detail.setId(rs.getInt("id"));
				detail.setCategoryId(rs.getInt("categoryId"));
				detail.setTitle(rs.getString("title"));
				detail.setSummary(rs.getString("summary"));
				detail.setContent(rs.getString("content"));
				detail.setAuthor(rs.getString("author"));
				detail.setCreateDate(rs.getTimestamp("createDate"));
				detail.setModifyDate(rs.getTimestamp("modifyDate"));
				detail.setPicPath(rs.getString("picpath"));
				details.add(detail);
			}
			page.setTotalRecordCount(totalRecordCount);//
			page.setNewsList(details);
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return page;
	}
	private int getRecordCount(String sql, Object... args) throws Exception {
		int n = 0;
		try {
			this.rs = this.executeQuery(sql, args);
			if (rs.next()) {
				n = rs.getInt(1);
			}
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return n;
	}
	@Override
	public News_detail getNews_detailById(int id) throws Exception {
		News_detail detail = null;
		try {
			String sql = "select * from news_detail where id=?";
			this.rs = this.executeQuery(sql, id);
			if (rs.next()) {
				detail = new News_detail();
				detail.setId(rs.getInt("id"));
				detail.setCategoryId(rs.getInt("categoryId"));
				detail.setTitle(rs.getString("title"));
				detail.setSummary(rs.getString("summary"));
				detail.setContent(rs.getString("content"));
				detail.setAuthor(rs.getString("author"));
				detail.setCreateDate(rs.getTimestamp("createDate"));
				detail.setModifyDate(rs.getTimestamp("modifyDate"));
				detail.setPicPath(rs.getString("picpath"));
			}
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return detail;
	}
	@Override
	public List<News_detail> getLatestNews_details(int id, int limit) throws Exception {
		List<News_detail> details = new ArrayList<>();
		try {
			String sql = "select * from news_detail where 1=1 ";
			if (id == 1) {
				sql += "order by createdate desc limit ?";
				this.rs = this.executeQuery(sql, limit);
			} else {
				sql += " and categoryid=? order by createdate desc limit ?";
				this.rs = this.executeQuery(sql, id, limit);
			}
			while (rs.next()) {
				News_detail detail = new News_detail();
				detail.setId(rs.getInt("id"));
				detail.setCategoryId(rs.getInt("categoryId"));
				detail.setTitle(rs.getString("title"));
				detail.setSummary(rs.getString("summary"));
				detail.setContent(rs.getString("content"));
				detail.setAuthor(rs.getString("author"));
				detail.setCreateDate(rs.getTimestamp("createDate"));
				detail.setModifyDate(rs.getTimestamp("modifyDate"));
				detail.setPicPath(rs.getString("picpath"));
				details.add(detail);
			}
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return details;
	}
	// 新增新闻
	@Override
	public int addNews_detail(News_detail detail) throws Exception {
		String sql = "insert into news_detail(categoryId,title,author,summary,content,picpath) values(?,?,?,?,?,?)";
		return this.executeUpdate(sql, detail.getCategoryId(), detail.getTitle(), detail.getAuthor(), detail.getSummary(), detail.getContent(), detail.getPicPath());
	}
	// 修改新闻
	@Override
	public int updateNews_detail(News_detail detail) throws Exception {
		String sql = "update news_detail set categoryId=?, title=?,author=?,summary=?,content=?,picpath=?,modifydate=now() where id=?";
		return this.executeUpdate(sql, detail.getCategoryId(), detail.getTitle(), detail.getAuthor(), detail.getSummary(), detail.getContent(), detail.getPicPath(), detail.getId());
	}
	// 删除新闻
	@Override
	public int deleteNews_detail(int id) throws Exception {
		String sql = "delete from news_detail where id=?";
		return this.executeUpdate(sql, id);
	}
}
