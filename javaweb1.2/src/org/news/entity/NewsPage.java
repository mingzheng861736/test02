package org.news.entity;
import java.util.*;
//新闻分页的实体对象
public class NewsPage {
	private int id = 1;// 主题id
	private int currPageNo = 1;// 当前的页号
	private int pageSize = 0;// 每页的记录数
	private int totalRecordCount = 0;// 总的记录数
	private int totalPageCount = 0;// 总页数
	private List<News_detail> newsList = null;// 每页新闻记录列表
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCurrPageNo() {
		return currPageNo;
	}
	public void setCurrPageNo(int currPageNo) {
		this.currPageNo = currPageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRecordCount() {
		return totalRecordCount;
	}
	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
		// 计算总页数
		this.totalPageCount = (totalRecordCount % pageSize == 0) 
				? totalRecordCount / pageSize : 
					totalRecordCount / pageSize + 1;
	}
	public List<News_detail> getNewsList() {
		return newsList;
	}
	public void setNewsList(List<News_detail> newsList) {
		this.newsList = newsList;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
}
