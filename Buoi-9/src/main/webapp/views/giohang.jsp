<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 3/27/2023
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Title</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet"
		  integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
</head>
<body>
<table class="table">
	<thead>
	<tr>
		<td>id</td>
		<td>Ma</td>
		<td>Ten</td>
		<td>Gia Ban</td>
		<td>Action</td>
	</tr>
	</thead>
	<tbody>
<%--	<c:forEach var="u" items="${list}">--%>
<%--		<tr>--%>
<%--			<th scope="row">${u.id}</th>--%>
<%--			<td>${u.ma}</td>--%>
<%--			<td>${u.ngayThanhToan}</td>--%>
<%--			<td>${u.tenNguoiNhan}</td>--%>
<%--			<td>${u.diaChi}</td>--%>
<%--			<td>${u.sdt}</td>--%>
<%--			<td>${u.tinhTrang}</td>--%>
<%--   --%>

<%--		</tr>--%>
<%--	</c:forEach>--%>
<c:forEach var="items" items="${cart}">
	<tr>
		<td>${items.productId}</td>
		<td>${items.productName}</td>
		<td>${items.quantity}</td>
		<td>${items.price}</td>
		<td>${items.quantity *items.price}</td>
	</tr>
</c:forEach>
	</tbody>
</table>
</body>
</html>
