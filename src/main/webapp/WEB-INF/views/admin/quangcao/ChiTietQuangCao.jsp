<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết sản phẩm</title>


</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-6">
				<div class="row">Mã sản phẩm: ${ sanPham.id }</div>
				<div class="row">Tên sản phẩm: ${ sanPham.tenSanPham }</div>
				<div class="row">Xuất xứ: ${ sanPham.xuatXu }</div>
				<div class="row">Bảo hành: ${ sanPham.baoHanh } năm</div>
				<div class="row">Giá nhập: <fmt:formatNumber type = "currency" 
          value = "${ sanPham.giaNhap }" currencySymbol=""/> VNĐ</div>
				<div class="row">Giá bán: <fmt:formatNumber type = "currency" 
          value = "${ sanPham.giaBan }" currencySymbol=""/> VNĐ</div>
				<div class="row">Loại sản phẩm: ${ sanPham.dongSanPham.loaiSanPham.tenLoaiSanPham }</div>
				<div class="row">Thương hiệu: ${ sanPham.dongSanPham.thuongHieu.tenThuongHieu }</div>
				<div class="row">Dòng sản phẩm: ${ sanPham.dongSanPham.tenDongSanPham }</div>
				<div class="row">
					Màu:
					<div class="col-lg-9"></div>
					<div class="col-lg-2">
						<a type="button" class="form-control btn btn-primary table__btn"
							href="<c:url value='/admin/san-pham/them-mau-san-pham?maSanPham=${ sanPham.id }'/>">Thêm
							màu</a>
					</div>
				</div>
				<div class="row">
					<table class="table">

						<thead class="thead-light">
							<tr>
								<th>STT</th>
								<th>Màu</th>
								<th>Hình ảnh</th>
								<th>Số lượng</th>
								<th></th>
							</tr>
						</thead>

						<tbody>
							<c:set var="total" value="0" />
							<c:forEach items="${ mauSanPhamDTOs }" var="mauSanPham"
								varStatus="counter">
								<tr>
									<td>${ counter.count }</td>
									<td>${ mauSanPham.tenMau }</td>
									<td><img
										src="data:image/jpg;base64,${ mauSanPham.hinhAnhBase64 }"
										width="120" height="80" /> <%-- <c:if test="${mauSanPham.hinhAnhBase64 != null}">
										<img src="data:image/jpg;base64,${mauSanPham.hinhAnhBase64}"
											width="120" height="80" />
								</c:if> --%></td>
									<td>
										${ mauSanPham.soLuong }
										<c:set var="total" value="${total + mauSanPham.soLuong}" />
									</td>
									<td><input type="button"
										class="btn btn-warning table__btn" value="Sửa"
										onclick="location.href='<c:url value='/admin/san-pham/cap-nhat-mau-san-pham?maSanPham=${ sanPham.id }&maMau=${ mauSanPham.maMau }' />'">

										<input type="button" class="btn btn-danger table__btn"
										value="Xóa"
										onclick="location.href='<c:url value='/admin/thuong-hieu/xoa-thuong-hieu?id=${ mauSanPham.maMau }' />'">

									</td>
								</tr>
							</c:forEach>

						</tbody>
						<thead class="thead-light">
							<tr>
								<th>Tổng:</th>
								<th></th>
								<th></th>
								<th>${ total }</th>
								<th></th>
							</tr>
						</thead>

					</table>
				</div>
				<div class="row">Nhà cung cấp: ${ sanPham.nhaCungCap.tenNhaCungCap }</div>
				<div class="row">Mô tả:</div>
				<div class="row">${ sanPham.moTa }</div>
			</div>
		</div>
	</div>

	<!-- /.container-fluid -->
</body>
</html>