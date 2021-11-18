function chiTietDonHang(id) {
	window.location.href = "http://localhost:8080/WebsiteBanNhacCu/admin/quan-li-don-hang/chi-tiet-don-hang?maDonHang=" + id;
}

const HOST_NAME = window.location.hostname
const PAGE_PATH = window.location.pathname
const PORT = window.location.port
const CONTEXT_PATH = PAGE_PATH.split("/")[1]
const API = 'api/hoa-don/danh-sach-don-hang'

function searchFull() {
	var DATE = document.getElementById("date").value;

	if(DATE.includes("dd")){
		DATE = '';
	}

	var TRANG_THAI = document.getElementById("trangThai").value;

	TRANG_THAI = TRANG_THAI.trim().split(' ').join('+');

	var pageHidden = document.getElementById("pageValue");//gia tri hiden
	var viewPage = document.getElementById("viewPage");//gia tri hien thi trang hien tai
	viewPage.value = 1; //gan lai  hien thi trang hien tai
	pageHidden.value = 1; //gan lai gia tri bien hidden

	const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API}?date=${DATE}&trangThai=${TRANG_THAI}&page=0`;
	console.log(url)

	$.get(url, function (data, status) {
		$("#tableDonHang").html("");
		for (var i = 0; i < data.length; i++) {

			var str = ``;
			const cthd = data[i].chiTietHoaDonDTOs;
			for (var k = 0; k < cthd.length; k++) {
				str +=
					`<p>Sản phẩm: ${cthd[k].mauSanPhamDTO.tenSanPham}
					- Màu: ${cthd[k].mauSanPhamDTO.tenMau} - Số lượng:
					${cthd[k].soLuong}</p>`
			}
			var date = new Date(data[i].ngayLapHD); // Date 2011-05-09T06:08:45.178Z
			var year = date.getFullYear();
			var month = ("0" + (date.getMonth() + 1)).slice(-2);
			var day = ("0" + date.getDate()).slice(-2);
			var strDate = `${day}-${month}-${year}`;

			$("#tableDonHang").append(
				`<tr>
				<td>${i + 1}</td>
				<td>${data[i].id}</td>
				<td>${strDate}</td>
				<td>
				${str}
				<td>
					${data[i].tongTien} VNĐ
				</td>
				<td>${data[i].trangThai}</td>
				<td>
					<button class="btn btn-danger" onclick="chiTietDonHang('${data[i].id}')">Xem chi tiết</button>
				</td>`
			);
		}
	});
}

function Reset(){
	document.getElementById("trangThai").value = '';
	document.getElementById("date").value = 'dd-MM-yyyy';
	searchFull();
}

document.getElementById("btnNext").onclick = function () {
	var DATE = document.getElementById("date").value;

	if(DATE.includes("dd")){
		DATE = '';
	}

	
	var TRANG_THAI = document.getElementById("trangThai").value;

	TRANG_THAI = TRANG_THAI.trim().split(' ').join('+');

	var pageHidden = document.getElementById("pageValue");//gia tri hiden
	var viewPage = document.getElementById("viewPage");//gia tri hien thi trang hien tai

	var page = Number.parseInt(pageHidden.value);//tang gia tri
	if (Number.parseInt(pageHidden.value) == 0) {
		page = page + 2;
	}
	else {
		page = page + 1;
	}


	const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API}?date=${DATE}&trangThai=${TRANG_THAI}&page=${ page - 1 }`;

	console.log(url)

	$.get(url, function (data, status) {

		if (data[0] != null) {
			console.log("data khac null")
			$("#tableDonHang").html("");
			for (var i = 0; i < data.length; i++) {

				var str = ``;
				const cthd = data[i].chiTietHoaDonDTOs;
				for (var k = 0; k < cthd.length; k++) {
					str +=
						`<p>Sản phẩm: ${cthd[k].mauSanPhamDTO.tenSanPham}
						- Màu: ${cthd[k].mauSanPhamDTO.tenMau} - Số lượng:
						${cthd[k].soLuong}</p>`
				}
				var date = new Date(data[i].ngayLapHD); // Date 2011-05-09T06:08:45.178Z
				var year = date.getFullYear();
				var month = ("0" + (date.getMonth() + 1)).slice(-2);
				var day = ("0" + date.getDate()).slice(-2);
				var strDate = `${day}-${month}-${year}`;

				$("#tableDonHang").append(
					`<tr>
					<td>${i + 1}</td>
					<td>${data[i].id}</td>
					<td>${strDate}</td>
					<td>
					${str}
					<td>
						${data[i].tongTien} VNĐ
					</td>
					<td>${data[i].trangThai}</td>
					<td>
						<button class="btn btn-danger" onclick="chiTietDonHang('${data[i].id}')">Xem chi tiết</button>
					</td>`
				);
			}

			viewPage.value = page; //gan lai  hien thi trang hien tai
			pageHidden.value = page; //gan lai gia tri bien hidden
		}

	});

};

document.getElementById("btnPreviusPage").onclick = function () {
	var DATE = document.getElementById("date").value;

	if(DATE.includes("dd")){
		DATE = '';
	}

	
	var TRANG_THAI = document.getElementById("trangThai").value;

	TRANG_THAI = TRANG_THAI.trim().split(' ').join('+');

	var pageHidden = document.getElementById("pageValue");//gia tri hiden
	var viewPage = document.getElementById("viewPage");//gia tri hien thi trang hien tai

	var page = Number.parseInt(pageHidden.value);//tang gia tri
	if (Number.parseInt(pageHidden.value) > 1) {
		page = page - 1;
	}

	const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API}?date=${DATE}&trangThai=${TRANG_THAI}&page=${ page - 1 }`;
	console.log(url);

	$.get(url, function (data, status) {

		if (data[0] != null) {
			$("#tableDonHang").html("");
			for (var i = 0; i < data.length; i++) {

				var str = ``;
				const cthd = data[i].chiTietHoaDonDTOs;
				for (var k = 0; k < cthd.length; k++) {
					str +=
						`<p>Sản phẩm: ${cthd[k].mauSanPhamDTO.tenSanPham}
						- Màu: ${cthd[k].mauSanPhamDTO.tenMau} - Số lượng:
						${cthd[k].soLuong}</p>`
				}
				var date = new Date(data[i].ngayLapHD); // Date 2011-05-09T06:08:45.178Z
				var year = date.getFullYear();
				var month = ("0" + (date.getMonth() + 1)).slice(-2);
				var day = ("0" + date.getDate()).slice(-2);
				var strDate = `${day}-${month}-${year}`;

				$("#tableDonHang").append(
					`<tr>
					<td>${i + 1}</td>
					<td>${data[i].id}</td>
					<td>${strDate}</td>
					<td>
					${str}
					<td>
						${data[i].tongTien} VNĐ
					</td>
					<td>${data[i].trangThai}</td>
					<td>
						<button class="btn btn-danger" onclick="chiTietDonHang('${data[i].id}')">Xem chi tiết</button>
					</td>`
				);
			}

			viewPage.value = page; //gan lai  hien thi trang hien tai
			pageHidden.value = page;//gan lai gia tri bien hidden
		}

	});

};

const API1 = 'api/hoa-don'
function searchId(){
	var id = document.getElementById("txtSearch").value;
	id = id.toUpperCase();

	var pageHidden = document.getElementById("pageValue");//gia tri hiden
	var viewPage = document.getElementById("viewPage");//gia tri hien thi trang hien tai
	viewPage.value = 1; //gan lai  hien thi trang hien tai
	pageHidden.value = 1; //gan lai gia tri bien hidden

	const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API1}?id=${id}`;

	console.log(url)

	$.get(url, function (data, status) {
		$("#tableDonHang").html("");

			var str = ``;
			const cthd = data.chiTietHoaDonDTOs;
			for (var k = 0; k < cthd.length; k++) {
				str +=
					`<p>Sản phẩm: ${cthd[k].mauSanPhamDTO.tenSanPham}
					- Màu: ${cthd[k].mauSanPhamDTO.tenMau} - Số lượng:
					${cthd[k].soLuong}</p>`
			}
			var date = new Date(data.ngayLapHD); // Date 2011-05-09T06:08:45.178Z
			var year = date.getFullYear();
			var month = ("0" + (date.getMonth() + 1)).slice(-2);
			var day = ("0" + date.getDate()).slice(-2);
			var strDate = `${day}-${month}-${year}`;

			$("#tableDonHang").append(
				`<tr>
				<td>${1}</td>
				<td>${data.id}</td>
				<td>${strDate}</td>
				<td>
				${str}
				<td>
					${data.tongTien} VNĐ
				</td>
				<td>${data.trangThai}</td>
				<td>
					<button class="btn btn-danger" onclick="chiTietDonHang('${data.id}')">Xem chi tiết</button>
				</td>`
			);
	});
}

$("#txtSearch").on('keyup', function (e) {
    if (e.key === 'txtSearch' || e.keyCode === 13) {
        searchId();
    }
});