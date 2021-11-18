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
	<style type="text/css">
		input{
			border: none;
			outline: none;
			width: 100%;'
		}
	</style>
</head>
<body>
<div class="container" style="padding: 0">
		<a href="/WebsiteBanNhacCu/admin/nguoi-dung/danh-sach-nguoi-dung">Quay
			lại </a>
	</div>

	<div class="wrapper container">

		<div class="side_right">

				<div class="form-group row">
					<label for="fullName" class="col-sm-2 col-form-label">Họ và
						tên</label>
					<div class="col-sm-10">
						<input value="${nguoiDung.hoTen }" readonly="readonly">
					</div>
				</div>
				<div class="form-group row">
					<label for="soDienThoai" class="col-sm-2 col-form-label">Số
						điện thoại</label>
					<div class="col-sm-10">
						<input value="${nguoiDung.soDienThoai }" readonly="readonly">
					</div>
				</div>

				<div class="form-group row">
					<label for="email" class="col-sm-2 col-form-label">Email</label>
					<div class="col-sm-10">
						<input value="${nguoiDung.email }" readonly="readonly">
					</div>
				</div>

				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Địa chỉ</label>
					<div class="col-sm-10">
						<input value="${nguoiDung.diaChi }" readonly="readonly">
					</div>

				</div>

				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Trạng thái</label>
					<div class="col-sm-10">
						<c:if test="${nguoiDung.trangThai == true }">
							<input value="Đã xác minh" readonly="readonly">
						</c:if>
						<c:if test="${nguoiDung.trangThai == false }">
							<input value="Chưa Xác minh" readonly="readonly">
						</c:if>
					</div>
				</div>
				
				
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Số đơn hàng đã có</label>
					<div class="col-sm-10">
						<input value="${soLuongHoaDon}" readonly="readonly">
					</div>

				</div>


		</div>
	</div>

	<script
		src="<c:url value="/static/assets/js/ThongTinCaNhan/ThongTinCaNhan.js"/>">
	</script>
</body>
</html>