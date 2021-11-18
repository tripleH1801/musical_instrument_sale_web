package com.websitenhaccu.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.websitenhaccu.entity.HoaDon;
import com.websitenhaccu.repository.HoaDonRepository;
import com.websitenhaccu.service.HoaDonService;
import com.websitenhaccu.util.Constant;

@Service
public class HoaDonServiceImpl implements HoaDonService {

	@Autowired
	HoaDonRepository hoaDonRepository;

	@Override
	public List<HoaDon> getTatCaHoaDons() {
		return hoaDonRepository.findAll(Sort.by(Sort.Direction.DESC, "ngayLapHoaDon"));
//		@SuppressWarnings("unchecked")
//		List<HoaDon> hoaDons = (List<HoaDon>) hoaDonRepository.findAll(PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "ngayLapHoaDon")));
//		return hoaDons;
	}

	@Override
	public HoaDon getHoaDonTheoId(String id) {
		return hoaDonRepository.findById(id).get();
	}

	@Override
	public HoaDon themHoaDon(HoaDon hoaDon) {
		return hoaDonRepository.save(hoaDon);
	}

	@Override
	public void xoaHoaDon(String id) {
		hoaDonRepository.deleteById(id);

	}

	@Override
	public void capNhatHoaDon(String maHoaDon, int trangThai) {
		HoaDon hoaDon = hoaDonRepository.findById(maHoaDon).get();
		String trangThaiStr = null;
		switch (trangThai) {
		case 1:
			trangThaiStr = Constant.DANG_CHO_XU_LY;
			break;
		case 2:
			trangThaiStr = Constant.DA_TIEP_NHAN;
			break;
		case 3:
			trangThaiStr = Constant.DANG_DONG_GOI;
			break;
		case 4:
			trangThaiStr = Constant.BAN_GIAO_VAN_CHUYEN;
			break;
		case 5:
			trangThaiStr = Constant.GIAO_THANH_CONG;
			break;
		case 6:
			trangThaiStr = Constant.DA_HUY;
			break;

		default:
			trangThaiStr = Constant.DANG_CHO_XU_LY;
			break;
		}
		hoaDon.setTrangThai(trangThaiStr);

		hoaDonRepository.save(hoaDon);
	}

	public HoaDon getHoaDonByNguoiDungId(String idNguoiDung) {
		return hoaDonRepository.getHoaDonByNguoiDungId(idNguoiDung);
	}

	@Override
	public List<HoaDon> getDanhSachTheoNgayTrangThai(String ngay, String trangThai, int page, int size) {
		return hoaDonRepository.findByNgayLapHoaDonAndTrangThaiContaining(Date.valueOf(ngay), trangThai, PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "ngayLapHoaDon")));
	}

	@Override
	public List<HoaDon> getDanhSachTheoTrangThai(String trangThai, int page, int size) {
		return hoaDonRepository.findByTrangThaiContaining(trangThai, PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "ngayLapHoaDon")));
	}
		
	public List<HoaDon> getHoaDonTheoNguoiDung(String id) {
		return hoaDonRepository.findByNguoiDungId(id, Sort.by(Sort.Direction.DESC, "ngayLapHoaDon"));
	}

}
