const HOST_NAME = window.location.hostname
const PAGE_PATH = window.location.pathname
const PORT = window.location.port
const CONTEXT_PATH = PAGE_PATH.split("/")[1]
const API = 'api/nha-cung-cap/danh-sach'

function typeSearch() {
    var searchText = document.getElementById("txtSearch").value;

    var pageHidden = document.getElementById("pageValue");//gia tri hiden
    var viewPage = document.getElementById("viewPage");//gia tri hien thi trang hien tai
    viewPage.value = 1; //gan lai  hien thi trang hien tai
    pageHidden.value = 1; //gan lai gia tri bien hidden

    const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API}?tenNhaCungCap=${searchText}&page=0`;

    $.get(url, function (data, status) {
        $("#tableNhaCungCap").html("");
        for (var i = 0; i < data.length; i++) {
            $("#tableNhaCungCap").append(
                `<tr>
                <td>${i + 1}</td>
                <td>${data[i].maNhaCungCap}</td>
                <td>${data[i].tenNhaCungCap}</td>
                <td>${data[i].soDienThoai}</td>
                <td><a href="${data[i].website}">${data[i].website}</a></td>
                <td>${data[i].diaChi}</td>
                <td>
                    <input type="button" class="btn btn-primary table__btn"
                    value="Chi tiết"
                    onclick="location.href='/${CONTEXT_PATH}/admin/nha-cung-cap/xem-chi-tiet?id=${data[i].maNhaCungCap}'">

                    <input type="button" class="btn btn-warning table__btn"
                    value="Sửa"
                    onclick="location.href='/${CONTEXT_PATH}/admin/nha-cung-cap/cap-nhat-thong-tin-nha-cung-cap?id=${data[i].maNhaCungCap}'">

                    <input type="button" class="btn btn-danger table__btn"
                    value="Xóa"
                    onclick="location.href='/${CONTEXT_PATH}/admin/nha-cung-cap/xoa-nha-cung-cap?id=${data[i].maNhaCungCap}'">

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


    const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API}?tenNhaCungCap=${searchText}&page=${page - 1}`;

    console.log(url)

    $.get(url, function (data, status) {

        if (data[0] != null) {
            console.log("data khac null")
            $("#tableNhaCungCap").html("");
            for (var i = 0; i < data.length; i++) {
                $("#tableNhaCungCap").append(
                    `<tr>
                    <td>${i + 1}</td>
                    <td>${data[i].maNhaCungCap}</td>
                    <td>${data[i].tenNhaCungCap}</td>
                    <td>${data[i].soDienThoai}</td>
                    <td><a href="${data[i].website}">${data[i].website}</a></td>
                    <td>${data[i].diaChi}</td>
                    <td>
                        <input type="button" class="btn btn-primary table__btn"
                        value="Chi tiết"
                        onclick="location.href='/${CONTEXT_PATH}/admin/nha-cung-cap/xem-chi-tiet?id=${data[i].maNhaCungCap}'">
    
                        <input type="button" class="btn btn-warning table__btn"
                        value="Sửa"
                        onclick="location.href='/${CONTEXT_PATH}/admin/nha-cung-cap/cap-nhat-thong-tin-nha-cung-cap?id=${data[i].maNhaCungCap}'">
    
                        <input type="button" class="btn btn-danger table__btn"
                        value="Xóa"
                        onclick="location.href='/${CONTEXT_PATH}/admin/nha-cung-cap/xoa-nha-cung-cap?id=${data[i].maNhaCungCap}'">
    
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

    const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API}?tenNhaCungCap=${searchText}&page=${page - 1}`;

    console.log(url)

    $.get(url, function (data, status) {

        if (data[0] != null) {
            console.log("data khac null")
            $("#tableNhaCungCap").html("");
            for (var i = 0; i < data.length; i++) {
                $("#tableNhaCungCap").append(
                    `<tr>
                    <td>${i + 1}</td>
                    <td>${data[i].maNhaCungCap}</td>
                    <td>${data[i].tenNhaCungCap}</td>
                    <td>${data[i].soDienThoai}</td>
                    <td><a href="${data[i].website}">${data[i].website}</a></td>
                    <td>${data[i].diaChi}</td>
                    <td>
                        <input type="button" class="btn btn-primary table__btn"
                        value="Chi tiết"
                        onclick="location.href='/${CONTEXT_PATH}/admin/nha-cung-cap/xem-chi-tiet?id=${data[i].maNhaCungCap}'">
    
                        <input type="button" class="btn btn-warning table__btn"
                        value="Sửa"
                        onclick="location.href='/${CONTEXT_PATH}/admin/nha-cung-cap/cap-nhat-thong-tin-nha-cung-cap?id=${data[i].maNhaCungCap}'">
    
                        <input type="button" class="btn btn-danger table__btn"
                        value="Xóa"
                        onclick="location.href='/${CONTEXT_PATH}/admin/nha-cung-cap/xoa-nha-cung-cap?id=${data[i].maNhaCungCap}'">
    
                    </td>
                </tr>`
                );
            }

            viewPage.value = page; //gan lai  hien thi trang hien tai
            pageHidden.value = page; //gan lai gia tri bien hidden
        }

    });

};

function xoa(id) {
	var cf = confirm("Bạn muốn xóa nhà cung cấp này ?");
	if (cf == true) {
		$.ajax({
			url: "http://localhost:8080/WebsiteBanNhacCu/api/nha-cung-cap/xoa?id=" + id ,
			type: 'DELETE',
			success: function (result) {
				if(result == 1){
					window.location.href = 'http://localhost:8080/WebsiteBanNhacCu/admin/nha-cung-cap/danh-sach-nha-cung-cap';
					toastr.success("Đã xóa nhà cung cấp");
				}else{
					
					toastr.error('Nhà cung cấp này không thể xóa');
				}
			}

		});
	}
}
