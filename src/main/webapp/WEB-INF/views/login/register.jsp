<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng kí tài khoản</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<link rel="stylesheet" href="static/style.css">
<link rel="stylesheet"
	href="<c:url value="/static/assets/css/ValidateStyle.css"/>" />

</head>
<body>
	<!-- <form action="" method="Post">
		<input type="text" name="email" /> <input type="password"
			name="password" /> <input type="submit" value="Login" />
	</form> -->
	<div id="logreg-forms">

		<form:form action="register" method="post" modelAttribute="user"
			id="formRegister">
			<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">
				Đăng kí tài khoản</h1>
			<!-- <div class="social-login">
				<button class="btn facebook-btn social-btn" type="button">
					<span><i class="fab fa-facebook-f"></i> Sign up with
						Facebook</span>
				</button>
			</div>
			<div class="social-login">
				<button class="btn google-btn social-btn" type="button">
					<span><i class="fab fa-google-plus-g"></i> Sign up with
						Google+</span>
				</button>
			</div>

			<p style="text-align: center">OR</p> -->

			<form:hidden path="userId" />
			<div class="form-group">
				<form:input path="fullName" typed="text" class="form-control"
					placeholder="Họ tên" required="" autofocus=""
					onblur="validateFullname()" />

				<span id="checkFullName"></span>
				<form:errors cssStyle="color:red" path="fullName" />
			</div>

			<div class="form-group">
				<form:input path="email" type="email" class="form-control"
					placeholder="Email" required="" autofocus=""
					onblur="validateEmail()" />
				<form:errors cssStyle="color:red" path="email" />
				<span id="checkEmail"></span>
			</div>

			<div class="form-group">
				<form:input path="phone" type="text" class="form-control"
					placeholder="Số điện thoại" required="" autofocus=""
					onblur="validateSdt()" />
				<span id="checkPhone"></span>
				<form:errors cssStyle="color:red" path="phone" />
			</div>
			<div class="form-group">
				<select id="tinh" Class="form-control" onblur="validateTinh()">
					<option value="-1" selected>Chọn Tỉnh/ Thành phố</option>
				</select> <span id="checkTinh"></span>
			</div>

			<form:hidden path="tinhThanhPho" />

			<div class="form-group">
				<select id="huyen" Class="form-control" onblur="vaidateHuyen()">
					<option value="-1" selected>Chọn Huyện/ Quận</option>
				</select> <span id="checkHuyen"></span>
			</div>

			<form:hidden path="quanHuyen" />

			<div class="form-group">
				<select id="xa" Class="form-control" onblur="vaidateXa()">
					<option value="-1" selected>Chọn Xã/ Phường</option>
				</select> <span id="checkXa"></span>
			</div>

			<form:hidden path="phuongXa" />

			<div class="form-group">
				<form:input path="diaChi" class="form-control"
					placeholder="Số nhà, tên đường" onblur="vaidateSoNha()" />
				<form:errors path="diaChi" Class="error"></form:errors>
				<span id="checkSoNha"></span>
			</div>

			<div class="form-group">
				<form:input path="password" type="password" class="form-control"
					placeholder="Mật khẩu" required="" autofocus=""
					onblur="validatePassword()" />
				<form:errors cssStyle="color:red" path="password" />
				<span id="checkPassword"></span>
			</div>

			<div class="form-group">
				<form:input path="passwordConf" type="password" class="form-control"
					placeholder="Nhập lại mật khẩu" required="" autofocus=""
					onblur="validatePasswordCf()" />
				<form:errors cssStyle="color:red" path="passwordConf" />
				<span id="checkPasswordCf"></span>
			</div>



			<button class="btn btn-primary btn-block" id="btnSubmit">
				<i class="fas fa-user-plus"></i> Đăng kí
			</button>
			<!-- <a href="login" id="cancel_signup"><i class="fas fa-angle-left"></i>
				Back</a> -->
		</form:form>
		<br>

	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script src="/script.js"></script>

	<script
		src="<c:url value="/static/assets/js/validate/ValidateRegister.js"/>"></script>
	<script src="<c:url value="/static/assets/js/diaChi.js"/>"></script>
</body>
</html>