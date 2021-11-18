package com.websitenhaccu.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietHoaDon_PK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MauSanPham_PK mauSanPham;
	private String hoaDon;

}
