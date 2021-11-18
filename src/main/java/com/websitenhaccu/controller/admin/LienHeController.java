package com.websitenhaccu.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.websitenhaccu.converter.LienHeConverter;
import com.websitenhaccu.dto.LienHeDTO;
import com.websitenhaccu.entity.LienHe;
import com.websitenhaccu.service.LienHeService;
import com.websitenhaccu.validator.LienHeValidator;

/**
 * @author nhath
 *
 */
@Controller
@RequestMapping("/admin/thong-tin-cua-hang")
public class LienHeController {
	@Autowired
	private LienHeService lienHeService;

	@Autowired
	private LienHeValidator lienHeValidator;
	
	@Autowired
	private LienHeConverter lienHeConverter;

	
	@RequestMapping()
	public String hienThiThongTin(Model model) {
		
		LienHe lienHe = lienHeService.getLienHe();
		
		if(lienHe == null) {
			lienHe = new LienHe("Số 12, Nguyễn Văn Bảo, Phường 04, Quận Gò Vấp, Thành phố Hồ Chí Minh", "dhcn@iuh.edu.vn", "0123456789");
			lienHeService.themLienHe(lienHe);
		}
		
		LienHeDTO lienHeDTO = lienHeConverter.toLienHeDTO(lienHe);
		
		model.addAttribute( "lienHe", lienHe);
		model.addAttribute( "lienHeDTO", lienHeDTO);

		return "admin/lienhe/LienHe";
	}


	
	@PostMapping()
	public String capNhatThongTin(Model model, @ModelAttribute("lienHeDTO") LienHeDTO lienHeDTO,  BindingResult bindingResult) {
		
		LienHe lienHe = lienHeConverter.toLienHe(lienHeDTO);
		
		lienHeValidator.validate(lienHe, bindingResult);

		if (bindingResult.hasErrors()) {
			
			model.addAttribute("lienHeDTO", lienHeDTO);
			
			return "admin/lienhe/LienHe";
		}

		lienHeService.themLienHe(lienHe);

		return "redirect:/admin/thong-tin-cua-hang";
	}


}
