<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách thương hiệu</title>

<link rel="stylesheet"
	href='<c:url value ="/static/assets/css/admin/AlignButton.css"/>'>
<link rel="stylesheet"
	href='<c:url value ="/static/assets/css/scrolltable.css"/>'>
</head>
<body>


	<div class="container-fluid" style="background-color: #fff">

		<!-- Row input -->
		<div class="row">
			<div class="col-lg-4">
				<div class="form-group">
					<label for="txtSearch">Tìm kiếm</label> <input type="text"
						class="form-control" id="txtSearch" aria-describedby="emailHelp"
						placeholder="Nhập tên thương hiệu" oninput="typeSearch()">
				</div>
			</div>

			<div class="col-lg-6"></div>

			<div class="col-lg-2">
				<div class="form-group">
					<label for="exampleInputEmail1">&#160;</label> <a type="button"
						class="form-control btn btn-primary table__btn"
						href="<c:url value='/admin/thuong-hieu/them-thuong-hieu'/>">Thêm
						thương hiệu</a>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="table-wrapper-scroll-y my-custom-scrollbar"
				style="width: 100%">
				<table class="table">

					<thead class="thead-light">
						<tr>
							<th style="width: 5%">STT</th>
							<th style="width: 20%">Mã thương hiệu</th>
							<th style="width: 20%">Hình ảnh</th>
							<th style="width: 30%">Tên thương hiệu</th>
							<th style="width: 25%"></th>
						</tr>
					</thead>

					<tbody id="tableThuongHieu">

						<c:forEach items="${ listThuongHieu }" var="thuonghieu"
							varStatus="counter">
							<tr>
								<td>${ counter.count }</td>
								<td>${ thuonghieu.id }</td>
								<td><c:if test="${thuonghieu.hinhAnhBase64 != null}">
										<img src="data:image/jpg;base64,${thuonghieu.hinhAnhBase64}"
											width="120" height="80" style="object-fit: contain" />
									</c:if></td>
								<td>${ thuonghieu.tenThuongHieu }</td>
								<td>
								<%-- <input type="button" class="btn btn-primary table__btn"
									value="Chi tiết"
									onclick="location.href='<c:url value='/admin/thuong-hieu/chi-tiet-thuong-hieu?id=${ thuonghieu.id }' />'"> --%>

									<input type="button" class="btn btn-warning table__btn"
									value="Sửa"
									onclick="location.href='<c:url value='/admin/thuong-hieu/cap-nhat-thuong-hieu?id=${ thuonghieu.id }' />'">

									<input type="button" class="btn btn-danger table__btn btnXoa" id="" value="Xóa">
                    				<input type="hidden" class="maThuongHieu" value="${thuonghieu.id}" />

								</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>

	</div>
	<input type="hidden" id="pageValue" value="${ page + 1}" />

	<div class="form-group row adjust_button">

		<button class="btn btn-danger color" id="btnPreviusPage">Trang
			trước</button>
		<input type="text" readonly class="form-control textPage"
			id="viewPage" value="${page = page + 1}" />

		<button class="btn btn-danger color" id="btnNext">Trang sau</button>



	</div>
	<!-- /.container-fluid -->
	<script src="<c:url value="/static/assets/js/thuonghieu.js"/>"></script>
</body>
</html>