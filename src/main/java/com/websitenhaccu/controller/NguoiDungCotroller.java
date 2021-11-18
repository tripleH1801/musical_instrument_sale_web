package com.websitenhaccu.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.websitenhaccu.converter.NguoiDungConverter;
import com.websitenhaccu.dto.NguoiDungDTO;
import com.websitenhaccu.dto.ThuongHieuDTO;
import com.websitenhaccu.entity.DongSanPham;
import com.websitenhaccu.entity.LoaiSanPham;
import com.websitenhaccu.entity.NguoiDung;
import com.websitenhaccu.service.DongSanPhamService;
import com.websitenhaccu.service.LoaiSanPhamService;
import com.websitenhaccu.service.NguoiDungService;
import com.websitenhaccu.util.CustomUserDetails;

@Controller
@RequestMapping("/tai-khoan")
public class NguoiDungCotroller {

	@Autowired
	private NguoiDungService nguoiDungService;

	@Autowired
	private LoaiSanPhamService LoaiSanPhamService;

	@Autowired
	private DongSanPhamService dongSanPhamService;

	@Autowired
	private NguoiDungConverter nguoiDungConverter;

	@GetMapping("/thong-tin-tai-khoan")
	private String chiTietNguoiDung(Model model) {

		Object pricipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email;
		if (pricipal instanceof CustomUserDetails) {
			email = ((CustomUserDetails) pricipal).getUsername();
		} else {
			email = pricipal.toString();
		}

		NguoiDung nguoiDung = nguoiDungService.getNguoiDungTheoEmail(email);
		NguoiDungDTO user = nguoiDungConverter.toNguoiDungDTO(nguoiDung);

		List<DongSanPham> dongSanPhams = dongSanPhamService.getTatCaDongSanPham();

		Map<LoaiSanPham, Set<ThuongHieuDTO>> map = LoaiSanPhamService.getMapLoaiThuongHieu();
		model.addAttribute("map", map);
		model.addAttribute("dongSanPhams", dongSanPhams);

		model.addAttribute("user", user);

		return "/user/ThongTinTaiKhoan";
	}

	@PostMapping("/thong-tin-tai-khoan")
	private String capNhatThongTinNguoiDung(@ModelAttribute("user") NguoiDungDTO nguoiDungDTO) {

		NguoiDung nguoiDung = nguoiDungConverter.toUpdateUser(nguoiDungDTO);
		nguoiDungService.capNhatNguoiDung(nguoiDung);
		return "redirect:/tai-khoan/thong-tin-tai-khoan";
	}

}
