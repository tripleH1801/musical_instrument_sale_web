package com.websitenhaccu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.websitenhaccu.util.MyGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "NhaCungCaps")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NhaCungCap {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nhaCungCap_generator")
	@GenericGenerator(name = "nhaCungCap_generator", strategy = "com.websitenhaccu.util.MyGenerator", parameters = {
			@Parameter(name = MyGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = MyGenerator.VALUE_PREFIX_PARAMETER, value = "NCC"),
			@Parameter(name = MyGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	@Column(name = "nha_cung_cap_id")
	private String maNhaCungCap;

	@Column(name = "ten_nha_cung_cap", columnDefinition = "NVARCHAR(MAX)")
	private String tenNhaCungCap;

	@Column(name = "dia_chi", columnDefinition = "NVARCHAR(MAX)")
	private String diaChi;

	@Column(name = "so_dien_thoai")
	private String soDienThoai;

	@Column(name = "email")
	private String email;

	@Column(name = "website")
	private String website;

	public NhaCungCap(String tenNhaCungCap, String diaChi, String soDienThoai, String email, String website) {
		super();
		this.tenNhaCungCap = tenNhaCungCap;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.website = website;
	}

}
