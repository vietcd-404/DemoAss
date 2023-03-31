<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 3/27/2023
  Time: 2:05 PM
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

<section class="container">
	<form action="/nhan-vien/add" method="post">
		<div class="mb-3">
			<label class="form-label">Id</label>
			<input name="id" type="text" class="form-control">
		</div>
		<div class="mb-3">
			<label class="form-label">Mã</label>
			<input name="ma" type="text" class="form-control">
		</div>
		<div class="mb-3">
			<label class="form-label">Tên</label>
			<input name="ten" type="text" class="form-control">
		</div>
		<div class="mb-3">
			<label class="form-label">Tên đệm</label>
			<input name="tenDem" type="text" class="form-control">
		</div>
		<div class="mb-3">
			<label class="form-label">Họ</label>
			<input name="ho" type="text" class="form-control">
		</div>
		<div class="mb-3">
			<label class="form-label">Ngày sinh</label>
			<input name="ngaySinh" type="text" class="form-control">
		</div>
		<div class="mb-3">
			<label class="form-label">Sdt</label>
			<input name="sdt" type="text" class="form-control">
		</div>
		<div class="mb-3">
			<label class="form-label">Địa chỉ</label>
			<input name="diaChi" type="text" class="form-control">
		</div>
		<div class="mb-3">
			<label class="form-label">Giới tính</label>
			<input name="gioiTinh" type="text" class="form-control">
		</div>
		<div class="mb-3">
			<label class="form-label">Mật khẩu</label>
			<input name="matKhau" type="text" class="form-control">
		</div>
		<div class="mb-3">
			<label class="form-label">Trạng thái</label>
			<input name="trangThai" type="text" class="form-control">
		</div>
		<div class="mb-3">
			<label class="form-label">Tên chức vụ</label>
			<select class="form-select" aria-label="Default select example" name="chucVu.id">

				<c:forEach items="${listcv}" var="cv">
					<option value="${cv.id}" selected>${cv.ten}</option>
				</c:forEach>
			</select>
		</div>
		<div class="mb-3">
			<label class="form-label">Tên của hàng</label>
			<select class="form-select" aria-label="Default select example" name="cuaHang.id">

				<c:forEach items="${listch}" var="ch">
					<option value="${ch.id}" selected>${ch.ten}</option>
				</c:forEach>
			</select>
		</div>

		<button type="submit" class="btn btn-secondary">Thêm</button>
	</form>
</section>
<table class="table">
	<thead>
	<tr>
		<th scope="col">Id</th>
		<th scope="col">Tên chức vụ</th>
		<th scope="col">Tên cửa hàng</th>
		<th scope="col">Mã</th>
		<th scope="col">Tên</th>
		<th scope="col">tenDem</th>
		<th scope="col">Họ</th>
		<th scope="col">ngaySinh</th>
		<th scope="col">sdt</th>
		<th scope="col">diaChi</th>
		<th scope="col">gioiTinh</th>
		<th scope="col">trangThai</th>
		<th scope="col">matKhau</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="u" items="${list}">
		<tr>
			<th scope="row">${u.id}</th>
			<td>${u.chucVu.ten}</td>
			<td>${u.cuaHang.ten}</td>
<%--			<td>${u.cuaHang.diaChi}</td>--%>
<%--			<td>${u.cuaHang.thanhPho}</td>--%>
			<td>${u.ma}</td>
			<td>${u.ten}</td>
			<td>${u.tenDem}</td>
			<td>${u.ho}</td>
			<td>${u.ngaySinh}</td>
			<td>${u.sdt}</td>
			<td>${u.diaChi}</td>
			<td>${u.gioiTinh}</td>
			<td>${u.trangThai}</td>
			<td>${u.matKhau}</td>

		</tr>
	</c:forEach>

	</tbody>
</table>
</body>
</html>
