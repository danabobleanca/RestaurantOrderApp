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
					<td>Product Ordered</td><td>Quantity Ordered</td><td>Product Price</td>
				</tr>
				<c:forEach  var="list" items="${listProducts}">
					<tr>
						<td><c:out value="${list.product}" /></td>
						<td><c:out value="${list.quantity}" /></td>
						<td><c:out value="${list.price}"/>RON</td>
					</tr>
				</c:forEach>
				<tr id="totalOrder"> <td>Total order</td><td colspan="2"><c:out value="${currentOrder}"/> RON</td></tr>
			</table>
			<input type="submit" value="GO TO MENU" />
 			</div>
		</form>
	</div>

</body>
</html>