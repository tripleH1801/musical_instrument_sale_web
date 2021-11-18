package com.websitenhaccu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.websitenhaccu.converter.ThuongHieuConverter;
import com.websitenhaccu.dto.ThuongHieuDTO;
import com.websitenhaccu.entity.ThuongHieu;
import com.websitenhaccu.repository.ThuongHieuRepository;
import com.websitenhaccu.service.ThuongHieuService;

@Service
public class ThuongHieuServiceImpl implements ThuongHieuService {

	@Autowired
	private ThuongHieuRepository thuonghieuRepository;
	@Autowired
	private ThuongHieuConverter thuongHieuConverter;

	@Override
	public List<ThuongHieu> getTatCaThuongHieu() {
		return thuonghieuRepository.findAll();
	}

	@Override
	public ThuongHieu getThuonghieuBangTenThuonghieu(String tenThuongHieu) {
		ThuongHieu thuonghieu = thuonghieuRepository.findByTenThuongHieu(tenThuongHieu);
		return thuonghieu;
	}

	@Override
	public void ThemThuonghieu(ThuongHieu thuongHieu) {
		thuonghieuRepository.save(thuongHieu);
	}

	@Override
	public boolean XoaThuonghieu(String maThuongHieu) {
		try {
			thuonghieuRepository.deleteById(maThuongHieu);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true;
	}

	@Override
	public void CapnhatThuonghieu(ThuongHieu thuongHieu) {
		if (thuongHieu != null) {
			if (thuongHieu.getHinhAnh() != null) {
				thuonghieuRepository.save(thuongHieu);
				return;
			} else {
				ThuongHieu thuongHieu2 = getThuonghieuBangMa(thuongHieu.getId());
				
				if (thuongHieu2.getHinhAnh() != null) {
					thuongHieu.setHinhAnh(thuongHieu2.getHinhAnh());
					thuonghieuRepository.save(thuongHieu);
				}
			}
			thuonghieuRepository.save(thuongHieu);
		}
	}

	@Override
	public ThuongHieu getThuonghieuBangMa(String maThuongHieu) {
		ThuongHieu thuonghieu = thuonghieuRepository.findById(maThuongHieu).get();
		return thuonghieu;
	}

	@Override
	public List<ThuongHieu> getDanhSachThuongHieuBangTenThuongHieu(String tenThuongHieu, int page, int size) {
		return thuonghieuRepository.findByTenThuongHieuContaining(tenThuongHieu, PageRequest.of(page, size));
	}

	@Override
	public List<ThuongHieuDTO> getTatCaThuongHieuDTO() {

		List<ThuongHieu> thuongHieus = thuonghieuRepository.findAll();
		List<ThuongHieuDTO> thuongHieuDTOs = new ArrayList<ThuongHieuDTO>();
		thuongHieus.forEach(th -> {
			ThuongHieuDTO thuongHieuDTO = thuongHieuConverter.toThuongHieuDTO(th);
			thuongHieuDTOs.add(thuongHieuDTO);
		});

		return thuongHieuDTOs;
	}

}
