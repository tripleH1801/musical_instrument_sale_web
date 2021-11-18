package com.websitenhaccu.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.websitenhaccu.entity.LoaiSanPham;
import com.websitenhaccu.service.LoaiSanPhamService;

@Component
public class LoaiSanPhamValidator implements Validator{

	@Autowired
	private LoaiSanPhamService loaiSanPhamService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return LoaiSanPham.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		if(!supports(target.getClass())) {
			return;
		}
		
		LoaiSanPham loaiSanPham = (LoaiSanPham) target;
		
		LoaiSanPham lspFInd = loaiSanPhamService.getLoaiSanPhamTheoTen(loaiSanPham.getTenLoaiSanPham());
		
		if(loaiSanPham.getTenLoaiSanPham().trim() == "") {
			errors.rejectValue("tenLoaiSanPham", null, "Tên loại sản phẩm không được bỏ trống");
		}
		else if(lspFInd != null && lspFInd.getId() != loaiSanPham.getId()) {
			errors.rejectValue("tenLoaiSanPham", null, "Tên loại sản phẩm đã tồn tại");
		}
	}

}
