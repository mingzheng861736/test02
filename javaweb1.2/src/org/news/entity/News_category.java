package org.news.entity;

   /**
    * news_category 实体类
    * 2019-05-17 11:33:35    */ 


public class News_category{
	private int id;
	private String name;
	private java.sql.Timestamp createDate;
	public void setId(int id){
	this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setName(String name){
	this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setCreateDate(java.sql.Timestamp createDate){
	this.createDate=createDate;
	}
	public java.sql.Timestamp getCreateDate(){
		return createDate;
	}
}

