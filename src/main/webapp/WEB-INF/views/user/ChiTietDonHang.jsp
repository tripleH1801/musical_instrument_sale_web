<%@page import="com.websitenhaccu.util.Constant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đơn hàng của tôi</title>
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/main.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/ChiTietDonHangUser/ChiTietDonHangUser.css"/>" />

</head>
<body>

	<div class="wrapper container">

			<div class="side_right">
				<div class="address">
					<input type="hidden" id="maNguoiDung" value="${ hoaDonDTO.nguoiDung.userId }">
					<h5>Thông tin người nhận</h5>
					<p>Họ và tên: <b>${ hoaDonDTO.nguoiDung.fullName }</b></p>
					<p>
						Địa chỉ:
						<span >${ hoaDonDTO.diaChiGiaoHang }</span>
					</p>
					<p>Số điện thoại: <span>${ hoaDonDTO.nguoiDung.phone }</span></p>
					<p><b>Trạng thái đơn hàng: <span>${ hoaDonDTO.trangThai }</span></b>&emsp;
						<c:set value="<%= Constant.DANG_CHO_XU_LY %>" var="dangCho"/>
						<c:set value="<%= Constant.DA_TIEP_NHAN %>" var="tiepNhan"/>
						<c:if test="${ hoaDonDTO.trangThai == dangCho or hoaDonDTO.trangThai == tiepNhan }">
							<button class="btn btn-outline-primary" onclick="huyDonHang('${ hoaDonDTO.id }')">Hủy đơn hàng</button>
						</c:if>
					</p>
				</div>

				<div class="products_table">
					<table class="table table-hover">
						<tbody>
							<tr>
								<th scope="col" class="sanPham">Sản phẩm</th>
								<th scope="col" class="gia">Giá</th>
								<th scope="col" class="soluong">Số lượng</th>
								<th scope="col" class="tamtinh">Tạm tính</th>
							</tr>
							
							<c:forEach items="${ hoaDonDTO.chiTietHoaDonDTOs }" var="chiTietHoaDonDTO" varStatus="counter">
								
								<tr>
									<td class="product">
										<div class="product_img">
											<img src="data:image/jpg;base64,${ chiTietHoaDonDTO.mauSanPhamDTO.hinhAnhBase64 }" alt="">
										</div>
										<input type="hidden" class="maSanPham" value="${ chiTietHoaDonDTO.mauSanPhamDTO.maSanPham }">
										<div class="product_name">
											<p>${ chiTietHoaDonDTO.mauSanPhamDTO.tenSanPham }</p>
											<c:set value="<%= Constant.GIAO_THANH_CONG %>" var="thanhCong"/>
											
											<c:if test="${ hoaDonDTO.trangThai == thanhCong }">
												<div>
													<button
														class="btn btn-outline-primary btnNhanXet"
														data-toggle="modal"
														data-target="#exampleModalCenter">
														Viết nhận xét
													</button>
													<button class="btn btn-outline-primary" onclick="muaLai('${chiTietHoaDonDTO.mauSanPhamDTO.maSanPham}')">
														Mua lại
													</button>
												</div>
											</c:if>
											
										</div>
	
									</td>
									<td class="price currentPrice"><fmt:formatNumber type = "number" value = "${ chiTietHoaDonDTO.giaBan }" /></td>
									<td class="ammout">${ chiTietHoaDonDTO.soLuong }</td>
									<td class="price t tempPrice"><fmt:formatNumber type = "number" value = "${ chiTietHoaDonDTO.tinhTien() }" /></td>
									
								</tr>
							
							</c:forEach>

						</tbody>
					</table>

					<hr />

					<p class="totalPrice">
						Tổng cộng: <span class="price" id="priceInner"><fmt:formatNumber type = "number" value = "${ hoaDonDTO.tongTien }" /></span>
					</p>
					
					
				</div>
			</div>
		</div>

		<!-- Modal -->
		<div
			class="modal fade"
			id="exampleModalCenter"
			tabindex="-1"
			role="dialog"
			aria-labelledby="exampleModalCenterTitle"
			aria-hidden="true"
		>
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<div class="top-modal">
							<h4>Vui lòng đánh giá</h4>
							<div class="start-ratting">
								<span class="fa fa-star"></span>
								<span class="fa fa-star"></span>
								<span class="fa fa-star"></span>
								<span class="fa fa-star"></span>
								<span class="fa fa-star"></span>
							</div>
						</div>
						<button
							type="button"
							class="close"
							data-dismiss="modal"
							aria-label="Close"
						>
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
							<div class="form-group">
								<textarea
									placeholder="Viết những đánh giá của bạn về sản phẩm"
									class="form-control"
									id="exampleFormControlTextarea1"
									rows="4"
								></textarea>
							</div>
							<button class="btn btn-warning btn" id="btnGuiDanhGia">
								Gửi đánh giá
							</button>
					</div>
					<div class="modal-footer"></div>
				</div>
			</div>
		</div>


	<script src="<c:url value="/static/assets/js/ChiTietDonHang_User/ChiTietDonHangUser.js"/>"></script>
</body>
</html>