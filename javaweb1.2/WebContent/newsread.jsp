<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.news.entity.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<c:set var="basePath"
	value="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${path }/"></c:set>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="${basePath }">
<title>My JSP 'doUserCreate.jsp' starting page</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/handlebars-v4.0.11.js"></script>
<script type="text/javascript" src="js/my.js"></script>
<script type="text/javascript" src="js/newsread.js"></script>
</head>
<script id="newsdetail-template" type="text/x-handlebars-template">
	<!--新闻的标题-->
	<h1>{{title}}</h1>
	<div class="source-bar">

		发布者：{{author}} 分类：新闻信息 更新时间：
		{{createDate }}
	</div>
	<div class="article-content">
		<span class="article-summary"><b>摘要：</b> {{summary}}
		</span>
		{{#if picPath}}
			<img class="image-responsive" alt="图片位置错误"
					src="${path }/upload/{{picPath}}">
		{{else}}
			暂无图片
		{{/if}}
		<p>{{content}}</P>
	</div>
</script>
<script id="commentList-template" type="text/x-handlebars-template">
	{{#each this}}
		<dl>
			<dt class="comment-top">
				<span class="fr">{{createDate}}</span>
				<b>{{addOne @index}}楼</b> <b>{{author}}</b>
			</dt>
			<dd class="comment-body">{{content}}</dd>
		</dl>
	{{/each}}
</script>
<body>
	<c:import url="include/indexTop.jsp"></c:import>
	<!--d页面主体-->
	<div id="content" class="main-content clearfix">
		<c:import url="include/indexSidebar.jsp"></c:import>
		<!--页面主体的右部，包括新闻的列表和评论内容 -->
		<div class="main-content-right">
			<!--各专题的新闻列表-->
			<div class="main-text-box">
				<div class="main-text-box-tbg">
					<div class="main-text-box-bbg">
						<div class="article-box">
							<div id="news_detail">
							
							</div>
							<div class="comment">

							</div>
							<div class="comment-form">
								<c:set var="author" value="${empty user?'匿名用户':user.userName }"></c:set>
								<form action="" method="post" id="frmcomment">
									<input type="hidden" name="author" value="${author }">
									<input type="hidden" id="newsid" name="newsid" >
									<div class="comment-form-header">
										<span>用户：${author }</span>
										<h3>发表评论：</h3>
									</div>
									<div class="comment-form-content">
										<textarea name="contents" id="contents"
											class="comment-textarea"></textarea>
										<button type="button" class="comment-btn" onclick="sendComment();">评论</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--合作媒体-->
			<div class="main-text-box">
				<div class="main-text-box-tbg">
					<div class="main-text-box-bbg">
						<div class="main-text-box-header">
							<h3>合作媒体</h3>
						</div>
						<div class="main-text-box-content">
							<ul class="link-text-ul clearfix">
								<li><a href="#">中国政府网</a></li>
								<li><a href="#">中国政府网</a></li>
								<li><a href="#">中国政府网</a></li>
								<li><a href="#">中国政府网</a></li>
								<li><a href="#">中国政府网</a></li>
								<li><a href="#">中国政府网</a></li>
								<li><a href="#">中国政府网</a></li>
								<li><a href="#">中国政府网</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:import url="include/indexBottom.jsp"></c:import>
</body>
</html>