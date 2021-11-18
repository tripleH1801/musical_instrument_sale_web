package com.websitenhaccu.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.websitenhaccu.dto.DongSanPhamDTO;
import com.websitenhaccu.dto.SanPhamDTO;
import com.websitenhaccu.entity.DongSanPham;
import com.websitenhaccu.service.DongSanPhamService;
import com.websitenhaccu.service.SanPhamService;

@RestController
@RequestMapping("/api/dong-san-pham")
public class DongSanPhamRestController {

	@Autowired
	private DongSanPhamService dongSanPhamService;
	@Autowired
	private SanPhamService sanPhamService;

	@GetMapping("/id")
	public ResponseEntity<DongSanPhamDTO> getDongSanPhamTheoMa(@RequestParam("maDongSanPham") String maDongSanPham) {
		DongSanPham dongSanPham = dongSanPhamService.getDongSanPhamBangMa(maDongSanPham);
		DongSanPhamDTO dongSanPhamDTO = new DongSanPhamDTO(dongSanPham.getId(), dongSanPham.getThuongHieu().getId(),
				dongSanPham.getLoaiSanPham().getId(), dongSanPham.getTenDongSanPham(), dongSanPham.getThue());
		return ResponseEntity.ok(dongSanPhamDTO);
	}

	/**
	 * chi tim bang ten
	 */
	@GetMapping("/danh-sach-maloaisanpham-mathuonghieu") // ko có bị lỗi do tìm ra 2 mapping có tham số string
	public List<DongSanPhamDTO> getDanhSachDongSanPhamTheoLoaiSanPhamVaThuongHieu(
			@RequestParam("maLoaiSanPham") String maLoaiSanPham, @RequestParam("maThuongHieu") String maThuongHieu) {
		List<DongSanPhamDTO> listDongSanPhamDTOs = new ArrayList<DongSanPhamDTO>();
		List<DongSanPham> listDongSanPhams = dongSanPhamService
				.getDanhSachDongSanPhamTheoLoaiSanPhamVaThuongHieu(maLoaiSanPham, maThuongHieu);
		for (DongSanPham d : listDongSanPhams) {
			DongSanPhamDTO d1 = new DongSanPhamDTO(d.getId(), d.getThuongHieu().getId(), d.getLoaiSanPham().getId(),
					d.getTenDongSanPham(), d.getThue());
			listDongSanPhamDTOs.add(d1);
		}
		return listDongSanPhamDTOs;
	}

	@GetMapping("/danh-sach") // ko có bị lỗi do tìm ra 2 mapping có tham số string
	public List<DongSanPhamDTO> getDanhSachDongSanPhamTheoLoaiSanPhamVaThuongHieu(
			@RequestParam("tenDongSanPham") String tenDongSanPham, @RequestParam("maLoaiSanPham") String maLoaiSanPham,
			@RequestParam("maThuongHieu") String maThuongHieu,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size) { // doi size thanh 20
		List<DongSanPhamDTO> listDongSanPhamDTOs = new ArrayList<DongSanPhamDTO>();
		List<DongSanPham> listDongSanPhams = dongSanPhamService.getDanhSachDongSanPhamTheoTenVaLoaiSanPhamVaThuongHieu(
				tenDongSanPham, maLoaiSanPham, maThuongHieu, page, size);
		for (DongSanPham d : listDongSanPhams) {
			DongSanPhamDTO d1 = new DongSanPhamDTO(d.getId(), d.getThuongHieu().getTenThuongHieu(),
					d.getLoaiSanPham().getTenLoaiSanPham(), d.getTenDongSanPham(), d.getThue());
			listDongSanPhamDTOs.add(d1);
		}
		return listDongSanPhamDTOs;
	}
	@DeleteMapping("/xoa")
	public int deleteLoaiSanPham(@RequestParam("id") String id) {
		List<SanPhamDTO> sanPhams = sanPhamService.timKiemSanPhamTheoNhieuDieuKien("", null, 0, 0,new ArrayList<String>(Arrays.asList(id)), null, null, 0, 10, 0);
		if(sanPhams.size() > 0)
			return -1;
		dongSanPhamService.XoaDongSanPham(id);
		return 1;
	}
}
