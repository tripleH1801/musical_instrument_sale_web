<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách nhà cung cấp</title>
</head>
<body>


	<div class="container-fluid" style="background-color: #fff">

		<!-- Row input -->
		<div class="row">
			

			<div class="col-lg-2">
				<div class="form-group">
					<label for="exampleInputEmail1">&#160;</label>
					<%-- <a type="button"
						class="form-control btn btn-primary table__btn"
						href="<c:url value='/admin/thong-tin-cua-hang/them-thong-tin-cua-hang'/>">Thêm thông tin cửa hàng</a> --%>
					<a type="button" class="form-control btn btn-primary table__btn"
						href="#" data-toggle="modal" data-target="#myModal">Cập nhật
						thông tin</a>
				</div>
			</div>
		</div>

		<div class="row">
			<label class="label-control col-lg-4">Email: ${ lienHe.email }</label>
		</div>
		<div class="row">
			<label class="label-control col-lg-4">Số điện thoại: ${ lienHe.soDienThoai }</label>
		</div>
		<div class="row">
			<label class="label-control col-lg-4">Địa chỉ: ${ lienHe.diaChi }</label>
		</div>

		<div class="modal fade" id="myModal">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<h3 class="modal-title">Cập nhật thông tin cửa hàng</h3>
						<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<form:form action="" method="POST" modelAttribute="lienHeDTO">

							<form:hidden path="id" />

							<div class="form-group">
								<label>Email:</label>
								<form:input path="email" class="form-control" />
								<form:errors path="email" cssClass="error"></form:errors>
							</div>

							<div class="form-group">
								<label>Số điện thoại:</label>
								<form:input path="soDienThoai" class="form-control" />
								<form:errors path="soDienThoai" cssClass="error"></form:errors>
							</div>

							<div class="form-group">
								<label>Tỉnh/ thành phố:</label> <select id="tinh"
									Class="form-control">
									<option value="-1" selected>Chọn Tỉnh/ Thành phố</option>
								</select>
							</div>

							<form:hidden path="tinhThanhPho" />

							<div class="form-group">
								<label>Huyện/ Quận:</label> <select id="huyen"
									Class="form-control">
									<option value="-1" selected>Chọn Huyện/ Quận</option>
								</select>
							</div>

							<form:hidden path="quanHuyen" />

							<div class="form-group">
								<label>Xã/ Phường:</label> <select id="xa" Class="form-control">
									<option value="-1" selected>Chọn Xã/ Phường</option>
								</select>
							</div>

							<form:hidden path="phuongXa" />

							<div class="form-group">
								<label>Số nhà, tên đường:</label>
								<form:input path="diaChi" class="form-control" />
								<form:errors path="diaChi" Class="error"></form:errors>
							</div>
							<div class="modal-footer">
								<button type="submit" class="btn btn-success">Lưu</button>
								<a type="button" class="btn btn-danger" data-dismiss="modal" />Hủy</a>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>

	</div>
	<!-- /.container-fluid -->
	<script src="<c:url value="/static/assets/js/diaChi.js"/>"></script>

</body>
</html>