package com.websitenhaccu.controller.admin;

import java.util.ArrayList;
import java.util.Arrays;
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

import com.websitenhaccu.dto.SanPhamDTO;
import com.websitenhaccu.entity.DongSanPham;
import com.websitenhaccu.entity.LoaiSanPham;
import com.websitenhaccu.entity.SanPham;
import com.websitenhaccu.entity.ThuongHieu;
import com.websitenhaccu.service.DongSanPhamService;
import com.websitenhaccu.service.LoaiSanPhamService;
import com.websitenhaccu.service.SanPhamService;
import com.websitenhaccu.service.ThuongHieuService;
import com.websitenhaccu.validator.DongSanPhamValidator;

@Controller
@RequestMapping("/admin/dong-san-pham")
public class DongSanPhamCotroller {
	@Autowired
	private DongSanPhamService dongSanPhamService;
	
	@Autowired
	private LoaiSanPhamService loaiSanPhamService;
	
	@Autowired
	private SanPhamService sanPhamService;
	
	@Autowired
	private ThuongHieuService thuongHieuService;

	@Autowired
	private DongSanPhamValidator dongSanPhamValidator;

	@GetMapping("/danh-sach-dong-san-pham")
	public String getTatcaDongSanPham(Model model) {
		List<DongSanPham> listDongSanPham = dongSanPhamService.getDanhSachDongSanPhamTheoTenVaLoaiSanPhamVaThuongHieu("", "", "", 0, 10);
		List<LoaiSanPham> listSanPham = loaiSanPhamService.getTatCaLoaiSanPham();
		List<ThuongHieu> listThuongHieu = thuongHieuService.getTatCaThuongHieu();

		model.addAttribute("listDongSanPham", listDongSanPham);
		model.addAttribute("listLoaiSanPham", listSanPham);
		model.addAttribute("listThuongHieu", listThuongHieu);
		
		return "admin/dongsanpham/DongSanPham";
	}

	@GetMapping("/chi-tiet-dong-san-pham")
	public ModelAndView getChitietDongSanPham(String id) {
		DongSanPham dongSanPham = dongSanPhamService.getDongSanPhamBangMa(id);
		return new ModelAndView("admin/dongsanpham/ChiTietDongSanPham", "dongSanPham", dongSanPham);
	}

	@GetMapping("/them-dong-san-pham")
	public String ThemDongSanPham(String id, Model model) {
		DongSanPham dongSanPham = new DongSanPham();
		
		List<LoaiSanPham> listSanPham = loaiSanPhamService.getTatCaLoaiSanPham();
		List<ThuongHieu> listThuongHieu = thuongHieuService.getTatCaThuongHieu();
		
		model.addAttribute("listLoaiSanPham", listSanPham);
		model.addAttribute("listThuongHieu", listThuongHieu);
		
		model.addAttribute("formTitle", "Thêm dòng sản phẩm");
		model.addAttribute("formButton", "Thêm");
		model.addAttribute("dongSanPham", dongSanPham);
		return "admin/dongsanpham/FormDongSanPham";
	}

	@PostMapping("/them-dong-san-pham")
	public String ThemDongSanPham(@ModelAttribute("dongSanPham") DongSanPham dongSanPham, BindingResult bindingResult, Model model, @RequestParam("thuongHieu") String idth, @RequestParam("loaiSanPham") String idlsp) {

		LoaiSanPham lsp = new LoaiSanPham(idlsp);
		ThuongHieu th = new ThuongHieu(idth);
		dongSanPham.setThuongHieu(th);
		dongSanPham.setLoaiSanPham(lsp);
		
		dongSanPhamValidator.validate(dongSanPham, bindingResult);
		if (bindingResult.hasErrors()) {

			List<LoaiSanPham> listSanPham = loaiSanPhamService.getTatCaLoaiSanPham();
			List<ThuongHieu> listThuongHieu = thuongHieuService.getTatCaThuongHieu();
			
			model.addAttribute("listLoaiSanPham", listSanPham);
			model.addAttribute("listThuongHieu", listThuongHieu);
			
			model.addAttribute("formTitle", "Thêm dòng sản phẩm");
			model.addAttribute("formButton", "Thêm");
			
			return "admin/dongsanpham/FormDongSanPham";
		}
		
		
		dongSanPhamService.ThemDongSanPham(dongSanPham);
		return "redirect:/admin/dong-san-pham/danh-sach-dong-san-pham";
	}

//	@GetMapping(value = "/xoa-dong-san-pham")
//	public String xoaDongSanPham(@RequestParam("id") String id) {
//		
//		List<SanPhamDTO> sanPhams = sanPhamService.timKiemSanPhamTheoNhieuDieuKien("", null, 0, 0,new ArrayList<String>(Arrays.asList(id)), null, null, 0, 10, 0);
//		dongSanPhamService.XoaDongSanPham(id);
//
//		return "redirect:/admin/dong-san-pham/danh-sach-dong-san-pham";
//	}

	@GetMapping("/cap-nhat-dong-san-pham")
	public String CapNhatDongSanPham(@RequestParam("id") String id, Model model) {
		DongSanPham dongSanPham = dongSanPhamService.getDongSanPhamBangMa(id);

		List<ThuongHieu> listThuongHieu = thuongHieuService.getTatCaThuongHieu();
		List<LoaiSanPham> listSanPham = loaiSanPhamService.getTatCaLoaiSanPham();
		
		model.addAttribute("listLoaiSanPham", listSanPham);
		model.addAttribute("listThuongHieu", listThuongHieu);
		
		model.addAttribute("formTitle", "Cập nhật loại sản phẩm");
		model.addAttribute("formButton", "Cập nhật");
		model.addAttribute("dongSanPham", dongSanPham);
		return "admin/dongsanpham/FormDongSanPham";
	}
	
	@PostMapping("/cap-nhat-dong-san-pham")
	public String CapNhatDongSanPham(@ModelAttribute("dongSanPham") DongSanPham dongSanPham, BindingResult bindingResult, Model model, @RequestParam("thuongHieu") String idth, @RequestParam("loaiSanPham") String idlsp) {

		ThuongHieu th = new ThuongHieu(idth);
		LoaiSanPham lsp = new LoaiSanPham(idlsp);
		dongSanPham.setThuongHieu(th);
		dongSanPham.setLoaiSanPham(lsp);
		
		dongSanPhamValidator.validate(dongSanPham, bindingResult);
		if (bindingResult.hasErrors()) {
			
			List<LoaiSanPham> listSanPham = loaiSanPhamService.getTatCaLoaiSanPham();
			List<ThuongHieu> listThuongHieu = thuongHieuService.getTatCaThuongHieu();
			
			model.addAttribute("listLoaiSanPham", listSanPham);
			model.addAttribute("listThuongHieu", listThuongHieu);
			
			return "admin/dongsanpham/FormDongSanPham";
		}
		
		dongSanPhamService.CapnhatDongSanPham(dongSanPham);
		return "redirect:/admin/dong-san-pham/danh-sach-dong-san-pham";
	}

}
