package com.websitenhaccu.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.websitenhaccu.util.MyGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "SanPhams")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sanPham_generator")
	@GenericGenerator(name = "sanPham_generator", strategy = "com.websitenhaccu.util.MyGenerator", parameters = {
			@Parameter(name = MyGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = MyGenerator.VALUE_PREFIX_PARAMETER, value = "SP"),
			@Parameter(name = MyGenerator.NUMBER_FORMAT_PARAMETER, value = "%06d") })
	@Column(name = "san_pham_id")
	private String id;

	@Column(name = "ten_san_pham", columnDefinition = "NVARCHAR(MAX)")
	private String tenSanPham;

	@Column(name = "mo_ta", columnDefinition = "NTEXT")
	private String moTa;

	@Column(name = "gia_nhap")
	private double giaNhap;

	@Column(name = "gia_ban")
	private double giaBan;

	@Column(name = "xuat_xu", columnDefinition = "NVARCHAR(MAX)")
	private String xuatXu;

	@Column(name = "trang_thai")
	private boolean trangThai;

	@Column(name = "bao_hanh")
	private int baoHanh;

	@Column(name = "nam_san_xuat")
	private int namSanXuat;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "nha_cung_cap_id")
	private NhaCungCap nhaCungCap;

	@OneToMany(mappedBy = "sanPham", fetch = FetchType.LAZY)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<BinhLuan> binhLuans;

//	@OneToMany(mappedBy = "sanPham")
//	@ToString.Exclude
//	@EqualsAndHashCode.Exclude
//	private List<ChiTietHoaDon> chiTietHoaDons;

//	@OneToMany(mappedBy = "sanPham", fetch = FetchType.LAZY)
//	@ToString.Exclude
//	@EqualsAndHashCode.Exclude
//	private List<GiamGia> giamGias;

	@OneToMany(mappedBy = "sanPham")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<MauSanPham> mauSanPhams;

	@ManyToOne
	@JoinColumn(name = "dong_san_pham_id")
	private DongSanPham dongSanPham;

	public SanPham(String id, String tenSanPham, String moTa, double giaNhap, double giaBan, String xuatXu,
			boolean trangThai, int baoHanh, int namSanXuat, NhaCungCap nhaCungCap, DongSanPham dongSanPham) {
		super();
		this.id = id;
		this.tenSanPham = tenSanPham;
		this.moTa = moTa;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.xuatXu = xuatXu;
		this.trangThai = trangThai;
		this.baoHanh = baoHanh;
		this.namSanXuat = namSanXuat;
		this.nhaCungCap = nhaCungCap;
		this.dongSanPham = dongSanPham;
	}
	
	

}
