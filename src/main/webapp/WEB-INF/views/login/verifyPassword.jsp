<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đổi mật khẩu</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<link rel="stylesheet" href="static/style.css">

</head>
<body>
	<div id="logreg-forms">
		<c:url
			value="/forgot-password/enter-password?email=${email}&token=${token}"
			var="url" />
		<form action="${url}" method="post">
			<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Đổi
				mật khẩu</h1>
			<div class="form-group">
			<input name="password" type="password" class="form-control"
				placeholder="Nhập mật khẩu mới" required autofocus /> 
			</div>
			
			<div class="form-group">
			<input
				type="password" class="form-control"
				placeholder="Nhập lại mật khẩu mới" required autofocus/>
			</div>
			<button class="btn btn-primary btn-block" type="submit">
				<i class="fas fa-user-plus"></i>Đổi mật khẩu
			</button>
		</form>

		<%-- <p class="mt-3 mb-1">
			<a href='<c:url value="/login"  />'>Đăng nhập</a>
		</p> --%>
	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script src="/script.js"></script>

</body>
</html>