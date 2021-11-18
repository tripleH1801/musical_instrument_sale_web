package com.websitenhaccu.dto;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public class SanPhamDTO {

	private String id;

	private String tenSanPham;

	private String moTa;

	@Setter(AccessLevel.NONE)
	private double giaNhap;

	@Setter(AccessLevel.NONE)
	private double giaBan;

	private String xuatXu;

	private boolean trangThai;

	@Setter(AccessLevel.NONE)
	private int baoHanh;

	@Setter(AccessLevel.NONE)
	private int namSanXuat;

	private String maNhaCungCap;
	
	private String tenNhaCungCap;

	private String maDongSanPham;
	
	private String tenDongSanPham;
	
	private String maLoaiSanPham;
	
	private String tenLoaiSanPham;
	
	private String maThuongHieu;
	
	private String tenThuongHieu;
	
	private String hinhAnhBase64;
	
	private List<MauSanPhamDTO> listMauSanPhamDTOs;
	
	private int tongSoLuong;
	
	
	
	public SanPhamDTO(String id, String tenSanPham, String moTa) {
		super();
		this.id = id;
		this.tenSanPham = tenSanPham;
		this.moTa = moTa;
	}

	public SanPhamDTO(String id, String tenSanPham, String xuatXu, String loaiSanPham, String thuongHieu) {
		super();
		this.id = id;
		this.tenSanPham = tenSanPham;
		this.xuatXu = xuatXu;
		this.maLoaiSanPham = loaiSanPham;
		this.maThuongHieu = thuongHieu;
	}

	
	public SanPhamDTO(String id, String tenSanPham, String moTa, double giaNhap, double giaBan, String xuatXu,
			boolean trangThai, int baoHanh, int namSanXuat, String maNhaCungCap, String tenNhaCungCap,
			String maDongSanPham, String tenDongSanPham, String maLoaiSanPham, String tenLoaiSanPham,
			String maThuongHieu, String tenThuongHieu, String hinhAnhBase64) {
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
		this.maNhaCungCap = maNhaCungCap;
		this.tenNhaCungCap = tenNhaCungCap;
		this.maDongSanPham = maDongSanPham;
		this.tenDongSanPham = tenDongSanPham;
		this.maLoaiSanPham = maLoaiSanPham;
		this.tenLoaiSanPham = tenLoaiSanPham;
		this.maThuongHieu = maThuongHieu;
		this.tenThuongHieu = tenThuongHieu;
		this.hinhAnhBase64 = hinhAnhBase64;
	}

	public SanPhamDTO(String id, String tenSanPham, String xuatXu, String tenLoaiSanPham, String tenThuongHieu,
			int tongSoLuong) {
		super();
		this.id = id;
		this.tenSanPham = tenSanPham;
		this.xuatXu = xuatXu;
		this.tenLoaiSanPham = tenLoaiSanPham;
		this.tenThuongHieu = tenThuongHieu;
		this.tongSoLuong = tongSoLuong;
	}

	public SanPhamDTO(String id, String tenSanPham, String moTa, double giaNhap, double giaBan, String xuatXu,
			boolean trangThai, int baoHanh, int namSanXuat, String maNhaCungCap, String tenNhaCungCap,
			String maDongSanPham, String tenDongSanPham, String maLoaiSanPham, String tenLoaiSanPham,
			String maThuongHieu, String tenThuongHieu, String hinhAnhBase64, List<MauSanPhamDTO> listMauSanPhamDTOs) {
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
		this.maNhaCungCap = maNhaCungCap;
		this.tenNhaCungCap = tenNhaCungCap;
		this.maDongSanPham = maDongSanPham;
		this.tenDongSanPham = tenDongSanPham;
		this.maLoaiSanPham = maLoaiSanPham;
		this.tenLoaiSanPham = tenLoaiSanPham;
		this.maThuongHieu = maThuongHieu;
		this.tenThuongHieu = tenThuongHieu;
		this.hinhAnhBase64 = hinhAnhBase64;
		this.listMauSanPhamDTOs = listMauSanPhamDTOs;
	}

	public SanPhamDTO() {
		this.giaNhap = 0;
		this.giaBan = 0;
		this.baoHanh = 0;
		this.namSanXuat = 0;
	}
	public void setNamSanXuat(Integer namSanXuat) {
		
		if (namSanXuat == null) {
			this.namSanXuat = 0;
			return;
		}
		
		this.namSanXuat = namSanXuat;
	}

	public void setGiaNhap(Double giaNhap) {
		
		if (giaNhap == null) {
			this.giaNhap = 0;
			return;
		}
		this.giaNhap = giaNhap;
	}

	public void setGiaBan(Double giaBan) {
		if (giaBan == null) {
			this.giaBan = 0;
			return;
		}
		this.giaBan = giaBan;
	}

	public void setBaoHanh(Integer baoHanh) {
		if (baoHanh == null) {
			this.baoHanh = 0;
			return;
		}
		this.baoHanh = baoHanh;
	}


}
