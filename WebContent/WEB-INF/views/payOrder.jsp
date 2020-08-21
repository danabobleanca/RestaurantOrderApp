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
	<div id="receipt">
	
		<h3>ORDER PAID</h3>
		<form method="post" action="receiptRegister">
		<div id="receiptBox">
		<table>
			<tr><td>Receipt No.</td><td></td></tr>
			<tr>
				<td>PRODUCT</td>
				<td>QUANTITY</td>
				<td>PRICE</td>
			</tr>
			<c:forEach items="${products}" var="product">
			<tr>
				<td><c:out value="${product.product}"/></td>
				<td><c:out value="${product.quantity}"/></td>
				<td><c:out value="${product.price}"/></td>
			</tr>
			</c:forEach>
		</table>
		<input type="submit" value="PAY ORDER" />
		</div>
		</form>
	</div>

</body>
</html>