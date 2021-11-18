package com.websitenhaccu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietHoaDonDTO {

	private String maHoaDon;

	private MauSanPhamDTO mauSanPhamDTO;

	private int soLuong;

	private double giaBan;

	public ChiTietHoaDonDTO(String maHoaDon, MauSanPhamDTO mauSanPhamDTO, int soLuong) {
		super();
		this.maHoaDon = maHoaDon;
		this.mauSanPhamDTO = mauSanPhamDTO;
		this.soLuong = soLuong;
	}

	public double tinhTien() {
		return soLuong * giaBan;
	}

}
