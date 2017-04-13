<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table width="700" align="center" border="1">
	<tr>
	<td>CurrentUser:</td><td>${currentUser.username }</td>
	</tr>
	<tr>
		<td><a href="${pageContext.request.contextPath}/user/update">Update</a></td>
	</tr>
	<tr>
		<td><a href="${pageContext.request.contextPath}/user/${currentUser.username }">User Info</a></td>
	</tr>
</table>
</body>
</html>