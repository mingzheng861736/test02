package org.news.dao;
import org.news.entity.*;
public interface News_UserDao {
	public News_user findUser(String name, String pwd) throws Exception;
}
