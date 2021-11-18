package com.websitenhaccu.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.websitenhaccu.entity.SanPham;

@Component
public class SanPhamValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return SanPham.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		if(!supports(target.getClass())) {
			return;
		}
		
		SanPham sanPham = (SanPham) target;
		
		if(sanPham.getTenSanPham() == null) {
			errors.rejectValue("tenSanPham", null, "Tên sản phẩm không được bỏ trống");
		}

		if(String.valueOf(sanPham.getGiaBan()).trim().length() == 0) {
			errors.rejectValue("giaBan", null, "Giá bán sản phẩm không được bỏ trống");
		}

		if(String.valueOf(sanPham.getGiaNhap()).trim().length() == 0) {
			errors.rejectValue("giaNhap", null, "Giá nhập sản phẩm không được bỏ trống");
		}
	}

}
