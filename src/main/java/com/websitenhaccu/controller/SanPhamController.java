package com.websitenhaccu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.websitenhaccu.converter.SanPhamConverter;
import com.websitenhaccu.dto.MauSanPhamDTO;
import com.websitenhaccu.dto.NguoiDungDTO;
import com.websitenhaccu.dto.SanPhamDTO;
import com.websitenhaccu.dto.ThuongHieuDTO;
import com.websitenhaccu.entity.BinhLuan;
import com.websitenhaccu.entity.DongSanPham;
import com.websitenhaccu.entity.LoaiSanPham;
import com.websitenhaccu.entity.SanPham;
import com.websitenhaccu.entity.ThuongHieu;
import com.websitenhaccu.service.BinhLuanService;
import com.websitenhaccu.service.DongSanPhamService;
import com.websitenhaccu.service.LoaiSanPhamService;
import com.websitenhaccu.service.MauSanPhamService;
import com.websitenhaccu.service.NguoiDungService;
import com.websitenhaccu.service.SanPhamService;
import com.websitenhaccu.service.ThuongHieuService;
import com.websitenhaccu.util.CustomUserDetails;

@Controller
public class SanPhamController {
	@Autowired
	private NguoiDungService userService;

	@Autowired
	private LoaiSanPhamService LoaiSanPhamService;

	@Autowired
	private ThuongHieuService thuongHieuService;

	@Autowired
	private DongSanPhamService dongSanPhamService;
	@Autowired
	private BinhLuanService binhLuanService;

	@Autowired
	private SanPhamService sanPhamService;

	@Autowired
	private MauSanPhamService mauSanPhamService;

	@Autowired
	private SanPhamConverter sanPhamConverter;

	@GetMapping("/danh-sach-san-pham")
	public String hienThiTrangChu(Model model, @RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "size", defaultValue = "15") int size) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email;
		if (principal instanceof CustomUserDetails) {
			email = ((CustomUserDetails) principal).getUsername();
		} else {
			email = principal.toString();
		}

		NguoiDungDTO user = userService.getByEmail(email);
		List<LoaiSanPham> loaiSanPhams = LoaiSanPhamService.getTatCaLoaiSanPham();
		List<ThuongHieu> thuongHieus = thuongHieuService.getTatCaThuongHieu();
		List<DongSanPham> dongSanPhams = dongSanPhamService.getTatCaDongSanPham();
		List<SanPhamDTO> sanPhamDTOs;
		Set<String> xuatXus = sanPhamService.getDanhSachXuatXu();

		Map<LoaiSanPham, Set<ThuongHieuDTO>> map = LoaiSanPhamService.getMapLoaiThuongHieu();

		sanPhamDTOs = sanPhamService.timKiemSanPhamTheoNhieuDieuKien("", null, 0, 0, null, null, null, page - 1, size,
				1);
		sanPhamDTOs.forEach(dto -> {
			xuatXus.add(dto.getXuatXu());
		});

		double maxpage = Math.ceil(sanPhamDTOs.size() / 15);

		model.addAttribute("maxpage", maxpage);
		model.addAttribute("pageTitle", "Danh sách sản phẩm");
		model.addAttribute("check_header", "header");
		model.addAttribute("user", user);
		model.addAttribute("map", map);
		model.addAttribute("loaiSanPhams", loaiSanPhams);
		model.addAttribute("thuongHieus", thuongHieus);
		model.addAttribute("dongSanPhams", dongSanPhams);
		model.addAttribute("xuatXus", xuatXus);
		model.addAttribute("sanPhamDTOs", sanPhamDTOs);
		model.addAttribute("xuatXus", xuatXus);
		return "user/DanhSachSanPham";
	}

	@GetMapping("/danh-sach-san-pham/{id}")
	public String hienThiTrangChu(Model model, @PathVariable("id") String id,
			@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "size", defaultValue = "15") int size) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email;
		if (principal instanceof CustomUserDetails) {
			email = ((CustomUserDetails) principal).getUsername();
		} else {
			email = principal.toString();
		}

		NguoiDungDTO user = userService.getByEmail(email);
		List<LoaiSanPham> loaiSanPhams = LoaiSanPhamService.getTatCaLoaiSanPham();
		List<ThuongHieu> thuongHieus = thuongHieuService.getTatCaThuongHieu();
		List<DongSanPham> dongSanPhams = dongSanPhamService.getTatCaDongSanPham();
		Map<LoaiSanPham, Set<ThuongHieuDTO>> map = LoaiSanPhamService.getMapLoaiThuongHieu();

		List<SanPhamDTO> sanPhamDTOs = new ArrayList<SanPhamDTO>();
		Set<String> xuatXus = sanPhamService.getDanhSachXuatXu();

		if (id.contains("LSP")) {

			sanPhamDTOs = sanPhamService.timKiemSanPhamTheoNhieuDieuKien("", null, 0, 0, null, null,
					new ArrayList<String>(Arrays.asList(id)), page - 1, size, 1);

		} else if (id.contains("TH")) {

			sanPhamDTOs = sanPhamService.timKiemSanPhamTheoNhieuDieuKien("", null, 0, 0, null,
					new ArrayList<String>(Arrays.asList(id)), null, page - 1, size, 1);

		} else if (id.contains("DSP")) {

			sanPhamDTOs = sanPhamService.timKiemSanPhamTheoNhieuDieuKien("", null, 0, 0,
					new ArrayList<String>(Arrays.asList(id)), null, null, page - 1, size, 1);

		}

		sanPhamDTOs.forEach(dto -> {
			xuatXus.add(dto.getXuatXu());
		});

		double maxpage = Math.ceil(sanPhamDTOs.size() / 15);

		model.addAttribute("maxpage", maxpage);
		model.addAttribute("pageTitle", "Danh sách sản phẩm");
		model.addAttribute("check_header", "header");
		model.addAttribute("user", user);
		model.addAttribute("map", map);
		model.addAttribute("loaiSanPhams", loaiSanPhams);
		model.addAttribute("thuongHieus", thuongHieus);
		model.addAttribute("dongSanPhams", dongSanPhams);
		model.addAttribute("xuatXus", xuatXus);
		model.addAttribute("sanPhamDTOs", sanPhamDTOs);
		model.addAttribute("xuatXus", xuatXus);
		return "user/DanhSachSanPham";
	}

	@GetMapping("/danh-sach-san-pham/{maLoaisanPham}/{maThuongHieu}")
	public String hienThiDanhSachSanPhamTheoThuongHieu(Model model, @PathVariable("maLoaisanPham") String maLoaisanPham,
			@PathVariable("maThuongHieu") String maThuongHieu,
			@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "size", defaultValue = "15") int size) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email;
		if (principal instanceof CustomUserDetails) {
			email = ((CustomUserDetails) principal).getUsername();
		} else {
			email = principal.toString();
		}

		NguoiDungDTO user = userService.getByEmail(email);
		List<LoaiSanPham> loaiSanPhams = LoaiSanPhamService.getTatCaLoaiSanPham();
		List<ThuongHieu> thuongHieus = thuongHieuService.getTatCaThuongHieu();
		List<DongSanPham> dongSanPhams = dongSanPhamService.getTatCaDongSanPham();
		List<SanPhamDTO> sanPhamDTOs;
		Set<String> xuatXus = sanPhamService.getDanhSachXuatXu();
		Map<LoaiSanPham, Set<ThuongHieuDTO>> map = LoaiSanPhamService.getMapLoaiThuongHieu();

		sanPhamDTOs = sanPhamService.timKiemSanPhamTheoNhieuDieuKien("", null, 0, 0, null,
				new ArrayList<String>(Arrays.asList(maThuongHieu)), new ArrayList<String>(Arrays.asList(maLoaisanPham)),
				page - 1, size, 1);
		sanPhamDTOs.forEach(dto -> {
			xuatXus.add(dto.getXuatXu());
		});

		double maxpage = Math.ceil(sanPhamDTOs.size() / 15);

		model.addAttribute("maxpage", maxpage);

		model.addAttribute("user", user);
		model.addAttribute("map", map);
		model.addAttribute("loaiSanPhams", loaiSanPhams);
		model.addAttribute("thuongHieus", thuongHieus);
		model.addAttribute("dongSanPhams", dongSanPhams);
		model.addAttribute("xuatXus", xuatXus);
		model.addAttribute("sanPhamDTOs", sanPhamDTOs);
		model.addAttribute("xuatXus", xuatXus);

		return "user/DanhSachSanPham";
	}

	@GetMapping("/san-pham")
	public String chiTietSanPham(Model model, @RequestParam("id") String id) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email;
		if (principal instanceof CustomUserDetails) {
			email = ((CustomUserDetails) principal).getUsername();
		} else {
			email = principal.toString();
		}

		NguoiDungDTO user = userService.getByEmail(email);

		model.addAttribute("user", user);

		SanPham sanPham = sanPhamService.getSanPhamTheoID(id);

		List<MauSanPhamDTO> mauSanPhamDTOs = mauSanPhamService.getMauSanPhamDTOTheoMaSanPham(id);

		SanPhamDTO sanPhamDTO = sanPhamConverter.toSanPhamDTO(sanPham);

		List<BinhLuan> binhLuans = binhLuanService.getBinhLuanTheoMaSanPham(id);

		List<DongSanPham> dongSanPhams = dongSanPhamService.getTatCaDongSanPham();

		Map<LoaiSanPham, Set<ThuongHieuDTO>> map = LoaiSanPhamService.getMapLoaiThuongHieu();

		model.addAttribute("map", map);

		model.addAttribute("pageTitle", "Chi tiết sản phẩm");
		model.addAttribute("sanPhamDTO", sanPhamDTO);
		model.addAttribute("dongSanPhams", dongSanPhams);
		model.addAttribute("mauSanPhamDTOs", mauSanPhamDTOs);
		model.addAttribute("binhLuans", binhLuans);

		return "user/ChiTietSanPham";
	}

	@GetMapping("/danh-sach-san-pham/tim-kiem-san-pham")
	public String timKiemTheoThem(Model model, @RequestParam("tenSanPham") String tenSanPham,
			@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "size", defaultValue = "15") int size) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email;
		if (principal instanceof CustomUserDetails) {
			email = ((CustomUserDetails) principal).getUsername();
		} else {
			email = principal.toString();
		}

		NguoiDungDTO user = userService.getByEmail(email);
		List<LoaiSanPham> loaiSanPhams = LoaiSanPhamService.getTatCaLoaiSanPham();
		List<ThuongHieu> thuongHieus = thuongHieuService.getTatCaThuongHieu();
		List<DongSanPham> dongSanPhams = dongSanPhamService.getTatCaDongSanPham();
		List<SanPhamDTO> sanPhamDTOs;
		Set<String> xuatXus = sanPhamService.getDanhSachXuatXu();
		Map<LoaiSanPham, Set<ThuongHieuDTO>> map = LoaiSanPhamService.getMapLoaiThuongHieu();

		sanPhamDTOs = sanPhamService.timKiemSanPhamTheoNhieuDieuKien(tenSanPham, null, 0, 0, null, null, null, page - 1,
				size, 1);
		sanPhamDTOs.forEach(dto -> {
			xuatXus.add(dto.getXuatXu());
		});

		double maxpage = Math.ceil(sanPhamDTOs.size() / 15);

		model.addAttribute("maxpage", maxpage);
		model.addAttribute("pageTitle", "Danh sách sản phẩm");
		model.addAttribute("check_header", "header");
		model.addAttribute("user", user);
		model.addAttribute("map", map);
		model.addAttribute("loaiSanPhams", loaiSanPhams);
		model.addAttribute("thuongHieus", thuongHieus);
		model.addAttribute("dongSanPhams", dongSanPhams);
		model.addAttribute("xuatXus", xuatXus);
		model.addAttribute("sanPhamDTOs", sanPhamDTOs);
		model.addAttribute("xuatXus", xuatXus);
		return "user/DanhSachSanPham";
	}
}
