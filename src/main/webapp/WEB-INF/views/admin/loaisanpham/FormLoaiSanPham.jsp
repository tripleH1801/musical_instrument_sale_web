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
	<div class="container" style="padding: 0">
		<a
			href="<c:url value='/admin/loai-san-pham/danh-sach-loai-san-pham' />">Quay
			lại </a>
	</div>
	<div class="container"
		style="background-color: #fff; padding: 20px 0; margin: 0 auto">

		<!-- Row input -->
		<div class="row">
			<div class="col-lg-3"></div>

			<div class="col-lg-6">
				<h1 style="text-align: center;">${formTitle}</h1>
				<form:form action="" method="POST" modelAttribute="loaiSanPham">

					<div class="form-group">
						<label>Tên loại sản phẩm:</label>
						<form:input path="tenLoaiSanPham" class="form-control" />
						<form:errors path="tenLoaiSanPham" cssClass="error"></form:errors>
					</div>

					<button type="submit" class="btn btn-success">${formButton}</button>
					<button type="button" class="btn btn-danger" onClick="window.location.href='http://localhost:8080/WebsiteBanNhacCu/admin/loai-san-pham/danh-sach-loai-san-pham'">Hủy</button>

				</form:form>

			</div>

			<div class="col-lg-3"></div>
		</div>






	</div>
	<!-- /.container-fluid -->
</body>
</html>