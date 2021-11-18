package com.websitenhaccu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.websitenhaccu.dto.ChiTietHoaDonDTO;
import com.websitenhaccu.dto.HoaDonDTO;
import com.websitenhaccu.dto.NguoiDungDTO;
import com.websitenhaccu.dto.SanPhamDTO;
import com.websitenhaccu.dto.ThuongHieuDTO;
import com.websitenhaccu.entity.DongSanPham;
import com.websitenhaccu.entity.LoaiSanPham;
import com.websitenhaccu.entity.NguoiDung;
import com.websitenhaccu.service.DongSanPhamService;
import com.websitenhaccu.service.LoaiSanPhamService;
import com.websitenhaccu.service.NguoiDungService;
import com.websitenhaccu.service.SanPhamService;
import com.websitenhaccu.util.CustomUserDetails;

@Controller
public class GioHangController {

	@Autowired
	NguoiDungService UserService;
	@Autowired
	SanPhamService sanPhamService;
	@Autowired
	private LoaiSanPhamService LoaiSanPhamService;

	@Autowired
	private DongSanPhamService dongSanPhamService;

	@GetMapping("/gio-hang")
	public String hienThiGioHang(Model model, HttpSession httpSession) {

		Object pricipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email;
		if (pricipal instanceof CustomUserDetails) {
			email = ((CustomUserDetails) pricipal).getUsername();
		} else {
			email = pricipal.toString();
		}

		NguoiDungDTO user = UserService.getByEmail(email);
		NguoiDung nguoiDung = UserService.getNguoiDungTheoEmail(email);

		HoaDonDTO hoaDonDTO = (HoaDonDTO) httpSession.getAttribute("hoaDonDTO");
		if (hoaDonDTO == null) {
			hoaDonDTO = new HoaDonDTO();
			if (nguoiDung != null) {

				hoaDonDTO.setDiaChiGiaoHang(nguoiDung.getDiaChi());
			}
			httpSession.setAttribute("hoaDonDTO", hoaDonDTO);
		}

		Map<ChiTietHoaDonDTO, SanPhamDTO> mapCTHD = new HashMap<ChiTietHoaDonDTO, SanPhamDTO>();
		hoaDonDTO.getChiTietHoaDonDTOs().forEach(cthd -> {
			String maSP = cthd.getMauSanPhamDTO().getMaSanPham();
			SanPhamDTO sanPhamDTO = sanPhamService.getSanPhamDTOTheoID(maSP);

			mapCTHD.put(cthd, sanPhamDTO);
		});

		List<DongSanPham> dongSanPhams = dongSanPhamService.getTatCaDongSanPham();

		Map<LoaiSanPham, Set<ThuongHieuDTO>> map = LoaiSanPhamService.getMapLoaiThuongHieu();
		
		model.addAttribute("map", map);
		model.addAttribute("dongSanPhams", dongSanPhams);
		model.addAttribute("mapCTHD", mapCTHD);
		model.addAttribute("pageTitle", "Giỏ hàng");
		model.addAttribute("user", user);

		return "user/GioHang";
	}

}
