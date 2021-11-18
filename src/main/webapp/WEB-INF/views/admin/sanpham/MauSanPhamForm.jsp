<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${formTitle}</title>

<link rel="stylesheet"
	href='<c:url value ="/static/assets/css/errors.css"/>'>
</head>
<body>

	<div class="container-fluid "
		style="background-color: #fff; padding: 20px 20px;">

		<a
			href="<c:url value='/admin/san-pham/xem-chi-tiet?id=${ mauSanPhamDTO.maSanPham }' />">Quay
			lại</a>

		<!-- Row input -->
		<div class="row">
			<div class="col-lg-3"></div>
			<div class="col-lg-6">
				<h1 style="text-align: center;">${formTitle}</h1>

				<form:form action="" method="POST" modelAttribute="mauSanPhamDTO"
					enctype="multipart/form-data">

					<div class="form-group">
						<label>Màu:</label>
						<form:select path="maMau" Class="form-control">
							<form:options items="${ maus }" itemValue="id" itemLabel="tenMau" />
						</form:select>
					</div>
					<div class="form-group">
						<label>Số lượng:</label>
						<form:input path="soLuong" class="form-control" />
						<form:errors path="soLuong" cssClass="error"></form:errors>
					</div>

					<div class="form-group">
						<label>Chọn ảnh:</label> <input type="file" name="hinhAnh"
							multiple="multiple" />
					</div>

					<button type="submit" class="btn btn-success">${formButton}</button>
					<button type="reset" class="btn btn-danger">Hủy</button>

				</form:form>


			</div>

			<div class="col-lg-3"></div>
		</div>





	</div>
	<!-- /.container-fluid -->
</body>
</html>