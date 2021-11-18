package com.websitenhaccu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.websitenhaccu.entity.DongSanPham;
import com.websitenhaccu.repository.DongSanPhamRepository;
import com.websitenhaccu.service.DongSanPhamService;

@Service
public class DongSanPhamServiceImpl implements DongSanPhamService {

	@Autowired
	private DongSanPhamRepository dongSanPhamRepository;

	@Override
	public List<DongSanPham> getTatCaDongSanPham() {
		return dongSanPhamRepository.findAll();
	}

	@Override
	public List<DongSanPham> getDanhSachDongSanPhamBangTenDongSanPham(String tenDongSanPham) {
		List<DongSanPham> dongSanPhams = dongSanPhamRepository.findByTenDongSanPhamContaining(tenDongSanPham);
		return dongSanPhams;
	}

	@Override
	public void ThemDongSanPham(DongSanPham dongSanPham) {
		dongSanPhamRepository.save(dongSanPham);
	}

	@Override
	public void XoaDongSanPham(String maDongSanPham) {
		dongSanPhamRepository.deleteById(maDongSanPham);
	}

	@Override
	public void CapnhatDongSanPham(DongSanPham dongSanPham) {
		if (dongSanPham != null) {
			dongSanPhamRepository.save(dongSanPham);
		}
	}

	@Override
	public DongSanPham getDongSanPhamBangMa(String maDongSanPham) {
		DongSanPham dongSanPham = dongSanPhamRepository.findById(maDongSanPham).get();
		return dongSanPham;
	}

	@Override
	public List<DongSanPham> getDanhSachDongSanPhamTheoLoaiSanPhamVaThuongHieu(String maLoaiSanPham, String maThuongHieu) {
		return dongSanPhamRepository.findByLoaiSanPhamIdAndThuongHieuId(maLoaiSanPham, maThuongHieu);
	}

	@Override
	public List<DongSanPham> getDanhSachDongSanPhamTheoTenVaLoaiSanPhamVaThuongHieu(String tenDongSanPham,
			String maLoaiSanPham, String maThuongHieu, int page, int size) {

		Pageable firstPageWithTwoElements = PageRequest.of(page, size);
		return dongSanPhamRepository.findByTenDongSanPhamContainingAndLoaiSanPhamIdContainingAndThuongHieuIdContaining(tenDongSanPham, maLoaiSanPham, maThuongHieu, firstPageWithTwoElements);
	}

	@Override
	public DongSanPham getDongSanPham_DungTenLoaiSPThuongHieu(String tenDongSanPham, String maLoaiSanPham,
			String maThuongHieu) {
		return dongSanPhamRepository.findByTenDongSanPhamAndLoaiSanPhamIdAndThuongHieuId(tenDongSanPham, maLoaiSanPham, maThuongHieu);
	}

	@Override
	public DongSanPham getDongSanPhamBangIdLoaiSP(String idLoaiSanPham) {
		return dongSanPhamRepository.findFirstByLoaiSanPhamId(idLoaiSanPham);
	}

	@Override
	public List<DongSanPham> getDongSanPhamBangIdThuongHieu(String idThuongHieu) {
		return dongSanPhamRepository.findByThuongHieuId(idThuongHieu);
	}

}
