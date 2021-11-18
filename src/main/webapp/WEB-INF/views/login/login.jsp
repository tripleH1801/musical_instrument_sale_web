<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>

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
		<form class="form-signin" action="" method="post">
			<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">
				Đăng nhập</h1>
			<!-- <div class="social-login">
				<button class="btn facebook-btn social-btn" type="button">
					<span><i class="fab fa-facebook-f"></i> Sign in with
						Facebook</span>
				</button>
				<button class="btn google-btn social-btn" type="button">
					<span><i class="fab fa-google-plus-g"></i> Sign in with
						Google+</span>
				</button>
			</div> 
			<p style="text-align: center">OR</p>-->
			<div class="form-group">
				<input type="text" id="inputEmail" class="form-control"
					placeholder="Email" required autofocus name="email"
					onblur="validateEmail()"> <span id="checkEmail"
					class="check"></span>
			</div>

			<div class="form-group">
				<input type="password" id="inputPassword" class="form-control"
					onblur="validatePassword()" placeholder="Mật khẩu" required
					name="password"> <span id="checkPassword" class="check"></span>
			</div>

			<div class="duytridangnhap">
				<input type="checkbox" name="remember-me"> <label
					class="form-group ">Duy trì đăng nhập</label>

			</div>




			<button class="btn btn-success btn-block" type="submit">
				<i class="fas fa-sign-in-alt"></i> Đăng nhập
			</button>
			<a href='forgot-password' id="forgot_pswd">Quên mật khẩu?</a>
			<hr>
			<!-- <p>Don't have an account!</p>  -->

		</form>
		<form class="form-signin" action="register">
			<button class="btn btn-primary btn-block" type="submit"
				id="btn-signup">
				<i class="fas fa-user-plus"></i> Đăng kí tài khoản
			</button>
		</form>

	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script src="/script.js"></script>

	<script
		src="<c:url value="/static/assets/js/validate/ValidateLogin.js"/>"></script>

</body>
</html>