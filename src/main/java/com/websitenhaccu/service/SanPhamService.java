package com.websitenhaccu.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.websitenhaccu.dto.SanPhamDTO;
import com.websitenhaccu.entity.MauSanPham;
import com.websitenhaccu.entity.SanPham;

@Service
public interface SanPhamService {

	public List<SanPham> getTatCaSanPham();

	public void themSanPham(SanPham sanPham, MauSanPham mauSanPham);
//	public void themSanPham(SanPham sanPham);

	public boolean xoaSanPham(String id);

	public void capNhatSanPham(SanPham sanPham);

	public SanPham getSanPhamTheoID(String id);

	public SanPhamDTO getSanPhamDTOTheoID(String id);

	public List<SanPham> timKiemSanPham(String tenSanPham, String maLoaiSanPham, String xuatXu, String maThuongHieu,
			int page, int size);

	public List<SanPhamDTO> getDanhSachSanPhamTheoLoaiThuongHieuDong(String id, int page, int size);

	public List<SanPham> getDanhSachSanPhamTheoNhaCungCap(String id);

	public List<SanPhamDTO> getDanhSachSanPhamTheoLoaiThuongHieu(String maLoaiSanPham, String maThuongHieu, int page,
			int size);

	public List<SanPhamDTO> getTatCaSanPham(int page, int size);

	public List<SanPhamDTO> danhSachSanPhamBanChay(int page, int size);

	public Set<String> getDanhSachXuatXu();

	public List<SanPhamDTO> timKiemSanPhamTheoNhieuDieuKien(String tenSanPham, List<String> xuatXus, double giaDau,
			double giaCuoi, List<String> listDongSanPhamId, List<String> listThuongHieuId,
			List<String> listLoaiSanPhamId, int page, int size, int sort);
}
