<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 3/27/2023
  Time: 2:06 PM
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
<form action="CuaHangServlet" method="post">
<div class="row mb-3">
	<div class="col-3"><h5>Id:</h5></div>
	<div class="col-3">
		<input
				value="${ch.id}"
				disabled
				name="id"
				class="form-control"
				type="text"
				aria-label="readonly input example"
		/>
	</div>
</div>
<div class="row mb-3">
	<div class="col-3"><h5>Mã:</h5></div>
	<div class="col-3">
		<input
				value="${ch.ma}"
				name="ma"
				class="form-control"
				type="text"
				aria-label="readonly input example"
		/>
	</div>
</div>
<div class="row mb-3">
	<div class="col-3"><h5>Tên:</h5></div>
	<div class="col-3">
		<input
				value="${ch.ten}"
				name="ten"
				class="form-control"
				type="text"
				aria-label="readonly input example"
		/>
	</div>
</div>
<div class="row mb-3">
	<div class="col-3"><h5>Địa chỉ:</h5></div>
	<div class="col-3">
		<input
				value="${ch.diaChi}"
				name="diaChi"
				class="form-control"
				type="text"
				aria-label="readonly input example"
		/>
	</div>
</div>
<div class="row mb-3">
	<div class="col-3"><h5>Thành phố:</h5></div>
	<div class="col-3">
		<input
				value="${ch.thanhPho}"
				name="thanhPho"
				class="form-control"
				type="text"
				aria-label="readonly input example"
		/>
	</div>
</div>
<div class="row mb-3">
	<div class="col-3"><h5>Quốc gia:</h5></div>
	<div class="col-3">
		<input
				value="${ch.quocGia}"
				name="quocGia"
				class="form-control"
				type="text"
				aria-label="readonly input example"
		/>
	</div>
</div>
<button formaction="/cua-hang/add" type="submit" class="btn btn-outline-secondary">Thêm</button>
<button formaction="/cua-hang/update?id=${ch.id}" class="btn btn-outline-secondary">
	Sửa
</button>
<table class="table">
	<thead>
	<tr>
		<th scope="col">Id</th>
		<th scope="col">Mã</th>
		<th scope="col">Tên</th>
		<th scope="col">Địa chỉ</th>
		<th scope="col">Thành phố</th>
		<th scope="col">Quốc gia</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="u" items="${list}">
		<tr>
			<th scope="row">${u.id}</th>
			<td>${u.ma}</td>
			<td>${u.ten}</td>
			<td>${u.diaChi}</td>
			<td>${u.thanhPho}</td>
			<td>${u.quocGia}</td>
			<td>
				<a href="/cua-hang/detail?id=${u.id}">Sửa</a>
				<a href="/cua-hang/delete?id=${u.id}">Xóa</a>
			</td>
		</tr>
	</c:forEach>

	</tbody>
</table>
</form>
</body>
</html>
