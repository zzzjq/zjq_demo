<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="mainform" action="" method="post">
		<table>
			<tr>
				<td align="right">姓名： </td>
				<td>
					<input type="text" id="name" name="name">
				</td>
				<td align="right">身份证： </td>
				<td>
					<input type="text" id="identity" name="identity">
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" name="sub" value="提 交" onclick="query();">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript">
	function query(){
		var param = $("#mainform").serialize();
		$.ajax({
			type : 'post',
			url : "${pageContext.request.contextPath}/ajax/query",
			dataType : 'JSON',
			data : param,
			success : function(result){
				alert(result.msg);
			}
		});
	}
</script>