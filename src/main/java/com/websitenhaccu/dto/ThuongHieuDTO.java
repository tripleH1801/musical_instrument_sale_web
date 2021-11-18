package com.websitenhaccu.dto;

import java.util.List;

import com.websitenhaccu.entity.DongSanPham;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor
public class ThuongHieuDTO {
	private String id;
	private String tenThuongHieu;
	private String hinhAnhBase64;
	private List<DongSanPham> dongSanPhams;

	public ThuongHieuDTO(String id, String tenThuongHieu) {
		super();
		this.id = id;
		this.tenThuongHieu = tenThuongHieu;
	}

	/**
	 * @param id
	 * @param tenThuongHieu
	 * @param hinhAnhBase64
	 */
	public ThuongHieuDTO(String id, String tenThuongHieu, String hinhAnhBase64) {
		super();
		this.id = id;
		this.tenThuongHieu = tenThuongHieu;
		this.hinhAnhBase64 = hinhAnhBase64;
	}


}
