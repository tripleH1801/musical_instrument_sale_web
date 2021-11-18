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
</head>
<body>

<a href="<c:url value='/admin/san-pham/danh-sach-san-pham' />">Quay
			lại</a>
	<div class="container-fluid" style="background-color: #fff;padding-top: 20px;">

		<!-- Row input -->
		<div class="row">
			<div class="col-lg-3"></div>

			<div class="col-lg-6">
				<h1 style="text-align: center;" id='formTitle'>${ formTitle }</h1>
				<form:form action="" method="POST" modelAttribute="sanPhamDTO"
					enctype="multipart/form-data">

					<form:hidden path="id" />

					<div class="form-group">
						<label>Sản Phẩm:</label>
						<form:input path="tenSanPham" class="form-control" />
						<form:errors path="tenSanPham" cssClass="error"></form:errors>
					</div>

					<div class="row">
						<div class="col-lg-4">
							<div class="form-group">
								<label>Xuất xứ:</label>
								<form:input path="xuatXu" class="form-control" />
								<form:errors path="xuatXu" cssClass="error"></form:errors>
							</div>
						</div>

						<div class="col-lg-4">
							<div class="form-group">
								<label>Năm sản xuất:</label>
								<form:input path="namSanXuat" class="form-control" />
								<form:errors path="namSanXuat" cssClass="error"></form:errors>
							</div>
						</div>

						<div class="col-lg-4">
							<div class="form-group">
								<label>Bảo hành:</label>
								<form:input path="baoHanh" class="form-control" type="number"/>
								<form:errors path="baoHanh" cssClass="error"></form:errors>
							</div>
						</div>
					</div>

					<div class="row">
					<fmt:formatNumber type = "number" groupingUsed = "false" value="${ sanPhamDTO.giaNhap }" var="giaNhap"/>
						<div class="col-lg-6">
							<div class="form-group">
								<label>Giá nhập:</label>
								<form:input path="giaNhap" value="${giaNhap}" class="form-control" type="number"/>
								<form:errors path="giaNhap" cssClass="error"></form:errors>
							</div>
						</div>
						<fmt:formatNumber type = "number" groupingUsed = "false" value="${ sanPhamDTO.giaBan }" var="giaBan"/>
						<div class="col-lg-6">
							<div class="form-group">
								<label>Giá bán:</label>
								<form:input path="giaBan" value="${giaBan}" class="form-control" type="number"/>
								<form:errors path="giaBan" cssClass="error"></form:errors>
							</div>
						</div>
					</div>


					<div class="row">

						<div class="col-lg-3">
							<div class="form-group">
								<label>Loại sản phẩm:</label> <select id="maLoaiSanPham"
									Class="form-control">
									<c:forEach items="${ loaiSanPhams }" var="loaiSanPham">
										<option value="${loaiSanPham.id}">${loaiSanPham.tenLoaiSanPham}</option>
									</c:forEach>

								</select>
							</div>
						</div>

						<div class="col-lg-3">
							<div class="form-group">
								<label>Thương hiệu:</label> <select id="maThuongHieu"
									Class="form-control">
									<c:forEach items="${ thuongHieus }" var="thuongHieu">
										<option value="${thuongHieu.id}">${thuongHieu.tenThuongHieu}</option>
									</c:forEach>
								</select>
							</div>
						</div>

						<div class="col-lg-6">
							<div class="form-group">
								<label>Dòng sản phẩm:</label>
								<form:select path="maDongSanPham" Class="form-control">
									<form:options items="${ dongSanPhams }" itemValue="id"
										itemLabel="tenDongSanPham" />
								</form:select>
							</div>
						</div>

					</div>

					<c:if test="${ formTitle == 'Thêm sản phẩm' }">
						<div class="row">
							<div class="col-lg-3">
								<div class="form-group">
									<label>Màu:</label> <select id="maMau" name="maMau"
										class="form-control">
										<c:forEach items="${ maus }" var="mau">
											<option value="${mau.id}">${mau.tenMau}</option>
										</c:forEach>
									</select>
								</div>
							</div>

							<div class="col-lg-3">
								<div class="form-group">
									<label>Số lượng:</label> <input name="soLuong"
										class="form-control" type="number" value="1"/>
										<form:errors path="tongSoLuong" cssClass="error"></form:errors>
								</div>
							</div>

							<div class="col-lg-6">
								<div class="form-group">
									<label>Chọn ảnh:</label> <label for="imageUpload"
										class="form-control btn btn-primary">Chọn ảnh</label> <input
										type="file" name="hinhAnh" multiple="multiple"
										id="imageUpload" accept="image/*" style="display: none" />
								</div>
							</div>

						</div>

					</c:if>


					<div class="form-group">
						<label>Nhà cung cấp:</label>
						<form:select path="maNhaCungCap" Class="form-control">
							<form:options items="${ nhaCungCaps }" itemValue="maNhaCungCap"
								itemLabel="tenNhaCungCap" />
						</form:select>
					</div>


					<div class="form-group">
						<label>Mô tả:</label>
						<div id="editor">
							<div id="edit" style="margin-top: 30px"></div>
						</div>
						<form:hidden path="moTa" />
					</div>


					<button type="submit" class="btn btn-success">${ formButton }</button>
					<button type="button" class="btn btn-danger" onClick="window.location.href='http://localhost:8080/WebsiteBanNhacCu/admin/san-pham/danh-sach-san-pham'">Hủy</button>

				</form:form>

			</div>

			<div class="col-lg-3"></div>
		</div>

		

	</div>
	<!-- /.container-fluid -->

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


	<script src="<c:url value="/static/assets/js/sanpham.js"/>"></script>
</body>
</html>