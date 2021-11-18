package com.websitenhaccu.service;

import java.util.List;

import com.websitenhaccu.entity.DongSanPham;

public interface DongSanPhamService {
	public List<DongSanPham> getTatCaDongSanPham();

	public List<DongSanPham> getDanhSachDongSanPhamBangTenDongSanPham(String tenDongSanPham);

	public DongSanPham getDongSanPhamBangMa(String maDongSanPham);

	public void ThemDongSanPham(DongSanPham dongSanPham);

	public void XoaDongSanPham(String maDongSanPham);

	public void CapnhatDongSanPham(DongSanPham dongSanPham);

	public List<DongSanPham> getDanhSachDongSanPhamTheoLoaiSanPhamVaThuongHieu(String maLoaiSanPham,
			String maThuongHieu);

	public List<DongSanPham> getDanhSachDongSanPhamTheoTenVaLoaiSanPhamVaThuongHieu(String tenDongSanPham,
			String maLoaiSanPham, String maThuongHieu, int page, int size);
	
	public DongSanPham getDongSanPham_DungTenLoaiSPThuongHieu (String tenDongSanPham, String maLoaiSanPham, String maThuongHieu);
	
	public DongSanPham getDongSanPhamBangIdLoaiSP(String idLoaiSanPham);
	
	public List<DongSanPham> getDongSanPhamBangIdThuongHieu(String idThuongHieu);

}
