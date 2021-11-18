package com.websitenhaccu.service;

import java.util.List;

import com.websitenhaccu.entity.HoaDon;

public interface HoaDonService {
	public List<HoaDon> getTatCaHoaDons();
	
	public List<HoaDon> getHoaDonTheoNguoiDung(String id);

	public HoaDon getHoaDonTheoId(String id);

	public HoaDon themHoaDon(HoaDon hoaDon);
	
	public void xoaHoaDon(String id);
	
	public void capNhatHoaDon(String maHoaDon, int trangThai);

	public HoaDon getHoaDonByNguoiDungId(String idNguoiDung);
	
	public List<HoaDon> getDanhSachTheoNgayTrangThai(String ngay, String trangThai, int page, int size);
	
	public List<HoaDon> getDanhSachTheoTrangThai(String trangThai, int page, int size);
}
