
/*
**check email
*/
validateEmail = () => {
	const email = document.getElementById("inputEmail").value;
	let checkEmail = document.getElementById("checkEmail");
	const regexEmail = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

	//email trống
	if (regexEmail.test(email) === false) {
		checkEmail.innerHTML = "(*) Email không hợp lệ"
		return false;
	} else {
		checkEmail.innerHTML = "";
		return true;
	}

}

validatePassword = () => {
	const password = document.getElementById("inputPassword").value;
	let checkPassword = document.getElementById("checkPassword");

	if (password === "") {
		checkPassword.innerHTML = "(*) Mật khẩu trống";
		return false
	} else {
		checkPassword.innerHTML ="";
		return true;
	}
}

$(document).ready(function () {
	if(window.location.href.includes("error")){
		toastr.error("Tài khoản hoặc mật khẩu không chính xác");
	}
});