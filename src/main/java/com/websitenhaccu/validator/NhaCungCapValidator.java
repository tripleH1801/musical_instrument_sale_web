package com.websitenhaccu.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.websitenhaccu.entity.NhaCungCap;

@Component
public class NhaCungCapValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return NhaCungCap.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
//		final String NOTNULL = "notNull";
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", NOTNULL);
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", NOTNULL);
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", NOTNULL);
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", NOTNULL);
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", NOTNULL);
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConf", NOTNULL);

		// kiểm tra object
		if (!supports(target.getClass())) {
			return;
		}

		NhaCungCap nhaCungCap = (NhaCungCap) target;

		if (nhaCungCap.getTenNhaCungCap() == null || nhaCungCap.getTenNhaCungCap().trim().length() == 0) {
			errors.rejectValue("tenNhaCungCap", null, "Tên nhà cung cấp không được bỏ trống");

		}

		// số điện thoại không được bỏ trống
		if (nhaCungCap.getSoDienThoai() == null || nhaCungCap.getSoDienThoai().trim().length() == 0) {
			errors.rejectValue("soDienThoai", null, "Số điện thoại không được bỏ trống");
		} else {

			// số điện thoại phải có 10 số
			if (!nhaCungCap.getSoDienThoai().trim().matches("\\d{10}")) {
				errors.rejectValue("soDienThoai", null, "Số điện thoại không đúng định dạng");
			}

		}

		// email không được bỏ trống
		if (nhaCungCap.getEmail() == null || nhaCungCap.getEmail().trim().length() == 0) {
			errors.rejectValue("email", null, "Email không được bỏ trống");
		} else {

			// email phải đúng định dạng
			if (!nhaCungCap.getEmail().trim().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
				errors.rejectValue("email", null, "Email không đúng định dạng");
			}

		}

	}

}
