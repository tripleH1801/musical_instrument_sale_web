muaNgay = () => {
	var maMau = $(".selected__color input").val();
	var maSanPham = $("#maSP").text();
	console.log(maSanPham);
	var apiFetch =
		"http://localhost:8080/WebsiteBanNhacCu/api/gio-hang/them-vao-gio-hang?maSanPham=" +
		maSanPham +
		"&maMau=" +
		maMau;
	console.log(apiFetch);

	$.get(apiFetch, function (data) {
		//		setTimeout(function () {
		if (data == 1) {
			console.log("Đã thêm vào giỏ hàng");
			toastr.success("Đã thêm vào giỏ hàng");
			window.location.href =
				"http://localhost:8080/WebsiteBanNhacCu/gio-hang";
		} else if (data == -1) {
			toastr.error("Sản phẩm đã hết hàng");
		}
		//		}, 500);
	});
};

themVaoGio = () => {
	var maMau = $(".selected__color input").val();
	var maSanPham = $("#maSP").text();
	console.log(maSanPham);
	var apiFetch =
		"http://localhost:8080/WebsiteBanNhacCu/api/gio-hang/them-vao-gio-hang?maSanPham=" +
		maSanPham +
		"&maMau=" +
		maMau;
	console.log(apiFetch);

	$.get(apiFetch, function (data) {
		//		setTimeout(function () {
		if (data == 1) {
			console.log("Đã thêm vào giỏ hàng");
			toastr.success("Đã thêm vào giỏ hàng");
		} else if (data == -1) {
			toastr.error("Sản phẩm đã hết hàng");
		}
		//		}, 500);
	});
};