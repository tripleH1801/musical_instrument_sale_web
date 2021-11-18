const HOST_NAME = window.location.hostname
const PAGE_PATH = window.location.pathname
const PORT = window.location.port
const CONTEXT_PATH = PAGE_PATH.split("/")[1]
const API = 'register/api/email/tim-kiem'


var trangThai = document.getElementById("trangThai").value;
if (trangThai != "") {
    alert(trangThai);
}

function searchType() {
    var searchText = document.getElementById("txtSearch").value.replaceAll(' ', '+');
    var txtSearchSdt = document.getElementById("txtSearchSdt").value.replaceAll(' ', '+');
    var txtSearchEmail = document.getElementById("txtSearchEmail").value.replaceAll(' ', '+');

    var pageHidden = document.getElementById("pageValue");//gia tri hiden
    var viewPage = document.getElementById("viewPage");//gia tri hien thi trang hien tai
    viewPage.value = 1; //gan lai  hien thi trang hien tai
    pageHidden.value = 1; //gan lai gia tri bien hidden

    const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API}?hoTen=${searchText}&soDienThoai=${txtSearchSdt}&email=${txtSearchEmail}&page=0`;

    $.get(url, function (data, status) {
        $("#tableNguoiDung").html("");
        for (var i = 0; i < data.length; i++) {
            var trangThaiND = 'Chưa xác minh';
            if(data[i].enabled == true)
                trangThaiND = 'Đã xác minh';
            $("#tableNguoiDung").append(
                `<tr>
                <td>${ i +1 }</td>
                <td>${ data[i].fullName }</td>
                <td>${ data[i].phone }</td>
                <td>${ data[i].email }</td>
                <td>${ data[i].tinhThanhPho }</td>
                <td>
                    ${trangThaiND}
                </td>
                <td><input type="button" class="btn btn-primary table__btn"
                    value="Chi tiết"
                    onclick="location.href='/${CONTEXT_PATH}/admin/nguoi-dung/chi-tiet-nguoi-dung?id=${ data[i].userId }'"/>

                    <input type="button" class="btn btn-warning table__btn"
                        value="Cập nhật"
                        onclick="location.href='/${CONTEXT_PATH}/admin/nguoi-dung/cap-nhat-nguoi-dung?id=${ data[i].userId }'">

                    <input type="button" class="btn btn-danger table__btn btnXoa" value="Xóa"/>

                    <input type="hidden" class="maNguoiDung" value="${ data[i].userId}" /></td>
            </tr>`
            );
        }
    });
}

document.getElementById("btnNext").onclick = function () {

    var searchText = document.getElementById("txtSearch").value.replaceAll(' ', '+');
    var txtSearchSdt = document.getElementById("txtSearchSdt").value.replaceAll(' ', '+');
    var txtSearchEmail = document.getElementById("txtSearchEmail").value.replaceAll(' ', '+');

    var pageHidden = document.getElementById("pageValue");//gia tri hiden
    var viewPage = document.getElementById("viewPage");//gia tri hien thi trang hien tai

    var page = Number.parseInt(pageHidden.value);//tang gia tri
    if (Number.parseInt(pageHidden.value) == 0) {
        page = page + 2;
    }
    else {
        page = page + 1;
    }

    const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API}?hoTen=${searchText}&soDienThoai=${txtSearchSdt}&email=${txtSearchEmail}&page=${page - 1}`;

    console.log(url)

    $.get(url, function (data, status) {

        if (data[0] != null) {
            console.log("data khac null")
            $("#tableNguoiDung").html("");
            for (var i = 0; i < data.length; i++) {
                var trangThaiND = 'Chưa xác minh';
                if(data[i].enabled == true)
                    trangThaiND = 'Đã xác minh';
                $("#tableNguoiDung").append(
                    `<tr>
                    <td>${ i +1 }</td>
                    <td>${ data[i].fullName }</td>
                    <td>${ data[i].phone }</td>
                    <td>${ data[i].email }</td>
                    <td>${ data[i].tinhThanhPho }</td>
                    <td>
                        ${trangThaiND}
                    </td>
                    <td><input type="button" class="btn btn-primary table__btn"
                        value="Chi tiết"
                        onclick="location.href='/${CONTEXT_PATH}/admin/nguoi-dung/chi-tiet-nguoi-dung?id=${ data[i].userId }'"/>
    
                        <input type="button" class="btn btn-warning table__btn"
                            value="Cập nhật"
                            onclick="location.href='/${CONTEXT_PATH}/admin/nguoi-dung/cap-nhat-nguoi-dung?id=${ data[i].userId }'">
    
                        <input type="button" class="btn btn-danger table__btn btnXoa" value="Xóa"/>
    
                        <input type="hidden" class="maNguoiDung" value="${ data[i].userId}" /></td>
                </tr>`
                );
            }

            viewPage.value = page; //gan lai  hien thi trang hien tai
            pageHidden.value = page; //gan lai gia tri bien hidden
        }

    });

};

document.getElementById("btnPreviusPage").onclick = function () {

    var searchText = document.getElementById("txtSearch").value.replaceAll(' ', '+');
    var txtSearchSdt = document.getElementById("txtSearchSdt").value.replaceAll(' ', '+');
    var txtSearchEmail = document.getElementById("txtSearchEmail").value.replaceAll(' ', '+');

    var pageHidden = document.getElementById("pageValue");//gia tri hiden
    var viewPage = document.getElementById("viewPage");//gia tri hien thi trang hien tai

    var page = Number.parseInt(pageHidden.value);//tang gia tri
    if (Number.parseInt(pageHidden.value) > 1) {
        page = page - 1;
    }

    const url = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/${API}?hoTen=${searchText}&soDienThoai=${txtSearchSdt}&email=${txtSearchEmail}&page=${page - 1}`;
    console.log(url);

    $.get(url, function (data, status) {

        if (data[0] != null) {
            $("#tableNguoiDung").html("");
            for (var i = 0; i < data.length; i++) {
                var trangThaiND = 'Chưa xác minh';
                if(data[i].enabled == true)
                    trangThaiND = 'Đã xác minh';
                $("#tableNguoiDung").append(
                    `<tr>
                    <td>${ i +1 }</td>
                    <td>${ data[i].fullName }</td>
                    <td>${ data[i].phone }</td>
                    <td>${ data[i].email }</td>
                    <td>${ data[i].tinhThanhPho }</td>
                    <td>
                        ${trangThaiND}
                    </td>
                    <td><input type="button" class="btn btn-primary table__btn"
                        value="Chi tiết"
                        onclick="location.href='/${CONTEXT_PATH}/admin/nguoi-dung/chi-tiet-nguoi-dung?id=${ data[i].userId }'"/>
    
                        <input type="button" class="btn btn-warning table__btn"
                            value="Cập nhật"
                            onclick="location.href='/${CONTEXT_PATH}/admin/nguoi-dung/cap-nhat-nguoi-dung?id=${ data[i].userId }'">
    
                        <input type="button" class="btn btn-danger table__btn btnXoa" value="Xóa"/>
    
                        <input type="hidden" class="maNguoiDung" value="${ data[i].userId}" /></td>
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
        var cf = confirm("Bạn muốn xóa người dùng này ?");
        if (cf == true) {
            let id = $(".maNguoiDung").get(index).value;
            xoaNguoiDung(id);
        }
    });
});

xoaNguoiDung = (id) => {

    $.ajax({
        url: apiFetch = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/register/api/email/xoa?id=` + id,
        type: 'DELETE',
        success: function (result) {
        	if(result == 1){
        		
	            window.location.href = `http://${HOST_NAME}:${PORT}/${CONTEXT_PATH}/admin/nguoi-dung/danh-sach-nguoi-dung`;
	            console.log("Đã xóa khách hàng");
	            toastr.success("Đã xóa khách hàng");
        	}else{
        		
        		console.log('Khách hàng này không thể xóa');
        		toastr.error('Khách hàng này không thể xóa');
        	}
        }
    });
}


$("body").on("DOMSubtreeModified", "#tableNguoiDung", function () {
	$(".btnXoa").each(function (index) {
        $(this).click(function () {
            console.log("da nhan btnXoa")
            var cf = confirm("Bạn muốn xóa người dùng này ?");
            if (cf == true) {
                let id = $(".maNguoiDung").get(index).value;
                xoaNguoiDung(id);
            }
        });
    });
});