<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 3/27/2023
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<%--<form action="/chuc-vu/update?id=${list.id}" method="post">--%>
	<div class="mb-3">
		<label class="form-label" >Id</label>
		<input value="${list.id}" name="id" type="text" class="form-control">
	</div>
		<div class="mb-3">
			<label class="form-label" >Mã</label>
			<input value="${list.ma}" name="ma" type="text" class="form-control">
		</div>
		<div class="mb-3">
			<label  class="form-label">Tên</label>
			<input value="${list.ten}" name="ten" type="text" class="form-control">
		</div>
		<button type="submit" class="btn btn-outline-secondary">Sửa</button>
	</form>
</body>
</html>
