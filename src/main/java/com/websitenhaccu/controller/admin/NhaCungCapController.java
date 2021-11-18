package com.websitenhaccu.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.websitenhaccu.converter.NhaCungCapConverter;
import com.websitenhaccu.dto.NhaCungCapDTO;
import com.websitenhaccu.entity.NhaCungCap;
import com.websitenhaccu.service.NhaCungCapService;
import com.websitenhaccu.validator.NhaCungCapValidator;

/**
 * @author nhath
 *
 */
@Controller
@RequestMapping("/admin/nha-cung-cap")
public class NhaCungCapController {

	@Autowired
	private NhaCungCapService nhaCungCapService;

	@Autowired
	private NhaCungCapValidator nhaCungCapValidator;
	
	@Autowired
	private NhaCungCapConverter nhaCungCapConverter;

	/**
	 * xem danh sách nhà cung cấp
	 * 
	 * @return
	 */
	@RequestMapping("/danh-sach-nha-cung-cap")
	public ModelAndView getUser() {

		List<NhaCungCap> nhaCungCaps = nhaCungCapService.timKiemNhaCungCap("", 0, 10);

		return new ModelAndView("admin/nhacungcap/NhaCungCap", "listNhaCungCap", nhaCungCaps);
	}

	/**
	 * Xem thông tin chi tiết nhà cung cấp
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/xem-chi-tiet")
	public ModelAndView xemChiTietNhaCungCap(@RequestParam("id") String id) {

		NhaCungCap nhaCungCap = nhaCungCapService.getNhaCungCapTheoMaNCC(id);

		return new ModelAndView("admin/nhacungcap/ChiTietNhaCungCap", "nhaCungCap", nhaCungCap);
	}

	/**
	 * Hiển thi form cập nhật thông tin nhà cung cấp
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/cap-nhat-thong-tin-nha-cung-cap")
	public String capNhatThongTinNCCView(Model model, @RequestParam("id") String id) {

		
		NhaCungCap nhaCungCap = nhaCungCapService.getNhaCungCapTheoMaNCC(id);
		
		NhaCungCapDTO nhaCungCapDTO = nhaCungCapConverter.toNhaCungCapDTO(nhaCungCap);
		
		model.addAttribute("nhaCungCapDTO", nhaCungCapDTO);
		model.addAttribute("formTitle", "Cập nhật nhà cung cấp");
		model.addAttribute("formButton", "Lưu");
		
		return "admin/nhacungcap/NhaCungCapForm";
	}

	/**
	 * Cập nhật thông tin nhà cung cấp
	 * 
	 * @param model
	 * @param nhaCungCap
	 * @param bindingResult
	 * @return
	 */
	@PostMapping(value = "/cap-nhat-thong-tin-nha-cung-cap")
	public String capNhatThongTinNCC(Model model, @ModelAttribute("nhaCungCapDTO") NhaCungCapDTO nhaCungCapDTO,  BindingResult bindingResult) {
		
		NhaCungCap nhaCungCap = nhaCungCapConverter.toNhaCungCap(nhaCungCapDTO);
		
		nhaCungCapValidator.validate(nhaCungCap, bindingResult);

		if (bindingResult.hasErrors()) {
			
			model.addAttribute("nhaCungCapDTO", nhaCungCapDTO);
			model.addAttribute("formTitle", "Cập nhật nhà cung cấp");
			model.addAttribute("formButton", "Lưu");
			
			return "admin/nhacungcap/NhaCungCapForm";
		}

		nhaCungCapService.themNhaCungCap(nhaCungCap);

		return "redirect:/admin/nha-cung-cap/danh-sach-nha-cung-cap";
	}

	/**
	 * Xóa nhà cung cấp
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/xoa-nha-cung-cap")
	public String xoaNhaCungCap(@RequestParam("id") String id) {

		nhaCungCapService.xoaNhaCungCap(id);

		return "redirect:/admin/nha-cung-cap/danh-sach-nha-cung-cap";
	}

	/**
	 * Hiển thi form thêm nhà cung cấp
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/them-nha-cung-cap")
	public String themNhaCungCap(Model model) {

		
		model.addAttribute("nhaCungCapDTO", new NhaCungCapDTO());
		
		model.addAttribute("formTitle", "Thêm nhà cung cấp");
		model.addAttribute("formButton", "Thêm");
		
		return "admin/nhacungcap/NhaCungCapForm";

	}

	
	/**
	 * Thêm nhà cung cấp
	 * 
	 * @param model
	 * @param nhaCungCap
	 * @param bindingResult
	 * @return
	 */
	@PostMapping(value = "/them-nha-cung-cap")
	public String themNhaCungCap(Model model, @ModelAttribute("nhaCungCapDTO") NhaCungCapDTO nhaCungCapDTO, BindingResult bindingResult) {
		
		NhaCungCap nhaCungCap = nhaCungCapConverter.toNhaCungCap(nhaCungCapDTO);
		
		nhaCungCapValidator.validate(nhaCungCap, bindingResult);

		if (bindingResult.hasErrors()) {
			
			model.addAttribute("nhaCungCap", nhaCungCap);
			model.addAttribute("formTitle", "Thêm nhà cung cấp");
			model.addAttribute("formButton", "Thêm");
			
			return "admin/nhacungcap/NhaCungCapForm";
		}

		nhaCungCapService.themNhaCungCap(nhaCungCap);
		
		return "redirect:/admin/nha-cung-cap/danh-sach-nha-cung-cap";

	}

}
