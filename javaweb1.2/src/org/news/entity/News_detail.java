package org.news.entity;

   /**
    * news_detail 实体类
    * 2019-05-17 11:33:35    */ 


public class News_detail{
	private int id;
	private int categoryId;
	private String title;
	private String summary;
	private String content;
	private String picPath="";
	private String author;
	private java.sql.Timestamp createDate;
	private java.sql.Timestamp modifyDate;
	public void setId(int id){
	this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setCategoryId(int categoryId){
	this.categoryId=categoryId;
	}
	public int getCategoryId(){
		return categoryId;
	}
	public void setTitle(String title){
	this.title=title;
	}
	public String getTitle(){
		return title;
	}
	public void setSummary(String summary){
	this.summary=summary;
	}
	public String getSummary(){
		return summary;
	}
	public void setContent(String content){
	this.content=content;
	}
	public String getContent(){
		return content;
	}
	public void setPicPath(String picPath){
	this.picPath=picPath;
	}
	public String getPicPath(){
		return picPath;
	}
	public void setAuthor(String author){
	this.author=author;
	}
	public String getAuthor(){
		return author;
	}
	public void setCreateDate(java.sql.Timestamp createDate){
	this.createDate=createDate;
	}
	public java.sql.Timestamp getCreateDate(){
		return createDate;
	}
	public void setModifyDate(java.sql.Timestamp modifyDate){
	this.modifyDate=modifyDate;
	}
	public java.sql.Timestamp getModifyDate(){
		return modifyDate;
	}
}

