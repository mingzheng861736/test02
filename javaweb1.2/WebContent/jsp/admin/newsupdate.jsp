<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<c:set var="basePath"
	value="${pageContext.request.scheme }://${pageContext.request.serverName }:${pageContext.request.serverPort }${path }/"></c:set>
<!DOCTYPE html>
<html>
<head>
<base href="${basePath }">
<meta charset="UTF-8">
<title>无标题文档</title>
<link type="text/css" rel="stylesheet" href="css/common.css" />
<link type="text/css" rel="stylesheet" href="css/form.css" />
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/handlebars-v4.0.11.js"></script>
<script type="text/javascript" src="js/my.js"></script>
<script type="text/javascript" src="js/newsupdate.js"></script>
</head>
<script id="newsdetail-template" type="text/x-handlebars-template">
	<input type="hidden" name="id" value="{{id}}"> <input
		type="hidden" name="hidpicpath" value="{{picPath}}">
	<p class="row">
		<label for="title">标题:</label> <input id="title" name="title"
			type="text" class="field-large" required="required"
			value="{{title}}" />
	</p>
	<p class="row">
		<label for="author">作者:</label> <input id="author"
			name="author" type="text" class="field-large"
			required="required" value="{{author}}" />
	</p>
	<p class="row">
		<label for="summary">摘要:</label>
		<textarea required="required" id="summary" name="summary"
			cols="40" rows="5" class="field-large">{{summary}}</textarea>
	</p>
	<p class="row">
		<label for="contents">内容:</label>
		<textarea required="required" id="contents" name="contents"
			cols="40" rows="5" class="field-large">{{content}}</textarea>
	</p>
	<p class="row">
		<label for="filename">上传图片:</label> <input id="filename"
			name="filename" type="file" class="field-large" />
	</p>
</script>
<body>
	<%@include file="include/adminTop.jsp"%>
	<!--主体-->
	<div id="content" class="main-content clearfix">
		<%@include file="include/adminSidebar.jsp"%>
		<div class="main-content-right">
			<!--即时新闻-->
			<div class="main-text-box">
				<div class="main-text-box-tbg">
					<div class="main-text-box-bbg">
						<form action="" id="frmnews" method="post"
							enctype="multipart/form-data">
							<c:set var="categorys" value="${categorys }"></c:set>
							<c:set var="detail" value="${detail }"></c:set>
							<fieldset>
								<h2 class="hdr-headinfo">修改新闻</h2>
								<div class="fields">
									<p class="row">
										<label for="categoryId">主题:</label> <select id="categoryId"
											name="categoryId" class="field-large"
											style="width: 302px; height: 25px;">
										</select>
									</p>

								</div>
							</fieldset>
							<table width="100%">
								<tr>
									<td style="text-align: center;" colspan="2">
										<button type="button" class="page-btn" name="save"
											onclick="updatenews();">保存</button>
										<button type="button" class="page-btn" name="return"
											onclick="javascript:location.href='jsp/admin/admin.jsp'">返回</button>
									</td>
								</tr>
							</table>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<c:import url="include/adminBottom.jsp"></c:import>
</body>
</html>