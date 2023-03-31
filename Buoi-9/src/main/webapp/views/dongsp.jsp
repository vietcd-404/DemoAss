<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 3/27/2023
  Time: 2:22 PM
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
<body class="container">
<center >
	<h1>Quản lý dòng sản phẩm</h1>
</center>
<form action="DongSpServlet" method="post">
	<div class="row mb-3">
		<div class="col-3">Id:</div>
		<div class="col-3">
			<input
					value="${dongSP.id}"
					disabled
					name="id"
					class="form-control"
					type="text"
					aria-label="readonly input example"
			/>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col-3">Mã:</div>
		<div class="col-3">
			<input
					value="${dongSP.ma}"
					name="ma"
					class="form-control"
					type="text"
					aria-label="readonly input example"
			/>
		</div>
	</div>
	<div class="row mb-3">
		<div class="col-3">Tên:</div>
		<div class="col-3">
			<input
					value="${dongSP.ten}"
					name="ten"
					class="form-control"
					type="text"
					aria-label="readonly input example"
			/>
		</div>
	</div>
	<button formaction="/dongsp/add" type="submit" class="btn btn-outline-secondary">Thêm</button>
	<button formaction="/dongsp/update?id=${dongSP.id}" class="btn btn-outline-secondary">
		Sửa
	</button>
	<hr>
	<table class="table">
		<thead>
		<tr>
			<th scope="col">Id</th>
			<th scope="col">Mã</th>
			<th scope="col">Tên</th>

		</tr>
		</thead>
		<tbody>
		<c:forEach var="u" items="${list}">
			<tr>
				<th scope="row">${u.id}</th>
				<td>${u.ma}</td>
				<td>${u.ten}</td>

				<td>
					<a href="/dongsp/detail?id=${u.id}">Sửa</a>
					<a href="/dongsp/delete?id=${u.id}">Xóa</a>
				</td>
			</tr>
		</c:forEach>

		</tbody>
	</table>
</form>
</body>
</html>
