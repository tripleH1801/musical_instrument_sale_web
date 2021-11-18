const HOST_NAME = window.location.hostname
const PAGE_PATH = window.location.pathname
const PORT = window.location.port
const CONTEXT_PATH = PAGE_PATH.split("/")[1]
const API = 'api/thuong-hieu/danh-sach'

function typeSearch() {
	var searchText = document.getElementById("txtSearch").value;
		
	var pageHidden = document.getElementById("pageValue");//gia tri hiden
	var viewPage = document.getElementById("viewPage");//gia tri hien thi trang hien tai
	viewPage.value = 1; //gan lai  hien thi trang hien tai
	pageHidden.value = 1; //gan lai gia tri bien hidden
	
	const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API}?tenThuongHieu=${searchText}`;

	$.get(url, function (data, status) {
		console.log(data)
		$("#tableThuongHieu").html("");
		for (var i = 0; i < data.length; i++) {
			$("#tableThuongHieu").append(
				`<tr>
				<td>${ i+1 }</td>
				<td>${ data[i].id }</td>
				<td><c:if test="${data[i].hinhAnhBase64 != null}">
						<img src="data:image/jpg;base64,${data[i].hinhAnhBase64}"
							width="120" height="80" />
					</c:if></td>
				<td>${ data[i].tenThuongHieu }</td>
				<td><input type="button" class="btn btn-primary table__btn"
					value="Chi tiết"
					onclick="location.href='/WebsiteBanNhacCu/admin/thuong-hieu/chi-tiet-thuong-hieu?id=${ data[i].id }'">

					<input type="button" class="btn btn-warning table__btn"
					value="Sửa"
					onclick="location.href='/WebsiteBanNhacCu/admin/thuong-hieu/cap-nhat-thuong-hieu?id=${ data[i].id }'">

					<input type="button" class="btn btn-danger table__btn"
					value="Xóa"
					onclick="location.href='/WebsiteBanNhacCu/admin/thuong-hieu/xoa-thuong-hieu?id=${ data[i].id }'">

				</td>
			</tr>`
			);
		}
	});
}

$(".btnXoa").each(function (index) {

	$(this).click(function () {
		console.log("da nhan btnXoa")
		var cf = confirm("Bạn muốn xóa thương hiệu này ?");
		if (cf == true) {
			let id = $(".maThuongHieu").get(index).value;
			xoaSanPham(id);
		}
	});
});

xoaSanPham = (id) => {

	console.log(`http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/api/thuong-hieu/xoa?id=${id}`);
	$.ajax({
		url: apiFetch = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/api/thuong-hieu/xoa?id=${id}`,
		type: 'DELETE',
		success: function (result) {
			if(result == 1){
				
				var pageHidden = document.getElementById("pageValue");//gia tri hiden
				var viewPage = document.getElementById("viewPage");//gia tri hien thi trang hien tai
				viewPage.value = 1; //gan lai  hien thi trang hien tai
				pageHidden.value = 1; //gan lai gia tri bien hidden
				
				window.location.href = 'http://localhost:8080/WebsiteBanNhacCu/admin/thuong-hieu/danh-sach-thuong-hieu';
				
				toastr.success("Đã xóa thương hiệu");
			}else{
				
				toastr.error('Thương hiệu này không thể xóa');
			}
		},
	});
}


$("body").on("DOMSubtreeModified", "#tableThuongHieu", function () {
	$(".btnXoa").each(function (index) {
		$(this).click(function () {
			console.log("da nhan btnXoa")
			var cf = confirm("Bạn muốn xóa thương hiệu này ?");
			if (cf == true) {
				let id = $(".maThuongHieu").get(index).value;
				xoaSanPham(id);
			}
		});
	});
});