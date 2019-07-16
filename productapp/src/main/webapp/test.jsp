<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guessing Games!</title>
</head>
<body>
	Q. What is the captial of India?
	<table>
		<tr>
			<th>Answer</th>
		</tr>
			<tr>
				<td>Lives : ${lives}</td>
				<td>${hidden}</td>
		</tr>
	</table>
	<form method ="post" action ="QuestionServlet">
		Alphabet <input type = "text" name="alpha" required /><br />
		<button type="submit">Verify</button>
	</form>	

</body>
</html>