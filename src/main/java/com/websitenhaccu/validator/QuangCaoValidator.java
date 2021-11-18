package com.websitenhaccu.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.websitenhaccu.dto.QuangCaoDTO;

@Component
public class QuangCaoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return QuangCaoDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		if (!supports(target.getClass())) {
			return;
		}

		QuangCaoDTO quangCaoDTO = (QuangCaoDTO) target;
		
		if(quangCaoDTO.getLink().trim().equals("")) {
			errors.rejectValue("link", null, "Link quảng cáo không được bỏ trống");
		}
		if(quangCaoDTO.getHinhAnhBase64() == null || quangCaoDTO.getHinhAnhBase64().trim().equals("")) {
			errors.rejectValue("hinhAnhBase64", null, "Cần chọn hình cho quảng cáo");
		}
	}

}
