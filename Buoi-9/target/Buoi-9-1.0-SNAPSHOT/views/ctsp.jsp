<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 4/2/2023
  Time: 1:56 PM
  To change this template use File | Settings | File Templates.
--%>
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
<%--${nhanVien.cuaHang.ten == ch.ten ? "selected" : ""}--%>
<form class="row g-3" method="post">
	<div class="col-md-3">
		<label for="validationDefault04" class="form-label">Sản phẩm</label>
		<select class="form-select" id="validationDefault04" name="sanPhamId">
			<c:forEach items="${listsp}" var="ch">
				<option value="${ch.id}" ${ctsp.sanPham.ten == ch.ten ? "selected" : ""}>${ch.ten}</option>
			</c:forEach>
		</select>
	</div>
	<div class="col-md-3">
		<label for="validationDefault04" class="form-label">Nhà sản xuất</label>
		<select class="form-select" id="validationDefault04" name="nsxId">
			<c:forEach items="${listnsx}" var="ch">
				<option value="${ch.id}" ${ctsp.nsx.ten == ch.ten ? "selected" : ""}>${ch.ten}</option>
			</c:forEach>
		</select>
	</div>
	<div class="col-md-3">
		<label for="validationDefault04" class="form-label">Dòng sản phẩm</label>
		<select class="form-select" id="validationDefault04" name="dongSPId">
			<c:forEach items="${listdongsp}" var="ch">
				<option value="${ch.id}" ${ctsp.dongSP.ten == ch.ten ? "selected" : ""}>${ch.ten}</option>
			</c:forEach>
		</select>
	</div>
	<div class="col-md-3">
		<label for="validationDefault04" class="form-label">Màu sắc</label>
		<select class="form-select" id="validationDefault04" name="mauSacId">
			<c:forEach items="${listdms}" var="ch">
				<option value="${ch.id}" ${ctsp.mauSac.ten == ch.ten ? "selected" : ""}>${ch.ten}</option>
			</c:forEach>
		</select>
	</div>
	<div class="col-md-3">
		<label class="form-label">Năm bảo hành</label>
		<input
				value="${ctsp.namBH}"
				name="namBH"
				type="number"
				class="form-control"
				required
		/>

	</div>
	<div class="col-md-3">
		<label class="form-label">Số lượng tồn</label>
		<input
				value="${ctsp.soLuongTon}"
				name="soLuongTon"
				type="number"
				class="form-control"
				required
		/>
	</div>
	<div class="col-md-3">
		<label class="form-label">Giá nhập</label>
		<input
				value="${ctsp.giaNhap}"
				name="giaNhap"
				type="number"
				step="0.01"
				class="form-control"
				required
		/>

	</div>
	<div class="col-md-3">
		<label class="form-label">Giá bán</label>
		<input
				value="${ctsp.giaBan}"
				name="giaBan"
				type="number"
				step="0.01"
				class="form-control"
				required
		/>
	</div>
	<div class="col-md-6">
		<label class="form-label">Mô tả</label>
		<textarea

				name="moTa"
				type="text"
				class="form-control"
				required
		>${ctsp.moTa}</textarea>
	</div>
	<div class="col-12">
		<button formaction="/ctsp/add" type="submit" class="btn btn-outline-secondary">Thêm</button>
		<button formaction="/ctsp/update?id=${ctsp.id}" type="submit" class="btn btn-outline-secondary">Sửa
		</button>
	</div>
	<table class="table table-hover table-bordered">
	<thead>
	<tr>


		<th scope="col">Sản phẩm</th>
		<th scope="col">Dòng sản phẩm</th>
		<th scope="col">Nhà sản xuất</th>
		<th scope="col">Màu sắc</th>
		<th scope="col">Năm bảo hành</th>
		<th scope="col">Số lượng tồn</th>
		<th scope="col">Giá nhập</th>
		<th scope="col">Giá bán</th>
		<th scope="col">Mô tả</th>
		<th scope="col">Chức năng</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="u" items="${list}">
		<tr onclick="location.href ='/ctsp/detail?id=${u.id}'">

				<%--			<td>${u.cuaHang.diaChi}</td>--%>
				<%--			<td>${u.cuaHang.thanhPho}</td>--%>
			<td>${u.sanPham.ten}</td>
			<td>${u.dongSP.ten}</td>
			<td>${u.nsx.ten}</td>
			<td>${u.mauSac.ten}</td>
			<td>${u.namBH}</td>
			<td>${u.soLuongTon}</td>
			<td>${u.giaNhap}</td>
			<td>${u.giaBan}</td>
			<td>${u.moTa}</td>
			<td>
					<%--					<a href="/nhan-vien/detail?id=${u.id}">Detail</a>--%>
				<a class="btn btn-outline-secondary" href="/ctsp/delete?id=${u.id}">Xóa</a>
				<a class="btn btn-outline-secondary" href="/ctsp/add-cart?product_id=${u.id}">Add to cart</a>
			</td>
		</tr>
	</c:forEach>

	</tbody>
	</table>
	<a class="btn btn-outline-secondary" href="/ctsp/cart">Giỏ hàng</a>
</form>
</body>

</html>

