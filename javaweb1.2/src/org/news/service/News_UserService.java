package org.news.service;
import org.news.dao.*;
import org.news.dao.impl.*;
import org.news.entity.*;
public class News_UserService {
	public News_user findUser(String name, String pwd) throws Exception {
		News_UserDao dao=new News_UserDaoImpl();
		return dao.findUser(name, pwd);
	}
	public static void main(String[] args) throws Exception {
		News_UserService service=new News_UserService();
		News_user user=service.findUser("admin1", "admin");
		System.out.println(user==null);
	}
}
