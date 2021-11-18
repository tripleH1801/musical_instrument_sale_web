<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Người dùng</title>
<link rel="stylesheet"
	href='<c:url value ="/static/assets/css/admin/AlignButton.css"/>'>
<link rel="stylesheet"
	href='<c:url value ="/static/assets/css/scrolltable.css"/>'>
</head>
<body>


	<div class="container-fluid"
		style="background-color: #fff; padding-top: 20px; padding-bottom: 20px;">

		<!-- Row input -->
		<div class="row">
			<div class="col-lg-6">
				<div class="form-group">
					<label for="txtSearch">Tìm kiếm tên</label> <input type="text"
						oninput="searchType()" class="form-control" id="txtSearch"
						aria-describedby="emailHelp" placeholder="Nhập tên người dùng" />
				</div>

				<div class="form-group">
					<label for="exampleInputEmail1">Số điện thoại</label> <input
						type="text" oninput="searchType()" class="form-control"
						id="txtSearchSdt" aria-describedby="emailHelp"
						placeholder="Nhập số điện thoại" />
				</div>

				<div class="form-group">
					<label for="exampleInputEmail1">Email</label> <input type="text"
						oninput="searchType()" class="form-control" id="txtSearchEmail"
						aria-describedby="emailHelp" placeholder="Nhập email" />
				</div>

			</div>

			<div class="col-lg-6"></div>
		</div>

		<div class="row">
			<div class="table-wrapper-scroll-y my-custom-scrollbar"
				style="width: 100%">
				<table class="table" id="">

					<thead class="thead-light">
						<tr>
							<th style="width: 5%">STT</th>
							<th style="width: 20%">Tên người dùng</th>
							<th style="width: 10%">Số điện thoại</th>
							<th style="width: 10%">Email</th>
							<th style="width: 20%">Địa chỉ</th>
							<th style="width: 12%">Trạng thái</th>
							<th style="width: 23%"></th>
						</tr>
					</thead>

					<tbody id="tableNguoiDung">

						<c:forEach items="${ listKhachHang }" var="nguoiDung"
							varStatus="counter">
							<tr>
								<td>${ counter.count }</td>
								<td>${ nguoiDung.fullName }</td>
								<td>${ nguoiDung.phone }</td>
								<td>${ nguoiDung.email }</td>
								<td>${ nguoiDung.tinhThanhPho }</td>
								<td><c:if test="${ nguoiDung.enabled == true }">
									Đã xác minh
								</c:if> <c:if test="${ nguoiDung.enabled == false }">
									Chưa xác minh
								</c:if></td>
								<td><input type="button" class="btn btn-primary table__btn"
									value="Chi tiết"
									onclick="location.href='<c:url value='/admin/nguoi-dung/chi-tiet-nguoi-dung?id=${ nguoiDung.userId }' />'">

									<input type="button" class="btn btn-warning table__btn"
									value="Sửa"
									onclick="location.href='<c:url value='/admin/nguoi-dung/cap-nhat-nguoi-dung?id=${ nguoiDung.userId }' />'">

									<input type="button" class="btn btn-danger table__btn btnXoa"
									id="" value="Xóa"> <input type="hidden"
									class="maNguoiDung" value="${ nguoiDung.userId}" /></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>



	</div>
	<!-- /.container-fluid -->
	<input type="hidden" id="pageValue" value="${ page + 1}" />
	<input type="hidden" id="trangThai" value="${trangThaiXoa}" />

	<div class="form-group row adjust_button">


		<button class="btn btn-danger color" id="btnPreviusPage">Trang
			trước</button>
		<input type="text" readonly class="form-control textPage"
			id="viewPage" value="${page = page + 1}" />

		<button class="btn btn-danger color" id="btnNext">Trang sau</button>


	</div>
	<script src="<c:url value="/static/assets/js/nguoidung.js"/>"></script>
</body>
</html>