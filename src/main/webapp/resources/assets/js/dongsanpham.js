const HOST_NAME = window.location.hostname
const PAGE_PATH = window.location.pathname
const PORT = window.location.port
const CONTEXT_PATH = PAGE_PATH.split("/")[1]
const API = 'api/dong-san-pham/danh-sach'

function searchType() {
	var searchText = document.getElementById("txtSearch").value;
	var cboLoaiSanPham = document.getElementById("cboLoaiSanPham").value;
	var cboThuongHieu = document.getElementById("cboThuongHieu").value;


	var pageHidden = document.getElementById("pageValue");//gia tri hiden
	var viewPage = document.getElementById("viewPage");//gia tri hien thi trang hien tai
	viewPage.value = 1; //gan lai  hien thi trang hien tai
	pageHidden.value = 1; //gan lai gia tri bien hidden

	const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API}?tenDongSanPham=${searchText}&maLoaiSanPham=${cboLoaiSanPham}&maThuongHieu=${cboThuongHieu}&page=0`;

	$.get(url, function (data, status) {
		$("#tableDongSanPham").html("");
		for (var i = 0; i < data.length; i++) {
			$("#tableDongSanPham").append(
				`<tr>
							<td>${i + 1}</td>
							<td>${data[i].id}</td>
							<td>${data[i].tenDongSanPham}</td>
							<td>${data[i].loaiSanPham}</td>
							<td>${data[i].thuongHieu}</td>
							<td>

								<input type="button" class="btn btn-warning table__btn"
								value="Sửa"
								onclick="location.href='/WebsiteBanNhacCu/admin/dong-san-pham/cap-nhat-dong-san-pham?id=${data[i].id}'">

								<input type="button" class="btn btn-danger table__btn"
								value="Xóa" onclick="Delete('${ data[i].id }')">

							</td>
						</tr>`
			);
		}
	});
}

$("select").change(function () {
	let optionSelected = $(this).find("option:selected");
	let valueSelected = optionSelected.val();

	let id = $(this).attr("id");

	if (id === "cboLoaiSanPham") {
		searchType();
	}

	if (id === "cboThuongHieu") {
		searchType();
	}
});

document.getElementById("btnNext").onclick = function () {

	var searchText = document.getElementById("txtSearch").value;
	var cboLoaiSanPham = document.getElementById("cboLoaiSanPham").value;
	var cboThuongHieu = document.getElementById("cboThuongHieu").value;

	var pageHidden = document.getElementById("pageValue");//gia tri hiden
	var viewPage = document.getElementById("viewPage");//gia tri hien thi trang hien tai

	var page = Number.parseInt(pageHidden.value);//tang gia tri
	if (Number.parseInt(pageHidden.value) == 0) {
		page = page + 2;
	}
	else {
		page = page + 1;
	}


	const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API}?tenDongSanPham=${searchText}&maLoaiSanPham=${cboLoaiSanPham}&maThuongHieu=${cboThuongHieu}&page=${page - 1}`;

	console.log(url)

	$.get(url, function (data, status) {

		if (data[0] != null) {
			console.log("data khac null")
			$("#tableDongSanPham").html("");
			for (var i = 0; i < data.length; i++) {
				$("#tableDongSanPham").append(
					`<tr>
							<td>${i + 1}</td>
							<td>${data[i].id}</td>
							<td>${data[i].tenDongSanPham}</td>
							<td>${data[i].loaiSanPham}</td>
							<td>${data[i].thuongHieu}</td>
							<td>

								<input type="button" class="btn btn-warning table__btn"
								value="Sửa"
								onclick="location.href='/WebsiteBanNhacCu/admin/dong-san-pham/cap-nhat-dong-san-pham?id=${data[i].id}'">

								<input type="button" class="btn btn-danger table__btn"
								value="Xóa" onclick="Delete('${ data[i].id }')">

							</td>
						</tr>`
				);
			}

			viewPage.value = page; //gan lai  hien thi trang hien tai
			pageHidden.value = page; //gan lai gia tri bien hidden
		}

	});

};

document.getElementById("btnPreviusPage").onclick = function () {



	var searchText = document.getElementById("txtSearch").value;
	var cboLoaiSanPham = document.getElementById("cboLoaiSanPham").value;
	var cboThuongHieu = document.getElementById("cboThuongHieu").value;

	var pageHidden = document.getElementById("pageValue");//gia tri hiden
	var viewPage = document.getElementById("viewPage");//gia tri hien thi trang hien tai

	var page = Number.parseInt(pageHidden.value);//tang gia tri
	if (Number.parseInt(pageHidden.value) > 1) {
		page = page - 1;
	}

	const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API}?tenDongSanPham=${searchText}&maLoaiSanPham=${cboLoaiSanPham}&maThuongHieu=${cboThuongHieu}&page=${page - 1}`;
	console.log(url);

	$.get(url, function (data, status) {

		if (data[0] != null) {
			$("#tableDongSanPham").html("");
			for (var i = 0; i < data.length; i++) {
				$("#tableDongSanPham").append(
					`<tr>
							<td>${i + 1}</td>
							<td>${data[i].id}</td>
							<td>${data[i].tenDongSanPham}</td>
							<td>${data[i].loaiSanPham}</td>
							<td>${data[i].thuongHieu}</td>
							<td>

								<input type="button" class="btn btn-warning table__btn"
								value="Sửa"
								onclick="location.href='/WebsiteBanNhacCu/admin/dong-san-pham/cap-nhat-dong-san-pham?id=${data[i].id}'">

								<input type="button" class="btn btn-danger table__btn"
								value="Xóa" onclick="Delete('${ data[i].id }')">

							</td>
						</tr>`
				);
			}

			viewPage.value = page; //gan lai  hien thi trang hien tai
			pageHidden.value = page;//gan lai gia tri bien hidden
		}

	});

};

function Delete(id) {
	var cf = confirm("Bạn muốn xóa dòng sản phẩm này ?");
	if (cf == true) {
		$.ajax({
			url: apiFetch = `http://localhost:8080/WebsiteBanNhacCu/api/dong-san-pham/xoa?id=${ id }`,
			type: 'DELETE',
			success: function (result) {
				if(result == 1){
					window.location.href = 'http://localhost:8080/WebsiteBanNhacCu/admin/dong-san-pham/danh-sach-dong-san-pham';
					toastr.success("Đã xóa dòng sản phẩm");
				}else{
					
					toastr.error('Dòng sản phẩm này không thể xóa');
				}
			}

		});
	}
}