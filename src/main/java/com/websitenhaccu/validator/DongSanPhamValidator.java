package com.websitenhaccu.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.websitenhaccu.entity.DongSanPham;
import com.websitenhaccu.service.DongSanPhamService;

@Component
public class DongSanPhamValidator implements Validator {

	@Autowired
	private DongSanPhamService dongSanPhamService;

	@Override
	public boolean supports(Class<?> clazz) {
		return DongSanPham.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		if (!supports(target.getClass())) {
			return;
		}

		DongSanPham dongSanPham = (DongSanPham) target;
		DongSanPham dsp = dongSanPhamService.getDongSanPham_DungTenLoaiSPThuongHieu(dongSanPham.getTenDongSanPham(),
				dongSanPham.getLoaiSanPham().getId(), dongSanPham.getThuongHieu().getId());
		
		if (dongSanPham.getTenDongSanPham() == null || dongSanPham.getTenDongSanPham().trim() == "") {
			errors.rejectValue("tenDongSanPham", null, "Tên dòng sản phẩm không được bỏ trống");
		} else if (dsp != null && !dsp.getId().equals(dongSanPham.getId())) {
			errors.rejectValue("tenDongSanPham", null, "Dòng sản phẩm này đã tồn tại");
		}
		if (String.valueOf(dongSanPham.getThue()).trim().length() == 0) {
			errors.rejectValue("thue", null, "Thuế không được bỏ trống");
		} else if (!String.valueOf(dongSanPham.getThue()).trim().matches("^\\d{1,2}([.,]\\d{1,3})*")) {
			errors.rejectValue("thue", null, "Thuế không đúng định dạng");
		}
		
	}

}
