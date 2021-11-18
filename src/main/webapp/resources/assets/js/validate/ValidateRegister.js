validatePassword = () => {
	const password = document.getElementById("password").value;
	let checkPassword = document.getElementById("checkPassword");

	if (password == "") {
		checkPassword.innerHTML = "(*) Mật khẩu trống";
		return false;
	} else {
		checkPassword.innerHTML = "";
		return true;
	}
}

validatePasswordCf = () => {
	const passwordcfg = document.getElementById("passwordConf").value;
	let checkPasswordcfg = document.getElementById("checkPasswordCf");
	const password = document.getElementById("password").value

	if (password == "") {
		checkPasswordcfg.innerHTML = "(*) Mật khẩu xác nhận trống";
		return false;
	} else if (passwordcfg !== password) {
		checkPasswordcfg.innerHTML = "(*) Mật xác nhận không khớp ";
		return false;
	}
	else {
		checkPasswordcfg.innerHTML = "";
		return true;
	}
}


validateFullname = () => {
	const fullname = document.getElementById("fullName").value;
	let checkFullName = document.getElementById("checkFullName");

	if (fullname == "") {
		checkFullName.innerHTML = "(*) Họ tên trống";
		return false;
	} else {
		checkFullName.innerHTML = "";
		return true;
	}
}

validateSdt = () => {
	const sdt = document.getElementById("phone").value;
	let stdCheck = document.getElementById("checkPhone");
	regex = /^\d{10}$/;

	if (regex.test(sdt) == false) {
		stdCheck.innerHTML = "(*) Số điện thoại không hợp lệ";
		return false;
	} else {
		stdCheck.innerHTML = "";

		return true;
	}

}





validateTinh = () => {
	const tinh = document.getElementById("tinh").value;
	let checkTinh = document.getElementById("checkTinh");

	if (tinh == -1) {
		checkTinh.innerHTML = "(*) Tỉnh thành phố không hợp lệ";
		return false;
	} else {
		checkTinh.innerHTML = "";
		return true;
	}

}



vaidateHuyen = () => {
	const huyen = document.getElementById("huyen").value;
	let checkHuyen = document.getElementById("checkHuyen");

	if (huyen == -1) {
		checkHuyen.innerHTML = "(*) Quận/huyện không hợp lệ";
		return false;
	} else {
		checkHuyen.innerHTML = "";
		return true;
	}

}


vaidateXa = () => {
	const xa = document.getElementById("xa").value;
	let checkXa = document.getElementById("checkXa");

	if (xa == -1) {
		checkXa.innerHTML = "(*) Phường/xã không hợp lệ";
		return false;
	} else {
		checkXa.innerHTML = "";
		return true;
	}

}



vaidateSoNha = () => {
	const diaChi = document.getElementById("diaChi").value;
	let checkSoNha = document.getElementById("checkSoNha");

	if (diaChi == "") {
		checkSoNha.innerHTML = "(*) Số nhà tên đường không hợp lệ";
		return false;
	} else {
		checkSoNha.innerHTML = "";
		return true;
	}

}


const regexEmail = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

function validateEmail() {

	let email = document.getElementById("email").value;
	let checkEmail = document.getElementById("checkEmail");


	if (!regexEmail.test(email)) {
		checkEmail.innerHTML = "(*) Email không hợp lệ";
		return false;
	} else {
		checkEmail.innerHTML = "";
		return true;
	}


}



document.getElementById("btnSubmit").addEventListener("click", function(e) {


	if (validateFullname()&& validateEmail()  && validateSdt()  && validateTinh() && vaidateHuyen() && vaidateXa() && vaidateSoNha() && validatePassword() && validatePasswordCf()) {
		form.submit();
	}
	else {
		e.preventDefault();

	}

});




