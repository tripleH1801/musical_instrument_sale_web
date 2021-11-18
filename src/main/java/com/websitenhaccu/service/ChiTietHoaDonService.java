package com.websitenhaccu.service;

import java.util.List;

import com.websitenhaccu.entity.ChiTietHoaDon;

public interface ChiTietHoaDonService {
	public List<ChiTietHoaDon> getChiTietHoaDonTheoMaHoaDon(String id);
	
	public List<ChiTietHoaDon> getChiTietHoaDonTheoMaSanPham(String id);
	
	public List<ChiTietHoaDon> getChiTietHoaDonTheoMauSanPham(String idSanPham, int idMau);

	public void themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon);
	
	public void xoaChiTietHoaDon(String maHoaDon);

	public ChiTietHoaDon getChiTietHoaDonByMaSanPham(String maSanPham);
}
