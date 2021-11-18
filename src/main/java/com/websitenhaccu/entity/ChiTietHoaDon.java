package com.websitenhaccu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ChiTietHoaDons")
@IdClass(ChiTietHoaDon_PK.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietHoaDon {

	@Id
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "san_pham_id", referencedColumnName = "san_pham_id"),
			@JoinColumn(name = "mau_id", referencedColumnName = "mau_id") })
	private MauSanPham mauSanPham;

	@Id
	@ManyToOne
	@JoinColumn(name = "hoa_don_id")
	private HoaDon hoaDon;

	@Column(name = "so_luong")
	private int soLuong;

	public double tinhTien() {
		return getSoLuong() * mauSanPham.getSanPham().getGiaBan();
	}
}
