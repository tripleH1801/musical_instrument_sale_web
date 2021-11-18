package com.websitenhaccu.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.websitenhaccu.dto.NguoiDungDTO;
import com.websitenhaccu.dto.ThuongHieuDTO;
import com.websitenhaccu.entity.DongSanPham;
import com.websitenhaccu.entity.LoaiSanPham;
import com.websitenhaccu.service.DongSanPhamService;
import com.websitenhaccu.service.LoaiSanPhamService;
import com.websitenhaccu.service.NguoiDungService;
import com.websitenhaccu.util.CustomUserDetails;

@Controller
public class Exeption403Controller {
	
	@Autowired
	private NguoiDungService userService;
	
	@Autowired
	private DongSanPhamService dongSanPhamService;
	
	@Autowired
	private LoaiSanPhamService LoaiSanPhamService;

	@GetMapping("/403")
	public String error403(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email;
		if (principal instanceof CustomUserDetails) {
			email = ((CustomUserDetails) principal).getUsername();
		} else {
			email = principal.toString();
		}

		NguoiDungDTO user = userService.getByEmail(email);
		List<DongSanPham> dongSanPhams = dongSanPhamService.getTatCaDongSanPham();
		Map<LoaiSanPham, Set<ThuongHieuDTO>> map = LoaiSanPhamService.getMapLoaiThuongHieu();

		model.addAttribute("map", map);
		model.addAttribute("dongSanPhams", dongSanPhams);
		model.addAttribute("user", user);
		return "common/error403";
	}
	@GetMapping("/error")
	public String error400(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email;
		if (principal instanceof CustomUserDetails) {
			email = ((CustomUserDetails) principal).getUsername();
		} else {
			email = principal.toString();
		}

		NguoiDungDTO user = userService.getByEmail(email);
		List<DongSanPham> dongSanPhams = dongSanPhamService.getTatCaDongSanPham();
		Map<LoaiSanPham, Set<ThuongHieuDTO>> map = LoaiSanPhamService.getMapLoaiThuongHieu();

		model.addAttribute("map", map);
		model.addAttribute("dongSanPhams", dongSanPhams);
		model.addAttribute("user", user);
		return "common/error400";
	}
}
