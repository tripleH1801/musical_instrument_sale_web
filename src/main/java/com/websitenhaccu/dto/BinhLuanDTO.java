package com.websitenhaccu.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BinhLuanDTO {

	private String maNguoiDung;

	private String maSanPham;

	private Date ngayBinhLuan;

	private String noiDung;

	private int danhGia;

	public BinhLuanDTO(String maNguoiDung, String maSanPham, String noiDung, int danhGia) {
		super();
		this.maNguoiDung = maNguoiDung;
		this.maSanPham = maSanPham;
		this.noiDung = noiDung;
		this.danhGia = danhGia;
	}
	
}
