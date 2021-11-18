package com.websitenhaccu.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.websitenhaccu.entity.ThuongHieu;
import com.websitenhaccu.service.ThuongHieuService;

@Component
public class ThuongHieuValidator implements Validator{
	
	@Autowired
	private ThuongHieuService thuongHieuService;

	@Override
	public boolean supports(Class<?> clazz) {
		return ThuongHieu.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		if(!supports(target.getClass())) {
			return;
		}
		
		ThuongHieu thuongHieu = (ThuongHieu) target;
		
		ThuongHieu th = thuongHieuService.getThuonghieuBangTenThuonghieu(thuongHieu.getTenThuongHieu());
		
		if(thuongHieu.getTenThuongHieu() == null || thuongHieu.getTenThuongHieu().trim().equals("")) {
			System.out.println("loi o ten");
			errors.rejectValue("tenThuongHieu", null, "Tên thương hiệu không được bỏ trống");
		}
		else if(th != null && !th.getId().equals(thuongHieu.getId())) {
			System.out.println("bi5 trung ten vi khac ma");
			errors.rejectValue("tenThuongHieu", null, "Tên thương hiệu này đã tồn tại");
		}
	}

}
