package com.websitenhaccu.controller.admin;

import java.util.ArrayList;
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

import com.websitenhaccu.converter.NguoiDungConverter;
import com.websitenhaccu.dto.NguoiDungDTO;
import com.websitenhaccu.entity.NguoiDung;
import com.websitenhaccu.service.HoaDonService;
import com.websitenhaccu.service.NguoiDungService;
import com.websitenhaccu.validator.CapNhatNguoiDungValidator;

@Controller
@RequestMapping("/admin/nguoi-dung")
public class NguoiDungAdminCotroller {
	
	@Autowired
	private NguoiDungService nguoiDungService;
	
	@Autowired
	private NguoiDungConverter nguoiDungConverter;
	
	@Autowired
	private HoaDonService hoaDonService;
	
	@Autowired
	private CapNhatNguoiDungValidator capNhatNguoiDungValidator;
	
	@GetMapping("/danh-sach-nguoi-dung")
	private String getAllKhachHang(Model model) {
		List<NguoiDungDTO> nguoiDungDTOs = new ArrayList<NguoiDungDTO>();
		List<NguoiDung> nguoiDungs = nguoiDungService.timKiemNguoiDung("", "", "", 0, 10);
		nguoiDungs.forEach(nd ->{
			NguoiDungDTO nguoiDungDTO = nguoiDungConverter.toNguoiDungDTO(nd);
			nguoiDungDTOs.add(nguoiDungDTO);
		});
		
		model.addAttribute("listKhachHang", nguoiDungDTOs);
		model.addAttribute("page", 0);
		return "admin/nguoidung/nguoidung";
	}
	
	@GetMapping("/chi-tiet-nguoi-dung")
	private String chiTietNguoiDung(Model model, @RequestParam("id") String id) {
		NguoiDung nguoiDung = nguoiDungService.getNguoiDungById(id);

		int soLuongHoaDon = hoaDonService.getHoaDonTheoNguoiDung(nguoiDung.getId()).size();
		
		model.addAttribute("nguoiDung", nguoiDung);
		model.addAttribute("soLuongHoaDon", soLuongHoaDon);

		return "/admin/nguoidung/ChiTietNguoiDung";
	}
	
	@GetMapping("/cap-nhat-nguoi-dung")
	private String FormCapNhatNguoiDung(Model model, @RequestParam("id") String id) {
		
		NguoiDung nguoiDung = nguoiDungService.getNguoiDungById(id);
		
		NguoiDungDTO nguoiDungDTO = nguoiDungConverter.toNguoiDungDTO(nguoiDung);

		model.addAttribute("user", nguoiDungDTO);
		if(nguoiDung.isTrangThai() == true)
			model.addAttribute("trangThai", 1);
		else 
			model.addAttribute("trangThai", 0);
		
		return "/admin/nguoidung/capnhatnguoidung";
	}
	
	@PostMapping("/cap-nhat-nguoi-dung")
	private String capNhatThongTinNguoiDung(@ModelAttribute("user") NguoiDungDTO nguoiDungDTO, @RequestParam("trangThai") String trangThai, BindingResult bindingResult, Model model) {
		
		capNhatNguoiDungValidator.validate(nguoiDungDTO, bindingResult);
		if (bindingResult.hasErrors()) {
			NguoiDung nguoiDung = nguoiDungService.getNguoiDungById(nguoiDungDTO.getUserId());

			model.addAttribute("user", nguoiDungDTO);
			if(nguoiDung.isTrangThai() == true)
				model.addAttribute("trangThai", 1);
			else 
				model.addAttribute("trangThai", 0);
			return "/admin/nguoidung/capnhatnguoidung";
		}
		
		NguoiDung nguoiDung = nguoiDungConverter.toUpdateUser(nguoiDungDTO);
		nguoiDung.setTrangThai(trangThai.equals("1") ? true : false);
		
		nguoiDungService.capNhatNguoiDung(nguoiDung);
		
		return "redirect:/admin/nguoi-dung/danh-sach-nguoi-dung";
	}
}
