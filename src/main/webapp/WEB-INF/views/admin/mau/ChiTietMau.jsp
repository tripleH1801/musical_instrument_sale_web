<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết màu</title>
</head>
<body>


	<div class="container-fluid">
		
		<p>${ mau.id }</p>
		<p>${ mau.tenMau }</p>
		
		<a href="<c:url value='/admin/mau/danh-sach-mau' />">Quay lại</a>

	</div>
	<!-- /.container-fluid -->
	
</body>
</html>