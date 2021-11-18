package com.websitenhaccu.dto;

import java.util.List;

import com.websitenhaccu.entity.SanPham;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor 
@NoArgsConstructor
public class DongSanPhamDTO {
	
	private String id;

	String thuongHieu;

	String loaiSanPham;

	private String tenDongSanPham;

	private float thue;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<SanPham> sanPhams;

	/**
	 * @param id
	 * @param thuongHieu
	 * @param loaiSanPham
	 * @param tenDongSanPham
	 * @param thue
	 */
	public DongSanPhamDTO(String id, String thuongHieu, String loaiSanPham, String tenDongSanPham, float thue) {
		super();
		this.id = id;
		this.thuongHieu = thuongHieu;
		this.loaiSanPham = loaiSanPham;
		this.tenDongSanPham = tenDongSanPham;
		this.thue = thue;
	}
	
	
}
