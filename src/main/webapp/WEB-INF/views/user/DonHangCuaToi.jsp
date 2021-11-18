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
	href="<c:url value="/static/assets/css/QuanLyDonHang_User/QuanLyDonHang_User.css"/>" />

</head>
<body>

	<div class="wrapper container">
	
		<div class="side_right">


			<table class="table table-hover">
				<thead>
                    <tr>
                        <th width="12%" scope="col" class="maDonHang">Mã đơn hàng</th>
                        <th width ="10%" scope="col" class="ngayMua">Ngày mua</th>
                        <th width = "46%" scope="col" class="sanPham">Sản phẩm</th>
                        <th width ="16%" scope="col" class="tongTien">Tổng tiền</th>
                        <th width ="16%" scope="col" class="trangThai">Trạng thái đơn hàng</th>
                    </tr>
				</thead>
				<tbody>
					<c:forEach items="${ hoaDonDTOs }" var="hoaDonDTO" >
					<tr>
						<th><a href="<c:url value="/quan-ly-don-hang/chi-tiet-don-hang?id=${ hoaDonDTO.id }"/>">${ hoaDonDTO.id }</a></th>
						<td>
							<fmt:formatDate pattern = "dd-MM-yyyy"  value = "${ hoaDonDTO.ngayLapHD }" />
						</td>
						<td>
							<c:set var="tongTien" value="0"/>
							<c:forEach items="${ hoaDonDTO.chiTietHoaDonDTOs }" var="chiTietHoaDonDTO">
								<p> Sản phẩm: ${ chiTietHoaDonDTO.mauSanPhamDTO.tenSanPham } - Màu: ${ chiTietHoaDonDTO.mauSanPhamDTO.tenMau } - Số lượng: ${ chiTietHoaDonDTO.soLuong }</p>
							</c:forEach>
						</td>
						<td><fmt:formatNumber type = "number" value = "${ hoaDonDTO.tongTien }" /> VNĐ</td>
						<td>${ hoaDonDTO.trangThai }</td>
					</tr>
				
				</c:forEach>
				
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>