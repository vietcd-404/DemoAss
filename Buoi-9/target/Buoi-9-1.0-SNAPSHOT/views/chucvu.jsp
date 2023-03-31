<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 3/27/2023
  Time: 2:02 PM
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
<center>
	<h1>Quản lý chức vụ</h1>
</center>
<form action="ChucVuServlet" method="post">

	<div class="mb-3">
		<label class="form-label ">Id</label>
		<input name="id" value="${cv.id}" type="text" class="form-control " disabled>
	</div>
	<div class="mb-3">
		<label class="form-label">Mã</label>
		<input name="ma" value="${cv.ma}" type="text" class="form-control">
	</div>
	<div class="mb-3">
		<label class="form-label">Tên</label>
		<input name="ten" value="${cv.ten}" type="text" class="form-control">
	</div>
<%--	<button type="submit" class="btn btn-outline-secondary">Thêm</button>--%>

>


	<button formaction="/chuc-vu/add" type="submit" class="btn btn-outline-secondary">Thêm</button>
	<button formaction="/chuc-vu/update?id=${cv.id}" class="btn btn-outline-secondary">
		Sửa
	</button>
	<button formaction="/chuc-vu/reset" type="submit" class="btn btn-outline-secondary">Clear</button>

<table class="table table-bordered table-hover">
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
				<a href="/chuc-vu/detail?id=${u.id}">Sửa</a>
				<a href="/chuc-vu/delete?id=${u.id}">Xóa</a>
			</td>
		</tr>
	</c:forEach>

	</tbody>
</table>
</form
</body>
</html>