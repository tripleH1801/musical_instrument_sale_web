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

import com.websitenhaccu.entity.LoaiSanPham;
import com.websitenhaccu.service.LoaiSanPhamService;
import com.websitenhaccu.validator.LoaiSanPhamValidator;

@Controller
@RequestMapping("/admin/loai-san-pham")
public class LoaiSanPhamCotroller {
	@Autowired
	private LoaiSanPhamService loaiSanPhamService;

	@Autowired
	private LoaiSanPhamValidator loaiSanPhamValidator;

	@GetMapping("/danh-sach-loai-san-pham")
	public String getTatcaLoaiSanPham(Model model) {
		List<LoaiSanPham> danhsachLoaiSanPham = loaiSanPhamService.getDanhSachLoaiSanPhamBangTenLoaiSanPham("", 0 , 10);
		
		model.addAttribute("page", 0);
		model.addAttribute("listLoaiSanPham", danhsachLoaiSanPham);
		
		return "admin/loaisanpham/LoaiSanPham";
	}

	@GetMapping("/chi-tiet-loai-san-pham")
	public ModelAndView getChitietLoaiSanPham(String id) {
		LoaiSanPham loaiSanPham = loaiSanPhamService.getLoaiSanPhamBangMa(id);
		return new ModelAndView("admin/loaisanpham/ChiTietLoaiSanPham", "loaiSanPham", loaiSanPham);
	}

	@GetMapping("/them-loai-san-pham")
	public String ThemLoaiSanPham(String id, Model model) {
		LoaiSanPham loaiSanPham = new LoaiSanPham();
		model.addAttribute("formTitle", "Thêm loại sản phẩm");
		model.addAttribute("formButton", "Thêm");
		model.addAttribute("loaiSanPham", loaiSanPham);
		return "admin/loaisanpham/FormLoaiSanPham";
	}

	@PostMapping("/them-loai-san-pham")
	public String ThemLoaiSanPham(@ModelAttribute("loaiSanPham") LoaiSanPham loaiSanPham, BindingResult bindingResult, Model model) {
		loaiSanPhamValidator.validate(loaiSanPham, bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute("formTitle", "Thêm loại sản phẩm");
			model.addAttribute("formButton", "Thêm");
			return "admin/loaisanpham/FormLoaiSanPham";
		}
		loaiSanPhamService.ThemLoaiSanPham(loaiSanPham);
		return "redirect:/admin/loai-san-pham/danh-sach-loai-san-pham";
	}

	@GetMapping(value = "/xoa-loai-san-pham")
	public String xoaLoaiSanPham(@RequestParam("id") String id) {

		loaiSanPhamService.XoaLoaiSanPham(id);

		return "redirect:/admin/loai-san-pham/danh-sach-loai-san-pham";
	}

	@GetMapping("/cap-nhat-loai-san-pham")
	public String CapNhatLoaiSanPham(@RequestParam("id") String id, Model model) {
		LoaiSanPham loaiSanPham = loaiSanPhamService.getLoaiSanPhamBangMa(id);
		model.addAttribute("formTitle", "Cập nhật loại sản phẩm");
		model.addAttribute("formButton", "Cập nhật");
		model.addAttribute("loaiSanPham", loaiSanPham);
		return "admin/loaisanpham/FormLoaiSanPham";
	}

	@PostMapping("/cap-nhat-loai-san-pham")
	public String CapNhatLoaiSanPham(@ModelAttribute("loaiSanPham") LoaiSanPham loaiSanPham, BindingResult bindingResult, Model model) {
		loaiSanPhamValidator.validate(loaiSanPham, bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute("formTitle", "Cập nhật loại sản phẩm");
			model.addAttribute("formButton", "Cập nhật");
			model.addAttribute("loaiSanPham", loaiSanPham);
			return "admin/loaisanpham/FormLoaiSanPham";
		}
		loaiSanPhamService.CapnhatLoaiSanPham(loaiSanPham);
		return "redirect:/admin/loai-san-pham/danh-sach-loai-san-pham";
	}

}
