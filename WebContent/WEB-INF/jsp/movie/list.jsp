<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table width="700" align="center" border="1">
	<tr>
		<th>Movie Name</th>
		<th>Date</th>
		<th>IMDB</th>
		<th>Categories</th>
	</tr>
	<c:forEach var="movie" items="${movieList }">
		<tr>
			<td><a href="${pageContext.request.contextPath}/movie/${movie.movieName }">${movie.movieName }</a></td>
			<td>${movie.date }</td>
			<td><a href=${movie.url }>${movie.url }</a></td>
			<td>
				<c:forEach var="category" items="${movie.getCategoryList() }">
					${category } 
				</c:forEach>
			</td>
		</tr>	
	</c:forEach>
</table>
</body>
</html>