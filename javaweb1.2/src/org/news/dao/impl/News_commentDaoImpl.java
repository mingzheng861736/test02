package org.news.dao.impl;
import java.util.*;
import org.news.dao.BaseDao;
import org.news.dao.News_commentDao;
import org.news.entity.*;
public class News_commentDaoImpl extends BaseDao implements News_commentDao {
	@Override
	public List<News_comment> getNews_commentsByNId(int id) throws Exception {
		List<News_comment> comments = new ArrayList<News_comment>();
		try {
			String sql = "select * from news_comment where newsid=? order by createdate desc";
			this.rs = this.executeQuery(sql, id);
			while (rs.next()) {
				News_comment comment = new News_comment();
				comment.setId(rs.getInt("id"));
				comment.setAuthor(rs.getString("author"));
				comment.setContent(rs.getString("content"));
				comment.setNewsid(rs.getInt("newsid"));
				comment.setIp(rs.getString("ip"));
				comment.setCreateDate(rs.getTimestamp("createDate"));
				comments.add(comment);
			}
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return comments;
	}
	// 查询最新评论的新闻列表
	public List<News_detail> getLatestNews_comments(int id, int limit) throws Exception {
		List<News_detail> details = new ArrayList<>();
		try {
			StringBuilder builder = new StringBuilder();
			if (id == 1) {
				builder.append("select news_detail.* from news_detail ");
				builder.append("inner join ");
				builder.append("(select newsid ");
				builder.append("from news_comment ");
				builder.append("group by newsid  ");
				builder.append("order by max(createDate) desc limit ?)temp ");
				builder.append("on news_detail.id=temp.newsid ");
				this.rs = this.executeQuery(builder.toString(), limit);
			} else {
				builder.append("select news_detail.* from news_detail ");
				builder.append("inner join ");
				builder.append("(select newsid ");
				builder.append("from news_comment inner join news_detail ");
				builder.append("on news_comment.newsid=news_detail.id ");
				builder.append("where news_detail.categoryId=? ");
				builder.append("group by newsid ");
				builder.append("order by max(news_comment.createDate) desc limit ?)temp ");
				builder.append("on news_detail.id=temp.newsid");
				this.rs = this.executeQuery(builder.toString(), id, limit);
			}
			while(rs.next()) {
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
	@Override
	public int AddNews_comment(News_comment comment) throws Exception {
		String sql="insert into news_comment(newsid,content,ip,author) values(?,?,?,?)";
		return this.executeUpdate(sql, comment.getNewsid(),comment.getContent(),comment.getIp(),comment.getAuthor());
	}
}
