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
		<a
			href="<c:url value='/admin/dong-san-pham/danh-sach-dong-san-pham' />">Quay
			lại</a>

	</div>

	<div class="container" style="background-color: #fff; padding: 20px 0">

		<!-- Row input -->
		<div class="row">
			<div class="col-lg-3"></div>

			<div class="col-lg-6">
				<h1 style="text-align: center;">${formTitle}</h1>
				<form:form action="" method="POST" modelAttribute="dongSanPham">

					<div class="form-group">
						<label>Tên dòng sản phẩm:</label>
						<form:input path="tenDongSanPham" class="form-control" />
						<form:errors path="tenDongSanPham" cssClass="error"></form:errors>
					</div>

					<div class="form-group">
						<label>Thuế:</label>
						<form:input path="thue" class="form-control" />
						<form:errors path="thue" cssClass="error"></form:errors>
					</div>

					<div class="form-group">
						<label>Loại sản phẩm:</label> <select class="form-control"
							id="loaiSanPham" name="loaiSanPham">

							<c:forEach items="${ listLoaiSanPham }" var="loaiSanPham1">

								<c:if test="${loaiSanPham1.id == dongSanPham.loaiSanPham.id}">
									<option value="${loaiSanPham1.id}" selected>${loaiSanPham1.tenLoaiSanPham}</option>
								</c:if>

								<c:if test="${loaiSanPham1.id != dongSanPham.loaiSanPham.id}">
									<option value="${loaiSanPham1.id}">${loaiSanPham1.tenLoaiSanPham}</option>
								</c:if>

							</c:forEach>
						</select>
					</div>

					<div class="form-group">
						<label>Thương Hiệu:</label> <select class="form-control"
							id="thuongHieu" name="thuongHieu">

							<c:forEach items="${ listThuongHieu }" var="thuongHieu">

								<c:if test="${thuongHieu.id == dongSanPham.thuongHieu.id}">
									<option value="${thuongHieu.id}" selected>${thuongHieu.tenThuongHieu}</option>
								</c:if>

								<c:if test="${thuongHieu.id != dongSanPham.thuongHieu.id}">
									<option value="${thuongHieu.id}">${thuongHieu.tenThuongHieu}</option>
								</c:if>

							</c:forEach>
						</select>
					</div>

					<button type="submit" class="btn btn-success">${formButton}</button>
					<button type="button" class="btn btn-danger" onClick="window.location.href='http://localhost:8080/WebsiteBanNhacCu/admin/dong-san-pham/danh-sach-dong-san-pham'">Hủy</button>

				</form:form>

			</div>

			<div class="col-lg-3"></div>
		</div>





	</div>
	<!-- /.container-fluid -->
</body>
</html>