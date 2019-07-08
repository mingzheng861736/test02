package org.news.entity;

   /**
    * news_comment 实体类
    * 2019-05-17 11:33:35    */ 


public class News_comment{
	private int id;
	private int newsid;
	private String content;
	private java.sql.Timestamp createDate;
	private String ip;
	private String author;
	public void setId(int id){
	this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setNewsid(int newsid){
	this.newsid=newsid;
	}
	public int getNewsid(){
		return newsid;
	}
	public void setContent(String content){
	this.content=content;
	}
	public String getContent(){
		return content;
	}
	public void setCreateDate(java.sql.Timestamp createDate){
	this.createDate=createDate;
	}
	public java.sql.Timestamp getCreateDate(){
		return createDate;
	}
	public void setIp(String ip){
	this.ip=ip;
	}
	public String getIp(){
		return ip;
	}
	public void setAuthor(String author){
	this.author=author;
	}
	public String getAuthor(){
		return author;
	}
}

