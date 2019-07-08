package org.news.web;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.news.entity.News_detail;
import org.news.service.News_detailService;
import org.news.util.PrintUtil;
import org.news.util.ReturnResult;
@WebServlet("/do_news_add")
public class do_news_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private News_detailService news_detailService = null;
	public do_news_add() {
		news_detailService = new News_detailService();
	}
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReturnResult returnresult = null;
		try {
			ServletContext application = request.getServletContext();
			News_detail detail = new News_detail();
			// 指定上传位置
			String uploadFilePath = application.getRealPath("upload/");
			File saveDir = new File(uploadFilePath);
			// 如果目录不存在，就创建目录
			if (!saveDir.exists()) {
				saveDir.mkdir();
			}
			// 创建文件上传核心类
			FileItemFactory factory = new DiskFileItemFactory(); // 实例化一个硬盘文件工厂,用来配置上传组件ServletFileUpload
			ServletFileUpload upload = new ServletFileUpload(factory); // 用以上工厂实例化上传组件
			// 处理表单请求
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> it = items.iterator();
			while (it.hasNext()) {
				FileItem item = it.next();
				if (item.isFormField()) {// 如果是普通表单控件
					if (item.getFieldName().equals("categoryId")) {
						detail.setCategoryId(Integer.parseInt(item.getString()));
					} else if (item.getFieldName().equals("title")) {
						detail.setTitle(item.getString("utf-8"));
					} else if (item.getFieldName().equals("summary")) {
						detail.setSummary(item.getString("utf-8"));
					} else if (item.getFieldName().equals("author")) {
						detail.setAuthor(item.getString("utf-8"));
					} else if (item.getFieldName().equals("contents")) {
						detail.setContent(item.getString("utf-8"));
					}
				} else {// 如果为文件域
					String filename = item.getName();// 获得文件名
					if (filename != null && !filename.equals("")) {// 如果选择了文件
						detail.setPicPath(filename);
						File file = new File(uploadFilePath, filename);
						item.write(file);// 保存文件
					}
				}
			}
			// 插入数据库
			news_detailService.addNews_detail(detail);
			returnresult = new ReturnResult(1, null, "插入新闻成功!");
		} catch (Exception e) {
			returnresult = new ReturnResult(-1, null, e.getMessage());
		}
		PrintUtil.write(returnresult, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
