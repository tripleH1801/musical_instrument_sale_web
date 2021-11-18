<%@page import="com.websitenhaccu.util.Constant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tài khoản của tôi</title>

<link rel="stylesheet"
	href="<c:url value="/static/assets/css/ThongTinCaNhan/ThongTinCaNhan.css"/>" />
</head>
<body>

	<div class="wrapper container">
		<div class="d-flex flex-row-reverse mb-3">
		<button class="btn btn-danger  " type="button" onclick="doiMatKhau()">Đổi
			mật khẩu</button>
		</div>
		
		<div class="side_right">



			<form:form method="POST" modelAttribute="user" onSubmit="if(!confirm('Bạn có muốn cập nhật thông tin?')){return false;}">
				<form:hidden path="userId" />
				<div class="form-group row">
					<label for="fullName" class="col-sm-2 col-form-label">Họ và
						tên</label>
					<div class="col-sm-10">
						<%-- <form:input type="text" class="form-control" path="fullName"  /> --%>
						<form:input type="text" class="form-control" path="fullName" />
					</div>
				</div>
				<div class="form-group row">
					<label for="soDienThoai" class="col-sm-2 col-form-label">Số
						điện thoại</label>
					<div class="col-sm-10">
						<form:input type="text" class="form-control" path="phone" />
					</div>
				</div>

				<div class="form-group row">
					<label for="email" class="col-sm-2 col-form-label">Email</label>
					<div class="col-sm-10">
						<form:input type="text" readonly="true" class="form-control"
							path="email" />
					</div>
				</div>

				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Địa chỉ</label>
					<div class="col-sm-10">
						<select class=" sel_diaChi custom-select col-3" id="tinh">
							<option selected value="-1">Chọn Tỉnh/ Thành phố</option>
						</select>
						<form:hidden path="tinhThanhPho" />

						<select class=" sel_diaChi custom-select col-3" id="huyen">
							<option selected value="-1">Chọn Huyện/ Quận</option>
						</select>
						<form:hidden path="quanHuyen" />

						<select class=" sel_diaChi custom-select col-3" id="xa">
							<option selected value="-1">Chọn Xã/ Phường</option>
						</select>
						<form:hidden path="phuongXa" />

						<form:input placeholder="Số nhà/tên đường" type="text"
							class="form-control mt-3" path="diaChi" />
						<span class="checkDiaChi"></span>
					</div>

				</div>



				<button class="btn btn-warning btnSubmit" type="submit">Cập
					nhật</button>
			</form:form>


		</div>
	</div>


	<script src="<c:url value="/static/assets/js/ThongTinCaNhan/ThongTinCaNhan.js"/>"></script>
	<script src="<c:url value="/static/assets/js/diaChi.js"/>"></script>
</body>
</html>