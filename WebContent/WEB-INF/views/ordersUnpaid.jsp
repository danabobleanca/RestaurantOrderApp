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
	<div id="orderUnpaid">
	
		<h3>ORDERS UNPAID</h3>
		<form method="get" action="payOrder">
		<div id="orderBox">
			<c:forEach items="${ordersUnpaid}" var="order">
				<div>
					No. Of Table: <input type="hidden" value="${order.noOfTable}" name="noOfTable"/><c:out value="${order.noOfTable}"/><br/><hr/>
					Total Order: <input type="hidden" value="${order.totalOrder}" name="totalOrder"/><c:out value="${order.totalOrder}"/>  RON<hr/><br/><br/>
					<input type="submit" value="PAY ORDER" />
				</div>
			</c:forEach>
		</div>
		</form>
	</div>

</body>
</html>