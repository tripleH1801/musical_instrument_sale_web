package com.websitenhaccu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websitenhaccu.entity.ChiTietHoaDon;
import com.websitenhaccu.repository.ChiTietHoaDonRepository;
import com.websitenhaccu.service.ChiTietHoaDonService;

@Service
public class ChiTietHoaDonServiceImpl implements ChiTietHoaDonService {

	@Autowired
	ChiTietHoaDonRepository chiTietHoaDonRepository;

	@Override
	public List<ChiTietHoaDon> getChiTietHoaDonTheoMaHoaDon(String id) {

		return chiTietHoaDonRepository.findByHoaDonId(id);
	}

	@Override
	public void themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		chiTietHoaDonRepository.save(chiTietHoaDon);
	}

	@Override
	public void xoaChiTietHoaDon(String maHoaDon) {
		chiTietHoaDonRepository.deleteByHoaDonId(maHoaDon);
	}

	@Override
	public ChiTietHoaDon getChiTietHoaDonByMaSanPham(String maSanPham) {
		return chiTietHoaDonRepository.findFirstByMauSanPhamSanPhamId(maSanPham);
	}

	@Override
	public List<ChiTietHoaDon> getChiTietHoaDonTheoMaSanPham(String id) {
		return chiTietHoaDonRepository.findByMauSanPhamSanPhamId(id);
	}

	@Override
	public List<ChiTietHoaDon> getChiTietHoaDonTheoMauSanPham(String idSanPham, int idMau) {
		return chiTietHoaDonRepository.findByMauSanPhamSanPhamIdAndMauSanPhamMauId(idSanPham, idMau);
	}

}
