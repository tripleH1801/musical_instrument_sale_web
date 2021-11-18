package com.websitenhaccu.converter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.websitenhaccu.dto.ChiTietHoaDonDTO;
import com.websitenhaccu.dto.HoaDonDTO;
import com.websitenhaccu.dto.NguoiDungDTO;
import com.websitenhaccu.entity.ChiTietHoaDon;
import com.websitenhaccu.entity.HoaDon;
import com.websitenhaccu.entity.NguoiDung;
import com.websitenhaccu.service.ChiTietHoaDonService;
import com.websitenhaccu.service.NguoiDungService;

@Component
public class HoaDonConverter {

	@Autowired
	private NguoiDungService nguoiDungService;

	@Autowired
	private ChiTietHoaDonService chiTietHoaDonService;
	@Autowired
	private NguoiDungConverter nguoiDungConverter;
	@Autowired
	private ChiTietHoaDonConverter chiTietHoaDonConverter;

	public HoaDon toHoaDon(HoaDonDTO hoaDonDTO) {

		if (hoaDonDTO == null)
			return null;

		String id = hoaDonDTO.getId();
		Date ngayLapHD = hoaDonDTO.getNgayLapHD();
		String diaChiGiaoHang = hoaDonDTO.getDiaChiGiaoHang();
		String trangThai = hoaDonDTO.getTrangThai();
		String email = hoaDonDTO.getNguoiDung().getEmail();
		NguoiDung nguoiDung = nguoiDungService.getNguoiDungTheoEmail(email);

		List<ChiTietHoaDon> chiTietHoaDons = new ArrayList<ChiTietHoaDon>();
		if (id != null) {
			chiTietHoaDonService.getChiTietHoaDonTheoMaHoaDon(id).forEach(sthd -> {
				chiTietHoaDons.add(sthd);
			});
		}

		HoaDon hoaDon = new HoaDon(id, ngayLapHD, diaChiGiaoHang, trangThai, nguoiDung, chiTietHoaDons);
		return hoaDon;
	}

	public HoaDonDTO toHoaDonDTO(HoaDon hoaDon) {

		if (hoaDon == null)
			return null;

		String id = hoaDon.getId();
		Date ngayLapHD = hoaDon.getNgayLapHoaDon();
		String diaChiGiaoHang = hoaDon.getDiaChiGiaoHang();
		String trangThai = hoaDon.getTrangThai();
		NguoiDungDTO nguoiDungDTO = nguoiDungConverter.toNguoiDungDTO(hoaDon.getNguoiDung());

		List<ChiTietHoaDonDTO> chiTietHoaDonDTOs = new ArrayList<ChiTietHoaDonDTO>();

		List<ChiTietHoaDon> chiTietHoaDons = chiTietHoaDonService.getChiTietHoaDonTheoMaHoaDon(id);
		
		chiTietHoaDons.forEach(cthd -> {
			chiTietHoaDonDTOs.add(chiTietHoaDonConverter.toChiTietHoaDonDTO(cthd));
		});
		
		hoaDon.setChiTietHoaDons(chiTietHoaDons);
		double tongTien = hoaDon.tinhTongTien();

		HoaDonDTO hoaDonDTO = new HoaDonDTO(id, ngayLapHD, diaChiGiaoHang, trangThai, nguoiDungDTO, chiTietHoaDonDTOs, tongTien);

		return hoaDonDTO;
	}
}
