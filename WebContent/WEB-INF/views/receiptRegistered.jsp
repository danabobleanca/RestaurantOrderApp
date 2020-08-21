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
	<div id="orderRegistered" class="receiptRegistered">
		<form method="get" action="/Restaurant/gotomenu">
			<div id="productsOrdered">
			<h4>RECEIPT REGISTERED</h4>
			<input type="submit" value="GO TO MENU" />
 			</div>
		</form>
	</div>

</body>
</html>