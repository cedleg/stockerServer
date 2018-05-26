<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Les produits</title>
</head>
<body>
	<div id="page">
		<table>
			<tr>
				<th>#</th>
				<th>Name</th>
				<th>Price</th>
				<th>Category</th>
			</tr>
			<c:forEach var="prod" items="${ products }">
				<tr>
					<td>${ prod.id }</td>
					<td>${ prod.name }</td>
					<td>${ prod.price }</td>
					<td>${ prod.category }</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<table>
			<tr>
				<th>#</th>
				<th>Name</th>
				<th>Price</th>
				<th>Description</th>
				<th>Products</th>
			</tr>
				<tr>
					<td>${ batch.id }</td>
					<td>${ batch.name }</td>
					<td>${ batch.price }</td>
					<td>${ batch.description }</td>
					<td>${ batch.products }</td>
				</tr>
		</table>
	</div>

</body>
</html>