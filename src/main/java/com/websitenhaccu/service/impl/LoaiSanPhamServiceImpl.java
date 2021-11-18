package com.websitenhaccu.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.websitenhaccu.dto.ThuongHieuDTO;
import com.websitenhaccu.entity.DongSanPham;
import com.websitenhaccu.entity.LoaiSanPham;
import com.websitenhaccu.repository.LoaiSanPhamRepository;
import com.websitenhaccu.service.DongSanPhamService;
import com.websitenhaccu.service.LoaiSanPhamService;
import com.websitenhaccu.service.ThuongHieuService;

@Service
public class LoaiSanPhamServiceImpl implements LoaiSanPhamService {

	@Autowired
	private LoaiSanPhamRepository loaiSanPhamRepository;

	@Autowired
	private ThuongHieuService thuongHieuService;
	
	@Autowired
	private DongSanPhamService dongSanPhamService;

	@Override
	public List<LoaiSanPham> getTatCaLoaiSanPham() {
		return loaiSanPhamRepository.findAll();
	}

	@Override
	public LoaiSanPham getLoaiSanPhamBangTenLoaiSanPham(String tenLoaiSanPham) {
		LoaiSanPham loaiSanPham = loaiSanPhamRepository.findByTenLoaiSanPham(tenLoaiSanPham);
		return loaiSanPham;
	}

	@Override
	public void ThemLoaiSanPham(LoaiSanPham loaiSanPham) {
		loaiSanPhamRepository.save(loaiSanPham);
	}

	@Override
	public void XoaLoaiSanPham(String maLoaiSanPham) {
		loaiSanPhamRepository.deleteById(maLoaiSanPham);
	}

	@Override
	public void CapnhatLoaiSanPham(LoaiSanPham loaiSanPham) {
		if (loaiSanPham != null) {
			loaiSanPhamRepository.save(loaiSanPham);
		}
	}

	@Override
	public LoaiSanPham getLoaiSanPhamBangMa(String maLoaiSanPham) {
		LoaiSanPham loaiSanPham = loaiSanPhamRepository.findById(maLoaiSanPham).get();
		return loaiSanPham;
	}

	@Override
	public List<LoaiSanPham> getDanhSachLoaiSanPhamBangTenLoaiSanPham(String tenLoaiSanPham, int page, int size) {
		return loaiSanPhamRepository.findByTenLoaiSanPhamContaining(tenLoaiSanPham, PageRequest.of(page, size));
	}

	@Override
	public LoaiSanPham getLoaiSanPhamTheoTen(String tenLoaiSanPham) {
		return loaiSanPhamRepository.findByTenLoaiSanPham(tenLoaiSanPham);
	}

	@Override
	public Map<LoaiSanPham, Set<ThuongHieuDTO>> getMapLoaiThuongHieu() {
		Map<LoaiSanPham, Set<ThuongHieuDTO>> map = new HashMap<LoaiSanPham, Set<ThuongHieuDTO>>();
		List<LoaiSanPham> loaiSanPhams = loaiSanPhamRepository.findAll();
		List<ThuongHieuDTO> thuongHieuDTOs = thuongHieuService.getTatCaThuongHieuDTO();
		List<DongSanPham> dongSanPhams = dongSanPhamService.getTatCaDongSanPham();

		loaiSanPhams.forEach(loaiSanPham -> {
			String maLoai = loaiSanPham.getId();
			Set<ThuongHieuDTO> temp = new HashSet<ThuongHieuDTO>();

			dongSanPhams.forEach(dongSanPham -> {
				if (dongSanPham.getLoaiSanPham().getId().equals(maLoai)) {
					String maTH = dongSanPham.getThuongHieu().getId();

					thuongHieuDTOs.forEach(thuongHieu -> {
						if (thuongHieu.getId().equals(maTH)) {
							temp.add(thuongHieu);
						}
					});

				}
			});

			map.put(loaiSanPham, temp);
		});

		return map;
	}

}
