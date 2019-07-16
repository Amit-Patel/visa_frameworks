<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Welcome, ${user} <br />
	<a href = "LoginServlet">Sign out</a>
	<h2>Product List using JSTL</h2>
	<form method = "post" action = "CartServlet">
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Price</th>
			<th>Select</th>
		</tr>
		<c:forEach items="${products}" var = "p"> 
			<tr>
				<td>${p.id}</td>
				<td>${p.name}</td>
				<td>${p.price}</td>
				<td><input type = "checkbox" name = "items" value ="${p.id}" /> </td>
			</tr>
		</c:forEach>
	</table>
	<button type = "submit">Add to Cart</button>
	</form>
</body>
</html>