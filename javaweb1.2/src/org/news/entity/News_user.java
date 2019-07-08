package org.news.entity;

   /**
    * news_user 实体类
    * 2019-05-17 11:33:35    */ 


public class News_user{
	private int id;
	private String userName;
	private String password;
	private String email;
	private int userType;
	public void setId(int id){
	this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setUserName(String userName){
	this.userName=userName;
	}
	public String getUserName(){
		return userName;
	}
	public void setPassword(String password){
	this.password=password;
	}
	public String getPassword(){
		return password;
	}
	public void setEmail(String email){
	this.email=email;
	}
	public String getEmail(){
		return email;
	}
	public void setUserType(int userType){
	this.userType=userType;
	}
	public int getUserType(){
		return userType;
	}
}

