package com.websitenhaccu.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.websitenhaccu.entity.LienHe;

@Component
public class LienHeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return LienHe.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		// kiểm tra object
		if (!supports(target.getClass())) {
			return;
		}

		LienHe lienHe = (LienHe) target;


		// số điện thoại không được bỏ trống
		if (lienHe.getSoDienThoai() == null || lienHe.getSoDienThoai().trim().length() == 0) {
			errors.rejectValue("soDienThoai", null, "Số điện thoại không được bỏ trống");
		} else {

			// số điện thoại phải có 10 số
			if (!lienHe.getSoDienThoai().trim().matches("\\d{10}")) {
				errors.rejectValue("soDienThoai", null, "Số điện thoại không đúng định dạng");
			}

		}

		// email không được bỏ trống
		if (lienHe.getEmail() == null || lienHe.getEmail().trim().length() == 0) {
			errors.rejectValue("email", null, "Email không được bỏ trống");
		} else {

			// email phải đúng định dạng
			if (!lienHe.getEmail().trim().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
				errors.rejectValue("email", null, "Email không đúng định dạng");
			}

		}

	}

}
