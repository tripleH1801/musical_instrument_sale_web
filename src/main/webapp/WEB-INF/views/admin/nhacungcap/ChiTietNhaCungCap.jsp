<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết nhà cung cấp</title>
</head>
<body>


	<div class="container-fluid" style="background-color: #fff">
		
		<p>${ nhaCungCap.maNhaCungCap }</p>
		<p>${ nhaCungCap.tenNhaCungCap }</p>
		<p>${ nhaCungCap.soDienThoai }</p>
		<p><a href="${ nhaCungCap.website }">${ nhaCungCap.website }</a></p>
		<p>${ nhaCungCap.diaChi }</p>
		
		<a href="<c:url value='/admin/nha-cung-cap/danh-sach-nha-cung-cap' />">Quay lại</a>

	</div>
	<!-- /.container-fluid -->
	
</body>
</html>