package com.websitenhaccu.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.websitenhaccu.dto.ChiTietHoaDonDTO;
import com.websitenhaccu.dto.MauSanPhamDTO;
import com.websitenhaccu.entity.ChiTietHoaDon;
import com.websitenhaccu.entity.HoaDon;
import com.websitenhaccu.entity.MauSanPham;
import com.websitenhaccu.service.HoaDonService;
import com.websitenhaccu.service.MauSanPhamService;

@Component
public class ChiTietHoaDonConverter {

	@Autowired
	private MauSanPhamService mauSanPhamService;
	@Autowired
	private HoaDonService hoaDonService;
	@Autowired
	private MauSanPhamConverter mauSanPhamConverter;

	public ChiTietHoaDon toChiTietHoaDon(ChiTietHoaDonDTO chiTietHoaDonDTO) {

		if (chiTietHoaDonDTO == null)
			return null;

		String maSanPham = chiTietHoaDonDTO.getMauSanPhamDTO().getMaSanPham();
		int maMau = chiTietHoaDonDTO.getMauSanPhamDTO().getMaMau();
		MauSanPham mauSanPham = mauSanPhamService.getMauSanPhamTheoMaSanPhamVaMaMau(maSanPham, maMau);

		String maHoaDon = chiTietHoaDonDTO.getMaHoaDon();
		HoaDon hoaDon = hoaDonService.getHoaDonTheoId(maHoaDon);

		int soLuong = chiTietHoaDonDTO.getSoLuong();

		ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(mauSanPham, hoaDon, soLuong);
		return chiTietHoaDon;
	}

	public ChiTietHoaDonDTO toChiTietHoaDonDTO(ChiTietHoaDon chiTietHoaDon) {

		if (chiTietHoaDon == null)
			return null;

		String maHoaDon = chiTietHoaDon.getHoaDon().getId();

		MauSanPhamDTO mauSanPhamDTO = mauSanPhamConverter.toMauSanPhamDTO(chiTietHoaDon.getMauSanPham());

		int soLuong = chiTietHoaDon.getSoLuong();
		double giaBan = chiTietHoaDon.getMauSanPham().getSanPham().getGiaBan();
		
//		ChiTietHoaDonDTO chiTietHoaDonDTO = new ChiTietHoaDonDTO(maHoaDon, mauSanPhamDTO, soLuong);
		ChiTietHoaDonDTO chiTietHoaDonDTO = new ChiTietHoaDonDTO(maHoaDon, mauSanPhamDTO, soLuong, giaBan);

		return chiTietHoaDonDTO;
	}
	
}
