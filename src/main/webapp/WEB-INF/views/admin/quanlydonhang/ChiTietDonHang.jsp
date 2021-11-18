<%@page import="com.websitenhaccu.util.Constant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết đơn hàng</title>
<link rel="stylesheet"
	href='<c:url value ="/static/assets/css/ChiTietHoaDon_Admin/ChiTietHoaDon_Admin.css"/>'>
</head>

<body>

	<div class="container-fluid management">
		<a style="margin: 10px auto;"
			href="<c:url value="/admin/quan-li-don-hang/danh-sach-don-hang"/>">Trở
			về danh sách</a>
		<div class="wrapper">

			<div class="side_right">
				<div class="address">
					<div class="address_user">

						<h5>Thông tin khách hàng</h5>
						<p>
							Họ và tên: <b>${ hoaDonDTO.nguoiDung.fullName }</b>
						</p>
						<p>
							Địa chỉ giao hàng: <span>${ hoaDonDTO.diaChiGiaoHang }</span>
						</p>
						<p>
							Số điện thoại: <span>${ hoaDonDTO.nguoiDung.phone }</span>
						</p>
					</div>

					<div class="order_detail">
						<h5>Thông tin Hóa đơn</h5>
						<p>
							Mã hóa đơn: <b>${ hoaDonDTO.id }</b>
						</p>
						<p>
							Ngày lập: <span><fmt:formatDate pattern="dd-MM-yyyy"
									value="${ hoaDonDTO.ngayLapHD }" /></span>
						</p>
					</div>
				</div>

				<div class="products_table">
					<table class="table table-hover">

						<tbody>

							<tr>
								<th scope="col" style="width: 5%">STT</th>
								<th scope="col" style="width: 55%">Sản phẩm</th>
								<th scope="col" style="width: 15%">Giá</th>
								<th scope="col" style="width: 10%">Số lượng</th>
								<th scope="col" style="width: 15%">Tạm tính</th>
							</tr>

							<c:forEach items="${ hoaDonDTO.chiTietHoaDonDTOs }"
								var="chiTietHoaDonDTO" varStatus="counter">

								<tr>
									<td>${ counter.count }</td>
									<td class="product">
										<div class="product_img">
											<img
												src="data:image/jpg;base64,${ chiTietHoaDonDTO.mauSanPhamDTO.hinhAnhBase64 }"
												alt="">
										</div>
										<div class="product_name">
											<p>${ chiTietHoaDonDTO.mauSanPhamDTO.tenSanPham }</p>
										</div>

									</td>
									<td class="price currentPrice"><fmt:formatNumber
											type="number" value="${ chiTietHoaDonDTO.giaBan }" /></td>
									<td class="ammout">${ chiTietHoaDonDTO.soLuong }</td>
									<td class="price tempPrice"><fmt:formatNumber
											type="number" value="${ chiTietHoaDonDTO.tinhTien() }" /></td>

								</tr>

							</c:forEach>

						</tbody>
					</table>


					<p class="totalPrice">
						Tổng thanh toán: <span class="price"><fmt:formatNumber
								type="number" value="${ hoaDonDTO.tongTien }" /></span>
					</p>

					<hr>

					<h5>Cập nhật trạng thái đơn hàng</h5>

					<div>
						<div class="status_total--price">

							<input type="hidden" id="maHoaDon" value="${ hoaDonDTO.id }">

							<select class="custom-select" id="trangThai">

								<c:forEach items="${ trangThais }" var="item"
									varStatus="counter">

									<c:choose>
										<c:when test="${ item == hoaDonDTO.trangThai }">
											<option value="${ counter.count }" selected>${ item }</option>
										</c:when>
										<c:otherwise>
											<option value="${ counter.count }">${ item }</option>
										</c:otherwise>
									</c:choose>

								</c:forEach>

							</select>
							<button id="btnCapNhat" class="btn btn-primary">Cập nhật</button>

						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

	<script src="<c:url value="/static/assets/js/don-hang.js"/>"></script>
</body>
</html>