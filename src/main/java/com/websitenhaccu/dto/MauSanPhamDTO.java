package com.websitenhaccu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MauSanPhamDTO {
	private int maMau;
	
	private String tenMau;

	private String maSanPham;
	
	private String tenSanPham;

	private int soLuong;

	private String hinhAnhBase64;

	public MauSanPhamDTO(String maSanPham) {
		super();
		this.maSanPham = maSanPham;
	}
}
