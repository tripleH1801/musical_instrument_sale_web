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

import com.websitenhaccu.entity.Mau;
import com.websitenhaccu.service.MauService;
import com.websitenhaccu.validator.MauValidator;

@Controller
@RequestMapping("/admin/mau")
public class MauCotroller {
	@Autowired
	private MauService mauService;

	@Autowired
	private MauValidator mauValidator;

	@GetMapping("/danh-sach-mau")
	public ModelAndView getTatcaMau() {
		List<Mau> danhSachMau = mauService.getTatCamau();
		return new ModelAndView("admin/mau/Mau", "listMau", danhSachMau);
	}

	@GetMapping("/chi-tiet-mau")
	public ModelAndView getChitietMau(int id) {

		Mau mau = mauService.getMauTheoId(id);

		return new ModelAndView("admin/mau/ChiTietMau", "mau", mau);
	}

	@GetMapping("/them-mau")
	public String ThemMau(Model model) {
		Mau mau = new Mau();
		model.addAttribute("formTitle", "Thêm màu");
		model.addAttribute("formButton", "Thêm");
		model.addAttribute("mau", mau);
		return "admin/mau/FormMau";
	}

	@PostMapping("/them-mau")
	public String ThemMau(@ModelAttribute("mau") Mau mau, BindingResult bindingResult, Model model) {
		mauValidator.validate(mau, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("formTitle", "Thêm màu");
			model.addAttribute("formButton", "Thêm");
			return "admin/mau/FormMau";
		}

		mauService.themMau(mau);

		return "redirect:/admin/mau/danh-sach-mau";
	}

	@GetMapping(value = "/xoa-mau")
	public String xoaMau(@RequestParam("id") int id) {

		mauService.xoaMau(id);

		return "redirect:/admin/mau/danh-sach-mau";
	}

	@GetMapping("/cap-nhat-mau")
	public String CapNhatMau(@RequestParam("id") int id, Model model) {
		Mau mau = mauService.getMauTheoId(id);

		model.addAttribute("formTitle", "Cập nhật màu");
		model.addAttribute("formButton", "Cập nhật");
		model.addAttribute("mau", mau);

		return "admin/mau/FormMau";
	}

	@PostMapping("/cap-nhat-mau")
	public String CapNhatMau(@ModelAttribute("mau") Mau mau, BindingResult bindingResult, Model model) {
		mauValidator.validate(mau, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("formTitle", "Cập nhật màu");
			model.addAttribute("formButton", "Cập nhật");
			return "admin/mau/FormMau";
		}
		mauService.capNhatMau(mau);
		return "redirect:/admin/mau/danh-sach-mau";
	}

}
