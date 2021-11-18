package com.websitenhaccu.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HoaDonDTO {

	private String id;

	private Date ngayLapHD;

	private String diaChiGiaoHang;

	private String trangThai;

	private NguoiDungDTO nguoiDung;

	private List<ChiTietHoaDonDTO> chiTietHoaDonDTOs;
	
	private double tongTien;

	public HoaDonDTO() {
		super();
		this.chiTietHoaDonDTOs = new ArrayList<ChiTietHoaDonDTO>();
	}
	
	public HoaDonDTO(String id, Date ngayLapHD, String diaChiGiaoHang, String trangThai, NguoiDungDTO nguoiDung,
			List<ChiTietHoaDonDTO> chiTietHoaDonDTOs) {
		super();
		this.id = id;
		this.ngayLapHD = ngayLapHD;
		this.diaChiGiaoHang = diaChiGiaoHang;
		this.trangThai = trangThai;
		this.nguoiDung = nguoiDung;
	}

	public boolean themChiTietHoaDonDTO(MauSanPhamDTO mauSanPhamDTO) {
		if(mauSanPhamDTO.getSoLuong() == 0)
			return false;
		
		for (ChiTietHoaDonDTO chiTietHoaDon : chiTietHoaDonDTOs) {
			// nếu đã có trong giỏ hàng
			if (chiTietHoaDon.getMauSanPhamDTO().equals(mauSanPhamDTO)) {

				if (chiTietHoaDon.getSoLuong() >= mauSanPhamDTO.getSoLuong())
					return false;

				chiTietHoaDon.setSoLuong(chiTietHoaDon.getSoLuong() + 1);
				return true;
			}

		}
		// chưa có trong giỏ hàng
		ChiTietHoaDonDTO chiTietHoaDonDTO = new ChiTietHoaDonDTO(this.id, mauSanPhamDTO, 1);
		chiTietHoaDonDTOs.add(chiTietHoaDonDTO);
		return true;
	}
	
	public boolean xoaChiTietHoaDon(MauSanPhamDTO mauSanPhamDTO) {
		int index = -1;
		for (ChiTietHoaDonDTO chiTietHoaDonDTO : chiTietHoaDonDTOs) {
			if (chiTietHoaDonDTO.getMauSanPhamDTO().equals(mauSanPhamDTO)) {
				index = chiTietHoaDonDTOs.indexOf(chiTietHoaDonDTO);
				break;
			}
		}
		if(index != -1) {
			chiTietHoaDonDTOs.remove(index);
			return true;
		}else {
			return false;
		}
		
	}



	



	
}
