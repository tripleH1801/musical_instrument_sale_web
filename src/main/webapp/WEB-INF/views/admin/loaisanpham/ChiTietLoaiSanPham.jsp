<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết loại sản phẩm</title>
</head>
<body>


	<div class="container-fluid">
		
		<p>${ loaiSanPham.id }</p>
		<p>${ loaiSanPham.tenLoaiSanPham }</p>
		
		<a href="<c:url value='/admin/loai-san-pham/danh-sach-loai-san-pham' />">Quay lại</a>

	</div>
	<!-- /.container-fluid -->
	
</body>
</html>