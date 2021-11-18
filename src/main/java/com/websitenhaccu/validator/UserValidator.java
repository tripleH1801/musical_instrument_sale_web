package com.websitenhaccu.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.websitenhaccu.dto.NguoiDungDTO;
import com.websitenhaccu.repository.NguoiDungRepository;

@Component
public class UserValidator implements Validator {

	@Autowired
	NguoiDungRepository nguoidung;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return NguoiDungDTO.class.isAssignableFrom(clazz);
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

		NguoiDungDTO userDTO = (NguoiDungDTO) target;

		if (userDTO.getFullName() == null || userDTO.getFullName().trim().length() == 0) {
			errors.rejectValue("fullName", null, "Tên không được bỏ trống");

		}

		// số điện thoại không được bỏ trống
		if (userDTO.getFullName() == null || userDTO.getPhone().trim().length() == 0) {
			errors.rejectValue("phone", null, "Số điện thoại không được bỏ trống");
		} else {

			// số điện thoại phải có 10 số
			if (!userDTO.getPhone().trim().matches("\\d{10}")) {
				errors.rejectValue("phone", null, "Số điện thoại không đúng định dạng");
			}

		}

		// email không được bỏ trống
		if (userDTO.getFullName() == null || userDTO.getEmail().trim().length() == 0) {
			errors.rejectValue("email", null, "Email không được bỏ trống");
		} else {

			// email phải đúng định dạng
			if (!userDTO.getEmail().trim().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
				errors.rejectValue("email", null, "Email không đúng định dạng");
			}
			
			else {
				if(nguoidung.existsByEmail(userDTO.getEmail())) {
					errors.rejectValue("email", null, "Email đã tồn tại");
				}
			}
		}

		// kiểm tra địa chỉ
//		if (userDTO.getFullName() == null || userDTO.getAddress().trim().length() == 0) {
//			errors.rejectValue("address", null, "Địa chỉ không được bỏ trống");
//		}

//		Kiểm tra mật khẩu
		if (userDTO.getFullName() == null || userDTO.getPassword().trim().length() == 0) {
			errors.rejectValue("password", null, "Mật khẩu không được để trống");
		} else if (userDTO.getFullName() == null || userDTO.getPasswordConf().trim().length() == 0) {
			errors.rejectValue("passwordConf", null, "Mật khẩu không được để trống");
		} else if (!userDTO.getPassword().equals(userDTO.getPasswordConf())) {
			errors.rejectValue("passwordConf", null, "Mật khẩu không khớp");
		}

	}

}
