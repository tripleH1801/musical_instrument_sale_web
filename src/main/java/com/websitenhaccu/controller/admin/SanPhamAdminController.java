package com.websitenhaccu.controller.admin;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.websitenhaccu.converter.MauSanPhamConverter;
import com.websitenhaccu.converter.SanPhamConverter;
import com.websitenhaccu.dto.MauSanPhamDTO;
import com.websitenhaccu.dto.SanPhamDTO;
import com.websitenhaccu.entity.DongSanPham;
import com.websitenhaccu.entity.LoaiSanPham;
import com.websitenhaccu.entity.Mau;
import com.websitenhaccu.entity.MauSanPham;
import com.websitenhaccu.entity.NhaCungCap;
import com.websitenhaccu.entity.SanPham;
import com.websitenhaccu.entity.ThuongHieu;
import com.websitenhaccu.service.DongSanPhamService;
import com.websitenhaccu.service.LoaiSanPhamService;
import com.websitenhaccu.service.MauSanPhamService;
import com.websitenhaccu.service.MauService;
import com.websitenhaccu.service.NhaCungCapService;
import com.websitenhaccu.service.SanPhamService;
import com.websitenhaccu.service.ThuongHieuService;
import com.websitenhaccu.validator.SanPhamDTOValidator;

/**
 * @author nhath
 *
 */
@Controller
@RequestMapping("/admin/san-pham")
public class SanPhamAdminController {

	@Autowired
	private SanPhamService sanPhamService;

	@Autowired
	private NhaCungCapService nhaCungCapService;

	@Autowired
	private MauService mauService;

	@Autowired
	private LoaiSanPhamService loaiSanPhamService;

	@Autowired
	private ThuongHieuService thuongHieuService;

	@Autowired
	private DongSanPhamService dongSanPhamService;

	@Autowired
	private MauSanPhamService mauSanPhamService;

	@Autowired
	private SanPhamConverter sanPhamConverter;

	@Autowired
	private MauSanPhamConverter mauSanPhamConverter;

	@Autowired
	private SanPhamDTOValidator sanPhamDTOValidator;
	

	@RequestMapping("/danh-sach-san-pham")
	public String danhSachSanPham(Model model) throws IOException, SQLException {

		List<SanPham> sanPhams = sanPhamService.timKiemSanPham("", "", "", "", 0, 10);

		Set<String> listXuatXu = sanPhamService.getDanhSachXuatXu();

		List<SanPhamDTO> listSanPhamDTO = new ArrayList<>();

		for (SanPham sp : sanPhams) {
			List<MauSanPham> mauSanPhams = mauSanPhamService.getMauSanPhamTheoMaSanPham(sp.getId());
			int soLuong = 0;
			for (MauSanPham msp : mauSanPhams) {
				soLuong += msp.getSoLuong();
			}
			SanPhamDTO sanPhamDTO = sanPhamConverter.toSanPhamDTO_TrangSanPham(sp);
			sanPhamDTO.setTongSoLuong(soLuong);
			listSanPhamDTO.add(sanPhamDTO);
		}

		List<LoaiSanPham> loaiSanPhams = loaiSanPhamService.getTatCaLoaiSanPham();
		List<ThuongHieu> thuongHieus = thuongHieuService.getTatCaThuongHieu();

		model.addAttribute("page", 0);

		model.addAttribute("listSanPham", listSanPhamDTO);
		model.addAttribute("listXuatXu", listXuatXu);
		model.addAttribute("listThuongHieu", thuongHieus);
		model.addAttribute("listLoaiSanPham", loaiSanPhams);

		return "admin/sanpham/SanPham";
	}

	@RequestMapping(value = "/xem-chi-tiet")
	public String xemChiTietNhaCungCap(Model model, @RequestParam("id") String id) {

		SanPham sanPham = sanPhamService.getSanPhamTheoID(id);

		List<MauSanPhamDTO> mauSanPhamDTOs = new ArrayList<MauSanPhamDTO>();
		List<MauSanPham> mauSanPhams = mauSanPhamService.getMauSanPhamTheoMaSanPham(id);
		mauSanPhams.forEach(mauSanPham -> {
			mauSanPhamDTOs.add(mauSanPhamConverter.toMauSanPhamDTO(mauSanPham));
		});

		model.addAttribute("sanPham", sanPham);
		model.addAttribute("mauSanPhamDTOs", mauSanPhamDTOs);

		return "admin/sanpham/ChiTietSanPham";
	}

	@GetMapping(value = "/them-san-pham")
	public String hienThiTrangThemSanPham(Model model) {

		List<NhaCungCap> nhaCungCaps = nhaCungCapService.getTatCaNhaCungCap();
		List<LoaiSanPham> loaiSanPhams = loaiSanPhamService.getTatCaLoaiSanPham();
		List<ThuongHieu> thuongHieus = thuongHieuService.getTatCaThuongHieu();
		List<DongSanPham> dongSanPhams = dongSanPhamService.getTatCaDongSanPham();
		List<Mau> maus = mauService.getTatCamau();

		model.addAttribute("sanPhamDTO", new SanPhamDTO());
		model.addAttribute("nhaCungCaps", nhaCungCaps);
		model.addAttribute("loaiSanPhams", loaiSanPhams);
		model.addAttribute("thuongHieus", thuongHieus);
		model.addAttribute("dongSanPhams", dongSanPhams);
		model.addAttribute("maus", maus);

		model.addAttribute("formTitle", "Thêm sản phẩm");
		model.addAttribute("formButton", "Thêm");

		return "admin/sanpham/SanPhamForm";

	}

	@PostMapping(value = "/them-san-pham")
	public String themSanPham(Model model,@ModelAttribute("sanPhamDTO") SanPhamDTO sanPhamDTO,
			@RequestParam("maMau") int maMau, @RequestParam(value = "soLuong") String soLuong,
			@RequestParam("hinhAnh") MultipartFile multipartFile, BindingResult bindingResult) {
		
		int tongSoLuong = 0;
		if(!soLuong.equals(""))
			tongSoLuong = Integer.parseInt(soLuong);
	
		sanPhamDTO.setTongSoLuong(tongSoLuong);
		
		sanPhamDTOValidator.validate(sanPhamDTO, bindingResult);
		
		if (bindingResult.hasErrors()) {

			List<NhaCungCap> nhaCungCaps = nhaCungCapService.getTatCaNhaCungCap();
			List<LoaiSanPham> loaiSanPhams = loaiSanPhamService.getTatCaLoaiSanPham();
			List<ThuongHieu> thuongHieus = thuongHieuService.getTatCaThuongHieu();
			List<DongSanPham> dongSanPhams = dongSanPhamService.getTatCaDongSanPham();
			List<Mau> maus = mauService.getTatCamau();

			model.addAttribute("sanPhamDTO", sanPhamDTO);
			model.addAttribute("nhaCungCaps", nhaCungCaps);
			model.addAttribute("loaiSanPhams", loaiSanPhams);
			model.addAttribute("thuongHieus", thuongHieus);
			model.addAttribute("dongSanPhams", dongSanPhams);
			model.addAttribute("maus", maus);

			model.addAttribute("formTitle", "Thêm sản phẩm");
			model.addAttribute("formButton", "Thêm");

			return "admin/sanpham/SanPhamForm";
		}

		byte[] bytes;
		MauSanPham mauSanPham = null;
		try {

			bytes = multipartFile.getBytes();

			MauSanPhamDTO mauSanPhamDTO = new MauSanPhamDTO(maMau, null, null, sanPhamDTO.getTenSanPham(), tongSoLuong,
					null);

			mauSanPham = mauSanPhamConverter.toMauSanPham(mauSanPhamDTO, bytes);
			sanPhamDTO.setTrangThai(true);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SanPham sanPham = sanPhamConverter.toSanPham(sanPhamDTO);

		sanPhamService.themSanPham(sanPham, mauSanPham);

		return "redirect:/admin/san-pham/danh-sach-san-pham";

	}

	@GetMapping(value = "/cap-nhat-san-pham")
	public String hienThiTrangCapNhat(Model model, @RequestParam("id") String maSanPham) {

		SanPham sanPham = sanPhamService.getSanPhamTheoID(maSanPham);
		SanPhamDTO sanPhamDTO = sanPhamConverter.toSanPhamDTO(sanPham);

		List<NhaCungCap> nhaCungCaps = nhaCungCapService.getTatCaNhaCungCap();
		List<LoaiSanPham> loaiSanPhams = loaiSanPhamService.getTatCaLoaiSanPham();
		List<ThuongHieu> thuongHieus = thuongHieuService.getTatCaThuongHieu();
		List<DongSanPham> dongSanPhams = dongSanPhamService.getTatCaDongSanPham();

		model.addAttribute("sanPhamDTO", sanPhamDTO);
		model.addAttribute("nhaCungCaps", nhaCungCaps);
		model.addAttribute("loaiSanPhams", loaiSanPhams);
		model.addAttribute("thuongHieus", thuongHieus);
		model.addAttribute("dongSanPhams", dongSanPhams);
		model.addAttribute("formTitle", "Cập nhật Sản phẩm");
		model.addAttribute("formButton", "Lưu");

		return "admin/sanpham/SanPhamForm";

	}

	@PostMapping(value = "/cap-nhat-san-pham")
	public String capNhatSanPham(@ModelAttribute("sanPhamDTO") SanPhamDTO sanPhamDTO, BindingResult bindingResult, Model model) {

		sanPhamDTO.setTongSoLuong(1); //ko xoa
		sanPhamDTOValidator.validate(sanPhamDTO, bindingResult);

		if (bindingResult.hasErrors()) {

			List<NhaCungCap> nhaCungCaps = nhaCungCapService.getTatCaNhaCungCap();
			List<LoaiSanPham> loaiSanPhams = loaiSanPhamService.getTatCaLoaiSanPham();
			List<ThuongHieu> thuongHieus = thuongHieuService.getTatCaThuongHieu();
			List<DongSanPham> dongSanPhams = dongSanPhamService.getTatCaDongSanPham();

			model.addAttribute("sanPhamDTO", sanPhamDTO);
			model.addAttribute("nhaCungCaps", nhaCungCaps);
			model.addAttribute("loaiSanPhams", loaiSanPhams);
			model.addAttribute("thuongHieus", thuongHieus);
			model.addAttribute("dongSanPhams", dongSanPhams);
			model.addAttribute("formTitle", "Cập nhật Sản phẩm");
			model.addAttribute("formButton", "Lưu");

			return "admin/sanpham/SanPhamForm";
		}

		SanPham sanPham = sanPhamConverter.toSanPham(sanPhamDTO);
		String[] temp = sanPham.getId().split(",");
		sanPham.setId(temp[0]);
		sanPhamService.capNhatSanPham(sanPham);

		return "redirect:/admin/san-pham/danh-sach-san-pham";

	}

	@GetMapping(value = "/them-mau-san-pham")
	public String hienThiFormThemMauSanPham(Model model, @RequestParam("maSanPham") String maSanPham) {
		List<Mau> maus = mauService.getTatCamau();

		MauSanPhamDTO mauSanPhamDTO = new MauSanPhamDTO(maSanPham);
		model.addAttribute("mauSanPhamDTO", mauSanPhamDTO);
		model.addAttribute("maus", maus);
		model.addAttribute("formTitle", "Thêm màu sản phẩm");
		model.addAttribute("formButton", "Thêm");
		return "/admin/sanpham/MauSanPhamForm";

	}

	@PostMapping(value = "/them-mau-san-pham")
	public String themMauSanPham(@ModelAttribute("mauSanPhamDTO") MauSanPhamDTO mauSanPhamDTO,
			@RequestParam("hinhAnh") MultipartFile multipartFile) throws IOException {

		byte[] bytes = multipartFile.getBytes();
		MauSanPham mauSanPham = mauSanPhamConverter.toMauSanPham(mauSanPhamDTO, bytes);

		mauSanPhamService.themMauSanPham(mauSanPham);

		return "redirect:/admin/san-pham/xem-chi-tiet?id=" + mauSanPhamDTO.getMaSanPham();

	}

	@GetMapping(value = "/cap-nhat-mau-san-pham")
	public String hienThiFormCapNhatMauSanPham(Model model, @RequestParam("maSanPham") String maSanPham,
			@RequestParam("maMau") int maMau) throws SQLException {
		List<Mau> maus = mauService.getTatCamau();
		MauSanPham mauSanPham = mauSanPhamService.getMauSanPhamTheoMaSanPhamVaMaMau(maSanPham, maMau);

		MauSanPhamDTO mauSanPhamDTO = mauSanPhamConverter.toMauSanPhamDTO(mauSanPham);
		model.addAttribute("mauSanPhamDTO", mauSanPhamDTO);
		model.addAttribute("maus", maus);
		model.addAttribute("formTitle", "Cập nhật màu sản phẩm");
		model.addAttribute("formButton", "Lưu");
		return "/admin/sanpham/MauSanPhamForm";

	}

	@PostMapping(value = "/cap-nhat-mau-san-pham")
	public String capNhatMauSanPham(@ModelAttribute("mauSanPhamDTO") MauSanPhamDTO mauSanPhamDTO,
			@RequestParam("hinhAnh") MultipartFile multipartFile) throws IOException, SQLException {

		byte[] bytes = null;

		if (multipartFile.getSize() > 0) {
			bytes = multipartFile.getBytes();
		} else {
			MauSanPham temp = mauSanPhamService.getMauSanPhamTheoMaSanPhamVaMaMau(mauSanPhamDTO.getMaSanPham(),
					mauSanPhamDTO.getMaMau());
			if (temp != null) {
				Blob blob = temp.getHinhAnh();
				int blobLength = (int) blob.length();
				bytes = blob.getBytes(1, blobLength);
			}
		}
		MauSanPham mauSanPham = mauSanPhamConverter.toMauSanPham(mauSanPhamDTO, bytes);
		mauSanPhamService.capNhatMauSanPham(mauSanPham);

		return "redirect:/admin/san-pham/xem-chi-tiet?id=" + mauSanPhamDTO.getMaSanPham();

	}

}
