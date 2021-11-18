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
			href="/WebsiteBanNhacCu/admin/quang-cao">Quay
			lại</a>
	</div>
	<div class="container"
		style="background-color: #fff; padding-top: 20px; padding-bottom: 20px">

		<!-- Row input -->
		<div class="row">
			<div class="col-lg-3"></div>
			<div class="col-lg-6">
				<h1 style="text-align: center;">${formTitle}</h1>

				<form:form action="" method="POST" modelAttribute="quangCaoDTO"
					enctype="multipart/form-data">

					<form:hidden path="id" />

					<div class="form-group">
						<label>Link:</label>
						<form:input path="link" class="form-control" />
						<form:errors path="link" cssClass="error"></form:errors>
					</div>

					<div class="form-group">
						<label>Chọn ảnh:</label> <input type="file" name="hinhAnh"
							multiple="multiple" /><br/>
						<form:errors path="hinhAnhBase64" cssClass="error"></form:errors>
					</div>

					<button type="submit" class="btn btn-success">${formButton}</button>
					<button type="reset" class="btn btn-danger" onclick="window.location.href='http://localhost:8080/WebsiteBanNhacCu/admin/quang-cao'">Hủy</button>

				</form:form>


			</div>

			<div class="col-lg-3"></div>
		</div>






	</div>
	<!-- /.container-fluid -->
</body>
</html>