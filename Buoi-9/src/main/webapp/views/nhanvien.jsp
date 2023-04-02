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

<%--<section class="container">--%>
<%--	<form action="/nhan-vien/add" method="post">--%>
<%--		<div class="mb-3">--%>
<%--			<label class="form-label">Id</label>--%>
<%--			<input name="id" type="text" class="form-control">--%>
<%--		</div>--%>
<%--		<div class="mb-3">--%>
<%--			<label class="form-label">Mã</label>--%>
<%--			<input name="ma" type="text" class="form-control">--%>
<%--		</div>--%>
<%--		<div class="mb-3">--%>
<%--			<label class="form-label">Tên</label>--%>
<%--			<input name="ten" type="text" class="form-control">--%>
<%--		</div>--%>
<%--		<div class="mb-3">--%>
<%--			<label class="form-label">Tên đệm</label>--%>
<%--			<input name="tenDem" type="text" class="form-control">--%>
<%--		</div>--%>
<%--		<div class="mb-3">--%>
<%--			<label class="form-label">Họ</label>--%>
<%--			<input name="ho" type="text" class="form-control">--%>
<%--		</div>--%>
<%--		<div class="mb-3">--%>
<%--			<label class="form-label">Ngày sinh</label>--%>
<%--			<input name="ngaySinh" type="text" class="form-control">--%>
<%--		</div>--%>
<%--		<div class="mb-3">--%>
<%--			<label class="form-label">Sdt</label>--%>
<%--			<input name="sdt" type="text" class="form-control">--%>
<%--		</div>--%>
<%--		<div class="mb-3">--%>
<%--			<label class="form-label">Địa chỉ</label>--%>
<%--			<input name="diaChi" type="text" class="form-control">--%>
<%--		</div>--%>
<%--		<div class="mb-3">--%>
<%--			<label class="form-label">Giới tính</label>--%>
<%--			<input name="gioiTinh" type="text" class="form-control">--%>
<%--		</div>--%>
<%--		<div class="mb-3">--%>
<%--			<label class="form-label">Mật khẩu</label>--%>
<%--			<input name="matKhau" type="text" class="form-control">--%>
<%--		</div>--%>
<%--		<div class="mb-3">--%>
<%--			<label class="form-label">Trạng thái</label>--%>
<%--			<input name="trangThai" type="text" class="form-control">--%>
<%--		</div>--%>
<%--		<div class="mb-3">--%>
<%--			<label class="form-label">Tên chức vụ</label>--%>
<%--			<select class="form-select" aria-label="Default select example" name="chucVu.id">--%>

<%--				<c:forEach items="${listcv}" var="cv">--%>
<%--					<option value="${cv.id}" selected>${cv.ten}</option>--%>
<%--				</c:forEach>--%>
<%--			</select>--%>
<%--		</div>--%>
<%--		<div class="mb-3">--%>
<%--			<label class="form-label">Tên của hàng</label>--%>
<%--			<select class="form-select" aria-label="Default select example" name="cuaHang.id">--%>

<%--				<c:forEach items="${listch}" var="ch">--%>
<%--					<option value="${ch.id}" selected>${ch.ten}</option>--%>
<%--				</c:forEach>--%>
<%--			</select>--%>
<%--		</div>--%>

<%--		<button type="submit" class="btn btn-secondary">Thêm</button>--%>
<%--	</form>--%>
<%--</section>--%>

<form class="row g-3" method="post">
	<div class="col-md-3">
		<label for="validationDefault01" class="form-label">Mã</label>
		<input
				value="${nhanVien.ma}"
				name="ma"
				type="text"
				class="form-control"
				id="validationDefault01"
				required
		/>
	</div>
	<div class="col-md-3">
		<label for="validationDefault02" class="form-label">Tên</label>
		<input
				value="${nhanVien.ten}"
				name="ten"
				type="text"
				class="form-control"
				id="validationDefault02"
				required
		/>
	</div>
	<div class="col-md-3">
		<label for="validationDefaultUsername" class="form-label"
		>Tên đệm</label
		>
		<div class="input-group">
			<input
					value="${nhanVien.tenDem}"
					name="tenDem"
					type="text"
					class="form-control"
					id="validationDefaultUsername"
					aria-describedby="inputGroupPrepend2"
					required
			/>
		</div>
	</div>
	<div class="col-md-3">
		<label for="validationDefault03" class="form-label">Họ</label>
		<input
				value="${nhanVien.ho}"
				name="ho"
				type="text"
				class="form-control"
				id="validationDefault03"
				required
		/>
	</div>

	<div class="col-md-3">
		<label for="validationDefault05" class="form-label">Giới tính</label>
		<input
				value="${nhanVien.gioiTinh}"
				name="gioiTinh"
				type="text"
				class="form-control"
				id="validationDefault05"
				required
		/>
	</div>

	<div class="col-md-3">
		<label for="validationDefault05" class="form-label">Địa chỉ</label>
		<input
				value="${nhanVien.diaChi}"
				name="diaChi"
				type="text"
				class="form-control"
				id="validationDefault05"
				required
		/>
	</div>
	<div class="col-md-3">
		<label for="validationDefault05" class="form-label"
		>Số điện thoại</label
		>
		<input
				value="${nhanVien.sdt}"
				name="sdt"
				type="text"
				class="form-control"
				id="validationDefault05"
				required
		/>
	</div>
	<div class="col-md-3">
		<label for="validationDefault05" class="form-label">Mật khẩu</label>
		<input
				value="${nhanVien.matKhau}"
				name="matKhau"
				type="password"
				class="form-control"
				id="validationDefault05"
				required
		/>
	</div>
	<div class="col-md-3">
		<label for="validationDefault05" class="form-label">Ngày sinh</label>
		<input
				value="${ngaySinh}"
				name="ngaySinh"
				type="date"
				class="form-control"
				id="validationDefault05"
				required
		/>
	</div>
	<div class="col-md-3">
		<label for="validationDefault05" class="form-label">Trạng thái</label>
		<select class="form-select" id="validationDefault04" name="trangThai">

			<option value="0" selected ${nhanVien.trangThai ==0? "selected" : ""}>Hoạt động</option>
			<option value="1" ${nhanVien.trangThai ==1? "selected" : ""}>Không hoạt động</option>

		</select>
	</div>
	<div class="col-md-3">
		<label for="validationDefault04" class="form-label">Cửa hàng</label>
		<select class="form-select" id="validationDefault04" name="cuaHang.id">
			<c:forEach items="${listch}" var="ch">
				<option value="${ch.id}"  ${nhanVien.cuaHang.ten == ch.ten ? "selected" : ""} >${ch.ten}</option>
			</c:forEach>
		</select>
	</div>
	<div class="col-md-3">
		<label class="form-label">Chức vụ</label>
		<select class="form-select" name="chucVu.id">
			<c:forEach items="${listcv}" var="cv">
				<option value="${cv.id}"  ${nhanVien.chucVu.ten == cv.ten ? "selected" : ""} >${cv.ten}</option>
			</c:forEach>
		</select>
	</div>

	<div class="col-12">
		<button formaction="/nhan-vien/add" type="submit" class="btn btn-outline-secondary">Thêm</button>
		<button formaction="/nhan-vien/update?id=${nhanVien.id}" type="submit" class="btn btn-outline-secondary">Sửa
		</button>
	</div>


	<table class="table table-hover table-bordered">
		<thead>
		<tr>


			<th scope="col">Mã</th>
			<th scope="col">Tên</th>
			<th scope="col">Tên đệm</th>
			<th scope="col">Họ</th>
			<th scope="col">Ngày sinh</th>
			<th scope="col">Số điện thoại</th>
			<th scope="col">Địa chỉ</th>
			<th scope="col">Giới tính</th>
			<th scope="col">Tên chức vụ</th>
			<th scope="col">Tên cửa hàng</th>
			<th scope="col">Trạng thái</th>
			<th scope="col">Mật khẩu</th>
			<th scope="col">Chức năng</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="u" items="${list}">
			<tr onclick="location.href ='/nhan-vien/detail?id=${u.id}'">

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
				<td>${u.chucVu.ten}</td>
				<td>${u.cuaHang.ten}</td>
				<td>${u.trangThai==0?"Hoạt động" : "Không hoạt động"}</td>
				<td>${u.matKhau}</td>
				<td>
<%--					<a href="/nhan-vien/detail?id=${u.id}">Detail</a>--%>
					<a class="btn btn-outline-secondary" href="/nhan-vien/delete?id=${u.id}">Xóa</a>
				</td>
			</tr>
		</c:forEach>

		</tbody>
	</table>
</form>
</body>

</html>
