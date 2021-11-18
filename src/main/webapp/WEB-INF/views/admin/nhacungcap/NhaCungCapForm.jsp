<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ formTitle }</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/froala_editor.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/froala_style.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/plugins/code_view.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/plugins/draggable.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/plugins/colors.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/plugins/emoticons.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/plugins/image_manager.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/plugins/image.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/plugins/line_breaker.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/plugins/table.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/plugins/char_counter.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/plugins/video.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/plugins/fullscreen.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/plugins/file.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/plugins/quick_insert.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/plugins/help.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/plugins/special_characters.css"/>" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.css" />

<link rel="stylesheet"
	href='<c:url value ="/static/assets/css/errors.css"/>'>
	<style type="text/css">
		.error_custom{
			font-style: italic;
			color: red;
			border: none;
			outline: none;
		}
	</style>
</head>
<body>

	<a href="<c:url value='/admin/nha-cung-cap/danh-sach-nha-cung-cap' />">Quay
		lại</a>
	<div class="container-fluid" style="background-color: #fff">

		<!-- Row input -->
		<div class="row">
			<div class="col-lg-3"></div>

			<div class="col-lg-6">
				<h1 style="text-align: center;" id='formTitle'>${ formTitle }</h1>
				<form:form action="" method="POST" modelAttribute="nhaCungCapDTO">

					<form:hidden path="maNhaCungCap" />

					<div class="form-group">
						<label>Tên nhà cung cấp:</label>
						<form:input path="tenNhaCungCap" class="form-control" />
						<form:errors path="tenNhaCungCap" cssClass="error"></form:errors>
					</div>

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
						<label>Website:</label>
						<form:input path="website" class="form-control" type="url" />
						<form:errors path="website" cssClass="error"></form:errors>
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

					<button type="submit" id="btnSubmit" class="btn btn-success">${ formButton }</button>
					<button type="button" class="btn btn-danger"
						onClick="window.location.href='http://localhost:8080/WebsiteBanNhacCu/admin/nha-cung-cap/danh-sach-nha-cung-cap'">Hủy</button>

				</form:form>

			</div>

			<div class="col-lg-3"></div>
		</div>


	</div>
	<!-- /.container-fluid -->

	<script>
		$("#clickMe").click(function() {
			var all = $(".fr-element").map(function() {
				return this.innerHTML;
			}).get();

			console.clear();
			console.log(all.join());
			$("#view-result").html(all.join());
		});
	</script>

	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/mode/xml/xml.min.js"></script>

	<script type="text/javascript"
		src="<c:url value="/static/assets/js/froala_editor.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/align.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/char_counter.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/code_beautifier.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/code_view.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/colors.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/draggable.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/emoticons.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/entities.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/file.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/font_size.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/font_family.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/fullscreen.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/image.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/image_manager.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/line_breaker.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/inline_style.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/link.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/lists.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/paragraph_format.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/paragraph_style.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/quick_insert.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/quote.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/table.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/save.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/url.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/video.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/help.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/print.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/special_characters.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/static/assets/js/plugins/word_paste.min.js"/>"></script>

	<script>
		(function() {
			new FroalaEditor("#edit");
		})();
	</script>

	<script src="<c:url value="/static/assets/js/diaChi.js"/>"></script>
</body>
</html>