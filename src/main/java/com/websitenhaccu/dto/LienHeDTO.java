package com.websitenhaccu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor 
@NoArgsConstructor
public class LienHeDTO {
	
	private String id;
	
	private String email;
	
	private String soDienThoai;
	
	private String tinhThanhPho;

	private String quanHuyen;

	private String phuongXa;

	private String diaChi;

	public LienHeDTO(String email, String soDienThoai, String tinhThanhPho, String quanHuyen, String phuongXa,
			String diaChi) {
		super();
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.tinhThanhPho = tinhThanhPho;
		this.quanHuyen = quanHuyen;
		this.phuongXa = phuongXa;
		this.diaChi = diaChi;
	}

	
}
