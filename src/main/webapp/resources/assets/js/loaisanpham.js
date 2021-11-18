const HOST_NAME = window.location.hostname
const PAGE_PATH = window.location.pathname
const PORT = window.location.port
const CONTEXT_PATH = PAGE_PATH.split("/")[1]
const API = 'api/loai-san-pham/danh-sach'

function typeSearch() {
	var searchText = document.getElementById("txtSearch").value;
		
	var pageHidden = document.getElementById("pageValue");//gia tri hiden
	var viewPage = document.getElementById("viewPage");//gia tri hien thi trang hien tai
	viewPage.value = 1; //gan lai  hien thi trang hien tai
	pageHidden.value = 1; //gan lai gia tri bien hidden
	
	const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API}?tenLoaiSanPham=${searchText}&page=0`;

	$.get(url, function (data, status) {
		$("#tableLoaiSanPham").html("");
		for (var i = 0; i < data.length; i++) {
			$("#tableLoaiSanPham").append(
				`<tr>
				<td>${i + 1}</td>
				<td>${data[i].id}</td>
				<td>${data[i].tenLoaiSanPham}</td>
				<>

					<input type="button" class="btn btn-primary table__btn"
					value="Chi tiết"
					onclick="location.href='/WebsiteBanNhacCu/admin/loai-san-pham/chi-tiet-loai-san-pham?id=${data[i].id}'">

					<input type="button" class="btn btn-warning table__btn"
					value="Sửa"
					onclick="location.href='/WebsiteBanNhacCu/admin/loai-san-pham/cap-nhat-loai-san-pham?id=${data[i].id}'">

					<input type="button" class="btn btn-danger table__btn btnXoa" id="" value="Xóa">
                    <input type="hidden" class="maLoaiSanPham" value="${ data[i].id}" />

				</td>
			</tr>`
			);
		}
	});
}

document.getElementById("btnNext").onclick = function () {

	var searchText = document.getElementById("txtSearch").value;

	var pageHidden = document.getElementById("pageValue");//gia tri hiden
	var viewPage = document.getElementById("viewPage");//gia tri hien thi trang hien tai

	var page = Number.parseInt(pageHidden.value);//tang gia tri
	if (Number.parseInt(pageHidden.value) == 0) {
		page = page + 2;
	}
	else {
		page = page + 1;
	}


	const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API}?tenLoaiSanPham=${searchText}&page=${page - 1}`;

	console.log(url)

	$.get(url, function (data, status) {

		if (data[0] != null) {
			console.log("data khac null")
			$("#tableLoaiSanPham").html("");
			for (var i = 0; i < data.length; i++) {
				$("#tableLoaiSanPham").append(
				`<tr>
					<td>${i + 1}</td>
					<td>${data[i].id}</td>
					<td>${data[i].tenLoaiSanPham}</td>
					<>

						<input type="button" class="btn btn-primary table__btn"
						value="Chi tiết"
						onclick="location.href='/WebsiteBanNhacCu/admin/loai-san-pham/chi-tiet-loai-san-pham?id=${data[i].id}'">

						<input type="button" class="btn btn-warning table__btn"
						value="Sửa"
						onclick="location.href='/WebsiteBanNhacCu/admin/loai-san-pham/cap-nhat-loai-san-pham?id=${data[i].id}'">

						<input type="button" class="btn btn-danger table__btn btnXoa" id="" value="Xóa">
                        <input type="hidden" class="maLoaiSanPham" value="${ data[i].id}" />

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

	var pageHidden = document.getElementById("pageValue");//gia tri hiden
	var viewPage = document.getElementById("viewPage");//gia tri hien thi trang hien tai

	var page = Number.parseInt(pageHidden.value);//tang gia tri
	if (Number.parseInt(pageHidden.value) > 1) {
		page = page - 1;
	}

	const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API}?tenLoaiSanPham=${searchText}&page=${page - 1}`;
	console.log(url);

	$.get(url, function (data, status) {

		if (data[0] != null) {
			$("#tableLoaiSanPham").html("");
			for (var i = 0; i < data.length; i++) {
				$("#tableLoaiSanPham").append(
				`<tr>
					<td>${i + 1}</td>
					<td>${data[i].id}</td>
					<td>${data[i].tenLoaiSanPham}</td>
					<>

						<input type="button" class="btn btn-primary table__btn"
						value="Chi tiết"
						onclick="location.href='/WebsiteBanNhacCu/admin/loai-san-pham/chi-tiet-loai-san-pham?id=${data[i].id}'">

						<input type="button" class="btn btn-warning table__btn"
						value="Sửa"
						onclick="location.href='/WebsiteBanNhacCu/admin/loai-san-pham/cap-nhat-loai-san-pham?id=${data[i].id}'">

						<input type="button" class="btn btn-danger table__btn btnXoa" id="" value="Xóa">
                        <input type="hidden" class="maLoaiSanPham" value="${ data[i].id}" />

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
		var cf = confirm("Bạn muốn xóa loại sản phẩm này ?");
		if (cf == true) {
			let id = $(".maLoaiSanPham").get(index).value;
			xoaSanPham(id);
		}
	});
});

xoaSanPham = (id) => {

	console.log(`http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/api/loai-san-pham/xoa?id=${id}`);
	$.ajax({
		url: apiFetch = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/api/loai-san-pham/xoa?id=${id}`,
		type: 'DELETE',
		success: function (result) {
			if(result == 1){
				
				var pageHidden = document.getElementById("pageValue"); //gia tri hiden
				var viewPage = document.getElementById("viewPage"); //gia tri hien thi trang hien tai
				viewPage.value = 1; //gan lai  hien thi trang hien tai
				pageHidden.value = 1; //gan lai gia tri bien hidden
				
				window.location.href = 'http://localhost:8080/WebsiteBanNhacCu/admin/loai-san-pham/danh-sach-loai-san-pham';
				
				console.log("Đã xóa loại sản phẩm");
				toastr.success("Đã xóa loại sản phẩm");
			}else{
				
				toastr.error('Loại sản phẩm này không thể xóa');
			}
		}

	});
}


$("body").on("DOMSubtreeModified", "#tableLoaiSanPham", function () {
	$(".btnXoa").each(function (index) {
		$(this).click(function () {
			console.log("da nhan btnXoa")
			var cf = confirm("Bạn muốn xóa loại sản phẩm này ?");
			if (cf == true) {
				let id = $(".maLoaiSanPham").get(index).value;
				xoaNguoiDung(id);
			}
		});
	});
});