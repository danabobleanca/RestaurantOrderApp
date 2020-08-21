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

	<div id="menuItems">
	<div id="menuAction"><div><a href="/Restaurant/ordersUnpaid">VIEW CURRENT ORDERS UNPAID</a></div><div><a href="/Restaurant/receipts">VIEW ALL RECEIPTS</a></div> </div>
		<h2>MENU</h2>
		<form method="post" action="continueOrder">
		<div id="item">
			<c:forEach items="${menuItems}" var="menu">
				<div> 
					 <c:out value="${menu.key}"/> <br/> <c:out value="${menu.value}"/> RON <input type="checkbox" name="menu" value="${menu.key}"/>
				</div>
			</c:forEach>
			</div>
			<input type="submit" value="Continue Order"/>
		</form>
	</div>
</body>
</html>