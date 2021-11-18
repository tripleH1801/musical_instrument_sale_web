
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết sản phẩm</title>
<link rel="stylesheet"
	href='<c:url value ="/static/assets/css/admin/ChiTietSanPham/ChiTietSanPham.css"/>'>


</head>
<body>
<a href="<c:url value='/admin/san-pham/danh-sach-san-pham' />">Quay
			lại</a>
	<div class="container-fluid wrapper">


		<div class="general_info">


			<div>
				<b>Mã sản phẩm: </b>${ sanPham.id }</div>
			<div>
				<b>Tên sản phẩm: </b> ${ sanPham.tenSanPham }
			</div>
			<div>
				<b>Xuất xứ: </b> ${ sanPham.xuatXu }
			</div>
			<div>
				<b>Bảo hành: </b> ${ sanPham.baoHanh } tháng
			</div>
			<div>
				<b>Giá nhập: </b>
				<fmt:formatNumber type="currency" value="${ sanPham.giaNhap }"
					currencySymbol="" />
				VNĐ
			</div>
			<div>
				<b>Giá bán: </b>
				<fmt:formatNumber type="currency" value="${ sanPham.giaBan }"
					currencySymbol="" />
				VNĐ
			</div>
			<div>
				<b>Loại sản phẩm: </b> ${ sanPham.dongSanPham.loaiSanPham.tenLoaiSanPham }
			</div>
			<div>
				<b>Thương hiệu: </b> ${ sanPham.dongSanPham.thuongHieu.tenThuongHieu }
			</div>
			<div>
				<b>Dòng sản phẩm: </b> ${ sanPham.dongSanPham.tenDongSanPham }
			</div>
			<div class="flex_mau">
				<b>Màu: </b> <a type="button" class="btn btn-primary table__btn"
					href="<c:url value='/admin/san-pham/them-mau-san-pham?maSanPham=${ sanPham.id }'/>">Thêm
					màu</a>

			</div>
		</div>


		<div class="">
			<table class="table table_detail">

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
							<td>${ mauSanPham.soLuong }<c:set var="total"
									value="${total + mauSanPham.soLuong}" />
							</td>
							<td><input type="button" class="btn btn-warning table__btn"
								value="Sửa"
								onclick="location.href='<c:url value='/admin/san-pham/cap-nhat-mau-san-pham?maSanPham=${ sanPham.id }&maMau=${ mauSanPham.maMau }' />'">

								<input type="button" class="btn btn-danger table__btn"
								value="Xóa"
								onclick="xoaMauSanPham('${ sanPham.id }', ${ mauSanPham.maMau })">

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

			<div class="suplier">

				<div>
					<b>Nhà cung cấp:</b> ${ sanPham.nhaCungCap.tenNhaCungCap }
				</div>
				<div>
					<b>Mô tả về sản phẩm : </b>
				</div>
				<div>${ sanPham.moTa }</div>
			</div>
		</div>

	</div>
	
	<script type="text/javascript">
		function xoaMauSanPham(maSanPham, maMau){
			const url = "http://localhost:8080/WebsiteBanNhacCu/api/san-pham/xoa-mau-san-pham?maSanPham=" + maSanPham + "&maMau=" + maMau;
			
			$.ajax({
				url: url,
				type: 'DELETE',
				success: function (result) {
					if(result == 1){
						
						window.location.href = "http://localhost:8080/WebsiteBanNhacCu/admin/san-pham/xem-chi-tiet?id=" + maSanPham;
			
						toastr.success("Đã xóa sản phẩm");
					}else{
						toastr.error('Không thể xóa');
					}
				}
			});
			
		}
	</script>

	<!-- /.container-fluid -->
</body>
</html>