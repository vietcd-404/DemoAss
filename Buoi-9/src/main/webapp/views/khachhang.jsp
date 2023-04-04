<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 3/26/2023
  Time: 5:13 PM
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
<form class="row g-3" action="KhachHangServlet" method="post" >

    <div class="col-md-3">
        <label for="validationDefault01" class="form-label">Mã</label>
        <input
                value="${khachHang.ma}"
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
                value="${khachHang.ten}"
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
                    value="${khachHang.tenDem}"
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
                value="${khachHang.ho}"
                name="ho"
                type="text"
                class="form-control"
                id="validationDefault03"
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
        <label for="validationDefault05" class="form-label">Địa chỉ</label>
        <input
                value="${khachHang.diaChi}"
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
                value="${khachHang.sdt}"
                name="sdt"
                type="text"
                class="form-control"
                id="validationDefault05"
                required
        />
    </div>
    <div class="col-md-3">
        <label for="validationDefault05" class="form-label"
        >Thành phố</label
        >
        <input
                value="${khachHang.thanhPho}"
                name="thanhPho"
                type="text"
                class="form-control"
                id="validationDefault05"
                required
        />
    </div>
    <div class="col-md-6">
        <label for="validationDefault05" class="form-label"
        >Quốc gia</label
        >
        <input
                value="${khachHang.quocGia}"
                name="quocGia"
                type="text"
                class="form-control"
                id="validationDefault05"
                required
        />
    </div>
    <div class="col-md-6">
        <label for="validationDefault05" class="form-label">Mật khẩu</label>
        <input
                value="${khachHang.matKhau}"
                name="matKhau"
                type="password"
                class="form-control"
                id="validationDefault05"
                required
        />
    </div>

   <div class="col-md-12">
       <button formaction="/khach-hang/add" type="submit" class="btn btn-outline-secondary">Thêm</button>
       <button formaction="/khach-hang/update?id=${khachHang.id}" class="btn btn-outline-secondary">
           Sửa
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
            <th scope="col">Thành phố</th>
            <th scope="col">Quốc gia</th>
            <th scope="col">Mật khẩu</th>
            <th scope="col">Chức năng</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="u" items="${list}">
            <tr>

                <td>${u.ma}</td>
                <td>${u.ten}</td>
                <td>${u.tenDem}</td>
                <td>${u.ho}</td>
                <td>${u.ngaySinh}</td>
                <td>${u.sdt}</td>
                <td>${u.diaChi}</td>
                <td>${u.thanhPho}</td>
                <td>${u.quocGia}</td>
                <td>${u.matKhau}</td>
                <td>
                    <a href="/khach-hang/detail?id=${u.id}">
                        Sửa
                    </a>
                    <a href="/khach-hang/delete?id=${u.id}">
                        Xoa
                    </a>
                </td>

            </tr>
        </c:forEach>

        </tbody>
    </table>
</form>
</body>
</html>
