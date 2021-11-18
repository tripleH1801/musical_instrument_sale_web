<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách màu</title>
</head>
<body>


	<div class="container-fluid" style="background: #fff">

		<!-- Row input -->
		<div class="row">
			<div class="col-lg-4">
				<div class="form-group">
					<label for="txtSearch">Tìm kiếm</label> <input type="text"
						 oninput="typeSearch()" class="form-control" id="txtSearch"
						aria-describedby="emailHelp" placeholder="Nhập tên màu">
				</div>
			</div>

			<div class="col-lg-6"></div>

			<div class="col-lg-2">
				<div class="form-group">
					<label for="exampleInputEmail1">&#160;</label> 
					<a type="button"
						class="form-control btn btn-primary table__btn"
						href="<c:url value='/admin/mau/them-mau'/>">Thêm
						màu</a>
				</div>
			</div>
		</div>

		<div class="row">

			<table class="table">

				<thead class="thead-light">
					<tr>
						<th style="width: 10%">STT</th>
						<th style="width: 30%" >Mã màu</th>
						<th style="width: 30%">Tên màu</th>
						<th style="width: 30%" ></th>
					</tr>
				</thead>

				<tbody id="tableLoaiSanPham">

					<c:forEach items="${ listMau }" var="mau"
						varStatus="counter">
						<tr>
							<td>${ counter.count }</td>
							<td>${ mau.id }</td>
							<td>${ mau.tenMau }</td>
							<td>

								<%-- <input type="button" class="btn btn-primary table__btn"
								value="Chi tiết"
								onclick="location.href='<c:url value='/admin/mau/chi-tiet-mau?id=${ mau.id }' />'"> --%>

								<input type="button" class="btn btn-warning table__btn"
								value="Sửa"
								onclick="location.href='<c:url value='/admin/mau/cap-nhat-mau?id=${ mau.id }' />'">

								<input type="button" class="btn btn-danger table__btn" value="Xóa" onclick="xoa(${ mau.id })">

							</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>

		</div>



	</div>
	<!-- /.container-fluid -->
	<script type="text/javascript">
		function xoa(id) {
			var cf = confirm("Bạn muốn xóa dòng màu này ?");
			if (cf == true) {
				$.ajax({
					url: "http://localhost:8080/WebsiteBanNhacCu/api/mau-san-pham/xoa-mau?id=" + id ,
					type: 'DELETE',
					success: function (result) {
						if(result == 1){
							window.location.href = 'http://localhost:8080/WebsiteBanNhacCu/admin/mau/danh-sach-mau';
							toastr.success("Đã xóa dòng sản phẩm");
						}else{
							
							toastr.error('Màu này không thể xóa');
						}
					}
		
				});
			}
		}
	</script>
	
</body>
</html>