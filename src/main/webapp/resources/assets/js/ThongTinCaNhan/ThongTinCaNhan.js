document.addEventListener("DOMContentLoaded", function () {
    var elements = document.getElementsByTagName("INPUT");
    for (var i = 0; i < elements.length; i++) {
        elements[i].oninvalid = function (e) {
            e.target.setCustomValidity("");
            if (!e.target.validity.valid) {
                e.target.setCustomValidity("Không được phép bỏ trống ở trường này");
            }
        };
        elements[i].oninput = function (e) {
            e.target.setCustomValidity("");
        };
    }
})


function doiMatKhau() {
	alert("Đã gửi email xác nhận đổi mật khẩu ");
	let email = $("#email").val();
	$.ajax({
	    url: apiFetch = "http://localhost:8080/WebsiteBanNhacCu/register/api/email/doi-mat-khau?email=" + email,
	    type: 'GET',
	});
}


const btnSubmit = $(".btnSubmit");
var checkDiaChi = $(".checkDiaChi");
var checkBlur = $(".sel_diaChi");

console.log(checkBlur)

checkBlur.blur(function (e) {
    $(this).each(function (index, element) {
     
        if (element.value == -1) {
            checkDiaChi.text("(*) Thông tin địa chỉ cần nhập đầy đủ");
            e.preventDefault();
        } else {
            checkDiaChi.text("");
        }

    })
})




btnSubmit.click(function (e) {
    if (checkBlur.val() == -1) {
        console.log("sai");
        checkDiaChi.text("(*) Thông tin địa chỉ cần nhập đầy đủ");
        e.preventDefault();
    }
})
