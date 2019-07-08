package org.news.filter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class CheckLogin implements Filter {
	private List<String> whitelist = null;
	public CheckLogin() {
	}
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		if (session.getAttribute("user") != null) {// 已经登录了
			chain.doFilter(request, response);// 通过
		} else {// 没有登录
			String uri = req.getRequestURI();
			uri = uri.substring(uri.lastIndexOf("/") + 1);// 请求资源的名称,比如:do_admin_list,index.jsp...
			if (uri.startsWith("do_") || uri.endsWith(".jsp")) {// 动态资源
				if (whitelist.contains(uri)) {// 判断请求的资源是否在白名单中
					chain.doFilter(request, response);// 通过
				} else {// 重定向到首页
					resp.sendRedirect(req.getContextPath() + "/index.jsp");
					return;
				}
			} else {// 静态资源
				chain.doFilter(request, response);// 通过
			}
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// 初始化白名单列表
		String strWhiteList = fConfig.getInitParameter("whitelist");
		whitelist = Arrays.asList(strWhiteList.split("\\|"));
		// System.out.println(whitelist);
	}
}
