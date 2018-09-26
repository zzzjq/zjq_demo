<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>上传文件</title>
</head>
<body>
	<div>
		<form id="fileForm" action="excel" method="post" enctype="multipart/form-data">
   		    <input id="excelFile" name="excelFile" type="file" value="选择文件" />
    		<input type="submit" value="上  传" />
		</form>
	</div>
</body>
</html>