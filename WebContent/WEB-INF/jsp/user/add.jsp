<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sf:form method="post" modelAttribute="user">
<table width="700" align="center" border="1">
	<tr>
		<td>Username:</td><td><sf:input path="username"/></td>
	</tr>
	<tr>
		<td>Password:</td><td><sf:input path="password"/></td>
	</tr>
	<tr>
		<td>Age:</td><td><sf:input path="age"/></td>
	</tr>
	<tr>
		<td>Gender:</td><td><sf:input path="gender"/></td>
	</tr>
	<tr>
		<td>Occupation:</td><td><sf:input path="occupation"/></td>
	</tr>
	<tr>
		<td>Zipcode:</td><td><sf:input path="zipcode"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="Create"/>
		</td>
	</tr>
</table>
</sf:form>

</body>
</html>