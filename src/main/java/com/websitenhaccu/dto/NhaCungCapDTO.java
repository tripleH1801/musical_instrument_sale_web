package com.websitenhaccu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NhaCungCapDTO {

	private String maNhaCungCap;

	private String tenNhaCungCap;

	private String soDienThoai;

	private String email;

	private String website;

	private String tinhThanhPho;

	private String quanHuyen;

	private String phuongXa;

	private String diaChi;
	
	

	public NhaCungCapDTO(String tenNhaCungCap, String soDienThoai, String email, String website, String tinhThanhPho,
			String quanHuyen, String phuongXa, String diaChi) {
		super();
		this.tenNhaCungCap = tenNhaCungCap;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.website = website;
		this.tinhThanhPho = tinhThanhPho;
		this.quanHuyen = quanHuyen;
		this.phuongXa = phuongXa;
		this.diaChi = diaChi;
	}

	public NhaCungCapDTO() {
		super();
		this.tinhThanhPho ="";
		this.quanHuyen = "";
		this.phuongXa = "";
		this.diaChi = "";
	}
	
}
