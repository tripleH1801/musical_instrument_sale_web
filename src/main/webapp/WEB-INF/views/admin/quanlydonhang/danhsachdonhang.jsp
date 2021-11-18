<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách đơn hàng</title>
<link rel="stylesheet"
	href='<c:url value ="/static/assets/css/DanhSachHoaDon_Admin/DanhSachHoaDon_Admin.css"/>'>
<link rel="stylesheet"
	href='<c:url value ="/static/assets/css/admin/AlignButton.css"/>'>
<link rel="stylesheet"
	href='<c:url value ="/static/assets/css/scrolltable.css"/>'>


</head>

<body>

	<div class="container-fluid management">
		<div class="form-group row timkiem">
			<label for="txtSearch" class="col-2 col-form-label">Tìm mã hóa
				đơn</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="txtSearch" value="" on>
			</div>
			<div class="col-sm-2">
				<input type="button" class="form-control btn-primary" id="btnClear"
					onclick="Reset()" value="Hiển thị tất cả">
			</div>
		</div>

		<div class="table-wrapper-scroll-y my-custom-scrollbar">
			<table class="table table-hover">
				<thead>
					<tr>
						<th style="width: 3%">STT</th>
						<th style="width: 10%">Mã đơn hàng</th>
						<th style="width: 23%">
							<div class="test">
								<span>Ngày lập</span> <input class="form-control ngayLap"
									type="date" value="yyyy-MM-dd" id="date"
									onchange="searchFull()">
							</div>
						</th>
						<th style="width: 25%" class="sanPham">Sản phẩm</th>
						<th style="width: 12%">Tổng tiền</th>
						<th style="width: 14%"><select class="custom-select"
							id="trangThai" onchange="searchFull()">
								<option value="">Trạng thái</option>
								<c:forEach items="${ trangThais }" var="item">
									<option value="${ item }">${ item }</option>
								</c:forEach>

						</select></th>
						<th style="width: 13%"></th>
					</tr>
				</thead>

				<tbody id="tableDonHang">
					<c:forEach items="${ hoaDonDTOs }" var="hoaDonDTO"
						varStatus="counter">
						<tr>
							<td>${ counter.count }</td>
							<td>${ hoaDonDTO.id }</td>
							<td><fmt:formatDate pattern="dd-MM-yyyy"
									value="${ hoaDonDTO.ngayLapHD }" /></td>
							<td>
								<c:set var="tongTien" value="0" />
								<c:forEach
									items="${ hoaDonDTO.chiTietHoaDonDTOs }" var="chiTietHoaDonDTO">
									<p>Sản phẩm: ${ chiTietHoaDonDTO.mauSanPhamDTO.tenSanPham }
										- Màu: ${ chiTietHoaDonDTO.mauSanPhamDTO.tenMau } - Số lượng:
										${ chiTietHoaDonDTO.soLuong }</p>
								</c:forEach>
							</td>
							<td>
								<fmt:formatNumber type="number" value="${ hoaDonDTO.tongTien }" /> VNĐ
							</td>
							<td>${ hoaDonDTO.trangThai }</td>
							<td>
								<button class="btn btn-danger" onclick="chiTietDonHang('${ hoaDonDTO.id }')">Xem chi tiết</button>
							</td>
						</tr>

					</c:forEach>

				</tbody>
			</table>

		</div>


	</div>
	<input type="hidden" id="pageValue" value="${page + 1}" />

	<div class="form-group row adjust_button">

		

		<button class="btn btn-danger color" id="btnPreviusPage">Trang
			trước</button>
		<input type="text" readonly class="form-control textPage"
			id="viewPage" value="${page = page + 1}" />
		
		<button class="btn btn-danger color" id="btnNext">Trang sau</button>


	</div>

	<script src="<c:url value="/static/assets/js/danhsachdonhang.js"/>"></script>

</body>
</html>