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

	<div class="container">
		<a href="<c:url value='/admin/thuong-hieu/danh-sach-thuong-hieu' />">Quay
			lại</a>
	</div>
	<div class="container"
		style="background-color: #fff; padding-top: 20px; padding-bottom: 20px">

		<!-- Row input -->
		<div class="row">
			<div class="col-lg-3"></div>
			<div class="col-lg-6">
				<h1 style="text-align: center;">${formTitle}</h1>

				<form:form action="" method="POST" modelAttribute="thuongHieu"
					enctype="multipart/form-data">

					<div class="form-group">
						<label>Tên thương hiệu:</label>
						<form:input path="tenThuongHieu" class="form-control" />
						<form:errors path="tenThuongHieu" cssClass="error"></form:errors>
					</div>

					<div class="form-group">
						<label>Ảnh thương hiệu:</label> <input type="file" name="hinhAnh"
							multiple="multiple" />
					</div>

					<button type="submit" class="btn btn-success">${formButton}</button>
					<button type="button" class="btn btn-danger" onClick="window.location.href='http://localhost:8080/WebsiteBanNhacCu/admin/thuong-hieu/danh-sach-thuong-hieu'">Hủy</button>

				</form:form>


			</div>

			<div class="col-lg-3"></div>
		</div>

	</div>
	<!-- /.container-fluid -->
</body>
</html>