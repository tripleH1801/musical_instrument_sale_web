<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý sản phẩm</title>
<link rel="stylesheet"
	href='<c:url value ="/static/assets/css/admin/AlignButton.css"/>'>
<link rel="stylesheet"
	href='<c:url value ="/static/assets/css/DanhSachHoaDon_Admin/DanhSachHoaDon_Admin.css"/>'>
<link rel="stylesheet"
	href='<c:url value ="/static/assets/css/scrolltable.css"/>'>

</head>


<body>


	<div class="container-fluid wrapper_sanpham">

		<!-- Row input -->
		<div class="row">
			<div class="col-lg-4">
				<div class="form-group">
					<label for="exampleInputEmail1"><b style="margin-top: 5px">Tìm
							kiếm</b></label> <input type="text" oninput="typeSearch()"
						class="form-control" id="txtSearch" aria-describedby="emailHelp"
						placeholder="Nhập tên sản phẩm">

				</div>
			</div>

			<div class="col-lg-6"></div>

			<div class="col-lg-2">
				<div class="form-group">
					<label for="exampleInputEmail1">&#160;</label> <a type="button"
						class="form-control btn btn-primary table__btn"
						href="<c:url value='/admin/san-pham/them-san-pham'/>">Thêm sản
						phẩm</a>
				</div>
			</div>

		</div>


		<div class="row">
			<div class="table-wrapper-scroll-y my-custom-scrollbar"
				style="width: 100%">
				<table class="table">

					<thead class="thead-light">
						<tr>

							<th style="width: 2%">STT</th>
							<th style="width: 25%">Tên sản phẩm</th>
							<th style="width: 14%"><select class="form-control"
								id="cboLoaiSanPham">
									<option value="">Loại sản phẩm</option>
									<c:forEach items="${listLoaiSanPham}" var="loaiSanPham">
										<option value="${loaiSanPham.id}">${loaiSanPham.tenLoaiSanPham}</option>
									</c:forEach>
							</select></th>
							<th style="width: 14%"><select class="form-control"
								id="cboXuatXu">
									<option value="">Xuất Xứ</option>
									<c:forEach items="${listXuatXu}" var="xuatXu">
										<option value="${xuatXu}">${xuatXu}</option>
									</c:forEach>
							</select></th>
							<th style="width: 14%"><select class="form-control"
								id="cboThuongHieu">
									<option value="">Thương Hiệu</option>
									<c:forEach items="${listThuongHieu}" var="thuongHieu">
										<option value="${thuongHieu.id}">${thuongHieu.tenThuongHieu}</option>
									</c:forEach>
							</select></th>
							<th style="width: 7%">Số lượng</th>
							<th style="width: 18%"></th>
						</tr>
					</thead>

					<tbody id="tableSanPham">

						<c:forEach items="${ listSanPham }" var="sanPham"
							varStatus="counter">
							<tr>
								<td>${ counter.count }</td>
								<td>${ sanPham.tenSanPham }</td>
								<td>${ sanPham.tenLoaiSanPham }</td>
								<td>${ sanPham.xuatXu }</td>
								<td>${ sanPham.tenThuongHieu }</td>
								<td>${sanPham.tongSoLuong}</td>
								<td><input type="button" class="btn btn-primary table__btn"
									value="Chi tiết"
									onclick="location.href='<c:url value='/admin/san-pham/xem-chi-tiet?id=${ sanPham.id }' />'">

									<input type="button" class="btn btn-warning table__btn"
									value="Sửa"
									onclick="location.href='<c:url value='/admin/san-pham/cap-nhat-san-pham?id=${ sanPham.id }' />'">

									<input type="button" class="btn btn-danger table__btn btnXoa" value="Xóa">
									<input class="maSanPham" value="${sanPham.id}"type="hidden" /></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>
	<input type="hidden" id="pageValue" value="${ page + 1}" />

	<div class="form-group row adjust_button">

		<button class="btn btn-danger color" onclick="typeSearch()"
			id="btnPreviusPage">Trang trước</button>

		<input type="text" readonly class="form-control" id="viewPage"
			value="${page = page + 1}">

		<button class="btn btn-danger color" onclick="typeSearch()"
			id="btnNext">Trang sau</button>

	</div>
	<!-- /.container-fluid -->
	<br>
	<p>${ user.userId }</p>
	<p>${ user.email }</p>
	<p>${ user.role }</p>
	<script src='<c:url value="/static/assets/js/sanpham.js"/>'></script>
</body>
</html>