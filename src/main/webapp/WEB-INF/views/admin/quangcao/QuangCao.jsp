<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách quảng cáo</title>


<style type="text/css">

.image{
	width: 200px;
	height: 100px;
	object-fit:contain;
	
}

</style>
</head>
<body>


	<div class="container-fluid" style="background-color: #fff">

		<!-- Row input -->
		<div class="row">
			<div class="col-lg-4"></div>

			<div class="col-lg-6"></div>

			<div class="col-lg-2">
				<div class="form-group">
					<label for="exampleInputEmail1">&#160;</label> <a type="button"
						class="form-control btn btn-primary table__btn"
						href="<c:url value='/admin/quang-cao/them-quang-cao'/>">Thêm
						quảng cáo</a>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="table-wrapper-scroll-y my-custom-scrollbar" style="width: 100%">
				<table class="table">

					<thead class="thead-light">
						<tr>
							<th style="width: 5%" >STT</th>
							<th style="width: 40%">Ảnh</th>
							<th style="width: 20%">Ngày thêm</th>
							<th style="width: 15%">Link</th>
							<th style="width: 20%"></th>
						</tr>
					</thead>

					<tbody id="tableLoaiSanPham">

						<c:forEach items="${ quangCaoDTOs }" var="quangCaoDTO"
							varStatus="counter">
							<tr>
								<td>${ counter.count }</td>
								<td><img alt=""
									class="image" src="data:image/jpg;base64,${ quangCaoDTO.hinhAnhBase64 }">
								</td>
								<td><fmt:formatDate pattern="dd-MM-yyyy"
										value="${ quangCaoDTO.ngayThem }" /></td>
								<td><a href="${ quangCaoDTO.link }">${ quangCaoDTO.link }</a>
								</td>
								<td><input type="button" class="btn btn-warning table__btn"
									value="Sửa"
									onclick="location.href='<c:url value='/admin/quang-cao/cap-nhat-quang-cao?id=${ quangCaoDTO.id }' />'">

									<input type="button" class="btn btn-danger table__btn"
									value="Xóa"
									onclick="location.href='<c:url value='/admin/quang-cao/xoa-quang-cao?id=${ quangCaoDTO.id }' />'">

								</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>



	</div>
	<!-- /.container-fluid -->
	<script src='<c:url value = "/static/assets/js/mau.js"/>'></script>
</body>
</html>