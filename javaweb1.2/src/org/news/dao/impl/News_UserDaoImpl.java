package org.news.dao.impl;

import org.news.dao.BaseDao;
import org.news.dao.News_UserDao;
import org.news.entity.News_user;

public class News_UserDaoImpl extends BaseDao implements News_UserDao {
	@Override
	public News_user findUser(String name, String pwd) throws Exception {
		News_user user=null;
		try {
			String sql="select * from news_user where username=? and password=?";
			this.rs=this.executeQuery(sql, name,pwd);
			if(rs.next()) {
				user=new News_user();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setUserType(rs.getInt("userType"));
			}
		} finally {
			this.closeAll(conn, pstmt, rs);
		}
		return user;
	}
}
