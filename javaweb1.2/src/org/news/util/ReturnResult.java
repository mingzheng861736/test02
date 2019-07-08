package org.news.util;
//传至客户端的json数据
public class ReturnResult {
	private int status;// 1:成功 -1:失败
	private Object data;// json包含的数据
	private String message;// 消息
	public ReturnResult(int status, Object data, String message) {
		this.status = status;
		this.data = data;
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
