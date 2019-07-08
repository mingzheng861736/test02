<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.news.entity.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="js/indexTop.js"></script>
<!--页面顶部-->
<div id="header">
	<div class="main-top">
		<div class="logo">
			<a href=""><span>新闻大视野</span></a>
		</div>
		<div class="login-box">
			<c:set var="user" value="${sessionScope.user }"></c:set>
			<c:choose>
				<c:when test="${not empty user }">
					欢迎:${user.userName }
					&nbsp;&nbsp;<a href='jsp/admin/admin.jsp'>新闻管理</a>
					&nbsp;&nbsp;<a href='do_logout'>注销</a>
				</c:when>
				<c:otherwise>
					<form action="" id="frmlogin">
						<label>用户名</label><input type="text" name="username" id="username"
							value="wangxy" /><label>密码</label><input type="password"
							name="password" id="password" value="123" /> <input
							type="button" class="submit" value="登录" onclick="login();">
					</form>
				</c:otherwise>
			</c:choose>
		</div>

	</div>
	<!--banner-->
	<div class="main-banner">
		<img src="images/banner.png" />
	</div>
	<!--搜索横框-->
	<div class="search-box">
		<div class="sl">
			<div class="sr clearfix">

				<span class="left-search clearfix"> <label>站内搜索</label><input
					type="text" name="keyword" value="关键词" />
					<button class="go-btn"></button>
				</span> <span class="right-link"> <label>快速链接</label><select><option>-----专题选择-----</option></select>
					<button class="go-btn"></button>
				</span>

			</div>
		</div>
	</div>
</div>