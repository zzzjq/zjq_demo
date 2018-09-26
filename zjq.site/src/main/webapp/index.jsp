<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*" pageEncoding="UTF-8"%>
<%=new java.util.Date()%>
<%=new String("ok")%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>zjq首页</title>
</head>
<body>
	<p>
	<a href="upload/index">上传文件</a>
	<p>
	<a href="download/index">下载文件</a>
	<p>
	<!-- url访问 -->
	<a href="https://www.baidu.com">baidu</a>
	<p>
	<a href="loginIndex">登录</a>
	<p>
	<a href="ajax/index">ajaxtest</a>
</body>
</html>