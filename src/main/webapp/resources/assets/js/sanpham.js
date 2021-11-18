const HOST_NAME = window.location.hostname
const PAGE_PATH = window.location.pathname
const PORT = window.location.port
const CONTEXT_PATH = PAGE_PATH.split("/")[1]
const API = 'api/dong-san-pham/danh-sach-maloaisanpham-mathuonghieu'

$(document).ready(function () {

	new FroalaEditor("#edit");
	var maSP = $('#id').val();
	var url = "http://localhost:8080/WebsiteBanNhacCu/api/san-pham?id=" + maSP;
	$.get(url, function (data, status) {
		if (status === "success") {
			$(".fr-element").html(data.moTa);
		}
	});

	const maLoaiSanPham = $('#maLoaiSanPham').val();
	const maThuongHieu = $('#maThuongHieu').val();

	const url1 = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API}?maLoaiSanPham=${maLoaiSanPham}&maThuongHieu=${maThuongHieu}&page=${page}`;

	$.get(url1, function (data, status) {


		if (status === "success") {
			//reset cbb
			$("#maDongSanPham").html("");
			for (var i = 0; i < data.length; i++) {
				$("#maDongSanPham").append(
					'<option value="' +
					data[i].id +
					'">' +
					data[i].tenDongSanPham +
					"</option>"
				);
			}
		}

	});

});

$("select").change(function () {
	let optionSelected = $(this).find("option:selected");
	let valueSelected = optionSelected.val();

	let id = $(this).attr("id");

	if (id === "maLoaiSanPham") {
		const maThuongHieu = $('#maThuongHieu').val();

		const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API}?maLoaiSanPham=${valueSelected}&maThuongHieu=${maThuongHieu}`;
		;
		$.get(url, function (data, status) {
			const rs = data.results;

			$("#maDongSanPham").html("");
			for (var i = 0; i < data.length; i++) {
				$("#maDongSanPham").append(
					'<option value="' +
					data[i].id +
					'">' +
					data[i].tenDongSanPham +
					"</option>"
				);
			}
		});
	}

	if (id === "maThuongHieu") {
		const maLoaiSanPham = $('#maLoaiSanPham').val();

		const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API}?maLoaiSanPham=${maLoaiSanPham}&maThuongHieu=${valueSelected}`;
		;

		$.get(url, function (data, status) {
			const rs = data.results;

			$("#maDongSanPham").html("");
			for (var i = 0; i < data.length; i++) {
				$("#maDongSanPham").append(
					'<option value="' +
					data[i].id +
					'">' +
					data[i].tenDongSanPham +
					"</option>"
				);
			}
		});
	}
});


$("body").on("DOMSubtreeModified", ".fr-element", function () {
	var all = $(".fr-element")
		.map(function () {
			return this.innerHTML;
		})
		.get()
		.join();
	console.clear();
	//console.log(all);
	$("#moTa").val(all);
});


const API1 = 'api/san-pham/danh-sach-san-pham/loai/xuat-xu/thuong-hieu'

function typeSearch() {
	var searchText = document.getElementById("txtSearch").value;
	const maLoaiSanPham = $('#cboLoaiSanPham').val();
	const maThuongHieu = $('#cboThuongHieu').val();
	const xuatXu = $('#cboXuatXu').val();
	const page = $('#pageValue').val();


	var pageHidden = document.getElementById("pageValue");//gia tri hiden
	var viewPage = document.getElementById("viewPage");//gia tri hien thi trang hien tai
	viewPage.value = 1; //gan lai  hien thi trang hien tai
	pageHidden.value = 1; //gan lai gia tri bien hidden

	const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API1}?tenSanPham=${searchText}&xuatXu=${xuatXu}&maLoaiSanPham=${maLoaiSanPham}&maThuongHieu=${maThuongHieu}&page=0`;

	console.log(url)

	$.get(url, function (data, status) {
		console.log(data)

		if (data[0] != null) {
			$("#tableSanPham").html("");
			$("#tableSanPham").html("");
			for (var i = 0; i < data.length; i++) {

				var id = data[i].id;
				var tenSanPham = data[i].tenSanPham;
				var maLoaiSanPham = data[i].tenLoaiSanPham;
				var xuatXu = data[i].xuatXu;
				var maThuongHieu = data[i].tenThuongHieu;
				var sl = data[i].tongSoLuong;

				$("#tableSanPham").append(
					`<tr>
						<td>${i + 1}</td>
						<td>${tenSanPham}</td>
						<td>${maLoaiSanPham}</td>
						<td>${xuatXu}</td>
						<td>${maThuongHieu}</td>
						<td>${sl}</td>
						<td><input type="button" class="btn btn-primary table__btn"
							value="Chi tiết"
							onclick="location.href='/${CONTEXT_PATH}/admin/san-pham/xem-chi-tiet?id=${id}'">
			
							<input type="button" class="btn btn-warning table__btn"
							value="Sửa"
							onclick="location.href='/${CONTEXT_PATH}/admin/san-pham/cap-nhat-san-pham?id=${id}'">
			
							<input type="button" class="btn btn-danger table__btn btnXoa"
								value="Xóa">
							<input class="maSanPham" value="${id}" type="hidden"/>
			
						</td>
					</tr>`
				);
			}
		}
		else {
			$("#tableSanPham").html("");
			$("#tableSanPham").append(
				'<tr><td>Không tìm thấy sản phẩm nào :( </td></tr>');
		}

	});
}

$("select").change(function () {

	let id = $(this).attr("id");

	if (id === "cboLoaiSanPham") {
		typeSearch();
	}

	else if (id === "cboThuongHieu") {
		typeSearch();
	}

	else if (id === "cboXuatXu") {
		typeSearch();
	}
});


document.getElementById("btnNext").onclick = function () {

	var searchText = document.getElementById("txtSearch").value;
	const maLoaiSanPham = $('#cboLoaiSanPham').val();
	const maThuongHieu = $('#cboThuongHieu').val();
	const xuatXu = $('#cboXuatXu').val();

	var pageHidden = document.getElementById("pageValue");//gia tri hiden
	var viewPage = document.getElementById("viewPage");//gia tri hien thi trang hien tai

	var page = Number.parseInt(pageHidden.value);//tang gia tri
	if (Number.parseInt(pageHidden.value) == 0) {
		page = page + 2;
	}
	else {
		page = page + 1;
	}


	const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API1}?tenSanPham=${searchText}&xuatXu=${xuatXu}&maLoaiSanPham=${maLoaiSanPham}&maThuongHieu=${maThuongHieu}&page=${page - 1}`;

	console.log(url)

	$.get(url, function (data, status) {

		if (data[0] != null) {

			$("#tableSanPham").html("");
			for (var i = 0; i < data.length; i++) {

				var id = data[i].id;
				var tenSanPham = data[i].tenSanPham;
				var maLoaiSanPham = data[i].tenLoaiSanPham;
				var xuatXu = data[i].xuatXu;
				var maThuongHieu = data[i].tenThuongHieu;
				var sl = data[i].tongSoLuong;

				$("#tableSanPham").append(
					`<tr>
						<td>${i + 1}</td>
						<td>${tenSanPham}</td>
						<td>${maLoaiSanPham}</td>
						<td>${xuatXu}</td>
						<td>${maThuongHieu}</td>
						<td>${sl}</td>
						<td><input type="button" class="btn btn-primary table__btn"
							value="Chi tiết"
							onclick="location.href='/${CONTEXT_PATH}/admin/san-pham/xem-chi-tiet?id=${id}'">
			
							<input type="button" class="btn btn-warning table__btn"
							value="Sửa"
							onclick="location.href='/${CONTEXT_PATH}/admin/san-pham/cap-nhat-san-pham?id=${id}'">
			
							<input type="button" class="btn btn-danger table__btn btnXoa"
								value="Xóa">
							<input class="maSanPham" value="${id}" type="hidden"/>
			
						</td>
					</tr>`
				);

			}

			viewPage.value = page; //gan lai  hien thi trang hien tai
			pageHidden.value = page;//gan lai gia tri bien hidden
		}

	});

};

document.getElementById("btnPreviusPage").onclick = function () {

	var searchText = document.getElementById("txtSearch").value;
	const maLoaiSanPham = $('#cboLoaiSanPham').val();
	const maThuongHieu = $('#cboThuongHieu').val();
	const xuatXu = $('#cboXuatXu').val();

	var pageHidden = document.getElementById("pageValue");//gia tri hiden
	var viewPage = document.getElementById("viewPage");//gia tri hien thi trang hien tai

	var page = Number.parseInt(pageHidden.value);//tang gia tri
	if (Number.parseInt(pageHidden.value) > 1) {
		page = page - 1;
	}

	const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API1}?tenSanPham=${searchText}&xuatXu=${xuatXu}&maLoaiSanPham=${maLoaiSanPham}&maThuongHieu=${maThuongHieu}&page=${page - 1}`;
	console.log(url);

	$.get(url, function (data, status) {

		if (data[0] != null) {

			$("#tableSanPham").html("");
			for (var i = 0; i < data.length; i++) {

				var id = data[i].id;
				var tenSanPham = data[i].tenSanPham;
				var maLoaiSanPham = data[i].tenLoaiSanPham;
				var xuatXu = data[i].xuatXu;
				var maThuongHieu = data[i].tenThuongHieu;
				var sl = data[i].tongSoLuong;

				$("#tableSanPham").append(
					`<tr>
						<td>${i + 1}</td>
						<td>${tenSanPham}</td>
						<td>${maLoaiSanPham}</td>
						<td>${xuatXu}</td>
						<td>${maThuongHieu}</td>
						<td>${sl}</td>
						<td><input type="button" class="btn btn-primary table__btn"
							value="Chi tiết"
							onclick="location.href='/${CONTEXT_PATH}/admin/san-pham/xem-chi-tiet?id=${id}'">
			
							<input type="button" class="btn btn-warning table__btn"
							value="Sửa"
							onclick="location.href='/${CONTEXT_PATH}/admin/san-pham/cap-nhat-san-pham?id=${id}'">
			
							<input type="button" class="btn btn-danger table__btn btnXoa"
								value="Xóa">
							<input class="maSanPham" value="${id}" type="hidden"/>
			
						</td>
					</tr>`
				);

			}

			viewPage.value = page; //gan lai  hien thi trang hien tai
			pageHidden.value = page;//gan lai gia tri bien hidden
		}

	});

};

$(".btnXoa").each(function (index) {

	$(this).click(function () {
		console.log("da nhan btnXoa")
		var cf = confirm("Bạn muốn xóa sản phẩm này ?");
		if (cf == true) {
			let id = $(".maSanPham").get(index).value;
			xoaSanPham(id);
		}
	});
});

xoaSanPham = (id) => {

	console.log(`http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/api/san-pham/xoa?id=${id}`);
	$.ajax({
		url: apiFetch = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/api/san-pham/xoa?id=${id}`,
		type: 'DELETE',
		success: function (result) {
			if(result == 1){
				var pageHidden = document.getElementById("pageValue");//gia tri hiden
				var viewPage = document.getElementById("viewPage");//gia tri hien thi trang hien tai
				viewPage.value = 1; //gan lai  hien thi trang hien tai
				pageHidden.value = 1; //gan lai gia tri bien hidden
				
				window.location.href = 'http://localhost:8080/WebsiteBanNhacCu/admin/san-pham/danh-sach-san-pham';
	
				toastr.success("Đã xóa sản phẩm");
			}else{
				toastr.error('sản phẩm này không thể xóa');
			}
		},
		error: function () {
			alert('sản phẩm này không thể xóa');
			
		},
	});
}


$("body").on("DOMSubtreeModified", "#tableSanPham", function () {
	$(".btnXoa").each(function (index) {
		$(this).click(function () {
			console.log("da nhan btnXoa")
			var cf = confirm("Bạn muốn xóa sản phẩm này ?");
			if (cf == true) {
				let id = $(".maSanPham").get(index).value;
				xoaSanPham(id);
			}
		});
	});
});