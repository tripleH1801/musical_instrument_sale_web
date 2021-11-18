const minus = $(".minus");
const add = $(".plus");
const count = $(".count");
const maxCount = $(".maxCount");
const alert = $(".alert");
const alert_block = $(".alert--block");
const totalPrice = $("#totalPrice");
const priceProduct = $(".price");
const checkBox = $(".form-check-input");
const idSanPham = $(".maSanPham");
const idMau = $(".maMau");
const deleteSP = $(".delete--sp");

console.log(checkBox)





calculateTotalPrice = () => {
    var price = 0;
    count.each(function (index) {
//        if (checkBox.get(index).checked === true) {
            // console.log($(this).val());
            let amountTemp = Number.parseInt($(this).val());
            let priceTemp = Number.parseInt(priceProduct.get(index).textContent.replaceAll(",", ""));
            let totalPriceTemp = amountTemp * priceTemp;
            price += totalPriceTemp;
//        }
    })

    totalPrice.html(price.toLocaleString(
    		  undefined, // leave undefined to use the visitor's browser 
              // locale or a string like 'en-US' to override it.
   { minimumFractionDigits: 0 }
 ));
}


checkBox.each(function (index) {
    $(this).change(function () {
        calculateTotalPrice();
    })
})



$(document).ready(function () {
    calculateTotalPrice();
});


add.each(function (index) {

    $(this).click(function () {
    	
    	let msp = idSanPham.get(index).value;
    	let mm = Number.parseInt(idMau.get(index).value);
    	
    	let apiFetch = "http://localhost:8080/WebsiteBanNhacCu/api/gio-hang/kiem-tra-so-luong-ton?maSanPham=" + msp + "&maMau=" + mm;
    	console.log(apiFetch);
    	
    	$.get(apiFetch, function (data, status) {
    			if (status === 'success') {
    				console.log(data);
    				maxCount.get(index).value = data;
    			}
    	});
    	
    	
        let currentVal = Number.parseInt(count.get(index).value);
        const max = Number.parseInt(maxCount.get(index).value);
        if (currentVal < max) {

            count.get(index).value = currentVal + 1;
            capNhatSoLuongChiTietHoaDon(msp, mm, currentVal + 1);

        } else {
            alert.show();
            clearAlert();
        }

//        if (checkBox.get(index).checked === true) {

            calculateTotalPrice();
//        }
    });
});

minus.each(function (index) {

    $(this).click(function () {
    	let msp = idSanPham.get(index).value;
    	let mm = Number.parseInt(idMau.get(index).value);
        let currentVal = Number.parseInt(count.get(index).value);
        const min = 1;
        if (currentVal > min) {
            count.get(index).value = currentVal - 1;
            capNhatSoLuongChiTietHoaDon(msp, mm, currentVal - 1);
            alert_block.css({ "display": "none" });

        }
//        if (checkBox.get(index).checked === true) {

            calculateTotalPrice();
//        }

    });
});
deleteSP.each(function (index) {
	
	$(this).click(function () {
		
		let msp = idSanPham.get(index).value;
    	let mm = Number.parseInt(idMau.get(index).value);
		xoaChiTietHoaDon(msp, mm);
		calculateTotalPrice();

		
	});
});


count.each(function (index) {
    $(this).blur(function () {
        let valueTemp = Number.parseInt($(this).val());
        console.log(isNaN(NaN));
        // nếu là số thì flase
        // là chuỗi thì true;
        // là nan thì true

        // console.log(isNaN()  === valueTemp);

        if (isNaN(valueTemp)) {

            // trường hợp này đúng
            $(this).val(1);
            let msp = idSanPham.get(index).value;
        	let mm = Number.parseInt(idMau.get(index).value);
            capNhatSoLuongChiTietHoaDon(msp, mm, 1);
            alert.show();
            clearAlert();
        }

        const max = Number.parseInt(maxCount.get(index).value);
        // console.log(max);
        if (valueTemp > 0 && valueTemp <= max) {
        	let msp = idSanPham.get(index).value;
        	let mm = Number.parseInt(idMau.get(index).value);
            capNhatSoLuongChiTietHoaDon(msp, mm, valueTemp);
            calculateTotalPrice();
            alert_block.css({ "display": "none" });
        } 
        if(valueTemp > max){
        	$(this).val(max);
        	let msp = idSanPham.get(index).value;
        	let mm = Number.parseInt(idMau.get(index).value);
            capNhatSoLuongChiTietHoaDon(msp, mm, max);
        	alert.show();
            clearAlert();
        }
        else {
        	$(this).val(1);
        	let msp = idSanPham.get(index).value;
        	let mm = Number.parseInt(idMau.get(index).value);
            capNhatSoLuongChiTietHoaDon(msp, mm, 1);
            alert.show();
            clearAlert()
        }

    })
})


function clearAlert() {
    setTimeout(function () {
        alert_block.css({ "display": "none" });

    }, 3000)

}
xoaChiTietHoaDon = (maSanPham, maMau) =>{
	
	$.ajax({
	    url: apiFetch = "http://localhost:8080/WebsiteBanNhacCu/api/gio-hang/xoa-gio-hang?maSanPham=" + maSanPham + "&maMau=" + maMau,
	    type: 'DELETE',
	    success: function(result) {
	    	
	    	window.location.href = "http://localhost:8080/WebsiteBanNhacCu/gio-hang";
	    	toastr.success("Đã xóa khỏi giỏ hàng");
	    },
	    error: function() {
			toastr.error('Không xóa được')
		},
	});
}

capNhatSoLuongChiTietHoaDon = (maSanPham, maMau, soLuong) =>{
	
	$.ajax({
		url: "http://localhost:8080/WebsiteBanNhacCu/api/gio-hang/cap-nhat-so-luong?maSanPham=" + maSanPham + "&maMau=" + maMau + "&soLuong=" + soLuong,
		type: 'GET',
	});
}






let amountCart = $("#amountCart");
let personel_info = $(".personel_info");

var currentAmountCart = amountCart.text();

if (currentAmountCart == 0) {
	personel_info.css({ "visibility": "hidden" })
}

amountCart.change(function() {
	let amount = amountCart.text();

	if (amount == 0) {
		personel_info.css({ "visibility": "hidden" })
	}



})

