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
<link rel="stylesheet"
	href='<c:url value ="/static/assets/css/errors.css"/>'>
</head>
<body>
<div class="container" style="padding: 0">
		<a href="/WebsiteBanNhacCu/admin/nguoi-dung/danh-sach-nguoi-dung">Quay
			lại </a>
	</div>
	<div class="wrapper container">

		<div class="side_right">

			<form:form method="POST" modelAttribute="user">
				<form:hidden path="userId" />
				<div class="form-group row">
					<label for="fullName" class="col-sm-2 col-form-label">Họ và
						tên</label>
					<div class="col-sm-10">
						<%-- <form:input type="text" class="form-control" path="fullName"  /> --%>
						<form:input type="text" class="form-control" path="fullName" />
						<form:errors path="fullName" cssClass="error"></form:errors>
					</div>
				</div>
				<div class="form-group row">
					<label for="soDienThoai" class="col-sm-2 col-form-label">Số
						điện thoại</label>
					<div class="col-sm-10">
						<form:input type="text" class="form-control" path="phone" />
						<form:errors path="phone" cssClass="error"></form:errors>
					</div>
				</div>

				<div class="form-group row">
					<label for="email" class="col-sm-2 col-form-label">Email</label>
					<div class="col-sm-10">
						<form:input type="text" readonly="true" class="form-control"
							path="email" />
						<form:errors path="email" cssClass="error"></form:errors>
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
				
				<div class="form-group row">
					<label class="col-sm-2 col-form-label">Trạng thái</label>
					<div class = "col-sm-10">
					<select class="  custom-select col-3" id="trangThaiCbo" onchange="thayDoiTrangThai()">
							<c:if test="${trangThai == 1 }">
								<option value="1" selected>Đã xác minh</option>
								<option value="0">Chưa Xác minh</option>
							</c:if>
							<c:if test="${trangThai == 0 }">
								<option value="1">Đã xác minh</option>
								<option value="0" selected>Chưa Xác minh</option>
							</c:if>
						</select>
					</div>
				</div>

				<input value="${ trangThai }" type="hidden" name="trangThai"
					id="trangThai">

				<button class="btn btn-warning btnSubmit" type="submit">Cập
					nhật</button>
			</form:form>


		</div>
	</div>

	<script
		src="<c:url value="/static/assets/js/ThongTinCaNhan/ThongTinCaNhan.js"/>">
		
	</script>
	<script src="<c:url value="/static/assets/js/diaChi.js"/>"></script>
	<script type="text/javascript">
		function thayDoiTrangThai(){
			document.getElementById("trangThai").value = document.getElementById("trangThaiCbo").value;
		}
	</script>
</body>
</html>