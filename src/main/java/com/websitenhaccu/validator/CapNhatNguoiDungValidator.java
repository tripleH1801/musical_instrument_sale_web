package com.websitenhaccu.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.websitenhaccu.dto.NguoiDungDTO;
import com.websitenhaccu.entity.NguoiDung;
import com.websitenhaccu.repository.NguoiDungRepository;
import com.websitenhaccu.service.NguoiDungService;

@Component
public class CapNhatNguoiDungValidator implements Validator {

	@Autowired
	NguoiDungRepository nguoidung;
	
	@Autowired
	private NguoiDungService nguoiDungService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return NguoiDungDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

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
				NguoiDung ndFind = nguoiDungService.getNguoiDungTheoEmail(userDTO.getEmail());
//				if(nguoidung.existsByEmail(userDTO.getEmail()) && ndFind.getId() != userDTO.getUserId()) {
//					System.out.println("id use dto truyen vao: "+ userDTO.getUserId()+" ------id ng dung trong database: "+ ndFind.getId());
//					errors.rejectValue("email", null, "Email đã tồn tại");
//				}
				if(ndFind != null && ndFind.getId() != userDTO.getUserId()) {
					System.out.println("id use dto truyen vao: "+ userDTO.getUserId()+" ------id ng dung trong database: "+ ndFind.getId());
					errors.rejectValue("email", null, "Email đã tồn tại");
				}
			}
		}

	}

}
