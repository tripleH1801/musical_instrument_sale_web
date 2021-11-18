<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách loại sản phẩm</title>

<link rel="stylesheet"
	href='<c:url value ="/static/assets/css/admin/AlignButton.css"/>'>
<link rel="stylesheet"
	href='<c:url value ="/static/assets/css/scrolltable.css"/>'>

</head>
<body>
	<c:if test="${thongBao == 1}">
		<script type="text/javascript">
			alert("Loại sản phẩm này không thể xóa");
		</script>
	</c:if>

	<div class="container-fluid" style="background-color: #fff">

		<!-- Row input -->
		<div class="row">
			<div class="col-lg-4">
				<div class="form-group">
					<label for="txtSearch"> <b>Tìm kiếm</b>
					</label> <input type="text" oninput="typeSearch()" class="form-control"
						id="txtSearch" aria-describedby="emailHelp"
						placeholder="Nhập tên loại sản phẩm">
				</div>
			</div>

			<div class="col-lg-6"></div>

			<div class="col-lg-2">
				<div class="form-group">
					<label for="exampleInputEmail1">&#160;</label> <a type="button"
						class="form-control btn btn-primary table__btn"
						href="<c:url value='/admin/loai-san-pham/them-loai-san-pham'/>">Thêm
						loại sản phẩm</a>
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
							<th style="width: 25%">Mã loại sản phẩm</th>
							<th style="width: 40%">Tên loại sản phẩm</th>
							<th style="width: 30%"></th>
						</tr>
					</thead>

					<tbody id="tableLoaiSanPham">

						<c:forEach items="${ listLoaiSanPham }" var="loaiSanPham"
							varStatus="counter">
							<tr>
								<td>${ counter.count }</td>
								<td>${ loaiSanPham.id }</td>
								<td>${ loaiSanPham.tenLoaiSanPham }</td>
								<td>
									<%-- <input type="button" class="btn btn-primary table__btn"
									value="Chi tiết"
									onclick="location.href='<c:url value='/admin/loai-san-pham/chi-tiet-loai-san-pham?id=${ loaiSanPham.id }' />'"> --%>

									<input type="button" class="btn btn-warning table__btn"
									value="Sửa"
									onclick="location.href='<c:url value='/admin/loai-san-pham/cap-nhat-loai-san-pham?id=${ loaiSanPham.id }' />'">

									<input type="button" class="btn btn-danger table__btn btnXoa" id="" value="Xóa">
                    				<input type="hidden" class="maLoaiSanPham" value="${loaiSanPham.id}" />
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		<input type="hidden" id="pageValue" value="${ page + 1}" />
	</div>

	<div class="form-group row adjust_button">



		<button class="btn btn-danger  color" onclick="typeSearch()"
			id="btnPreviusPage">Trang trước</button>

		<input type="text" readonly class="form-control textPage"
			id="viewPage" value="${page = page + 1}">



		<button class="btn btn-danger color" onclick="typeSearch()"
			id="btnNext">Trang sau</button>

	</div>


	<!-- /.container-fluid -->
	<script src='<c:url value = "/static/assets/js/loaisanpham.js"/>'></script>
</body>
</html>