<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style><%@include file="style.css"%></style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="orderRegistered">
		<form method="get" action="/Restaurant/gotomenu">
			<div id="productsOrdered">
			<table>
				<tr id="head">
					<td>Receipt id</td><td>Receipt value</td><td>Receipt date</td>
				</tr>
				<c:forEach  var="receipt" items="${receipts}">
					<tr>
						<td><c:out value="${receipt.id}" /></td>
						<td><c:out value="${receipt.total}" /></td>
						<td><c:out value="${receipt.date}" /></td>
					</tr>
				</c:forEach>
			</table>
			<input type="submit" value="GO TO MENU" />
 			</div>
		</form>
	</div>

</body>
</html>