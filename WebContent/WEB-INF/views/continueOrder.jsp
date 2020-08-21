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
	<div id="selected">
		<form method="post" action="registeredOrder">
			<div>
			<table>
			<tr id="head">
			<td>PRODUCTS</td><td>QUANTITY</td></tr>
				<c:forEach items="${items}" var="item">			
					<br/>
					<tr>
						<td><label for="${item.key}"><c:out value="${item.key}"/> </label></td>
						<td><input type="number" name="${item.key}" id="${item.key}"/></td>
					</tr>
				</c:forEach>
					<tr>
						<td><label for="table">Table no. </label></td>
						<td><input type="number" name="table" id="${item.key}"/></td>
					</tr>
				</table>
				<input type="submit" value="Register order" />
 			</div>
		</form>
	</div>

</body>
</html>