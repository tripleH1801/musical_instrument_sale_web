package com.websitenhaccu.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BinhLuans")
@IdClass(BinhLuan_PK.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BinhLuan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "nguoi_dung_id")
	private NguoiDung nguoiDung;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "san_pham_id")
	private SanPham sanPham;

	@Column(name = "binh_luan", columnDefinition = "NVARCHAR(MAX)")
	private String binhLuan;

	@Column(name = "ngay_binh_luan")
	private Date ngayBinhLuan;
	
	@Column(name = "danh_gia")
	private int danhGia;

}
